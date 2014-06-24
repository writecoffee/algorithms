import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * Calculate the deep size of an object.
 * 
 * [Difficulty] - Easy
 * [Source]     - tripadvisor interview
 *
 */
public class gr_deep_size_of_object {
    public long deepSizeOf(Object o) {
        long result = 0;
        Queue<Object> q = new LinkedList<Object>();
        IdentityHashMap<Object, Boolean> visited = new IdentityHashMap<Object, Boolean>();
        visited.put(o, true);

        while (!q.isEmpty()) {
            Object c = q.poll();
            result += getSizeOf(c);

            for (Object ref : getRefs(c)) {
                if (!visited.containsKey(ref)) {
                    visited.put(ref, true);
                    q.add(ref);
                }
            }
        }

        return result;
    }

    private long getSizeOf(Object o) {
        return 1;
    }

    private List<Object> getRefs(Object o) {
        return new ArrayList<Object>();
    }
}