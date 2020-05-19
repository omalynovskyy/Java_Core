package Geometric;

public class Line extends GeometricalObject {

    Point startPoint;
    Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        super(0, 2);
        if (startPoint.x < endPoint.x) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        } else if (startPoint.x > endPoint.x){
            this.startPoint = endPoint;
            this.endPoint = startPoint;
        } else if (startPoint.y < endPoint.y) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        } else {
            this.startPoint = endPoint;
            this.endPoint = startPoint;
        }
    }

    @Override
    public void compose(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Line)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.startPoint.compose(((Line) operand[i]).startPoint);
                    this.endPoint.compose(((Line) operand[i]).endPoint);
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
                if (!(operand[i] instanceof Line)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.startPoint.subtract(((Line) operand[i]).startPoint);
                    this.endPoint.subtract(((Line) operand[i]).endPoint);
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }

    }

    @Override
    public void invert() {
        startPoint.invert();
        endPoint.invert();

    }
}
