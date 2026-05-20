// DSA07 (Java): Queue using Array

import java.util.Scanner;

public class QueueArr {
    static final int MAX = 10;

    static int[] queue = new int[MAX];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ch = 0;

        do {
            System.out.println("--- Menu ---\n"
                + "1. Insert at end (enqueue)\n"
                + "2. Remove from front (dequeue)\n"
                + "3. View first element (peek)\n"
                + "4. Display queue\n"
                + "5. Exit");

            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                // 1. Enqueue
                case 1:
                {
                    System.out.print("Enter an element: ");
                    int ele = sc.nextInt();
                    enqueue(ele);
                }
                break;

                // 2. Dequeue
                case 2:
                    dequeue();
                break;

                // 3. Peek
                case 3:
                    peek();
                break;

                // 4. Display queue
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

    static boolean isFull()
    {
        return rear == MAX - 1;
    }

    static boolean isEmpty()
    {
        return front == -1 || front > rear;
    }

    static void enqueue(int ele) {
        if (isFull()) {
            System.out.println("Queue overflow!");
            return;
        }

        queue[++rear] = ele;
        if (front == -1)
            front = 0;

        System.out.println("Enqueued " + queue[rear] + " onto the queue");
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return;
        }

        System.out.println("Dequeued " + queue[front++] + " from the queue");

        if (front > rear)
            front = rear = -1;
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front element is " + queue[front]);
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements are: ");
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }
}
