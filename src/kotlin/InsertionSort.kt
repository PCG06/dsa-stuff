// DSA04 (Kotlin): Insertion Sort

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

    insertionSort(arr)

    print("The array elements after sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    sc.close()
}

fun insertionSort(arr: IntArray) {
    val n = arr.size

    for (i in 1 until n) {
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        
        arr[j + 1] = key
    }
}
