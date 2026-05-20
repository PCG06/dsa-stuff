// DSA10 (Kotlin): Circular Queue

import java.util.Scanner

val MAX = 10

var queue = IntArray(MAX)
var front = -1
var rear = -1
var count = 0

fun main() {
    val sc = Scanner(System.`in`)

    var ch = 0

    do {
        println("--- Menu ---\n"
            + "1. Insert at end (enqueue)\n"
            + "2. Remove from front (dequeue)\n"
            + "3. View first element (peek)\n"
            + "4. Display queue\n"
            + "5. Exit")
        print("\nEnter your choice: ")
        ch = sc.nextInt()

        when (ch) {
            // 1. Enqueue
            1 -> {
                print("Enter an element: ")
                val ele = sc.nextInt()
                enqueue(ele)
            }

            // 2. Dequeue
            2 -> dequeue()

            // 3. Peek
            3 -> peek()

            // 4. Display queue
            4 -> display()

            // 5. Exiting
            5 -> print("Exiting...")

            else -> println("Invalid choice! Enter again")
        }
        println()
    } while (ch != 5)

    sc.close()
}

fun isFull(): Boolean {
    return count == MAX
}

fun isEmpty(): Boolean {
    return count == 0
}

fun enqueue(ele: Int) {
    if (isFull()) {
        println("Queue overflow!")
        return
    }

    rear = (rear + 1) % MAX
    queue[rear] = ele
    count++
    
    if (front == -1)
        front = 0

    println("Enqueued ${queue[rear]} onto the queue")
}

fun dequeue() {
    if (isEmpty()) {
        println("Queue underflow!")
        return
    }
    
    val ele = queue[front]
    count--

    if (isEmpty()) {
        front = -1
        rear = -1
    } else {
        front = (front + 1) % MAX
    }

    println("Dequeued $ele from the queue")
}

fun peek() {
    if (isEmpty()) {
        println("Queue is empty!")
        return
    }

    println("Front element is ${queue[front]}")
}

fun display() {
    if (isEmpty()) {
        println("Queue is empty!")
        return
    }

    var f = front

    print("Queue elements are: ")
    for (i in 0 until count) {
        print("${queue[f]} ")
        f = (f + 1) % MAX
    }
    println()
}
