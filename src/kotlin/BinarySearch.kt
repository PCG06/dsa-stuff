// KT01: Program to perform binary search

fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (target == arr[mid])
            return mid

        if (target < arr[mid])
            high = mid - 1
        else
            low = mid + 1
    }

    return -1
}

fun main() {
    print("Enter the number of elements: ");
    val n = readln().toInt()

    var arr = IntArray(n)
    print("Enter the elements: ")
    for (i in arr.indices)
        arr[i] = readln().toInt()

    print("Enter the search element: ")
    val target = readln().toInt()

    print("The array elements are: ")
    for (i in arr)
        print("$i ")
    println()


    val pos = binarySearch(arr, target)

    if (pos != -1)
        println("Element found at index $pos")
    else
        println("Element not found")
}
