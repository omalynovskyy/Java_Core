package Geometric;

public class Point extends GeometricalObject {

    protected int x;
    protected int y;

    public Point(int x, int y) {
        super(0, 1);
        this.x = x;
        this.y = y;
    }

    @Override
    public void compose(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Point)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.x += ((Point) operand[i]).x;
                    this.y += ((Point) operand[i]).y;
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
                if (!(operand[i] instanceof Point)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else {
                    this.x -= ((Point) operand[i]).x;
                    this.y -= ((Point) operand[i]).y;
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }
    }

    @Override
    public void invert() {
        x = -x;
        y = -y;
    }

}
