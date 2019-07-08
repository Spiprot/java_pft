package ru.stqa.pft.sandbox;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((this.x - p.x), 2.0) + Math.pow((this.y - p.y), 2.0));
    }
}
