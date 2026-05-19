// DSA07 (C): Queue using Array

#include <stdio.h>

#define MAX 10

static int queue[MAX];
static int front = -1;
static int rear = -1;

static void enqueue(int ele);
static void dequeue(void);
static void peek(void);
static void display(void);

int main() {
    int ch = 0;

    do {
        printf("--- Menu ---\n"
            "1. Insert at end (enqueue)\n"
            "2. Remove from front (dequeue)\n"
            "3. View first element (peek)\n"
            "4. Display queue\n"
            "5. Exit\n");

        printf("\nEnter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            // 1. Enqueue
            case 1:
            {
                int ele;
                printf("Enter an element: ");
                scanf("%d", &ele);
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
                printf("Exiting...");
            break;

            default:
                printf("Invalid choice! Enter again\n");
        }
        printf("\n");
    } while (ch != 5);
    return 0;
}

static int isFull(void)
{
    return rear == MAX - 1;
}

static int isEmpty(void)
{
    return front == -1 || front > rear;
}

static void enqueue(int ele) {
    if (isFull()) {
        printf("Queue overflow!\n");
        return;
    }

    queue[++rear] = ele;
    if (front == -1)
        front = 0;

    printf("Enqueued %d onto the queue\n", queue[rear]);
}

static void dequeue(void) {
    if (isEmpty()) {
        printf("Queue underflow!\n");
        return;
    }

    printf("Dequeued %d from the queue\n", queue[front++]);

    if (front > rear)
        front = rear = -1;
}

static void peek(void) {
    if (isEmpty()) {
        printf("Queue underflow!\n");
        return;
    }

    printf("Front element is %d\n", queue[front]);
}

static void display(void) {
    if (isFull()) {
        printf("Queue overflow!\n");
        return;
    }

    printf("Queue elements are: ");
    for (int i = front; i <= rear; i++)
        printf("%d ", queue[i]);
    printf("\n");
}
