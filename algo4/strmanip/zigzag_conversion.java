

public class zigzag_conversion {
    public static String convert(String s, int nRows) {
        StringBuilder result = new StringBuilder();
        int inc = 2 * (nRows - 1);
        int N = s.length();
        for (int i = 0; i < nRows; ++i) {
        	int j = 0;
        	while (true) {
        		if (i > 0 && i < nRows - 1 && j - i >= 0 && j - i < N) {
        			result.append(s.charAt(j - i));
        		}
        		if (j + i < N) {
        			result.append(s.charAt(j + i));
        		} else {
        			break;
        		}
	    		j += inc;
        	}
        }
        
        return result.toString();
    }
    
    public static void main(String []args) {
    	System.out.println(convert(new String("AMONSTUKOLTZ"), 4));
    }
}
