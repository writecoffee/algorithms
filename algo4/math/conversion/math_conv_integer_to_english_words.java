package conversion;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 *
 * For example,
 *
 * 123 -> "One Hundred Twenty Three"
 *
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 *
 * 1234567 ->
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Hint:
 *
 * 1. Did you see a pattern in dividing the number into chunk of words? For
 * example, 123 and 123000.
 *
 * 2. Group the number by thousands (3 digits). You can write a helper function
 * that takes a number less than 1000 and convert just that chunk to words.
 *
 * 3. There are many edge cases. What are some good test cases? Does your code
 * work with input such as 0? Or 1000010? (middle chunk is zero and should not
 * be printed out)
 *
 * [Source]         - {@linkplain https://leetcode.com/problems/integer-to-english-words/}
 * [Difficulty]     - Medium
 * [Tediousness]    - High
 *
 */
public class math_conv_integer_to_english_words
{
    private static boolean cached = false;
    private static Map<String, String> conversion = new HashMap<>();

    public String numberToWords(int num)
    {
        if (!cached) {
            cacheAllNumbers();
            cached = true;
        }

        if (num == 0) {
            return "Zero";
        }

        String result = conversion.get(Integer.toString(num % 1000));
        num /= 1000;

        for (int i = 1; i < 4 && num != 0; i++) {
            int t = num % 1000;

            if (!"".equals(result) && t != 0) {
                result = conversion.get(Integer.toString(t)) + " " + significance[i] + " " + result;
            } else if (t != 0) {
                result = conversion.get(Integer.toString(t)) + " " + significance[i];
            }

            num /= 1000;
        }

        return result;
    }

    private static String[] significance = new String[] {
        "",
        "Thousand",
        "Million",
        "Billion"
    };

    private static String[] nums = new String[] {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
        "Twenty"
    };

    private static String[] tens = new String[] {
        "",
        "Ten",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    private void cacheAllNumbers()
    {
        conversion.put("0", "");
        conversion.put("00", "");
        conversion.put("000", "");

        for (int i = 1; i < 1000; i++) {
            int t = i % 100;
            String result = null;

            if (t > 20 && t % 10 != 0) {
                result = tens[t / 10] + " " + nums[t % 10];
            } else if (t > 20) {
                result = tens[t / 10];
            } else {
                result = nums[t];
            }

            int h = i / 100;
            if (h != 0 && t != 0) {
                result = nums[h] + " Hundred " + result;
            } else if (h != 0) {
                result = nums[h] + " Hundred";
            }

            conversion.put(Integer.toString(i), result);
        }
    }
}
