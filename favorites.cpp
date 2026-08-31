#include <iostream>

using namespace std;

int main()
{
    string subject;
    string band;
    string activity;
    cout << "Please enter your favorite school subject: ";
    getline(cin, subject);
    cout << "Please enter your favorite musical artist or band: ";
    getline(cin, band);
    cout << "Please enter your favorite after-school activity: ";
    getline(cin, activity);
    cout << "Favorite subject: " << subject << endl;
    cout << "Favorite artist or band: " << band << endl;
    cout << "Favorite after-school activity: " << activity << endl;
    return 0;
}
