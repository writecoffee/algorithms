/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * NOTE: There are cases like 1.003.77, which makes it more tedious to tackle.
 *
 * [Difficulty]     - Medium
 * [Source]         - {@linkplain https://leetcode.com/problems/compare-version-numbers/}
 * [Tediousness]    - High
 *
 */
public class tp_compare_version_numbers
{
    public int compareVersion(String version1, String version2)
    {
        int m = version1.length(),
            n = version2.length(),
            dot1 = version1.indexOf(".", 0),
            dot2 = version2.indexOf(".", 0),
            i = 0,
            j = 0;

        StringBuilder s1 = new StringBuilder(),
                      s2 = new StringBuilder();

        while (dot1 != -1 && dot2 != -1) {
            int subLen1 = dot1 - i,
                subLen2 = dot2 - j;

            align(s1, i, subLen1, version1, s2, j, subLen2, version2);
            i += subLen1 + 1;
            j += subLen2 + 1;
            dot1 = version1.indexOf(".", dot1 + 1);
            dot2 = version2.indexOf(".", dot2 + 1);
        }

        while (dot1 != -1) {
            int subLen1 = dot1 - i,
                subLen2 = j >= n ? 0 : n - j;

            align(s1, i, subLen1, version1, s2, j, subLen2, version2);
            i += subLen1 + 1;
            j += subLen2;
            dot1 = version1.indexOf(".", dot1 + 1);
        }

        while (dot2 != -1) {
            int subLen1 = i >= m ? 0 : m - i,
                subLen2 = dot2 - j;

            align(s1, i, subLen1, version1, s2, j, subLen2, version2);
            i += subLen1;
            j += subLen2 + 1;
            dot2 = version2.indexOf(".", dot2 + 1);
        }

        align(s1, i, m - i, version1, s2, j, n - j, version2);
        return Math.min(Math.max(-1, s1.toString().compareTo(s2.toString())), 1);
    }

    private void align(StringBuilder s1, int i, int subLen1, String version1, StringBuilder s2, int j, int subLen2, String version2)
    {
        int maxLen = Math.max(subLen1, subLen2);

        for (int k = 0; k < maxLen - subLen1; ++k) {
            s1.append(0);
        }

        for (int k = 0; k < maxLen - subLen2; ++k) {
            s2.append(0);
        }

        for (int k = 0; k < subLen1; ++k) {
            s1.append(version1.charAt(i + k));
        }

        for (int k = 0; k < subLen2; ++k) {
            s2.append(version2.charAt(j + k));
        }
    }
}
