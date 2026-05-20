// DSA09 (Kotlin): Prefix Sum Array

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter the number of elements: ")
    val n = sc.nextInt()

    val arr = IntArray(n)
    print("Enter the elements: ")
    for (i in arr.indices)
        arr[i] = sc.nextInt()

    print("The array elements are: ")
    for (i in arr)
        print("$i ")
    println()

    val prefix = IntArray(n)
    prefixArray(arr, prefix)

    print("The prefix array: ")
    for (i in prefix)
        print("$i ")
    println()

    if (n >= 3)
        println("Range sum [0, 2]: ${rangeSum(prefix, 0, 2)}")

    if (n >= 4)
        println("Range sum [1, 3]: ${rangeSum(prefix, 1, 3)}")

    if (n >= 5)
       println("Range sum [2, 4]: ${rangeSum(prefix, 2, 4)}")

    sc.close()
}

fun prefixArray(arr: IntArray, prefix: IntArray) {
    val n = arr.size

    prefix[0] = arr[0]

    for (i in 1 until n)
        prefix[i] = prefix[i - 1] + arr[i]
}

fun rangeSum(prefix: IntArray, left: Int, right: Int): Int {
    if (left == 0)
        return prefix[right]

    return prefix[right] - prefix[left - 1]
}
