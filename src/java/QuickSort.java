// DSA17 (Java): Quick Sort

import java.util.Scanner;

public class QuickSort {
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

        quickSort(arr, 0, arr.length - 1);

        System.out.print("The array elements after sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sc.close();
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        int pivot = arr[mid];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            
                i++;
                j--;
            }
        }

        quickSort(arr, left, j);
        quickSort(arr, i, right);
    }
}
