package SortingAlgorithms;
/*
--Sorting algorithm based on comparison and swapping adjacent elements--
-- IN GENERAL SUCH ALGORITHMS CANNOT DO BETTER THAN O(n^2)--

Like bubble sort, selection sort cannot do better than O(n^2) since, there are two nested loops controlling the iteration with swaps occuring every single time
*/

import java.util.*;

public class SelectionSort {
    protected int[] A;

    public SelectionSort(int[] a) {
        this.A = a.clone();
        Sort();
    }

    void Sort() {
        for (int i = 0; i < this.A.length; i++) {
            int mintemp = i;
            for (int j = i + 1; j < this.A.length; j++) {
                if (this.A[j] < this.A[mintemp]) {
                    mintemp = j;
                }
            }
            int temp = this.A[mintemp];
            this.A[mintemp] = this.A[i];
            this.A[i] = temp;
        }
        printArray();
    }

    void printArray() {
        for (int i = 0; i < this.A.length; i++) {
            System.out.print(this.A[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();
        int[] a = new int[Num];

        for (int i = 0; i < Num; i++) {
            a[i] = sc.nextInt();
        }

        new SelectionSort(a);
        sc.close();
    }
}
