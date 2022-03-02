package SortingAlgorithms;
/*
@author: Karim
@Kaysium
-- Sorting algorithm based on comparison and swapping adjacent elements --
-- IN GENERAL SUCH ALGORITHMS CANNOT DO BETTER THAN O(n^2). --

A relatively simple sorting algorithm that has a crazy time complexity. 
Bubble sorts operates based on two nested loops ALWAYS RUNNING since they are controlling the iteration, making the complexity of it always O(n^2)

The swapping part of it, may never be executed, hence O(1), since condition is always false, or the swapping may be executed every single time, O(n). Regardless, the time complexity is O(n^2).
*/

import java.util.*;

public class BubbleSort {
    protected int[] A;

    public BubbleSort(int[] a) {
        this.A = a.clone();
        Sort();
    }

    void Sort() {
        for (int i = 0; i < this.A.length - 1; i++) {
            for (int j = i + 1; j < this.A.length; j++) {
                if (this.A[i] > this.A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
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

        new BubbleSort(a);
        sc.close();
    }
}
