// DSA06 (Java): Stack using Array

import java.util.Scanner;

public class StackArr {
    static final int MAX = 10;

    static int[] stack = new int[MAX];
    static int top = -1;

    public static void main(String[] args) {
        int ch = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("--- Menu ---\n"
                + "1. Insert at end (push)\n"
                + "2. Remove from end (pop)\n"
                + "3. View last element (peek)\n"
                + "4. Display stack\n"
                + "5. Exit");

            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                // 1. Push
                case 1:
                {
                    System.out.print("Enter an element: ");
                    int ele = sc.nextInt();
                    push(ele);
                }
                break;

                // 2. Pop
                case 2:
                    pop();
                break;

                // 3. Peek
                case 3:
                    peek();
                break;

                // 4. Display stack
                case 4:
                    display();
                break;

                // 5. Exiting
                case 5:
                    System.out.print("Exiting...");
                break;

                default:
                    System.out.println("Invalid choice! Enter again");
            }
            System.out.println();
        } while (ch != 5);

        sc.close();
    }

    static boolean isFull() {
        return top == MAX - 1;
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static void push(int ele) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }

        stack[++top] = ele;
        System.out.println("Pushed " + stack[top] + " onto the stack!");
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return;
        }

        System.out.println("Popped " + stack[top--] + " from the stack!");
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("Top element is " + stack[top]);
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements are: ");
        for (int i = top; i >= 0; i--)
            System.out.print(stack[i] + " ");
        System.out.println();
    }
}
