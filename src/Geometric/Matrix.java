package Geometric;

public class Matrix extends GeometricalObject {

    int[][] a;

    public Matrix(int[][] a) {
        super(0, 0);
        this.a = a.clone();
    }

    @Override
    public void compose(Object... operand) {
        if (operand != null) {
            for (int i = 0; i < operand.length; i++) {
                if (!(operand[i] instanceof Matrix)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else if (this.a.length == ((Matrix) operand[i]).a.length) {
                    for (int j = 0; j < this.a.length; j++) {
                        for (int k = 0; k < this.a.length; k++) {
                            this.a[j][k] += ((Matrix) operand[i]).a[j][k];
                        }
                    }
                } else {
                    System.out.println("Different Matrix size");
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
                if (!(operand[i] instanceof Matrix)) {
                    System.out.println("Invalid object was passed!!");
                    return;
                } else if (this.a.length == ((Matrix) operand[i]).a.length) {
                    for (int j = 0; j < this.a.length; j++) {
                        for (int k = 0; k < this.a.length; k++) {
                            this.a[j][k] -= ((Matrix) operand[i]).a[j][k];
                        }
                    }
                } else {
                    System.out.println("Different Matrix size");
                }
            }
        } else {
            System.out.println("Argument was null!!");
            return;
        }
    }

    @Override
    public void invert() {
        for (int j = 0; j < this.a.length; j++) {
            for (int k = 0; k < this.a.length; k++) {
                this.a[j][k] *= -1;

            }
        }
    }
}

