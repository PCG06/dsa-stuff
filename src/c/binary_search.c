// C03: Program to perform binary search

#include <stdio.h>

int binarySearch(int arr[], int n, int target);

int main() {
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

    int pos = binarySearch(arr, n, target);

    if (pos != -1)
        printf("Element found at index %d", pos);
    else
        printf("Element not found");
    printf("\n");

    return 0;
}

int binarySearch(int arr[], int n, int target) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (target == arr[mid])
            return mid;
        
        if (target < arr[mid])
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}
