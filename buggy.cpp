#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>
#include <unordered_set>

using namespace std;

struct Instruction {
    string inst;
    int value;
    bool visited;
};

int main() {
    string filename;
    cout << "Choose an input file (input.txt or example.txt): ";
    cin >> filename;

    ifstream file(filename);
    if(!file.is_open()) {
        cout << "Error: file not found." << endl;
    return 1;
    }
    vector<Instruction> instructions;
    string line;
    while (getline(file, line)) {
        Instruction instr;
        instr.inst = line.substr(0, 3);
        instr.value = stoi(line.substr(4));
        instr.visited = false;
        instructions.push_back(instr);
    }
    file.close();

    int treat = 0;
    int currentInstruction = 0;
    unordered_set<int> visitedInstructions;

    while(true) {
        if(visitedInstructions.count(currentInstruction) > 0) {
            cout << treat << endl;
            break;
        }
    Instruction& current = instructions[currentInstruction];
    current.visited = true;

    visitedInstructions.insert(currentInstruction);
    if(current.inst == "acc") {
        treat += current.value;
        currentInstruction++;
    }
    else if(current.inst == "jmp") {
        currentInstruction += current.value;
    }
    else if(current.inst == "sit") {
        currentInstruction++;
    }
    if(currentInstruction >= instructions.size()) {
        cout << "End of program reached without looping." << endl;
        break;
    }
    }
    return 0;
    }

