package GraphTheory;

/*
@author: Karim 
@Kaysium

Displaying an undirected graph using adjacency matrix
*/

import java.util.*;

public class GraphMatrix {
    protected int[][] Matrix;

    public GraphMatrix(int Vertex) {
        Matrix = new int[Vertex][Vertex];
    }

    void addEdge(int V1, int V2) {
        Matrix[V1][V2] = 1;
        Matrix[V2][V1] = 1;
    }

    void printMatrix() {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Vertex = sc.nextInt(), Edge = sc.nextInt();

        GraphMatrix Graph = new GraphMatrix(Vertex);
        for (int i = 0; i < Edge; i++) {
            int V1 = sc.nextInt(), V2 = sc.nextInt();
            Graph.addEdge(V1, V2);
        }

        Graph.printMatrix();
        sc.close();
    }
}