// DSA03 (C++): Bubble Sort

#include <iostream>
#include <vector>

using namespace std;

static void bubbleSort(vector<int>& arr);

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

    bubbleSort(arr);

    cout << "The array elements after sorting are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    return 0;
}

static void bubbleSort(vector<int>& arr) {
    size_t n = arr.size();

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
