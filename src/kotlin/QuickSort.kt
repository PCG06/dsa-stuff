// DSA17 (Java): Quick Sort

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

    quickSort(arr, 0, arr.size - 1)

    print("The array elements after sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    sc.close()
}

fun quickSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right)
        return

    val mid = left + (right - left) / 2

    val pivot = arr[mid]
    var i = left
    var j = right

    while (i <= j) {
        while (arr[i] < pivot)
            i++

        while (arr[j] > pivot)
            j--

        if (i <= j) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

            i++
            j--
        }
    }

    quickSort(arr, left, j)
    quickSort(arr, i, right)
}
