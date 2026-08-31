#include <iostream>

using namespace std;

void printSpaces(int num_spaces) {
    for(int i = 0; i < num_spaces; ++i) {
        cout << " ";
    }
}
void printCircles(int num_circles) {
    for(int i = 0; i < num_circles; ++i) {
        cout << "o";
    }
}
void printTriangle(int size) {
    for(int i = 1; i <= size; ++i) {
        printSpaces(size - i);
        printCircles(2 * i - 1);
        cout << endl;
    }
}

int main()
{
    int size = 0;
    while(size <= 0 || size > 10) {
        cout << "Please enter the size of your triangle: " << endl;
        cin >> size;
        if(size <= 0 || size > 10) {
            cout << "Invalid input" << endl;
        }
    }


    printTriangle(size);
    return 0;
}
