package myApplication;

import java.util.Scanner;


class Point {
    double x, y;

    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


class Line implements Comparable<Line> {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double calculateLength() {
        return Math.sqrt(Math.pow((end.x - start.x), 2) + Math.pow((end.y - start.y), 2));
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line otherLine = (Line) obj;
        return Double.compare(this.calculateLength(), otherLine.calculateLength()) == 0;
    }

    @Override
    public int compareTo(Line otherLine) {
        return Double.compare(this.calculateLength(), otherLine.calculateLength());
    }
}

public class lineCom {
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program on Master Branch");

        Scanner sc = new Scanner(System.in);

        // --- Line 1 Input ---
        System.out.println("\nEnter coordinates for Line 1:");
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();

        Line line1 = new Line(new Point(x1, y1), new Point(x2, y2));

        System.out.println("\nEnter coordinates for Line 2:");
        System.out.print("x1: ");
        double a1 = sc.nextDouble();
        System.out.print("y1: ");
        double b1 = sc.nextDouble();
        System.out.print("x2: ");
        double a2 = sc.nextDouble();
        System.out.print("y2: ");
        double b2 = sc.nextDouble();

        Line line2 = new Line(new Point(a1, b1), new Point(a2, b2));

        System.out.println("\nLength of Line 1: " + line1.calculateLength());
        System.out.println("Length of Line 2: " + line2.calculateLength());

        if (line1.equals(line2)) {
            System.out.println("Both lines are EQUAL in length.");
        } else {
            System.out.println("Both lines are NOT equal in length.");
        }

        int result = line1.compareTo(line2);
        if (result == 0) {
            System.out.println("Both lines are EQUAL in length.");
        } else if (result > 0) {
            System.out.println("Line 1 is GREATER than Line 2.");
        } else {
            System.out.println("Line 1 is LESS than Line 2.");
        }

        sc.close();
    }
}
