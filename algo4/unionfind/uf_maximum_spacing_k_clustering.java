import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Problem statement: given a distance measure d and k, comput the k-clustering with maximum spacing.
 * 
 * In this programming problem and the next you'll code up the clustering algorithm from lecture for
 * computing a max-spacing k-clustering. Download the text file here. This file describes a distance
 * function (equivalently, a complete graph with edge costs). It has the following format:
 * 
 *    [number_of_nodes]
 *    [edge 1 node 1] [edge 1 node 2] [edge 1 cost]
 *    [edge 2 node 1] [edge 2 node 2] [edge 2 cost]
 *    ...
 * 
 * There is one edge (i,j) for each choice of 1≤i<j≤n, where n is the number of nodes. For example,
 * the third line of the file is "1 3 5250", indicating that the distance between nodes 1 and 3
 * (equivalently, the cost of the edge (1,3)) is 5250. You can assume that distances are positive,
 * but you should NOT assume that they are distinct.
 * 
 * Your task in this problem is to run the clustering algorithm from lecture on this data set, where
 * the target number k of clusters is set to 4. What is the maximum spacing of a 4-clustering?
 * 
 * [Difficulty] - Medium
 * [Source]     - Standford Algorithm II PA2.1
 * 
 */
public class uf_maximum_spacing_k_clustering {
    public static class Edge implements Comparable<Edge> {
        private final String u, v;
        private final int dist;

        public Edge(String _u, String _v, int _dist) {
            u = _u;
            v = _v;
            dist = _dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

    public static int findMinSpanning(ArrayList<Edge> edges, HashMap<String, ArrayList<String>> hUnderling, HashMap<String, String> hLeader, int k) {
        Collections.sort(edges);

        for (Edge e : edges) {
            String u = e.u, v = e.v;

            if (hUnderling.size() == k) {
                break;
            } else if (hLeader.get(u).equals(hLeader.get(v))) {
                continue;
            }
 
            String uLead = hLeader.get(u), vLead = hLeader.get(v);

            if (hUnderling.get(vLead).size() > hUnderling.get(uLead).size()) {
                String t = v;
                v = u;
                u = t;
                t = vLead;
                vLead = uLead;
                uLead = t;
            }

            for (String underling : hUnderling.get(vLead)) {
                hLeader.put(underling, uLead);
            }

            hUnderling.get(uLead).addAll(hUnderling.get(vLead));
            hUnderling.remove(vLead);
        }

        int gMin = Integer.MAX_VALUE;
        for (Edge e : edges) {
            String u = e.u, v = e.v;

            if (hLeader.get(u).equals(hLeader.get(v))) {
                continue;
            }

            gMin = Math.min(gMin, e.dist);
        }

        return gMin;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("clustering1.txt")));
        PrintWriter out = new PrintWriter(System.out);
        out.println("Number of nodes: " + in.readLine());

        HashMap<String, ArrayList<String>> hUnderling = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> hLeader = new HashMap<String, String>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        String line = null;
        while ((line = in.readLine()) != null) {
            String[] splits = line.split("\\s+");
            String u = splits[0], v = splits[1];
            edges.add(new Edge(u, v, Integer.parseInt(splits[2])));

            if (!hLeader.containsKey(u)) {
                hLeader.put(u, u);
                hUnderling.put(u, new ArrayList<String>(Arrays.asList(new String[] { u })));
            }

            if (!hUnderling.containsKey(v)) {
                hLeader.put(v, v);
                hUnderling.put(v, new ArrayList<String>(Arrays.asList(new String[] { v })));
            }
        }

        out.println("Minimum distance: " + findMinSpanning(edges, hUnderling, hLeader, 4));
        in.close();
        out.close();
    }
}