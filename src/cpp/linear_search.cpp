// DSA01 (C++): Linear Search

#include <iostream>
#include <vector>

using namespace std;

int linearSearch(vector<int>& arr, int target);

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

    int pos = linearSearch(arr, target);

    if (pos != -1)
        cout << "Element found at index " << pos << "\n";
    else
        cout << "Element not found" << "\n";

    return 0;
}

int linearSearch(vector<int>& arr, int target) {
    size_t n = arr.size();

    for (int i = 0; i < n; i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}
