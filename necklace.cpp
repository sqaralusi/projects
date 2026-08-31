#include <iostream>
using namespace std;

int main()
{
    int num1, num2;

    cout << "Please enter two digits separated by a space: ";
    cin >> num1 >> num2;
    num1 %= 10;
    num2 %= 10;

    cout << num1 << " " << num2 << " ";

    int old1 = num1, old2 = num2;
    int steps = 0;
    do {
        const int newcur = (old1 + old2) % 10;
        cout << newcur << " ";

        old1 = old2;
        old2 = newcur;
        ++steps;
    }
    while (old1 != num1 || old2 != num2);

    cout << '\n' << "Total Steps: " << steps << endl;
}
