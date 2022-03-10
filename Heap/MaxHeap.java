package Heap;

/*
@author: Karim
@Kaysium
-- Max Heap -- 

Insertion complexity of Heap is O(log n)
Complexity of percolateUp is O(log n)
Complexity of percolateDown is O(log n)
Copying elements of an array is O(n)
Hence, building a heap is O(nlogn)
*/

import java.util.*;

public class MaxHeap {
    protected int size;
    protected int MaxSize;
    protected int[] Heap;

    public MaxHeap(int maxsize) {
        this.MaxSize = maxsize;
        this.size = 0;
        Heap = new int[this.MaxSize + 1];
    }

    void Maxinsert(int item) {
        Heap[++size] = item;
        MaxpercolateUp(size);
    }

    void MaxpercolateUp(int pos) {
        int temp = Heap[pos];

        while (pos / 2 >= 1 && temp > Heap[pos / 2]) { // Min Heap is similar, just change the condition
            Heap[pos] = Heap[pos / 2];
            pos /= 2;
        }
        Heap[pos] = temp;
    }

    void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MaxHeap Heap = new MaxHeap(sc.nextInt());

        for (int i = 0; i < Heap.MaxSize; i++) {
            Heap.Maxinsert(sc.nextInt());
        }

        Heap.printHeap();
        sc.close();
    }
}
