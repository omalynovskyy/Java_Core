package Geometric;

public class Vector extends GeometricalObject {

    Point startPoint;
    Point endPoint;

    @Override
    public void compose(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Vector)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.endPoint.x += ((Vector) operand[i]).endPoint.x - ((Vector) operand[i]).startPoint.x;
                    this.endPoint.y += ((Vector) operand[i]).endPoint.y - ((Vector) operand[i]).startPoint.y;
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
                if (!(operand[i] instanceof Vector)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.endPoint.x += ((Vector) operand[i]).startPoint.x - ((Vector) operand[i]).endPoint.x;
                    this.endPoint.y += ((Vector) operand[i]).startPoint.y - ((Vector) operand[i]).endPoint.y;
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }

    }

    @Override
    public void invert() {
        Point buffer = this.startPoint;
        this.startPoint = this.endPoint;
        this.endPoint = buffer;

    }

    public Vector(int angleCount, int pointCounts, Point startPoint, Point endPoint) {
        super(0, 2);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
