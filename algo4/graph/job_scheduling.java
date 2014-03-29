import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class job_scheduling {
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
        HashMap<Integer, ArrayList<Integer>> notify = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> inDegrees = new HashMap<Integer, Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; ++i) {
            inDegrees.put(i + 1, 0);
            notify.put(i + 1, new ArrayList<Integer>());
        }

        for (Entry<Integer, List<Integer>> entry : deps.entrySet()) {
            int jobId = entry.getKey();
            List<Integer> depIds = entry.getValue();

            inDegrees.put(jobId, depIds.size());
            for (Integer depId : depIds) {
                notify.get(depId).add(jobId);
            }
        }

        for (Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            int jobId = entry.getKey();
            int inDegree = entry.getValue();

            if (inDegree == 0) {
                q.add(jobId);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            Integer jobId = q.poll();
            result[i++] = jobId;

            for (Integer successor : notify.get(jobId)) {
                int depCount = inDegrees.put(successor, inDegrees.get(successor) - 1) - 1;
                if (depCount == 0) {
                    q.add(successor);
                }
            }
        }

        return i == n;
    }
}