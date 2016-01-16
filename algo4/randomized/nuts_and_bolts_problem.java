/**
 * Given a set of n nuts of different sizes and n bolts of different sizes.
 * There is a one-one mapping between nuts and bolts. Comparison of a nut to
 * another nut or a bolt to another bolt is not allowed. It means nut can only
 * be compared with bolt and bolt can only be compared with nut to see which one
 * is bigger/smaller.
 *
 * We will give you a compare function to compare nut with bolt.
 *
 * Example
 *
 * Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].
 *
 * Your code should find the matching bolts and nuts.
 *
 * one of the possible return:
 *
 * nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].
 *
 * we will tell you the match compare function. If we give you another compare
 * function.
 *
 * the possible return is the following:
 *
 * nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].
 *
 * So you must use the compare function that we give to do the sorting.
 *
 * The order of the nuts or bolts does not matter. You just need to find the
 * matching bolt for each nut.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/nuts-bolts-problem/}
 * [Difficulty] - Hard
 *
 */
public class nuts_and_bolts_problem
{
    public abstract class NBComparator
    {
        public abstract int cmp(String a, String b);
    }

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare)
    {
        sort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void sort(String[] nuts, String[] bolts, NBComparator compare, int l, int u)
    {
        if (l >= u) {
            return;
        }

        int partNuts = partition(nuts, bolts[l], compare, l, u);
        partition(bolts, nuts[partNuts], compare, l, u);

        sort(nuts, bolts, compare, l, partNuts - 1);
        sort(nuts, bolts, compare, partNuts + 1, u);
    }

    private int partition(String[] str, String pivot, NBComparator compare, int l, int u)
    {
        int i = l;

        for (int j = l + 1; j <= u; j++) {
            if (compare.cmp(str[j], pivot) == -1 || compare.cmp(pivot, str[j]) == 1) {
                i++;
                swap(str, j, i);
            } else if (compare.cmp(str[j], pivot) == 0 || compare.cmp(pivot, str[j]) == 0) {
                swap(str, j, l);
                j--;
            }
        }

        swap(str, i, l);
        return i;
    }

    private void swap(String[] str, int l, int r)
    {
        String t = str[l];
        str[l] = str[r];
        str[r] = t;
    }
}
