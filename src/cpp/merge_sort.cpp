// DSA16 (C++): Merge Sort

#include <iostream>
#include <vector>

using namespace std;

void mergeSort(vector<int>& arr, int left, int right);
void merge(vector<int>& arr, int left, int mid, int right);

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

    mergeSort(arr, 0, arr.size() - 1);

    cout << "Array elements after sorting are: ";
    for (int i : arr)
        cout << i << ' ';
    cout << "\n";

    return 0;
}

void mergeSort(vector<int>& arr, int left, int right) {
    if (left >= right) 
        return;

    int mid = left + (right - left) / 2;

    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    merge(arr, left, mid, right);
}

void merge(vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<int> l(n1);
    vector<int> r(n2);

    for (int i = 0; i < n1; i++)
        l[i] = arr[left + i];

    for (int i = 0; i < n2; i++)
        r[i] = arr[mid + 1 + i];

    int i = 0;
    int j = 0;
    int k = left;

    while (i < n1 && j < n2) {
        if (l[i] <= r[j])
            arr[k++] = l[i++];
        else
            arr[k++] = r[j++];
    }

    while (i < n1)
        arr[k++] = l[i++];

    while (j < n2)
        arr[k++] = r[j++];
}
