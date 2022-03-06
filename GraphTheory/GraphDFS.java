package GraphTheory;

/*
@author: Karim
@Kaysium

This is going to be an undirected graph. 
That will be travsersed through DFS.

Within this code, the verticies will be given an ID from 0 to Intial vertex - 1.
*/

import java.util.*;

public class GraphDFS {
    protected HashMap<Integer, LinkedList<Integer>> Graph = new HashMap<>();

    public GraphDFS(int Vertex) {
        for (int i = 0; i < Vertex; i++) {
            Graph.put(i, new LinkedList<>());
        }
    }

    void addEdge(int V1, int V2) {
        Graph.get(V1).add(V2);
        Graph.get(V2).add(V1);
    }

    void DFSCall() {
        boolean[] Visited = new boolean[Graph.size()];
        for (int i = 0; i < Visited.length; i++) {
            Visited[i] = false;
        }

        for (int i = 0; i < Visited.length; i++) {
            if (!Visited[i]) {
                DFS(i, Visited);
            }
        }
    }

    void DFS(int Source, boolean Visited[]) {
        Visited[Source] = true;
        Iterator<Integer> itr = Graph.get(Source).listIterator();

        System.out.print(Source + " ");
        while (itr.hasNext()) {
            int n = itr.next();
            if (!Visited[n]) {
                DFS(n, Visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Vertex = sc.nextInt(), Edge = sc.nextInt();

        GraphDFS Graph = new GraphDFS(Vertex);
        for (int i = 0; i < Edge; i++) {
            int V1 = sc.nextInt(), V2 = sc.nextInt();
            Graph.addEdge(V1, V2);
        }

        Graph.DFSCall();
        sc.close();
    }
}
