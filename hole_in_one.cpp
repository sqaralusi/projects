#include <iostream>

using namespace std;

int main()
{
    string first;
    string second;
    cout << "Please enter your first string: ";
    getline(cin, first);
    cout << "Please enter your second string: ";
    getline(cin, second);
    cout << second.insert(second.length()/2, first);
    return 0;
}
