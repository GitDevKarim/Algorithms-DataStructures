package Heap;

import java.util.*;

class BuildHeap {
    protected int size;
    protected int[] Heap;

    public BuildHeap(int[] a) {
        Heap = new int[a.length + 1];
        this.size = a.length;

        for (int i = 1; i <= size; i++) {
            Heap[i] = a[i - 1];
        }

        for (int i = size / 2; i >= 1; i--) {
            MinpercolateDown(i);
        }
    }

    void MinpercolateDown(int pos) {
        int temp = Heap[pos];

        while (pos * 2 <= size) {
            int child = pos * 2;
            if (child != size && Heap[child + 1] < Heap[child]) {
                child++;
            }
            if (temp > Heap[child]) {
                Heap[pos] = Heap[child];
                pos = child;
            } else {
                break;
            }
        }
        Heap[pos] = temp;
    }

    void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.println();
    }
}

public class MinHeap {
    protected int size;
    protected int MaxSize;
    protected int[] Heap;

    public MinHeap(int maxsize) {
        this.MaxSize = maxsize;
        this.size = 0;
        Heap = new int[this.MaxSize + 1];
    }

    void Mininsert(int item) {
        Heap[++size] = item;
        MinpercolateUp(size);
    }

    void MinpercolateUp(int pos) {
        int temp = Heap[pos];

        while (pos / 2 >= 1 && temp < Heap[pos / 2]) {
            Heap[pos] = Heap[pos / 2];
            pos /= 2;
        }
        Heap[pos] = temp;
    }

    int deletemin() {
        int temp = Heap[1];
        Heap[1] = Heap[size--];
        MinpercolateDown(1);

        return temp;
    }

    void MinpercolateDown(int pos) {
        int temp = Heap[pos];

        while (pos * 2 <= size) {
            int child = pos * 2;
            if (child != size && Heap[child + 1] < Heap[child]) {
                child++;
            }
            if (temp > Heap[child]) {
                Heap[pos] = Heap[child];
                pos = child;
            } else {
                break;
            }
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
        MinHeap Heap = new MinHeap(sc.nextInt());

        for (int i = 0; i < Heap.MaxSize; i++) {
            Heap.Mininsert(sc.nextInt());
        }
        Heap.printHeap();

        System.out.println("Sorted array: ");
        for (int i = 0; i < Heap.MaxSize; i++) {
            System.out.print(Heap.deletemin() + " ");
        }
        System.out.println();

        int[] array = { 53, 26, 17, 23, 34, 41, 12, 5, 9 };
        new BuildHeap(array).printHeap();
        sc.close();
    }
}
