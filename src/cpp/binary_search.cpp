// DSA02 (C++): Binary Search

#include <iostream>
#include <vector>

using namespace std;

static int binarySearch(vector<int>& arr, int target);

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    int target;
    cout << "Enter the search element: ";
    cin >> target;

    cout << "The array elements are: ";
    for (int i: arr)
        cout << i << ' ';
    cout << "\n";

    int pos = binarySearch(arr, target);

    if (pos != -1)
        cout << "Element found at index " << pos << "\n";
    else
        cout << "Element not found" << "\n";

    return 0;
}

static int binarySearch(vector<int>& arr, int target) {
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
