// DSA02 (Java): Binary Search

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the search element: ");
        int target = sc.nextInt();

        System.out.print("The array elements are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        int pos = binarySearch(arr, target);

        if (pos != -1)
            System.out.println("Element found at index " + pos);
        else
            System.out.println("Element not found");

        sc.close();
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid])
                return mid;

            if (target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
