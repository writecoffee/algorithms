package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example, Given n = 2, return ["11","69","88","96"].
 *
 * Hint:
 *
 * Try to use recursion and notice that it should recurse with n - 2 instead of
 * n - 1.
 *
 * [Difficulty]     - Medium
 * [Source]         - {@linkplain https://leetcode.com/problems/strobogrammatic-number-ii/}
 * [Tediousness]    - Medium
 *
 */
public class dfs_combination_strobogrammatic_number_II
{
    public List<String> findStrobogrammatic(int n)
    {
        List<String> result = new ArrayList<>();
        explore(result, n, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    private static List<String>    stroboPair   = Arrays.asList("00", "11", "69", "96", "88");
    private static List<Character> stroboSingle = Arrays.asList('0', '1', '8');

    private void explore(List<String> result, int n, List<Character> lPath, List<Character> rPath)
    {
        if (n == 1) {
            for (Character c : stroboSingle) {
                result.add(construct(lPath, rPath, c));
            }

            return;
        } else if (n == 0) {
            result.add(construct(lPath, rPath, null));
            return;
        }

        for (String pair : stroboPair) {
            if (pair.equals("00") && lPath.isEmpty()) {
                continue;
            }

            lPath.add(pair.charAt(0));
            rPath.add(pair.charAt(1));
            explore(result, n - 2, lPath, rPath);
            lPath.remove(lPath.size() - 1);
            rPath.remove(rPath.size() - 1);
        }
    }

    private String construct(List<Character> lPath, List<Character> rPath, Character mid)
    {
        StringBuilder sb = new StringBuilder();

        for (Character c : lPath) {
            sb.append(c);
        }

        if (mid != null) {
            sb.append(mid);
        }

        for (int i = rPath.size() - 1; i >= 0; i--) {
            sb.append(rPath.get(i));
        }

        return sb.toString();
    }
}
