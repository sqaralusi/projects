#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> numbers;
    int num;

    cout << "Please enter a positive number (-1 to quit): ";
    cin >> num;

    while (num != -1) {
        vector<int>::iterator it = numbers.begin();
        while (it != numbers.end() && *it < num) {
            ++it;
        }
        numbers.insert(it, num);

        cout << "Please enter a positive number (-1 to quit): ";
        cin >> num;
    }

    for (vector<int>::iterator it = numbers.begin(); it != numbers.end(); ++it) {
        cout << *it << endl;
    }

    return 0;
}
