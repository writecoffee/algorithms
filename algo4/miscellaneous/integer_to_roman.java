
public class integer_to_roman {
    
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder re = new StringBuilder();
        while (num > 0) {
            if (num >= nums[i]) {
                num -= nums[i];
                re.append(romans[i]);
            } else {
                ++i;
            }
        }

        return re.toString();
    }

    public static void main(String[] args) {
        
    }
}