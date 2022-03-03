package SortingAlgorithms;
/*
@author: Karim
@Kaysium
-- Algorithm based on comparison only --
-- Usage of recrusion --
-- Such algorithms can do better than O(n^2), as such, merge sort can go as O(nlogn) --

This algorithm works on the principle of divide and conquer.
It will keep on dividing the array into smaller sub-arrays until it reaches the base case, which is when the array is of size 1. This step technically takes aprox O(log(n)) time, going from size n to 1.

In order to achieve this, aka to take the main array and keep on dividing until we reach one, we use the method called Msort. Such method takes as input the array and the starting and ending index of the array.
Then we get the mid of it, and we call the method again, but this time with the mid as the starting index and the end as the ending index.

After that's done, we call a method called merge, which takes as input the Array, start, mid and end of it. We copy the elements from the start to the mid to a new array, and then we copy the elements from the mid to the end to a new array.

Then we compare the two arrays and copy the smaller element to the main array, unitl one of the sub arrays goes out of bounds. Then we copy the remaining parts of the sub arrays to the main array. Assume this takes  O(n) time.

MergeSort in a nutshell: Two methods, one that divides until it reaches the base case, and one that merges the two sub arrays until one goes out of bounds. 

Time Complexity: O(nlogn)
*/

import java.util.*;

public class MergeSort {
    protected int[] A;

    public MergeSort(int[] a) {
        this.A = a.clone();
        MSort(this.A, 0, this.A.length - 1);
    }

    void MSort(int[] Array, int Start, int End) {
        if (Start >= End) {
            return;
        }

        int Mid = (Start + End) / 2;
        MSort(Array, Start, Mid);
        MSort(Array, Mid + 1, End);

        Merge(Array, Start, Mid, End);
    }

    void Merge(int[] Array, int Start, int Mid, int End) {
        int[] x = new int[Mid - Start + 1], y = new int[End - Mid];

        for (int i = 0; i < x.length; i++) {
            x[i] = Array[Start + i];
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = Array[Mid + 1 + i];
        }

        int i = 0, j = 0, k = Start;
        while (i < x.length && j < y.length) {
            if (x[i] <= y[j]) {
                Array[k] = x[i];
                i++;
            } else {
                Array[k] = y[j];
                j++;
            }
            k++;
        }

        // After the main loop, we need to copy the remaining elements of the sub arrays
        // to the main array.
        while (i < x.length) {
            Array[k] = x[i];
            i++;
            k++;
        }

        while (j < y.length) {
            Array[k] = y[j];
            j++;
            k++;
        }
    }

    void printArray() {
        for (int i = 0; i < this.A.length; i++) {
            System.out.print(this.A[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = sc.nextInt();
        }

        new MergeSort(Array).printArray();
        sc.close();
    }
}

/*
 * -- Master theorem --
 * is of form T(n) = AT(n/B) + O(n^D)
 * 
 * Where T(n) is the time complexity of the algorithm, A is the asymptotic (how
 * many recusrive calls)
 * constant, T(n/B) is the time complexity of the sub-algorithm, and n is the
 * size of the array. O(n^D) is the time complexity to merge the sorted arrays.
 * 
 * Three ways to solve the problem:
 * T(n) = Θ(𝑛^log_𝑏⁡(𝑎)) if 𝑎/𝑏^𝑑 > 1
 * T(n) = Θ(𝑛^D) if 𝑎/𝑏^𝑑 < 1
 * T(n) = Θ(𝑛^D log(n)) if 𝑎/𝑏^𝑑 = 1
 * 
 * 
 * In case of merge sort, O(n^D), D = 1; so O(n^1) = O(n)
 * So T(n) = 2T(n/2) + O(n^1)
 * A = 2
 * B = 2
 * D = 1
 * a/b^d = 1
 * so the complexity of T(n) = O(n^1 log(n)) = O(nlog(n))
 */
