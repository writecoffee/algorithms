import java.util.ArrayDeque;
import java.util.Deque;

public class simplify_path {
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                continue;
            } else if (path.charAt(i) == '.' && (
                            (i < path.length() - 2 && path.charAt(i + 1) == '.' && path.charAt(i + 2) == '/') ||
                            (i == path.length() - 2 && path.charAt(i + 1) == '.'))) {
                stack.pollLast();
                i += 2;
            } else if (path.charAt(i) == '.' && (
                            (i < path.length() - 1 && path.charAt(i + 1) == '/') ||
                            (i == path.length() - 1))) {
                i += 1;
            } else {
                int j = i + 1;
                while (j < path.length() && path.charAt(j) != '/') {
                    j++;
                }

                stack.addLast(path.substring(i, j));

                i = j - 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Object s : stack.toArray()) {
            result.append('/');
            result.append((String) s);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static String simplifyPathRightWay(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        int last = 1;

        for (int i = path.indexOf("/", 1); i > 0 && i < path.length(); last = i + 1, i = path.indexOf("/", i + 1)) {
            String s = path.substring(last, i);
            if (s.equals("..")) {
                stack.pollLast();
            } else if (!s.isEmpty() && !s.equals(".") && !s.equals("/")) {
                stack.addLast(s);
            }
        }

        if (last != path.length()) {
            if (path.substring(last).equals("..")) {
                stack.pollLast();
            } else if (!path.substring(last).equals(".")) {
                stack.addLast(path.substring(last));
            }
        }

        StringBuilder result = new StringBuilder();
        for (Object o : stack.toArray()) {
            result.append("/" + (String) o);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPathRightWay("///"));
        System.out.println(simplifyPathRightWay("/a/./b/../../c/"));
        System.out.println(simplifyPathRightWay("/..."));
        System.out.println(simplifyPathRightWay("/."));
        System.out.println(simplifyPathRightWay("/.."));
        System.out.println(simplifyPathRightWay("/abc/..."));
    }
}