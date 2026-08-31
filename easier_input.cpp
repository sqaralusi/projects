#include <iostream>

using namespace std;

string inputLine(string prompt) {
    cout << prompt;
    string input;
    getline(cin, input);
    return input;
}
double inputDouble(string prompt) {
    cout << prompt;
    double input;
    cin >> input;
    return input;
}
double inputDouble(string prompt, double min, double max) {
    double input;
    do {
        input = inputDouble(prompt);
    }
    while(input < min || input > max);
    return input;
}
int inputInt(string prompt) {
    cout << prompt;
    int input;
    cin >> input;
    return input;
}
int inputInt(string prompt, int min, int max) {
    int input;
    do {
        input = inputInt(prompt);
    }
    while(input < min || input > max);
    return input;
}

int main()
{
    string line = inputLine("Please enter a string: ");
    cout << "You entered: " << line << endl;
    double d = inputDouble("Please enter a double: ");
    cout << "You entered: " << d << endl;
    double d_range = inputDouble("Please enter a double between 0 and 1: ", 0, 1);
    cout << "You entered: " << d_range << endl;
    int i = inputInt("Please enter an integer: ");
    cout << "You entered: " << i << endl;
    int i_range = inputDouble("Please enter an integer between 0 and 10: ", 0, 10);
    cout << "You entered: " << i_range << endl;
    return 0;
}
