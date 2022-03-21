package SortingAlgorithms;

/*
@author: Karim
@Kaysium
-- Algorithm based on comparison only --
-- Usage of recursion --
-- Such algorithms can do better than O(n^2), as such, quicksort can go as O(nlogn) --

Like Mergesort, this sorting algorithm works on the principle of divide and conquer.
We pick a pivot, could be anywhere within the array itself or could be the first element, and then we divide the array into two sub arrays, one with elements smaller than the pivot, and one with elements greater than the pivot.
We then recursively call the method on the sub arrays. Partition usually takes O(n) time, and the recursion is O(logn)

Time complexity on average: O(nlogn)
Worst case is when you call quicksort on an array that is already sorted. O(n^2)
*/
import java.util.*;

public class QuickSort {
    protected int[] A;

    public QuickSort(int[] a) {
        this.A = a.clone();
        QSort(this.A, 0, this.A.length - 1);
    }

    void QSort(int[] A, int Start, int End) {
        if (Start >= End) {
            return;
        }

        int P = Partition(A, Start, End);
        QSort(A, Start, P - 1);
        QSort(A, P + 1, End);
    }

    int Partition(int[] A, int Begin, int End) {
        int Pivot = A[End]; // Can be taken anywhere within the array
        int i = Begin - 1;

        for (int j = Begin; j < End + 1; j++) {
            if (A[j] <= Pivot) {
                int temp = A[j];
                A[j] = A[i + 1];
                A[i + 1] = temp;
                i++;
            }
        }
        return i;
    }

    void printArray() {
        for (int i = 0; i < this.A.length; i++) {
            System.out.print(this.A[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Size = sc.nextInt();
        int[] Array = new int[Size];

        for (int i = 0; i < Size; i++) {
            Array[i] = sc.nextInt();
        }

        new QuickSort(Array).printArray();
        sc.close();
    }
}
