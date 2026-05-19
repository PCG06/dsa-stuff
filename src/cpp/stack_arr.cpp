// DSA06 (C++): Stack using Array

#include <iostream>
#include <vector>

using namespace std;

#define MAX 10

static vector<int> stack(MAX);
static int top = -1;

static void push(int ele);
static void pop(void);
static void peek(void);
static void display(void);

int main() {
    int ch = 0;

    do {
        cout << "--- Menu ---\n"
            "1. Insert at end (push)\n"
            "2. Remove from end (pop)\n"
            "3. View last element (peek)\n"
            "4. Display stack\n"
            "5. Exit\n";

        cout << "\nEnter your choice: ";
        cin >> ch;

        switch (ch) {
            // 1. Push
            case 1:
            {
                int ele;
                cout << "Enter an element: ";
                cin >> ele;
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
    return top == MAX - 1;
}

static int isEmpty(void) {
    return top == -1;
}

static void push(int ele) {
    if (isFull()) {
        cout << "Stack overflow!\n";
        return;
    }

    stack[++top] = ele;
    cout << "Pushed " << stack[top] << " onto the stack!\n";
}

static void pop(void) {
    if (isEmpty()) {
        cout << "Stack underflow!\n";
        return;
    }

    cout << "Popped " << stack[top--] << " from the stack!\n";
}

static void peek(void) {
    if (isEmpty()) {
        cout << "Stack underflow!\n";
        return;
    }

    cout << "Top element is " << stack[top] << "\n";
}

static void display(void) {
    if (isEmpty()) {
        cout << "Stack underflow!\n";
        return;
    }

    cout << "Stack elements are: ";
    for (int i = top; i >= 0; i--)
        cout << stack[i] << ' ';
    cout << "\n";
}
