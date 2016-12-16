import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Something
{
    Function<Key, Value> f = new Function<Something.Key, Something.Value>() {
        @Override
        public Value apply(Key t)
        {
            return new Value();
        }
    };

    public class Key
    {

    }

    public class Value
    {

    }

    Map<Key, Value> map = new ConcurrentHashMap<>();

    /**
     * {@code Key} cannot be applied lock.
     */
    public Value compute(Key k)
    {
        Value v = null;

        /*
         * Remove this bottleneck.
         */
        synchronized (map) {
            v = map.get(k);

            if (v == null) {
                /*
                 * Say f() call is an expensive call, try to 
                 * make it called once and only once!
                 */
                v = f.apply(k);
                map.put(k, v);
            }
        }

        return v;
    }
}
