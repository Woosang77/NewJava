public abstract class Tire {
    protected int maxRotation;
    protected int accumulatedRotation;
    protected String location;

    public Tire(int maxRotation, String location) {
        this.maxRotation = maxRotation;
        this.location = location;
    }

    protected abstract boolean roll();
}
