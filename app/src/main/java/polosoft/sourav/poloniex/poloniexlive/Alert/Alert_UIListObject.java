package polosoft.sourav.poloniex.poloniexlive.Alert;

/**
 * Created by Sourav on 02-07-2017.
 */

public class Alert_UIListObject {

    String CoinCode;

    String CoinName;
    String PriceHigh;       // Price High
    String PriceLow;    // Price Low
    String KeyNote;
    String Type;

    public Alert_UIListObject(String coinCode, String coinName, String priceHigh, String priceLow, String keyNote, String type) {
        CoinCode = coinCode;
        CoinName = coinName;
        PriceHigh = priceHigh;
        PriceLow = priceLow;
        KeyNote = keyNote;
        Type = type;
    }


    public String getCoinCode() {
        return CoinCode;
    }

    public String getCoinName() {
        return CoinName;
    }

    public String getPriceHigh() {
        return PriceHigh;
    }

    public String getType() {
        return Type;
    }

    public String getPriceLow() {
        return PriceLow;
    }

    public String getKeyNote() {
        return KeyNote;
    }
}
