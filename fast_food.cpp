#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    const double CHICKEN_SANDWICH_PRICE = 3.90;
    const double WAFFLE_FRIES_PRICE = 2.20;
    const double SODA_PRICE = 1.60;
    const double SALES_TAX_RATE = 0.0825;
    int num_chicken_sandwiches;
    int num_waffle_fries;
    int num_sodas;

    cout << "Please enter the number of Chicken Sandwiches: ";
    cin >> num_chicken_sandwiches;
    cout << "Please enter the number of Waffle Fries: ";
    cin >> num_waffle_fries;
    cout << "Please enter the number of Sodas: ";
    cin >> num_sodas;

    double subtotal = num_chicken_sandwiches * CHICKEN_SANDWICH_PRICE +
                      num_waffle_fries * WAFFLE_FRIES_PRICE +
                      num_sodas * SODA_PRICE;
    double tax = subtotal * SALES_TAX_RATE;
    double total = subtotal + tax;
    printf("Subtotal: $%.2f\n", subtotal);
    printf("Tax: $%.2f\n", tax);
    printf("Total: $%.2f\n", total);
    return 0;
}
