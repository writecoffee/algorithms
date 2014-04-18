import java.util.ArrayList;

public class restore_ip_addresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        explore(s, new ArrayList<String>(), 0, 0, result);
        return result;
    }

    private void explore(String s, ArrayList<String> nxt, int start, int section, ArrayList<String> result) {
        if (section == 4 && start == s.length()) {
            result.add(parseIp(nxt));
            return;
        } else if (section == 4 && start < s.length()) {
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); ++i) {
            String t = s.substring(start, i + 1);

            if (Integer.parseInt(t) > 255 || (t.length() > 1 && t.charAt(0) == '0')) {
                break;
            }

            nxt.add(t);
            explore(s, nxt, i + 1, section + 1, result);
            nxt.remove(nxt.size() - 1);
        }
    }

    private String parseIp(ArrayList<String> sections) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; ++i) {
            sb.append(sections.get(i));
            sb.append('.');
        }
        sb.append(sections.get(3));
        return sb.toString();
    }
}