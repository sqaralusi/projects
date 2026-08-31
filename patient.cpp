#include <iostream>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include "util.h"

using namespace std;

struct patient {
    string name;
    float temperature;
};

void promptPatientInfo(vector<patient>& patients);

int main() {
    vector<patient> patients;
    promptPatientInfo(patients);

    cout << "\nThe following patients may attend:\n";
    for (const auto& p : patients) {
        if (p.temperature < 100)
            cout << p.name << endl;
    }

    return 0;
}

void promptPatientInfo(vector<patient>& patients) {
    while (true) {
        string name;
        float temperature;

        cout << "Please enter the patient's name ('exit' when done): ";
        name = toUpperCase(readLine(""));

        if (name == "EXIT")
            break;

        cout << "\nPlease enter their temperature: ";
        temperature = readDouble(95.0, 106.0, "Temperature should be between 95 and 106: ", "Temperature should be between 95 and 106: ");

        patients.push_back({name, temperature});
    }
}
