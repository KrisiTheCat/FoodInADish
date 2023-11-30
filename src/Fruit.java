public class Fruit extends Food{
    private boolean isReadyToEat;

    public Fruit() {
        super();
        this.isReadyToEat = true;
    }

    public Fruit(String name, double kg, boolean isReadyToEat) {
        super(name, kg);
        this.isReadyToEat = isReadyToEat;
    }

    public boolean isReadyToEat() {
        return isReadyToEat;
    }

    public void setReadyToEat(boolean readyToEat) {
        isReadyToEat = readyToEat;
    }
}
