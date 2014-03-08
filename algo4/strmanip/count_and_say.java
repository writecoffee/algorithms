public class count_and_say {
    public static String countAndSay(int n) {
        StringBuilder current = new StringBuilder();
        StringBuilder result = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            char preChar = result.charAt(0);
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == preChar) {
                    count++;
                } else {
                    current.append(count);
                    current.append(preChar);
                    count = 1;
                    preChar = result.charAt(j);
                }
            }

            current.append(count);
            current.append(preChar);
            result = current;
            current = new StringBuilder();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(20));
    }
}