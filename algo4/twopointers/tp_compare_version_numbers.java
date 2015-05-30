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
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int lengthV1 = v1.length;
        int lengthV2 = v2.length;
        int len = Math.max(lengthV1, lengthV2);

        for (int i = 0; i < len; i++) {
            int nV1 = 0, nV2 = 0;

            if (i < lengthV1) {
                nV1 = Integer.parseInt(v1[i]);
            }

            if (i < lengthV2) {
                nV2 = Integer.parseInt(v2[i]);
            }

            if (nV1 > nV2) {
                return 1;
            } else if (nV1 < nV2) {
                return -1;
            }
        }

        return 0;
    }
}
