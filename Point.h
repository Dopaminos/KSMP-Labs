#pragma once

#include <vector>

struct Point {
    float x;
    float y;
};

extern std::vector<Point> point;
extern void addPoint();
extern void outPoint();
extern float distances(Point p1, Point p2);
extern void clearPoint();
