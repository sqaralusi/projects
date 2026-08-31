#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> initial {8, 3, 9, 5, 14, 11, 23, 2, 6};
    vector<int> evenVector;
    vector<int> oddVector;

    for (int value : initial) {
        if (value % 2 == 0) {
            evenVector.push_back(value);
        }
        else {
            oddVector.push_back(value);
        }
    }

    for (int value : evenVector) {
        cout << value << " ";
    }
    cout << endl;

    for (int value : oddVector) {
        cout << value << " ";
    }
    cout << endl;

    return 0;
}
