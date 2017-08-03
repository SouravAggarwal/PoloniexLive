package polosoft.sourav.poloniex.poloniexlive.Detailed;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab1_Objclass {
    double price;
    double quantity;

    public DTab1_Objclass(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }
}
