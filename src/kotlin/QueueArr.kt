// DSA07 (Kotlin): Queue using Array

import java.util.Scanner

val MAX = 10

var queue = IntArray(MAX)
var front = -1
var rear = -1

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
                var ele = sc.nextInt()
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
    return rear == MAX - 1
}

fun isEmpty(): Boolean {
    return front == -1 || front > rear
}

fun enqueue(ele: Int) {
    if (isFull()) {
        println("Queue overflow!")
        return
    }

    queue[++rear] = ele
    if (front == -1)
        front = 0

    println("Enqueued ${queue[rear]} onto the queue")
}

fun dequeue() {
    if (isEmpty()) {
        print("Queue underflow!")
        return
    }

    println("Dequeued ${queue[front++]} from the queue")

    if (front > rear) {
        front = -1
        rear = -1
    }
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

    print("Queue elements are: ")
    for (i in front until rear + 1)
        print("${queue[i]} ")
    println()
}
