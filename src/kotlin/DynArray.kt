// DSA08 (Kotlin): Dynamic Array

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val arr = mutableListOf<Int>()

    var ch = 0

    do {
        println(
            "--- Menu ---\n" +
            "1. Push element (end)\n" +
            "2. Pop element (end)\n" +
            "3. Sort elements\n" +
            "4. Display elements\n" +
            "5. Show information\n" +
            "6. Exit"
        )

        print("\nEnter your choice: ")
        ch = sc.nextInt()

        when (ch) {
            // 1: Push end
            1 -> {
                print("Enter the new element: ")
                val ele = sc.nextInt()

                arr.add(ele)

                println("Element $ele pushed!")
            }

            // 2: Pop end
            2 -> {
                if (arr.isEmpty()) {
                    println("There is nothing to pop!")
                } else {
                    val ele = arr.last()

                    arr.removeAt(arr.size - 1)

                    println("Element $ele popped!")
                }
            }

            // 3: Sorting
            3 -> {
                if (arr.isEmpty()) {
                    println("There is nothing to sort!")
                } else {
                    arr.sort()
                    println("Array sorted!")
                }
            }

            // 4: Display array
            4 -> {
                if (arr.isEmpty()) {
                    println("There is nothing to display!")
                } else {
                    println("Array elements are: $arr")
                }
            }

            // 5: Show information
            5 -> {
                println("\n--- Array details ---")
                println("Array size: ${arr.size}")
            }

            // 6: Exiting
            6 -> print("Exiting...")

            // Invalid input
            else -> println("Invalid choice! Enter again")
        }
        println()

    } while (ch != 6)

    sc.close()
}
