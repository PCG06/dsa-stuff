// DSA08 (Java): Dynamic Array

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class DynArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        int ch = 0;

        do {
            System.out.println("--- Menu ---\n"
                + "1. Push element (end)\n"
                + "2. Pop element (end)\n"
                + "3. Sort elements\n"
                + "4. Display elements\n"
                + "5. Show information\n"
                + "6. Exit"
            );

            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                // 1: Push end
                case 1:
                {
                    System.out.print("Enter the new element: ");
                    int ele = sc.nextInt();
                    arr.add(ele);
                    System.out.println("Element " + ele + " pushed!");
                }
                break;

                // 2: Pop end
                case 2:
                    if (arr.isEmpty()) {
                        System.out.println("There is nothing to pop!");
                    } else {
                        int ele = arr.get(arr.size() - 1);
                        arr.remove(arr.size() - 1);
                        System.out.println("Element " + ele + " popped!");
                    }
                break;

                // 3: Sorting
                case 3:
                    if (arr.isEmpty()) {
                        System.out.println("There is nothing to sort!");
                    } else {
                        Collections.sort(arr);
                        System.out.println("Array sorted!");
                    }
                break;

                // 4: Display array
                case 4:
                    if (arr.isEmpty()) {
                        System.out.println("There is nothing to display!");
                    } else {
                        System.out.println("Array elements are: " + arr);
                    }
                break;

                // 5: Show information
                case 5:
                    System.out.println("\n--- Array details ---");
                    System.out.println("Array size: " + arr.size());
                break;

                // 6: Exiting
                case 6:
                    System.out.print("Exiting...");
                break;

                // Invalid input
                default:
                    System.out.println("Invalid choice! Enter again");
            }
            System.out.println();
        } while (ch != 6);

        sc.close();
    }
}
