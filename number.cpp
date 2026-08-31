#include <iostream>
#include "util.h"

int main() {
    setSeed(1);
    int secretNumber = randInt(1, 100);
    int guess;

    cout << "Welcome to the Number Guessing Game!\n";
    cout << "I have chosen a number between 1 and 100. Can you guess it?\n";
    while (true) {
        guess = readInt("Enter your guess: ");

        if (guess == secretNumber) {
            cout << "Congratulations! You guessed the correct number.\n";
            break;
        }
        else if (guess < secretNumber) {
            cout << "Higher!\n";
        }
        else {
            cout << "Lower!\n";
        }
    }
    return 0;
}
