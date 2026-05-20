// DSA06 (Kotlin): Stack using Array

import java.util.Scanner

val MAX = 10

var stack = IntArray(MAX)
var top = -1

fun main() {
    val sc = Scanner(System.`in`)

    var ch = 0

    do {
        println("--- Menu ---\n"
            + "1. Insert at end (push)\n"
            + "2. Remove from end (pop)\n"
            + "3. View last element (peek)\n"
            + "4. Display stack\n"
            + "5. Exit")
        print("\nEnter your choice: ")
        ch = sc.nextInt()

        when (ch) {
            // 1. Push
            1 -> {
                print("Enter an element: ")
                val ele = sc.nextInt()
                push(ele)
            }

            // 2. Pop
            2 -> pop()

            // 3. Peek
            3 -> peek()

            // 4. Display stack
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
    return top == MAX - 1
}

fun isEmpty(): Boolean {
    return top == -1
}

fun push(ele: Int) {
    if (isFull()) {
        println("Stack overflow!")
        return
    }

    stack[++top] = ele
    println("Pushed ${stack[top]} unto the stack!")
}

fun pop() {
    if (isEmpty()) {
        println("Stack underflow!")
        return
    }

    println("Popped ${stack[top--]} from the stack!")
}

fun peek() {
    if (isEmpty()) {
        println("Stack is empty!")
        return
    }

    println("Top element is ${stack[top]}")
}

fun display() {
    if (isEmpty()) {
        println("Stack is empty!")
        return
    }

    print("Stack elements are: ")
    for (i in top downTo 0)
        print("${stack[i]} ")
    println()
}
