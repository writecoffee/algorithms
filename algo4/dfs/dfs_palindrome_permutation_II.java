import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 *
 * For example:
 *
 * Given s = "aabb", return ["abba", "baab"].
 *
 * Given s = "abc", return [].
 *
 * Hint:
 *
 * If a palindromic permutation exists, we just need to generate the first half
 * of the string.
 *
 * To generate all distinct permutations of a (half of) string, use a similar
 * approach from: Permutations II or Next Permutation.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/palindrome-permutation-ii/}
 * [Difficulty] - Medium
 *
 */
public class dfs_palindrome_permutation_II
{
    public List<String> generatePalindromes(String s)
    {
        Set<String> result = new HashSet<>();
        List<Character> cs = new ArrayList<>();
        boolean singled = false;
        Character singleChar = null;

        int[] occurs = new int[256];

        for (char c : s.toCharArray()) {
            occurs[c]++;
        }

        for (int i = 0; i < occurs.length; i++) {
            if (occurs[i] % 2 == 1 && singled) {
                return new ArrayList<>();
            }

            if (occurs[i] % 2 == 1) {
                singled = true;
                singleChar = (char) i;
            }

            for (int j = 0; j < occurs[i] / 2; j++) {
                cs.add((char) i);
            }
        }

        explore(result, cs, new HashSet<>(), cs.size(), singleChar, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void explore(Set<String> result, List<Character> cs, Set<Integer> visited, int n, Character single, StringBuilder sb)
    {
        if (sb.length() == n) {
            if (single == null) {
                result.add(sb.toString() + new StringBuilder(sb).reverse().toString());
            } else {
                result.add(sb.toString() + single + new StringBuilder(sb).reverse().toString());
            }

            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited.contains(j)) {
                continue;
            }

            visited.add(j);
            explore(result, cs, visited, n, single, sb.append(cs.get(j)));
            sb.delete(sb.length() - 1, sb.length());
            visited.remove(j);
        }
    }
}
