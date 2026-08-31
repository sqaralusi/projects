#include <iostream>
#include <vector>
#include <string>

using namespace std;

string nextAppointment(int day, int daysToNext = 7);

string getDayOfWeek(int day) {
    vector<string> daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    return daysOfWeek[day - 1];
}
string nextAppointment(int day, int daysToNext) {
    int followUpDay = (day + daysToNext) % 7;
    if (followUpDay == 0)
        followUpDay = 7;

    return getDayOfWeek(followUpDay);
}
int main() {
    cout << "What type of appointment do you have? ";
    string appointmentType;
    getline(cin, appointmentType);

    cout << "Which day is your appointment?" << endl;
    cout << "1: Sunday\n2: Monday\n3: Tuesday\n4: Wednesday\n5: Thursday\n6: Friday\n7: Saturday\n";
    int appointmentDay;
    cin >> appointmentDay;

    int daysToNext = 7;
    if (appointmentType == "Oncologist")
        daysToNext = 2;
    else if (appointmentType == "Orthodontist")
        daysToNext = 10;

    string followUpDay = nextAppointment(appointmentDay, daysToNext);
    cout << "Your follow up will be on a " << followUpDay << endl;

    return 0;
}
