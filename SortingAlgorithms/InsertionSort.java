package SortingAlgorithms;
/*
@author: Karim
@Kaysium
--Sorting algorithm based on comparison and swapping adjacent elements --
-- IN GENERAL SUCH ALGORITHMS CANNOT DO BETTER THAN O(n^2) -- 
In All three, only insertion can go down to O(n)

For when it comes to insertion sort, it is better than bubble sort
Since, after careful attention to the code, we realize the following
In Bubble sort, we got two nest loops that controls iteration, regardless if there would be swapping or not, iteration will occur. On the other hand, in insertion sort, we realize that the nested loop is in 
control of both iteration and swapping, 2 in 1.

So when it comes to the complexity of Insertion sort, at BEST, we have that the 2nd loop never goes, since the coniditions will never meet, making the first loop going n times only. Hence, O(n).
At WORST, we have that the 2nd nested loop always going, making the Complexity of the algorithm n.n, hence   O(n^2). Since, the 2nd loop determines also the number of swaps, swapping may be done 1 time O(1) or n times aka every time, O(n)
*/

import java.util.*;

public class InsertionSort {
    protected int[] ArrayToBeSorted;

    public InsertionSort(int[] a) {
        this.ArrayToBeSorted = a.clone();
        Insertion();
    }

    void Insertion() {
        for (int i = 1; i < this.ArrayToBeSorted.length; i++) {
            int temp = this.ArrayToBeSorted[i];
            int k = i;

            while (k > 0 && temp < this.ArrayToBeSorted[k - 1]) {
                this.ArrayToBeSorted[i] = this.ArrayToBeSorted[k - 1];
                this.ArrayToBeSorted[k - 1] = temp;
                k--;
            }
        }
        printArray();
    }

    void printArray() {
        for (int i = 0; i < this.ArrayToBeSorted.length; i++) {
            System.out.print(this.ArrayToBeSorted[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Size = sc.nextInt();
        int[] array = new int[Size];

        for (int i = 0; i < Size; i++) {
            array[i] = sc.nextInt();
        }

        new InsertionSort(array);
        sc.close();
    }
}