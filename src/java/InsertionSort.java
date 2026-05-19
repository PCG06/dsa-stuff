// DSA04 (Java): Insertion Sort

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("The array elements before sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        insertionSort(arr);

        System.out.print("The array elements after sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sc.close();
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
