// JV01: Program to perform binary search

import java.util.Scanner;
import java.util.ArrayList;

class BinarySearch {
    static int binarySearch(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr.get(mid))
                return mid;

            if (target < arr.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.print("Enter the search element: ");
        int target = sc.nextInt();

        System.out.println("The array elements are: " + arr);

        int pos = binarySearch(arr, target);

        if (pos != -1)
            System.out.println("Element found at index " + pos);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
