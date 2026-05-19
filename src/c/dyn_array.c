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
size_t getarrsize(Array *arr);
size_t getarrcapacity(Array *arr);
int pusharr(Array *arr, int value);
int poparr(Array *arr);
void printarr(Array *arr, char *sep);
void sortarr(Array *arr);

int main() {
    size_t n;
    printf("Enter number of elements: ");
    scanf("%zu", &n);

    Array arr = array(n);
    printf("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        int val;
        scanf("%d", &val);
        pusharr(&arr, val);
    }

    int ch = 0;
    do {
        printf("\n--- Menu ---\n"
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
                int val;
                printf("Enter the new element: ");
                scanf("%d", &val);
                if (pusharr(&arr, val) == 0)
                    printf("Element %d pushed!", val);
            }
            break;

            // 2: Pop end
            case 2:
                if (getarrsize(&arr) == 0) {
                    printf("There is nothing to pop!");
                } else {
                    int val = poparr(&arr);
                    printf("Element %d popped!", val);
                }
            break;

            // 3: Sorting
            case 3:
                if (getarrsize(&arr) == 0) {
                    printf("There is nothing to sort!");
                } else {
                    sortarr(&arr);
                    printf("Array sorted!");
                }
            break;

            // 4: Display array
            case 4:
                if (getarrsize(&arr) == 0) {
                    printf("There is nothing to display!");
                } else {
                    printf("Array elements are: ");
                    printarr(&arr, ", ");
                }
            break;

            // 5: Display array
            case 5:
                printf("--- Array details ---\n");
                printf("Array memory: %zu (bytes)\n", sizeof(arr));
                printf("Array size: %zu\n", getarrsize(&arr));
                printf("Array capacity: %zu", getarrcapacity(&arr));
            break;

            // 6: Exiting
            case 6:
                printf("Exiting...");
            break;

            // Invalid input
            default:
                printf("Invalid choice! Enter again");
            break;
        }
        printf("\n");
    } while (ch != 6);

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

int pusharr(Array *arr, int value) {
    if (arr->size >= arr->capacity) {
        arr->capacity *= 2;

        int *temp = (int *) realloc(arr->data, arr->capacity * sizeof(int));

        if (temp == NULL)
            exit(1);

        arr->data = temp;
    }
    arr->data[arr->size++] = value;
    return 0;
}

int poparr(Array *arr) {
    if (arr->size == 0)
        exit(1);

    int value = arr->data[--arr->size];

    if (arr->size < arr->capacity / 4) {
        arr->capacity /= 2;
        
        if (arr->capacity < 4)
            arr->capacity = 4;

        int *temp = (int *) realloc(arr->data, arr->capacity * sizeof(int));

        if (temp == NULL)
            exit(1);
            
        arr->data = temp;
    }
    return value;
}

void printarr(Array *arr, char *sep) {
    for (size_t i = 0; i < arr->size - 1; i++)
        printf("%d%s", arr->data[i], sep);
    printf("%d", arr->data[arr->size - 1]);
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
