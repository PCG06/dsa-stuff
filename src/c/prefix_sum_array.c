// DSA09 (C): Prefix Sum Array

#include <stdio.h>

static void prefixArray(int arr[], int prefix[], int n);
static int rangeSum(int prefix[], int left, int right);

int main(void) {
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("The array elements are: ");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    int prefix[n];
    prefixArray(arr, prefix, n);

    printf("The prefix array: ");
    for (int i = 0; i < n; i++)
        printf("%d ", prefix[i]);
    printf("\n");

    if (n >= 3)
        printf("Range sum [0, 2]: %d\n", rangeSum(prefix, 0, 2));

    if (n >= 4)
        printf("Range sum [1, 3]: %d\n", rangeSum(prefix, 1, 3));

    if (n >= 5)
        printf("Range sum [2, 4]: %d\n", rangeSum(prefix, 2, 4));
    
    return 0;
}

static void prefixArray(int arr[], int prefix[], int n) {
    prefix[0] = arr[0];

    for (int i = 1; i < n; i++)
        prefix[i] = prefix[i - 1] + arr[i];
}

static int rangeSum(int prefix[], int left, int right) {
    if (left == 0)
        return prefix[right];

    return prefix[right] - prefix[left - 1];
}
