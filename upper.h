#include <string>

using namespace std;

string upperCase(const string& str) {
    string result;
    for(char c : str) {
        result += toupper(c);
    }
    return result;
}
