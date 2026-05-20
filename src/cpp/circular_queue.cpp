// DSA10 (C++): Circular Queue

#include <iostream>
#include <vector>

using namespace std;

#define MAX 10

static vector<int> queue(MAX);
static int front = -1;
static int rear = -1;
static int count = 0;

static void enqueue(int ele);
static void dequeue(void);
static void peek(void);
static void display(void);

int main() {
    int ch = 0;

    do {
        cout << "--- Menu ---\n"
            "1. Insert at end (enqueue)\n"
            "2. Remove from front (dequeue)\n"
            "3. View first element (peek)\n"
            "4. Display queue\n"
            "5. Exit\n";

        cout << "\nEnter your choice: ";
        cin >>  ch;

        switch (ch) {
            // 1. Enqueue
            case 1:
            {
                int ele;
                cout << "Enter an element: ";
                cin >>  ele;
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
                cout << "Exiting...";
            break;

            default:
                cout << "Invalid choice! Enter again\n";
        }
        cout << "\n";
    } while (ch != 5);
    return 0;
}

static int isFull(void) {
    return count == MAX;
}

static int isEmpty(void) {
    return count == 0;
}

static void enqueue(int ele) {
    if (isFull()) {
        cout << "Queue overflow!\n";
        return;
    }

    rear = (rear + 1) % MAX;
    queue[rear] = ele;
    count++;

    if (front == -1)
        front = 0;

    cout << "Enqueued " << queue[rear] << " onto the queue\n";
}

static void dequeue(void) {
    if (isEmpty()) {
        cout << "Queue underflow!\n";
        return;
    }

    int ele = queue[front];
    count--;

    if (isEmpty())
        front = rear = -1;
    else
        front = (front + 1) % MAX;

    cout << "Dequeued " << ele << " from the queue\n";
}

static void peek(void) {
    if (isEmpty()) {
        cout << "Queue is empty!\n";
        return;
    }

    cout << "Front element is " << queue[front] << "\n";
}

static void display(void) {
    if (isEmpty()) {
        cout << "Queue is empty!\n";
        return;
    }

    int f = front;

    cout << "Queue elements are: ";
    for (int i = 0; i < count; i++) {
        cout << queue[f] << ' ';
        f = (f + 1) % MAX;
    }
    cout << "\n";
}
