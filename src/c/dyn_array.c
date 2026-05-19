// DSA08 (C): Dynamic Array

#include <stdio.h>
#include <stdlib.h>

typedef struct Array {
    int *data;
    size_t size;
    size_t capacity;
} Array;

Array array(size_t capacity);
void freearr(Array *arr);
int empty(Array *arr);
size_t getarrmemory(Array *arr);
size_t getarrsize(Array *arr);
size_t getarrcapacity(Array *arr);
int pusharr(Array *arr, int ele);
int poparr(Array *arr);
void sortarr(Array *arr);

int main() {
    #define MAX 10
    Array arr = array(MAX);

    int ch = 0;
    do {
        printf("--- Menu ---\n"
                "1. Push element (end)\n"
                "2. Pop element (end)\n"
                "3. Sort elements\n"
                "4. Display elements\n"
                "5. Show information\n"
                "6. Exit\n");

        printf("\nEnter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            // 1: Push end
            case 1:
            {
                int ele;
                printf("Enter the new element: ");
                scanf("%d", &ele);
                if (pusharr(&arr, ele) == 0)
                    printf("Element %d pushed!\n", ele);
            }
            break;

            // 2: Pop end
            case 2:
                if (empty(&arr)) {
                    printf("There is nothing to pop!\n");
                } else {
                    int ele = poparr(&arr);
                    printf("Element %d popped!\n", ele);
                }
            break;

            // 3: Sorting
            case 3:
                if (empty(&arr)) {
                    printf("There is nothing to sort!\n");
                } else {
                    sortarr(&arr);
                    printf("Array sorted!\n");
                }
            break;

            // 4: Display array
            case 4:
                if (empty(&arr)) {
                    printf("There is nothing to display!");
                } else {
                    printf("Array elements are: ");
                    for (int i = 0; i < arr.size; i++)
                        printf("%d ", arr.data[i]);
                    printf("\n");
                }
            break;

            // 5: Show information
            case 5:
                printf("\n--- Array details ---\n");
                printf("Array memory: %zu (bytes)\n", getarrmemory(&arr));
                printf("Array size: %zu\n", getarrsize(&arr));
                printf("Array capacity: %zu\n", getarrcapacity(&arr));
            break;

            // 6: Exiting
            case 6:
                printf("Exiting...");
            break;

            // Invalid input
            default:
                printf("Invalid choice! Enter again\n");
            break;
        }
        printf("\n");
    } while (ch != 6);

    freearr(&arr);
    return 0;
}

// Array functions
Array array(size_t capacity) {
    Array arr;

    if (capacity < 1)
        capacity = 1;

    arr.data = (int *) malloc(capacity * sizeof(int));
    arr.size = 0;
    arr.capacity = capacity;

    return arr;
}

int empty(Array *arr) {
    return getarrsize(arr) == 0;
}

size_t getarrmemory(Array *arr) {
    return arr->capacity * sizeof(int);
}

size_t getarrsize(Array *arr) {
    return arr->size;
}

size_t getarrcapacity(Array *arr) {
    return arr->capacity;
}

void freearr(Array *arr) {
    free(arr->data);
    
    arr->data = NULL;
    arr->size = 0;
    arr->capacity = 0;
}

int pusharr(Array *arr, int ele) {
    if (arr->size >= arr->capacity) {
        arr->capacity *= 2;

        int *temp = (int *) realloc(arr->data, arr->capacity * sizeof(int));

        if (temp == NULL)
            exit(1);

        arr->data = temp;
    }
    arr->data[arr->size++] = ele;
    return 0;
}

int poparr(Array *arr) {
    if (arr->size == 0)
        exit(1);

    int ele = arr->data[--arr->size];

    if (arr->size < arr->capacity / 4) {
        arr->capacity /= 2;
        
        if (arr->capacity < 4)
            arr->capacity = 4;

        int *temp = (int *) realloc(arr->data, arr->capacity * sizeof(int));

        if (temp == NULL)
            exit(1);
            
        arr->data = temp;
    }
    return ele;
}

int _compare(const void *a, const void *b) {
    int x = *(int *)a;
    int y = *(int *)b;

    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

void sortarr(Array *arr) {
    qsort(arr->data, arr->size, sizeof(int), _compare);
}
