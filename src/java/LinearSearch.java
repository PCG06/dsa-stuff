// DSA01 (Java): Linear Search

import java.util.Scanner;

public class LinearSearch {
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

        int pos = linearSearch(arr, target);

        if (pos != -1)
            System.out.println("Element found at index " + pos);
        else
            System.out.println("Element not found");

        sc.close();
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
