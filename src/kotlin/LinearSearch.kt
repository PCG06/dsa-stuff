// DSA01 (Kotlin): Linear Search

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter the number of elements: ")
    val n = sc.nextInt()

    var arr = IntArray(n)
    print("Enter the elements: ")
    for (i in arr.indices)
        arr[i] = sc.nextInt()

    print("Enter the search element: ")
    val target = sc.nextInt()

    print("The array elements are: ")
    for (i in arr)
        print("$i ")
    println()

    val pos = linearSearch(arr, target)

    if (pos != -1)
        println("Element found at index $pos")
    else
        println("Element not found")

    sc.close()
}

fun linearSearch(arr: IntArray, target: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == target)
            return i
    }
    return -1
}
