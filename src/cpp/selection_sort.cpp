// DSA05 (C++): Selection Sort

#include <iostream>
#include <vector>

using namespace std;

static void selectionSort(vector<int>& arr);

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "The array elements before sorting are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    selectionSort(arr);

    cout << "The array elements after sorting are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    return 0;
}

static void selectionSort(vector<int>& arr) {
    size_t n = arr.size();

    for (int i = 0; i < n -1; i++) {
        int min = i;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min])
                min = j;
        }

        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
