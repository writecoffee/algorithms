import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings
 * that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/group-shifted-strings/}
 *
 */
public class group_shifted_strings
{
    public List<List<String>> groupStrings(String[] strings)
    {
        return new ArrayList<>(Stream.of(strings)
                                     .sorted()
                                     .collect(Collectors.groupingBy(s -> s.chars()
                                                                          .mapToObj(c -> (c - s.charAt(0) + 26) % 26)
                                                                          .collect(Collectors.toList())))
                                     .values());
    }

    public List<List<String>> groupsStrings(String[] strings)
    {
        Map<List<Integer>, List<String>> convertedDist = convert(strings);
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<List<Integer>, List<String>> entry : convertedDist.entrySet()) {
            Collections.sort(entry.getValue());
            result.add(entry.getValue());
        }

        return result;
    }

    private Map<List<Integer>, List<String>> convert(String[] strings) {
        Map<List<Integer>, List<String>> result = new HashMap<>();

        for (String str : strings) {
            char[] charList = str.toCharArray();
            List<Integer> dist = new ArrayList<>();

            for (char c : charList) {
                dist.add((c - charList[0] + 26) % 26);
            }

            if (!result.containsKey(dist)) {
                result.put(dist, new ArrayList<>());
            }

            result.get(dist).add(str);
        }

        return result;
    }
}
