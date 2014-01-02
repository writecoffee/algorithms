
public class StringUtils {

    public static int editDistance(String s1, String s2) {
        int ilen = s1.length() + 1;
        int jlen = s2.length() + 1;
        int iprev, jprev, ijprev;

        int array[][] = new int[2][jlen];

        // init row 0 of the array, assume we are comparing "" and s2
        for (int j = 1; j < jlen; ++j) {
            array[0][j] = j;
        }

        for (int i = 1; i < ilen; ++i) {
            // init column 0 of the array, assuming we are comparing s1 and ""
            array[i % 2][0] = i;

            for (int j = 1; j < jlen; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    array[i % 2][j] = array[(i - 1) % 2][j - 1];
                } else {
                    iprev = array[(i - 1) % 2][j];
                    jprev = array[i % 2][j - 1];
                    ijprev = array[(i - 1) % 2][j - 1];
                    array[i % 2][j] = min(min(iprev, jprev), ijprev) + 1;
                }
            }
        }

        return array[(ilen - 1) % 2][jlen - 1];
    }
    
    public static int min(int i1, int i2) {
    	if (i1 <= i2) {
            return i1;
    	} else {
            return i2;
    	}
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("To run edit distance, call StringUtils [string1] [string2]");
        } else {
            String s1 = args[0];
            String s2 = args[1];
            System.out.println(editDistance(s1,s2));
        }
    }
}
