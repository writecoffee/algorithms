public class search_word_in_a_sorted_dictionary_having_empty_string {
    public static int search(String[] dict, String target) {
        int l = 0;
        int r = dict.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int lMid = mid, rMid = mid;

            while (lMid >= l && dict[lMid].isEmpty()) {
                lMid--;
            }

            while (rMid <= r && dict[rMid].isEmpty()) {
                rMid++;
            }

            if (lMid < l && rMid > r) {
                break;
            } else {
                mid = lMid < l ? rMid : lMid;
            }

            if (dict[mid].compareTo(target) == 0) {
                return mid;
            } else if (dict[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] query = new String[] { "aa", "bb", "cc", "dd", "kk", "e" };
        for (String q : query) {
            System.out.println(search(new String[] { "", "aa", "", "bb", "", "cc", "dd", "e", "", "", "ff" }, q));
        }
    }
}