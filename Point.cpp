#include "Point.h"
#include <iostream>

std::vector<Point> point(0);

void addPoint() {
    float x, y;
    std::cin >> x >> y;
    Point newPoint{ x, y };
    point.push_back(newPoint);
}

void outPoint() {
    for (int i = 0; i < point.size(); i++) {
        std::cout << point[i].x << ' ' << point[i].y << std::endl;
    }
    if (point.size() == 0) {
        std::cout << "Точки не обнаружены";
    }
}

float distances(Point p1, Point p2) {
    return sqrt(pow((p2.x - p1.x), 2) + pow((p2.y - p1.y), 2));
}

void clearPoint() {
    point.clear();
}
