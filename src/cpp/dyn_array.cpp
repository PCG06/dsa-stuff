// DSA08 (C++): Dynamic Array

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<int> arr;

    int ch = 0;

    do {
        cout << "--- Menu ---\n"
            "1. Push element (end)\n"
            "2. Pop element (end)\n"
            "3. Sort elements\n"
            "4. Display elements\n"
            "5. Show information\n"
            "6. Exit\n";

        cout << "\nEnter your choice: ";
        cin >> ch;

        switch (ch) {
            // 1: Push end
            case 1:
            {
                int ele;
                cout << "Enter the new element: ";
                cin >> ele;
                arr.push_back(ele);
                cout << "Element " << ele << " pushed!\n";
            }
            break;

            // 2: Pop end
            case 2:
                if (arr.empty()) {
                    cout << "There is nothing to pop!\n";
                } else {
                    int ele = arr.back();
                    arr.pop_back();
                    cout << "Element " << ele << " popped!\n";
                }
            break;

            // 3: Sorting
            case 3:
                if (arr.empty()) {
                    cout << "There is nothing to sort!\n";
                } else {
                    sort(arr.begin(), arr.end());
                    cout << "Array sorted!\n";
                }
            break;

            // 4: Display array
            case 4:
                if (arr.empty()) {
                    cout << "There is nothing to display!\n";
                } else {
                    cout << "Array elements are: ";
                    for (int i : arr)
                        cout << i << ' ';
                    cout << "\n";
                }
            break;

            // 5: Show information
            case 5:
                cout << "\n--- Array details ---\n";
                cout << "Array size: " << arr.size() << "\n";
                cout << "Array capacity: " << arr.capacity() << "\n";
            break;

            // 6: Exiting
            case 6:
                cout << "Exiting...";
            break;

            // Invalid input
            default:
                cout << "Invalid choice! Enter again\n";
            break;
        }
        cout << "\n";
    } while (ch != 6);

    return 0;
}
