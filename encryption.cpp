#include <iostream>
#include <cctype>
using namespace std;

string encrypt(const string& phrase, int shift) {
    string result;
    for (char c : phrase) {
        if (isalpha(c)) {
            char shifted = toupper(c) + shift;
            if (shifted > 'Z') {
                shifted -= 26;
            }
            result += shifted;
        }
        else {
            result += c;
        }
    }
    return result;
}

string decrypt(const string& phrase, int shift) {
    string result;
    for (char c : phrase) {
        if (isalpha(c)) {
            char shifted = toupper(c) - shift;
            if (shifted < 'A') {
                shifted += 26;
            }
            result += shifted;
        }
        else {
            result += c;
        }
    }
    return result;
}

int main() {
    string phrase;
    char choice;
    int shift;

    cout << "Enter a phrase: ";
    getline(cin, phrase);

    do {
        cout << "Encrypt (e) or Decrypt (d)? ";
        cin >> choice;
        choice = toupper(choice);
    } while (choice != 'E' && choice != 'D');

    do {
        cout << "Enter the shift value (1-26): ";
        cin >> shift;
    } while (shift < 1 || shift > 26);

    if (choice == 'E') {
        string encrypted = encrypt(phrase, shift);
        cout << "Encrypted phrase: " << encrypted << endl;
    }
    else {
        string decrypted = decrypt(phrase, shift);
        cout << "Decrypted phrase: " << decrypted << endl;
    }
    return 0;
}
