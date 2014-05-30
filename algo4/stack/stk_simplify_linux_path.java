import java.util.ArrayList;

public class stk_simplify_linux_path {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        ArrayList<String> stk = new ArrayList<String>();

        for (int i = 0; i < n; ++i) {
            String c = dirs[i];

            if (c.equals(".") || c.equals("") || (c.equals("..") && stk.isEmpty())) {
                continue;
            } else if (c.equals("..") && !stk.isEmpty()) {
                stk.remove(stk.size() - 1);
            } else {
                stk.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stk.isEmpty()) {
            return "/";
        }

        for (String dir : stk) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.toString();
    }
}