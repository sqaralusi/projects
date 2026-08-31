#include <iostream>
using namespace std;

int main() {
    int cents;
    cout << "Please enter an amount (less than 1000 cents): ";
    cin >> cents;
    if (cents < 0) {
        cout << "Error: Negative input" << endl;
        return 1;
    } else if (cents > 999) {
        cout << "Error: Input greater than 999" << endl;
        return 2;
    }
    int quarters = cents / 25;
    cents %= 25;
    int dimes = cents / 10;
    cents %= 10;
    int nickels = cents / 5;
    cents %= 5;
    int pennies = cents;
    cout << endl;
    cout << "Quarters: " << quarters << endl;
    cout << "Dimes: " << dimes << endl;
    cout << "Nickels: " << nickels << endl;
    cout << "Pennies: " << pennies << endl;
    return 0;
}
