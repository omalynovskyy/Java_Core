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
                    this.endPoint.x = ;
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }

    }

    @Override
    public void subtract(Object... operand) {

    }

    @Override
    public void invert() {

    }

    public Vector(int angleCount, int pointCounts, Point startPoint, Point endPoint) {
        super(0, 2);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
