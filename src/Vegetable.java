public class Vegetable extends Food{
    private boolean isFresh;

    public Vegetable() {
        super();
        this.isFresh = true;
    }

    public Vegetable(String name, double kg, boolean isFresh) {
        super(name, kg);
        this.isFresh = isFresh;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }
}
