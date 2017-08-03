package polosoft.sourav.poloniex.poloniexlive.Detailed;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab2_Obj {
    String type;

    String date;
    double tradeId;
    double price;
    double amount;

    public DTab2_Obj(double tradeId, String date,String type,  double price, double amount) {
        this.type = type;
        this.date = date;
        this.tradeId = tradeId;
        this.price = price;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return date;
    }

    public double getTradeId() {
        return tradeId;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }
}
