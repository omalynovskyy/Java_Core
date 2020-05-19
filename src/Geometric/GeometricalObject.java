package Geometric;

public abstract class GeometricalObject implements ArithmeticalOperations {
    protected int angleCount;
    protected int pointCounts;

    public GeometricalObject(int angleCount, int pointCounts) {
        this.angleCount = angleCount;
        this.pointCounts = pointCounts;
    }

    public abstract void compose(Object... operand);
    public abstract void subtract(Object... operand);
    public abstract void invert();
}
