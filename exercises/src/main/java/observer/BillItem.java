package observer;

import java.util.function.Consumer;

public class BillItem {

    private Consumer<PriceChangeRequestEvent> observer;

    private int price;

    public BillItem(int price) {
        this.price = price;
    }

    public void onChange(Consumer<PriceChangeRequestEvent> observer) {
        this.observer = observer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        observer.accept(new PriceChangeRequestEvent(this.price, price));
        this.price = price;
    }
}
