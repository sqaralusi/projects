#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;

char calculateGrade(double avg) {
    if (avg >= 90) return 'A';
    else if (avg >= 80) return 'B';
    else if (avg >= 70) return 'C';
    else if (avg >= 60) return 'D';
    else return 'F';
}

double calculateRemainingAvg(vector<int>& grades, double currentAvg, int quarters, char desiredGrade) {
    double sum = currentAvg * quarters;
    double remainingQuarters = 4 - quarters;
    double minAvg;

    if (desiredGrade == 'A') {
        minAvg = (90 * 4 - sum) / remainingQuarters;
    }
    else if (desiredGrade == 'B') {
        minAvg = (80 * 4 - sum) / remainingQuarters;
    }
    else if (desiredGrade == 'C') {
        minAvg = (70 * 4 - sum) / remainingQuarters;
    }
    else if (desiredGrade == 'D') {
        minAvg = (60 * 4 - sum) / remainingQuarters;
    }
    else {
        minAvg = (60 * 4 - sum) / remainingQuarters;
    }
    return minAvg;
}

int main() {
    vector<int> grades;
    int grade;
    double currentAvg = 0;
    int quarters = 0;

    while (true) {
        cout << "Please enter your quarterly grade (-1 when finished): ";
        cin >> grade;

        if (grade == -1) {
            if (quarters == 0) {
                cout << "You must enter at least one quarterly average!" << endl;
                return 1;
            }
            break;
        }

        grades.push_back(grade);
        currentAvg += grade;
        quarters++;
    }

    currentAvg /= quarters;

    char currentGrade = calculateGrade(currentAvg);
    cout << fixed << setprecision(1);

    cout << "To get a " << currentGrade << " for the year, you will need to average: " << calculateRemainingAvg(grades, currentAvg, quarters, currentGrade) << endl;

    if (currentGrade != 'A') {
        char nextGrade = currentGrade + 1;
        cout << "To keep a " << currentGrade << " for the year, you will need to average: " << calculateRemainingAvg(grades, currentAvg, quarters, nextGrade) << endl;
    }

    return 0;
}
