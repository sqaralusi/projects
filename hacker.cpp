#include <iostream>
#include <string>
using namespace std;

int main() {
    string input;
    cout << "Please enter your phrase: ";
    getline(cin, input);

    string hacker_speak = input;

    for (int i = 0; i < hacker_speak.length(); ++i) {
        if (hacker_speak[i] == 'a' || hacker_speak[i] == 'A') {
            hacker_speak[i] = '4';
        }
        else if (hacker_speak[i] == 'e' || hacker_speak[i] == 'E') {
            hacker_speak[i] = '3';
        }
        else if (hacker_speak[i] == 'i' || hacker_speak[i] == 'I') {
            hacker_speak[i] = '1';
        }
        else if (hacker_speak[i] == 'o' || hacker_speak[i] == 'O') {
            hacker_speak[i] = '0';
        }
    }

    cout << input << " in H4ck3r Sp34k: " << hacker_speak << endl;
    return 0;
}
