// DSA05 (Java): Selection Sort

import java.util.Scanner;

public class SelectionSort {
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

        selectionSort(arr);

        System.out.print("The array elements after sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sc.close();
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
