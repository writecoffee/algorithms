import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class deep_size_of_object {
    long deepSizeOf(Object o) {
        long result = 0;
        Queue<Object> outer = new LinkedList<Object>();
        Queue<Object> inner;
        IdentityHashMap<Object, Boolean> visited = new IdentityHashMap<Object, Boolean>();
        visited.put(o, true);

        while (!outer.isEmpty()) {
            inner = new LinkedList<Object>(outer);
            outer.clear();

            while (!inner.isEmpty()) {
                Object current = inner.poll();
                result += getSizeOf(current);

                for (Object ref : getRefs(current)) {
                    if (!visited.containsKey(ref)) {
                        visited.put(ref, true);
                        outer.add(ref);
                    }
                }
            }
        }

        return result;
    }

    private long getSizeOf(Object o) {
        return 1;
    }

    private List<Object> getRefs(Object o) {
        return null;
    }
}