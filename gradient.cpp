#include <iostream>
#include <vector>

using namespace std;

int main() {
    int width, height, seed, step;

    cout << "Please enter a width: ";
    cin >> width;
    cout << "Please enter a height: ";
    cin >> height;
    cout << "Please enter a seed value: ";
    cin >> seed;
    cout << "Please enter a step value: ";
    cin >> step;

    vector<vector<int>> gradient(height, vector<int>(width));

    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            gradient[i][j] = seed + i * step + j * step;
        }
    }
    for (const auto &row : gradient) {
        for (const auto &value : row) {
            cout << value << "\t";
        }
        cout << endl;
    }
    return 0;
}
