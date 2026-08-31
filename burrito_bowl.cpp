#include <iostream>
#include <string>

using namespace std;
void burritoBowl(string protein, string rice = "white", string beans = "black", string salsa = "mild");

int main()
{
    burritoBowl("chicken");
    burritoBowl("steak", "white", "refried", "hot");
    burritoBowl("veggie", "brown");
    return 0;
}
void burritoBowl(string protein, string rice, string beans, string salsa) {
    cout << "Your Burrito Bowl: " << endl;
    cout << "A " << protein << " with " << rice << " rice" << ", " << beans << " beans" << ", and " << salsa << " salsa." << endl;
}
