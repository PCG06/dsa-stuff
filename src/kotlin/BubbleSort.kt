// DSA03 (Kotlin): Bubble Sort

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter the number of elements: ")
    val n = sc.nextInt()

    val arr = IntArray(n)
    print("Enter the elements: ")
    for (i in arr.indices)
        arr[i] = sc.nextInt()

    print("The array elements before sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    bubbleSort(arr)

    print("The array elements after sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    sc.close()
}

fun bubbleSort(arr: IntArray) {
    val n = arr.size

    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}
