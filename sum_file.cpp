#include <iostream>
#include <fstream>

using namespace std;

int main() {
    string filename;
    cout << "Please enter a filename: ";
    cin >> filename;

    ifstream file(filename);
    if(!file.is_open()) {
        cout << "Error: file didn't open" << endl;
        return 1;
    }

    double sum = 0.0;
    string num_str;
    while(file >> num_str) {
        sum += stod(num_str);
    }

    cout << "The sum is " << sum << endl;
    return 0;
}
