package polosoft.sourav.poloniex.poloniexlive.Alert;

/**
 * Created by Sourav on 18-06-2017.
 */


public class UtilsListObj {
    String hCoin;
    String hJsonLastPrice;
    String hJsonLowask;
    String hJsonHighbid;
    String hJsonPerChange;

    public UtilsListObj(String hCoin, String hJsonLastPrice, String hJsonLowask, String hJsonHighbid, String hJsonPerChange) {
        this.hCoin = hCoin;
        this.hJsonLastPrice = hJsonLastPrice;
        this.hJsonLowask = hJsonLowask;
        this.hJsonHighbid = hJsonHighbid;
        this.hJsonPerChange = hJsonPerChange;
    }

    public String gethCoin() {
        return hCoin;
    }

    public String gethJsonLastPrice() {
        return hJsonLastPrice;
    }

    public String gethJsonLowask() {
        return hJsonLowask;
    }

    public String gethJsonHighbid() {
        return hJsonHighbid;
    }

    public String gethJsonPerChange() {
        return hJsonPerChange;
    }
}
