// DSA05 (Kotlin): Selection Sort

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

    selectionSort(arr)

    print("The array elements after sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    sc.close()
}

fun selectionSort(arr: IntArray) {
    val n = arr.size

    for (i in 0 until n - 1) {
        var min = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[min])
                min = j
        }

        if (min != i) {
            val temp = arr[i]
            arr[i] = arr[min]
            arr[min] = temp
        }
    }
}
