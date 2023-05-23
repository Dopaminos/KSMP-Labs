#ifndef RATIONAL_H
#define RATIONAL_H

#include <iostream>

class Rational {
private:
    int numerator;
    int denominator;

public:
    Rational(int numerator = 0, int denominator = 1);

    int getNumerator() const;
    int getDenominator() const;
    friend std::istream& operator>>(std::istream& is, Rational& rational);
    friend std::ostream& operator<<(std::ostream& os, const Rational& rational);
    Rational operator+(const Rational& other) const;
    Rational operator-(const Rational& other) const;
    Rational operator*(const Rational& other) const;
    Rational operator/(const Rational& other) const;
    bool operator==(const Rational& other) const;
    bool operator!=(const Rational& other) const;
    bool operator<(const Rational& other) const;
    bool operator>(const Rational& other) const;
    bool operator<=(const Rational& other) const;
    bool operator>=(const Rational& other) const;

    Rational reduce() const;
    double toDouble() const;
};

std::ostream& operator<<(std::ostream& out, const Rational& r);
Rational fromDouble(double x, double accuracy);
std::istream& operator>>(std::istream& is, Rational& rational);

#endif 
