// DSA09 (Java): Prefix Sum Array

import java.util.Scanner;

public class PrefixSumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("The array elements are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        int[] prefix = new int[n];
        prefixArray(arr, prefix);

        System.out.print("The prefix array: ");
        for (int i : prefix)
            System.out.print(i + " ");
        System.out.println();

        if (n >= 3)
            System.out.println("Range sum [0, 2]: " + rangeSum(prefix, 0, 2));

        if (n >= 4)
            System.out.println("Range sum [1, 3]: " + rangeSum(prefix, 1, 3));

        if (n >= 5)
            System.out.println("Range sum [2, 4]: " + rangeSum(prefix, 2, 4));

        sc.close();
    }

    static void prefixArray(int[] arr, int[] prefix) {
        int n = arr.length;

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + arr[i];
    }

    static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0)
            return prefix[right];

        return prefix[right] - prefix[left - 1];
    }
}