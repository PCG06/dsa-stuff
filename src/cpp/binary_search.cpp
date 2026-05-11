// CPP01: Program to perform binary search

#include <iostream>
#include <vector>

using namespace std;

int binarySearch(vector<int>& arr, int target);

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int& i: arr)
        cin >> i;

    int target;
    cout << "Enter the search element: ";
    cin >> target;

    cout << "The array elements are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << endl;

    int pos = binarySearch(arr, target);

    if (pos != -1)
        cout << "Element found at index " << pos << endl;
    else
        cout << "Element not found" << endl;

    return 0;
}

int binarySearch(vector<int>& arr, int target) {
    int low = 0;
    int high = arr.size() - 1;

    while (low <= high)
    {
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
