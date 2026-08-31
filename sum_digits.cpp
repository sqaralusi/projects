#include <iostream>

using namespace std;

int main()
{
    int num;
    cout << "Please enter a positive integer: ";
    cin >> num;
    if (num <= 0) {
        cout << "Number must be positive" << endl;
        return 1;
    }
    int sum = 0;
    while (num > 0) {
        sum += num % 10;
        num /= 10;
    }
    cout << "The sum of the digits is " << sum << endl;
    return 0;
}
