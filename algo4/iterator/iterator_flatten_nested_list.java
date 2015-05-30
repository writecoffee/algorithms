import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other
 * lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 *
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next
 * should be: [1,1,2,1,1].
 *
 * Example 2:
 * Given the list [1,[4,[6]]],
 *
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next
 * should be: [1,4,6].
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/flatten-nested-list-iterator/}
 *
 */
public class iterator_flatten_nested_list
{
    public interface NestedInteger
    {
        // @return true if this NestedInteger holds a single integer, rather
        // than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds
        // a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a
        // nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer>
    {
        private Deque<Iterator<NestedInteger>> stk;
        private NestedInteger current;

        public NestedIterator(List<NestedInteger> nestedList) {
            stk = new ArrayDeque<Iterator<NestedInteger>>();
            current = null;

            if (nestedList != null) {
                stk.push(nestedList.iterator());
            }
        }

        @Override
        public Integer next()
        {
            if (current != null) {
                Integer result = current.getInteger();
                current = null;
                return result;
            } else {
                // throw new exeception.
                return null;
            }
        }

        @Override
        public boolean hasNext()
        {
            while (!stk.isEmpty()) {
                Iterator<NestedInteger> it = stk.peek();

                if (!it.hasNext()) {
                    stk.pop();
                } else {
                    NestedInteger next = it.next();

                    if (next.isInteger()) {
                        current = next;
                        return true;
                    } else {
                        stk.push(next.getList().iterator());
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args)
    {
        Map<Integer, int[]> h = new HashMap<Integer, int[]>();
    }
}
