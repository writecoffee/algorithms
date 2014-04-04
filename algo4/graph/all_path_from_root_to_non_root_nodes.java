import java.util.ArrayList;
import java.util.HashSet;

public class all_path_from_root_to_non_root_nodes {
    public class Node<T> {
        public final T value;
        public final ArrayList<Node<T>> neighbors;

        public Node(T _value, ArrayList<Node<T>> _neighbors) {
            value = _value;
            neighbors = _neighbors;
        }
    }

    public ArrayList<ArrayList<Integer>> printPaths(Node<Integer> root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Node<Integer>> path = new ArrayList<Node<Integer>>();
        path.add(root);
        HashSet<Node<Integer>> visited = new HashSet<Node<Integer>>();
        visited.add(root);
        explore(root, path, visited, result);
        return result;
    }

    public void explore(Node<Integer> c, ArrayList<Node<Integer>> path, HashSet<Node<Integer>> visited, ArrayList<ArrayList<Integer>> result) {
        for (Node<Integer> v : c.neighbors) {
            if (visited.contains(v)) {
                continue;
            } else {
                visited.add(v);
                path.add(v);
                printPath(path, result);
                explore(v, path, visited, result);
                path.remove(path.size() - 1);
                visited.remove(v);
            }
        }
    }

    private void printPath(ArrayList<Node<Integer>> path, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (Node<Integer> n : path) {
            r.add(n.value);
        }
        result.add(r);
    }
}