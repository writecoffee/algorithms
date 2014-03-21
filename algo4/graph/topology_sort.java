import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class topology_sort {
    static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> graph, int[] inDegrees) {
        int n = inDegrees.length;
        Queue<Integer> q = new PriorityQueue<Integer>(n);
        ArrayList<Integer> result = new ArrayList<Integer>(n);

        for (int i = 0; i < n; ++i) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int nodeId = q.poll();
            result.add(nodeId + 1);

            for (int neighbor : graph.get(nodeId)) {
                if (--inDegrees[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(n);
        int[] indegs = new int[n];
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>(n));
        }

        for (int j = 0; j < m; ++j) {
            int uId = in.nextInt() - 1, vId = in.nextInt() - 1;
            graph.get(uId).add(vId);
            indegs[vId]++;
        }

        toposort(graph, indegs);
    }
}