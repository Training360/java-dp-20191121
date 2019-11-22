package observer;

public class PriceChangeRequestEvent {

    private int oldPrice;

    private int newPrice;

    public PriceChangeRequestEvent(int oldPrice, int newPrice) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public int getDiff() {
        return newPrice - oldPrice;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }
}
