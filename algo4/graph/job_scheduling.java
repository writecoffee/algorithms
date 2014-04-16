import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class job_scheduling {
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
        HashMap<Integer, ArrayList<Integer>> hNotify = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> hInDegrees = new HashMap<Integer, Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; ++i) {
            hNotify.put(i + 1, new ArrayList<Integer>());
            hInDegrees.put(i + 1, 0);
        }

        for (Entry<Integer, List<Integer>> entry : deps.entrySet()) {
            int jobId = entry.getKey();
            List<Integer> depIds = entry.getValue();

            hInDegrees.put(jobId, depIds.size());
            for (Integer depId : depIds) {
                hNotify.get(depId).add(jobId);
            }
        }

        for (Entry<Integer, Integer> entry : hInDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            Integer jobId = q.poll();
            result[i++] = jobId;

            for (Integer nxt : hNotify.get(jobId)) {
                if (hInDegrees.put(nxt, hInDegrees.get(nxt) - 1) == 1) {
                    q.add(nxt);
                }
            }
        }

        return i == n;
    }
}