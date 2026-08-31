#include <iostream>
#include <string>
#include <bitset>

using namespace std;

int main() {
    int empKeyStart = 686;
    int compKeyStart = 1248;

    int empFactor = 692;
    int compFactor = 483;

    int divisor = 308947;

    int numPairs;
    cout << "Enter the number of pairs to compare: ";
    cin >> numPairs;

    int matchCount = 0;

    for (int i = 0; i < numPairs; ++i) {
        empKeyStart = (empKeyStart * empFactor) % divisor;
        compKeyStart = (compKeyStart * compFactor) % divisor;

        string empBinary = bitset<32>(empKeyStart).to_string();
        string compBinary = bitset<32>(compKeyStart).to_string();

        if (empBinary.substr(20) == compBinary.substr(20)) {
            matchCount++;
        }
    }

    cout << "Number of matches: " << matchCount << endl;

    return 0;
}
