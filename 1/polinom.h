#ifndef POLINOM_H
#define POLINOM_H

const int PolinomMaxDegree = 10;

struct Polinom
{
    int n; 
    double a[PolinomMaxDegree + 1];
};


extern int PolinomRead(Polinom* p);


extern void PolinomWrite(Polinom* p);

#endif
