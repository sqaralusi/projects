
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int computerTurn() {
    int roundScore = 0;
    bool rolledOne = false;
    while (true) {
        int roll = rand() % 6 + 1;
        if (!rolledOne) {
            cout << "\nThe computer rolled a " << roll;
            if (roll == 1) {
                cout << ". End of turn\n\n";
                rolledOne = true;
            }
            else {
                cout << "\n";
            }
        }

        if (roll == 1) {
            roundScore = 0;
            break;
        }
        else {
            roundScore += roll;
            cout << "This round the computer has: " << roundScore << "\n";
            if (roundScore >= 15) {
                cout << "The computer chooses to bank its points.\n\n";
                break;
            }
            else {
                cout << "The computer chooses to roll again.\n\n";
            }
        }
    }
    return roundScore;
}

int main() {
    srand(time(0));

    int playerTotalScore = 0;
    int computerTotalScore = 0;
    int turn = 1;

    while (playerTotalScore < 100 && computerTotalScore < 100) {
        int playerRoundScore = 0;
        int computerRoundScore = 0;
        cout << "Turn " << turn << "\n";
        cout << "Your Current Score is: " << playerTotalScore << "\n";
        cout << "Computer Current Score is: " << computerTotalScore << "\n";
        cout << "This round you have: " << playerRoundScore << "\n";

        while (true) {
            cout << "Would you like to roll or bank? ";
            string choice;
            cin >> choice;

            if (choice == "roll") {
                int roll = rand() % 6 + 1;
                cout << "\nYou rolled a " << roll << ".\n";

                if (roll == 1) {
                    playerRoundScore = 0;
                    cout << "You rolled a 1! You get a zero for this round!\n\n";
                    break;
                }
                else {
                    playerRoundScore += roll;
                    cout << "This round you have: " << playerRoundScore << "\n";
                }
            }
            else if (choice == "bank") {
                playerTotalScore += playerRoundScore;
                break;
            }
            else {
                cout << "Invalid choice. Please enter 'roll' or 'bank'.\n";
            }
        }

        computerRoundScore = computerTurn();
        computerTotalScore += computerRoundScore;

        turn++;
    }

    cout << "\n";
    if (playerTotalScore >= 100 && computerTotalScore >= 100) {
        if (playerTotalScore > computerTotalScore) {
            cout << "Congratulations! You won on " << turn - 1 << " turns!\n";
        }
        else if (playerTotalScore < computerTotalScore) {
            cout << "Good try! The Computer won on " << turn - 1 << " turns.\n";
        }
        else {
            cout << "It's a tie!\n";
        }
    }
    else if (playerTotalScore >= 100) {
        cout << "Congratulations! You won on " << turn - 1 << " turns!\n";
    }
    else {
        cout << "Good try! The Computer won on " << turn - 1 << " turns.\n";
    }

    return 0;
}
