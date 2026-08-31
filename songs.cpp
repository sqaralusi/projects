#include <iostream>

using namespace std;

struct song {
    string title;
    string artist;
    int length_seconds;
};

int main()
{
    song song1;
    song1.title = "Believer";
    song1.artist = "Imagine Dragons";
    song1.length_seconds = 207;
    cout << song1.title << " by " << song1.artist << " is " << song1.length_seconds << " seconds long." << endl;
    song song2;
    song2.title = "Alexander Hamilton";
    song2.artist = "Original Broadway Cast";
    song2.length_seconds = 237;
    cout << song2.title << " by " << song2.artist << " is " << song2.length_seconds << " seconds long." << endl;
    return 0;
}
