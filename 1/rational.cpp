#include "rational.h"
#include <iostream>
#include <cmath>
#include <numeric>

Rational::Rational(int numerator, int denominator) {
    if (denominator == 0) {
        throw std::invalid_argument("Denominator cannot be zero.");
    }

    if (numerator == 0) {
        this->numerator = 0;
        this->denominator = 1;
    }
    else {
        int sign = (numerator > 0) ? 1 : -1;
        int gcd = std::gcd(std::abs(numerator), denominator);
        this->numerator = sign * std::abs(numerator) / gcd;
        this->denominator = denominator / gcd;
    }
}

std::istream& operator>>(std::istream& is, Rational& rational) {
    int numerator, denominator;
    char slash;
    is >> numerator >> slash >> denominator;
    rational = Rational(numerator, denominator);
    return is;
}

int Rational::getNumerator() const {
    return numerator;
}

int Rational::getDenominator() const {
    return denominator;
}

Rational Rational::operator+(const Rational& other) const {
    int newDenominator = denominator * other.denominator;
    int newNumerator = numerator * other.denominator + denominator * other.numerator;
    return Rational(newNumerator, newDenominator).reduce();
}

Rational Rational::operator-(const Rational& other) const {
    int newDenominator = denominator * other.denominator;
    int newNumerator = numerator * other.denominator - denominator * other.numerator;
    return Rational(newNumerator, newDenominator).reduce();
}

Rational Rational::operator*(const Rational& other) const {
    int newNumerator = numerator * other.numerator;
    int newDenominator = denominator * other.denominator;
    return Rational(newNumerator, newDenominator).reduce();
}

Rational Rational::operator/(const Rational& other) const {
    if (other.numerator == 0) {
        throw std::invalid_argument("Division by zero.");
    }

    int newNumerator = numerator * other.denominator;
    int newDenominator = denominator * other.numerator;
    return Rational(newNumerator, newDenominator).reduce();
}

bool Rational::operator==(const Rational& other) const {
    return numerator == other.numerator && denominator == other.denominator;
}

bool Rational::operator!=(const Rational& other) const {
    return !(*this == other);
}

bool Rational::operator<(const Rational& other) const {
    int newDenominator = denominator * other.denominator;
    int newNumerator1 = numerator * other.denominator;
    int newNumerator2 = other.numerator * denominator;
    return newNumerator1 < newNumerator2;
}

bool Rational::operator>(const Rational& other) const {
    return !(*this < other) && *this != other;
}

bool Rational::operator<=(const Rational& other) const {
    return *this < other || *this == other;
}

bool Rational::operator>=(const Rational& other) const {
    return *this > other || *this == other;
}

Rational Rational::reduce() const {
    int gcd = std::gcd(std::abs(numerator), denominator);
    return Rational(numerator / gcd, denominator / gcd);
}

double Rational::toDouble() const {
    return static_cast<double>(numerator) / denominator;
}

std::ostream& operator<<(std::ostream& out, const Rational& r) {
    out << r.getNumerator() << "/" << r.getDenominator();
    return out;
}

Rational fromDouble(double x, double accuracy) {
    int sign = (x > 0) ? 1 : -1;
    double absX = std::abs(x);
    int integerPart = static_cast<int>(absX);
    double fractionalPart = absX - integerPart;

    int numerator = static_cast<int>(std::round(fractionalPart / accuracy));
    int denominator = static_cast<int>(1.0 / accuracy);

    return Rational(sign * (integerPart * denominator + numerator), denominator);
}
