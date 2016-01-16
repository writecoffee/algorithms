package memorization_search;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where
 * each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 *    s = "catsanddog",
 *    dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * Solution should be ["cats and dog", "cat sand dog"].
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-break-ii/}
 *
 */
public class dp_ms_all_word_break_partitioning
{
    public ArrayList<String> wordBreak(String s, Set<String> dict)
    {
        ArrayList<String> result = new ArrayList<String>();
        explore(s, s.length() - 1, dict, new Stack<String>(), result, preprocess(s, dict));
        return result;
    }

    private void explore(String s, int end, Set<String> dict, Stack<String> path, ArrayList<String> result, boolean[] isBreakableBackFrom)
    {
        if (end < 0) {
            result.add(convert(new ArrayList<String>(path)));
            return;
        } else if (!isBreakableBackFrom[end]) {
            return;
        }

        for (int i = end; i >= 0; --i) {
            String t = s.substring(i, end + 1);

            if (dict.contains(t)) {
                path.push(t);
                explore(s, i - 1, dict, path, result, isBreakableBackFrom);
                path.pop();
            }
        }
    }

    private boolean[] preprocess(String s, Set<String> dict)
    {
        int n = s.length();
        boolean[] isBreak = new boolean[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || isBreak[j - 1])) {
                    isBreak[i] = true;
                    break;
                }
            }
        }

        return isBreak;
    }

    private String convert(ArrayList<String> path)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = path.size() - 1; i >= 0; --i) {
            sb.append(path.get(i));
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
