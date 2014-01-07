
public class remove_element {
    
    public static int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            if (A[0] == elem) {
                return 0;
            }

            return 1;
        }
 
        int p = 0;
        int q = A.length;

        while (q > p) {
            if (A[p] != elem) {
                p++;
                continue;
            }
            if (A[q - 1] == elem) {
                q--;
                continue;
            }
            
            int temp = A[p];
            A[p] = A[q - 1];
            A[q - 1] = temp;
        }
        
        return p;
    }
    
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] { 1, 2, 3, 4, 5, 6, 2, 1, 1, 1, 3 }, 3));
        System.out.println(removeElement(new int[] { 2, 2 }, 2));
    }
}