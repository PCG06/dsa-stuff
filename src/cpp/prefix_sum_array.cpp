// DSA09 (C++): Prefix Sum Array

#include <iostream>
#include <vector>

using namespace std;

static void prefixArray(vector<int>& arr, vector<int>& prefix);
static int rangeSum(vector<int>& prefix, int left, int right);

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "The array elements are: ";
    for (int i : arr)
        cout << i << ' ';
    cout << "\n";

    vector<int> prefix(n);
    prefixArray(arr, prefix);

    cout << "The prefix array: ";
    for (int i : prefix)
        cout << i << ' ';
    cout << "\n";

    if (n >= 3)
        cout << "Range sum [0, 2]: " << rangeSum(prefix, 0, 2) << "\n";

    if (n >= 4)
        cout << "Range sum [1, 3]: " << rangeSum(prefix, 1, 3) << "\n";

    if (n >= 5)
        cout << "Range sum [2, 4]: " << rangeSum(prefix, 2, 4) << "\n";
    
    return 0;
}

static void prefixArray(vector<int>& arr, vector<int>& prefix) {
    int n = prefix.size();

    prefix[0] = arr[0];

    for (int i = 1; i < n; i++)
        prefix[i] = prefix[i - 1] + arr[i];
}

static int rangeSum(vector<int>& prefix, int left, int right) {
    if (left == 0)
        return prefix[right];

    return prefix[right] - prefix[left - 1];
}
