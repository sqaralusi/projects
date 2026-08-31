#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <limits>
using namespace std;

struct Movie {
    string title;
    string actor;
    int year;
    double rating;
};

// Function prototypes
void addMoviesFromFile(vector<Movie> &movies, const string& filename);
void listMovies(const vector<Movie> &movies);
void searchMenu(const vector<Movie> &movies);
void searchByTitle(const vector<Movie> &movies);
void searchByYear(const vector<Movie> &movies);
void searchByActor(const vector<Movie> &movies);
void searchByRating(const vector<Movie> &movies);

int main() {
    vector<Movie> movies;
    addMoviesFromFile(movies, "movies.txt");

    char choice;
    do {
        cout << "Would you like to (s)earch, (l)ist movies, or (e)xit? ";
        cin >> choice;
        switch(choice) {
            case 's':
                searchMenu(movies);
                break;
            case 'l':
                listMovies(movies);
                break;
            case 'e':
                cout << "Exiting..." << endl;
                break;
            default:
                cout << "Invalid input." << endl;
        }
    } while(choice != 'e');

    return 0;
}

void addMoviesFromFile(vector<Movie> &movies, const string& filename) {
    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Error opening file " << filename << endl;
        return;
    }
    string line;
    while (getline(file, line)) {
        stringstream ss(line);
        Movie newMovie;
        getline(ss, newMovie.title, ';');
        ss >> newMovie.year;
        ss.ignore();
        getline(ss, newMovie.actor, ';');
        ss >> newMovie.rating;
        movies.push_back(newMovie);
    }
    file.close();
}

void listMovies(const vector<Movie> &movies) {
    if(movies.empty()) {
        cout << "No movies to display." << endl;
        return;
    }

    cout << "Listing movies..." << endl;
    int movieCount = 0;
    for(const Movie &movie : movies) {
        cout << "Title: " << movie.title << endl;
        cout << "Year: " << movie.year << endl;
        cout << "Actor: " << movie.actor << endl;
        cout << "Rating: " << movie.rating << endl << endl;
        movieCount++;
    }

    cout << "Total Count: " << movieCount << endl;
}

void searchMenu(const vector<Movie> &movies) {
    cout << "Search menu:" << endl;
    cout << "1. Search by Title" << endl;
    cout << "2. Search by Year" << endl;
    cout << "3. Search by Actor" << endl;
    cout << "4. Search by Rating" << endl;

    int option;
    cout << "Enter option: ";
    cin >> option;

    switch(option) {
        case 1:
            searchByTitle(movies);
            break;
        case 2:
            searchByYear(movies);
            break;
        case 3:
            searchByActor(movies);
            break;
        case 4:
            searchByRating(movies);
            break;
        default:
            cout << "Invalid option. Please enter a number between 1 and 4." << endl;
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
}

void searchByTitle(const vector<Movie> &movies) {
    string searchTerm;
    cout << "Please enter a title to search for: ";
    cin.ignore();
    getline(cin, searchTerm);

    vector<Movie> results;
    for(const Movie &movie : movies) {
        if(movie.title.find(searchTerm) != string::npos) {
            results.push_back(movie);
        }
    }
    listMovies(results);
}

void searchByYear(const vector<Movie> &movies) {
    int startYear, endYear;
    cout << "Please enter the starting year to search: ";
    cin >> startYear;
    cout << "Please enter the ending year to search: ";
    cin >> endYear;

    vector<Movie> results;
    for(const Movie &movie : movies) {
        if(movie.year >= startYear && movie.year <= endYear) {
            results.push_back(movie);
        }
    }
    listMovies(results);
}

void searchByActor(const vector<Movie> &movies) {
    string searchTerm;
    cout << "Please enter an actor's name to search for: ";
    cin.ignore(); // Ignore the newline character left in the buffer
    getline(cin, searchTerm);

    vector<Movie> results;
    for(const Movie &movie : movies) {
        if(movie.actor.find(searchTerm) != string::npos) {
            results.push_back(movie);
        }
    }
    listMovies(results);
}

void searchByRating(const vector<Movie> &movies) {
    double minRating, maxRating;
    cout << "Please enter the minimum rating: ";
    cin >> minRating;
    cout << "Please enter the maximum rating: ";
    cin >> maxRating;

    vector<Movie> results;
    for(const Movie &movie : movies) {
        if(movie.rating >= minRating && movie.rating <= maxRating) {
            results.push_back(movie);
        }
    }
    listMovies(results);
}
