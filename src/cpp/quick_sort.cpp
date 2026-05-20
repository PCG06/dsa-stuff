// DSA17 (C++): Quick Sort

#include <iostream>
#include <vector>

using namespace std;

static void quickSort(vector<int>& arr, int left, int right);

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "Array elements before sorting are: ";
    for (int i : arr)
        cout << i << ' ';
    cout << "\n";

    quickSort(arr, 0, arr.size() - 1);

    cout << "Array elements after sorting are: ";
    for (int i : arr)
        cout << i << ' ';
    cout << "\n";

    return 0;
}

static void quickSort(vector<int>& arr, int left, int right) {
    if (left >= right)
        return;

    int mid = left + (right - left) / 2;

    int pivot = arr[mid];
    int i = left;
    int j = right;

    while (i <= j) {
        while (arr[i] < pivot)
            i++;

        while (arr[j] > pivot)
            j--;

        if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    quickSort(arr, left, j);
    quickSort(arr, i, right);
}
