package GraphTheory;

import java.util.*;

public class GraphCycle {

    protected HashMap<Integer, LinkedList<Integer>> Graph = new HashMap<>();

    public GraphCycle(int Vertex) {
        for (int i = 0; i < Vertex; i++) {
            Graph.put(i, new LinkedList<Integer>());
        }
    }

    void addEdge(int V1, int V2) {
        Graph.get(V1).add(V2);
        Graph.get(V2).add(V1);
    }

    boolean DFSCall() {
        boolean[] Visited = new boolean[Graph.size()];

        for (int i = 0; i < Graph.size(); i++) {
            Visited[i] = false;
        }

        for (int i = 0; i < Graph.size(); i++) {
            if (!Visited[i]) {
                if (DFS(i, Visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean DFS(int Source, boolean[] Visited, int Parent) {
        Visited[Source] = true;
        Iterator<Integer> itr = Graph.get(Source).listIterator();

        while (itr.hasNext()) {
            int n = itr.next();
            if (!Visited[n]) {
                if (DFS(n, Visited, Source)) {
                    return true;
                }
            } else if (n != Parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Vertex = sc.nextInt(), Edge = sc.nextInt();

        GraphCycle Graph = new GraphCycle(Vertex);
        for (int i = 0; i < Edge; i++) {
            int V1 = sc.nextInt(), V2 = sc.nextInt();
            Graph.addEdge(V1, V2);
        }

        if (Graph.DFSCall()) {
            System.out.println("no");
            System.exit(0);
        }
        System.out.println("yes");
        sc.close();
    }
}
