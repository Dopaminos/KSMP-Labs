#include "rational.h"
#include <iostream>
void input(); 
int main() {
    int choice;
    Rational r1, r2;

    do {
        std::cout << "\n=====================\n"
            << "Rational Calculator\n"
            << "=====================\n"
            << "1. Add two rational numbers\n"
            << "2. Subtract two rational numbers\n"
            << "3. Multiply two rational numbers\n"
            << "4. Divide two rational numbers\n"
            << "5. Compare two rational numbers\n"
            << "6. Convert a decimal to a rational number\n"
            << "7. Exit\n"
            << "Enter your choice: ";

        std::cin >> choice;
        switch (choice) {
        case 1:
            std::cout << "Enter the first rational number: ";
            std::cin >> r1;
            std::cout << "Enter the second rational number: ";
            std::cin >> r2;
            std::cout << "Result: " << r1 + r2 << "\n";
            break;

        case 2:
            std::cout << "Enter the first rational number: ";
            std::cin >> r1;
            std::cout << "Enter the second rational number: ";
            std::cin >> r2;
            std::cout << "Result: " << r1 - r2 << "\n";
            break;

        case 3:
            std::cout << "Enter the first rational number: ";
            std::cin >> r1;
            std::cout << "Enter the second rational number: ";
            std::cin >> r2;
            std::cout << "Result: " << r1 * r2 << "\n";
            break;

        case 4:
            std::cout << "Enter the first rational number: ";
            std::cin >> r1;
            std::cout << "Enter the second rational number: ";
            std::cin >> r2;
            std::cout << "Result: " << r1 / r2 << "\n";
            break;

        case 5:
            std::cout << "Enter the first rational number: ";
            std::cin >> r1;
            std::cout << "Enter the second rational number: ";
            std::cin >> r2;

            if (r1 == r2) {
                std::cout << "Both numbers are equal.\n";
            }
            else if (r1 < r2) {
                std::cout << r1 << " is less than " << r2 << ".\n";
            }
            else {
                std::cout << r1 << " is greater than " << r2 << ".\n";
            }

            break;

        case 6:
            double x, accuracy;
            std::cout << "Enter a decimal number: ";
            std::cin >> x;
            std::cout << "Enter the accuracy (number of decimal places): ";
            std::cin >> accuracy;
            std::cout << "Result: " << fromDouble(x, accuracy) << "\n";
            break;

        case 7:
            std::cout << "Goodbye!\n";
            break;

        default:
            std::cout << "Invalid choice. Please enter a number between 1 and 7.\n";
            break;
        }

    } while (choice != 7);

    return 0;
