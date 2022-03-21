package GraphTheory;
/*
!@author: Karim
!@Kaysium

*This is going to be an undirected graph. 
*That will be traversed through BFS.

*Within this code, the vertices will be given an ID from 0 to Initial vertex - 1.
*/

import java.util.*;

public class GraphBFS {
    protected HashMap<Integer, LinkedList<Integer>> Graph = new HashMap<>();

    public GraphBFS(int Vertex) {
        for (int i = 0; i < Vertex; i++) {
            Graph.put(i, new LinkedList<>());
        }
    }

    void addEdge(int V1, int V2) {
        Graph.get(V1).add(V2);
        Graph.get(V2).add(V1);
    }

    void BFSCall() {
        boolean[] Visited = new boolean[Graph.size()];
        for (int i = 0; i < Graph.size(); i++) {
            Visited[i] = false;
        }

        for (int i = 0; i < Graph.size(); i++) {
            if (!Visited[i]) {
                BFS(i, Visited);
            }
        }
    }

    void BFS(int Source, boolean[] Visited) {
        Queue<Integer> Queue = new LinkedList<Integer>();
        Visited[Source] = true;
        Queue.add(Source);

        while (!Queue.isEmpty()) {
            Source = Queue.poll();
            Iterator<Integer> itr = Graph.get(Source).listIterator();

            System.out.print(Source + " ");
            while (itr.hasNext()) {
                int n = itr.next();
                if (!Visited[n]) {
                    Visited[n] = true;
                    Queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Vertex = sc.nextInt(), Edge = sc.nextInt();

        GraphBFS Graph = new GraphBFS(Vertex);
        for (int i = 0; i < Edge; i++) {
            int V1 = sc.nextInt(), V2 = sc.nextInt();
            Graph.addEdge(V1, V2);
        }

        Graph.BFSCall();
        sc.close();
    }
}
