// DSA01 (C): Linear Search

#include <stdio.h>

static int linearSearch(int arr[], int n, int target);

int main(void) {
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int target;
    printf("Enter the search element: ");
    scanf("%d", &target);

    printf("The array elements are: ");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    int pos = linearSearch(arr, n, target);

    if (pos != -1)
        printf("Element found at index %d", pos);
    else
        printf("Element not found");
    printf("\n");

    return 0;
}

static int linearSearch(int arr[], int n, int target) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}
