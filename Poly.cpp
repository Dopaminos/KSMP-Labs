#include "Poly.h"
#include <iostream>
#include <fstream>

float Perimeter() {
    float per = 0;
    for (int i = 0; i < point.size(); i++) {
        int j = (i + 1) % point.size();
        per += distances(point[i], point[j]);
    }
    if (per == 0)
        std::cout << "Добавьте больше точек\n";
    return per;
}

float Area() {
    float plosh = 0;
    float sum = 0;
    for (int i = 0; i < point.size(); i++) {
        int j = (i + 1) % point.size();
        sum += (point[j].x - point[i].x) * (point[j].y + point[i].y);
    }
    plosh = abs(sum / 2);
    if (plosh == 0)
        std::cout << "Добавьте больше точек\n";
    return plosh;
}

void writepol() {
    std::string filename = "pol.txt";
    std::ofstream file(filename);
    if (file.is_open()) {
        for (int i = 0; i < point.size(); i++) {
            file << point[i].x << ' ' << point[i].y << std::endl;
        }
        file.close();
    }
    else {
        std::cout << "Ошибка при записи: " << filename << std::endl;
    }
}

void readpol() {
    std::string filename = "pol.txt";
    std::ifstream file(filename);
    if (file.is_open()) {
        std::string line;
        while (getline(file, line)) {
            std::cout << line << std::endl;
        }
        file.close();
    }
    else {
        std::cout << "Ошибка при чтении: " << filename << std::endl;
    }
}
