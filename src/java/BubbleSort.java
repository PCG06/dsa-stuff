// DSA03 (Java): Bubble Sort

import java.util.Scanner;

public class BubbleSort {
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

        bubbleSort(arr);

        System.out.print("The array elements after sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sc.close();
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
