import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class design_mini_cassandra
{
    public class Column
    {
        public int key;
        public String value;

        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public class MiniCassandra
    {
        private Map<String, NavigableMap<Integer, String>> keyMapper;

        public MiniCassandra() {
            keyMapper = new HashMap<String, NavigableMap<Integer, String>>();
        }

        public void insert(String rawKey, int columnKey, String columnValue)
        {
            if (!keyMapper.containsKey(rawKey)) {
                keyMapper.put(rawKey, new TreeMap<Integer, String>());
            }

            keyMapper.get(rawKey).put(columnKey, columnValue);
        }

        public List<Column> query(String rawKey, int columnStart, int columnEnd)
        {
            List<Column> rt = new ArrayList<Column>();
            if (!keyMapper.containsKey(rawKey)) {
                return rt;
            }

            for (Map.Entry<Integer, String> entry : keyMapper.get(rawKey).subMap(columnStart, true, columnEnd, true).entrySet()) {
                rt.add(new Column(entry.getKey(), entry.getValue()));
            }

            return rt;
        }
    }
}
