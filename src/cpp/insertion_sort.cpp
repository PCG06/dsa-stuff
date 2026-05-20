// DSA04 (C++): Insertion Sort

#include <iostream>
#include <vector>

using namespace std;

static void insertionSort(vector<int>& arr);

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "The array elements before sorting are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    insertionSort(arr);

    cout << "The array elements after sorting are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    return 0;
}

static void insertionSort(vector<int>& arr) {
    size_t n = arr.size();

    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
