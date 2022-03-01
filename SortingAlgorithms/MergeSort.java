package SortingAlgorithms;
/*
-- Algorithm based on comparison only --
-- Usage of recrusion --
-- Such algorithms can do better than O(n^2), as such, merge sort can go as O(nlogn) --

This algorithm works on the principle of divide and conquer.
It will keep on dividing the array into smaller sub-arrays until it reaches the base case, which is when the array is of size 1. This step technically takes aprox log(n), going from size n to 1.

In order to achieve this, .

*/

import java.util.*;

public class MergeSort {
    protected int[] A;

    public MergeSort(int[] a) {
        this.A = a.clone();
    }

    void MSort(int[] a, int s, int e) {

    }

    void printArray() {
        for (int i = 0; i < this.A.length; i++) {
            System.out.print(this.A[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}
