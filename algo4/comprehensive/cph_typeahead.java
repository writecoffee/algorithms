import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class cph_typeahead
{
    public class Typeahead
    {
        private HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        // @param dict A dictionary of words dict
        public Typeahead(Set<String> dict) {
            // do initialize if necessary
            for (String str : dict) {
                int len = str.length();
                for (int i = 0; i < len; ++i)
                    for (int j = i + 1; j <= len; ++j) {
                        String tmp = str.substring(i, j);
                        if (!map.containsKey(tmp)) {
                            map.put(tmp, new ArrayList<String>());
                            map.get(tmp).add(str);
                        } else {
                            List<String> index = map.get(tmp);
                            if (!str.equals(index.get(index.size() - 1))) {
                                index.add(str);
                            }
                        }
                    }
            }
        }

        // @param str: a string
        // @return a list of words
        public List<String> search(String str)
        {
            // Write your code here
            if (!map.containsKey(str)) {
                return new ArrayList<String>();
            } else {
                return map.get(str);
            }
        }
    }
}
