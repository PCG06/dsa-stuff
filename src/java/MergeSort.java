// DSA16 (Java): Merge Sort

import java.util.Scanner;

class MergeSort {
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

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("The array elements after sorting are: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sc.close();
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++)
            l[i] = arr[left + i];

        for (int i = 0; i < n2; i++)
            r[i] = arr[mid + 1 + i];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (l[i] <= r[j])
                arr[k++] = l[i++];
            else
                arr[k++] = r[j++];
        }

        while (i < n1)
            arr[k++] = l[i++];

        while (j < n2)
            arr[k++] = r[j++];
    }
}
