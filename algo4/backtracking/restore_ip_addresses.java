import java.util.ArrayList;

public class restore_ip_addresses {

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder ip = new StringBuilder();
        probe(s, result, ip, 0, 0);
        return result;
    }

    private static void probe(
                    String s,
                    ArrayList<String> result,
                    StringBuilder intermediate,
                    int section, int index) {

        if (section == 4 && index == s.length()) {
            result.add(intermediate.toString());
        }

        if (section == 4) {
            return;
        }

        int num = 0;
        int origSize = intermediate.length();
        if (origSize != 0) {
            intermediate.append('.');
        }

        for (int i = index; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) {
                break;
            }

            intermediate.append(s.charAt(i));
            probe(s, result, intermediate, section + 1, i + 1);
            if (num == 0) {
                break;
            }
        }

        intermediate.delete(origSize, intermediate.length());
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }

}