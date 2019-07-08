package ru.stqa.pft.sandbox;

class Point {

    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point p) {
        return Math.sqrt(Math.pow((this.x - p.x), 2.0) + Math.pow((this.y - p.y), 2.0));
    }
}