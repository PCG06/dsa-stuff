// DSA06 (C): Stack using Array

#include <stdio.h>

#define MAX 10

static int stack[MAX];
static int top = -1;

static void push(int ele);
static void pop(void);
static void peek(void);
static void display(void);

int main() {
    int ch = 0;

    do {
        printf("--- Menu ---\n"
            "1. Insert at end (push)\n"
            "2. Remove from end (pop)\n"
            "3. View last element (peek)\n"
            "4. Display stack\n"
            "5. Exit\n");

        printf("\nEnter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            // 1. Push
            case 1:
            {
                int ele;
                printf("Enter an element: ");
                scanf("%d", &ele);
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
                printf("Exiting...");
            break;

            default:
                printf("Invalid choice! Enter again\n");
        }
        printf("\n");
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
        printf("Stack overflow!\n");
        return;
    }

    stack[++top] = ele;
    printf("Pushed %d onto the stack!\n", stack[top]);
}

static void pop(void) {
    if (isEmpty()) {
        printf("Stack underflow!\n");
        return;
    }

    printf("Popped %d from the stack!\n", stack[top--]);
}

static void peek(void) {
    if (isEmpty()) {
        printf("Stack is empty!\n");
        return;
    }

    printf("Top element is %d\n", stack[top]);
}

static void display(void) {
    if (isEmpty()) {
        printf("Stack is empty!\n");
        return;
    }

    printf("Stack elements are: ");
    for (int i = top; i >= 0; i--)
        printf("%d ", stack[i]);
    printf("\n");
}
