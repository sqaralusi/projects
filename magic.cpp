#include "util.h"
#include <fstream>
#include <vector>

int sumRow(vector<vector<int>>& square, int row) {
    int sum = 0;
    for (int j = 0; j < square[row].size(); ++j) {
        sum += square[row][j];
    }
    return sum;
}

int sumCol(vector<vector<int>>& square, int col) {
    int sum = 0;
    for (int i = 0; i < square.size(); ++i) {
        sum += square[i][col];
    }
    return sum;
}

int sumMainDiag(vector<vector<int>>& square) {
    int sum = 0;
    for (int i = 0; i < square.size(); ++i) {
        sum += square[i][i];
    }
    return sum;
}

int sumOtherDiag(vector<vector<int>>& square) {
    int sum = 0;
    for (int i = 0; i < square.size(); ++i) {
        sum += square[i][square.size() - i - 1];
    }
    return sum;
}

bool magic(vector<vector<int>>& square) {
    int sum = sumMainDiag(square);
    if (sum != sumOtherDiag(square))
        return false;

    for (int i = 0; i < square.size(); ++i) {
        if (sumRow(square, i) != sum || sumCol(square, i) != sum)
            return false;
    }

    return true;
}

void printSquare(vector<vector<int>>& square) {
    for (auto& row : square) {
        for (int num : row)
            cout << num << "\t";
        cout << endl;
    }
}


int main() {
    ifstream in;
    in.open("magic_data.txt");
    if(in.fail())
        Error("File didn't open - check the name");

    int count = 1; //count which square we're on

    string line;
    getline(in, line);
    int size = stoi(line); //size of next square

	//Expecting -1 at bottom of input file
	while (size != -1) {
	    //create a new square and read in the data
	    vector<vector<int> > square;
        for (int i = 0; i < size; i++){
            vector<int> row;
            getline(in, line);
            vector<string> input = splitLine(line);
            for(int j = 0; j < input.size(); j++){
                row.push_back(stoi(input[j]));
            }
            square.push_back(row);
        }
        // Print out
		cout << "******** Square " << count << " ********" << endl;
        printSquare(square);

        // Display results
        if (magic(square)){
            cout << "The Square is magic! Everything sums to ";
            cout << sumRow(square, 0) << "." << endl;
        }
        else {
            cout << "The Square is not a magic square." << endl;
        }

        getline(in, line);
        size = stoi(line); //size of next square
        count ++;
	}
    return 0;
}
