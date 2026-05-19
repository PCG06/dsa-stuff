// DSA16 (Kotlin): Merge Sort

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

    mergeSort(arr, 0, arr.size - 1)

    print("The array elements after sorting are: ")
    for (i in arr)
        print("$i ")
    println()

    sc.close()
}

fun mergeSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right)
        return

    val mid = left + (right - left) / 2
    
    mergeSort(arr, left, mid)
    mergeSort(arr, mid + 1, right)

    merge(arr, left, mid, right)
}

fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid

    val l = IntArray(n1)
    val r = IntArray(n2)

    for (i in 0 until n1)
        l[i] = arr[left + i]

    for (i in 0 until n2)
        r[i] = arr[mid + 1 + i]

    var i = 0
    var j = 0
    var k = left

    while (i < n1 && j < n2) {
        if (l[i] <= r[j])
            arr[k++] = l[i++]
        else
            arr[k++] = r[j++]
    }

    while (i < n1)
        arr[k++] = l[i++]

    while (j < n2)
        arr[k++] = r[j++]
}
