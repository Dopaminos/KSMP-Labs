#include "polinom.h"
#include <iostream>

int PolinomRead(Polinom* p)
{
    std::cout << "Enter the degree of the polynomial (up to " << PolinomMaxDegree << "): ";
    std::cin >> p->n;

    if (p->n > PolinomMaxDegree) {
        std::cout << "Degree of the polynomial is too large.\n";
        return -1;
    }

    std::cout << "Enter the polynomial coefficients, starting with the highest degree:\n";
    for (int i = p->n; i >= 0; i--) {
        std::cin >> p->a[i];
    }

    if (p->a[p->n] == 0) {
        std::cout << "The highest degree coefficient must be non-zero.\n";
        return -1;
    }

    return 0;
}

void PolinomWrite(Polinom* p)
{
    std::cout << "Polynomial:";
    for (int i = p->n; i >= 0; i--) {
        std::cout << " " << p->a[i];
    }
    std::cout << std::endl;
}
