#include <iostream>
#include <string>
#include <stdexcept>

using namespace std;

int main() {
    string input;
    int age;

    while (true) {
        cout << "Please enter your age: ";
        getline(cin, input);

        try {
            age = stoi(input);

            if (age < 0) {
                throw invalid_argument("Age cannot be negative.");
            }
            else if (age < 2) {
                throw "Age invalid. Too young.";
            }
            else if (age > 110) {
                throw "Age invalid. Too old.";
            }

            cout << "On your next birthday, you will be " << age + 1 << " years old.\n";
            break;
        }
        catch (invalid_argument) {
            cout << "Invalid input. Please enter a valid number.\n";
        }
        catch (exception const& e) {
            cout << e.what() << endl;
        }
        catch(const char* error) {
            cerr<<"Error: "<<error<<endl;
        }
    }
    return 0;
}
