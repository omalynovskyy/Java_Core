package Geometric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Rectangle extends GeometricalObject {

    Point point1;
    Point point2;
    Point point3;
    Point point4;

    public Rectangle(int angleCount, int pointCounts, Point point1, Point point2, Point point3, Point point4) {
        super(4, 4);
        ArrayList<Point> pointsList = new ArrayList<Point>();
        pointsList.add(point1);
        pointsList.add(point2);
        pointsList.add(point3);
        pointsList.add(point4);
        pointsList.sort(Comparator.comparing(m ->  m.x));
        pointsList.sort(Comparator.comparing(m ->  m.y));

        this.point1 = pointsList.get(0);
        this.point2 = pointsList.get(1);
        this.point3 = pointsList.get(2);
        this.point4 = pointsList.get(3);
    }


    @Override
    public void compose(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Rectangle)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.point1.compose(((Rectangle) operand[i]).point1);
                    this.point2.compose(((Rectangle) operand[i]).point2);
                    this.point3.compose(((Rectangle) operand[i]).point3);
                    this.point4.compose(((Rectangle) operand[i]).point4);
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }

    }

    @Override
    public void subtract(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Rectangle)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.point1.subtract(((Rectangle) operand[i]).point1);
                    this.point2.subtract(((Rectangle) operand[i]).point2);
                    this.point3.subtract(((Rectangle) operand[i]).point3);
                    this.point4.subtract(((Rectangle) operand[i]).point4);
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }

    }

    @Override
    public void invert() {
        point1.invert();
        point2.invert();
        point3.invert();
        point4.invert();

    }
}
