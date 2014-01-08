import java.util.ArrayList;
import java.util.HashMap;

public class anagrams {

    public static ArrayList<String> retrieveAnagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> tableSignatureCounter = new HashMap<String, Integer>();
        HashMap<String, String> tableSignature = new HashMap<String, String>();

        for (int i = 0; i < strs.length; i++) {
            String sig = signature(strs[i]);
            tableSignature.put(strs[i], sig);

            if (tableSignatureCounter.containsKey(sig)) {
                tableSignatureCounter.put(sig, tableSignatureCounter.get(sig) + 1);
            } else {
                tableSignatureCounter.put(sig, 1);
            }
        }

        for (int i = 0; i < strs.length; i++) {
            String sig = tableSignature.get(strs[i]);

            if (tableSignatureCounter.get(sig) > 1) {
                result.add(strs[i]);
            }
        }

        return result;
    }
    
    public static String signature(String str) {
        int[] chars = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a'] += 1;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chars[i]; j++) {
                result.append((char) (i + 'a'));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        retrieveAnagrams(new String[] { "alal", "good", "alla" });
    }
}