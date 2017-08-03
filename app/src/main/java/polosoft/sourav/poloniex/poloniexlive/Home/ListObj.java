package polosoft.sourav.poloniex.poloniexlive.Home;

/**
 * Created by Sourav on 18-06-2017.
 */


public class ListObj {
   private int colorflag;
    private String hCoin;
    private String hJsonBaseVol;
    private String hJsonQuoteVol;
    private String hJsonPerChange;
    private String hJsonLastPrice, hJsonDayHighPrice, hJsonLowPrice, hJsonLowAsk, hJsonHighBid;
    public boolean isFavourite;
    public int getColorflag() {
        return colorflag;
    }

    public String gethCoin() {
        return hCoin;
    }

    public String gethJsonBaseVol() {
        return hJsonBaseVol;
    }

    public String gethJsonQuoteVol() {
        return hJsonQuoteVol;
    }

    public String gethJsonPerChange() {
        return hJsonPerChange;
    }

    public String gethJsonLastPrice() {
        return hJsonLastPrice;
    }

    public String gethJsonDayHighPrice() {
        return hJsonDayHighPrice;
    }

    public String gethJsonLowPrice() {
        return hJsonLowPrice;
    }

    public String gethJsonLowAsk() {
        return hJsonLowAsk;
    }

    public String gethJsonHighBid() {
        return hJsonHighBid;
    }
    public boolean isFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }


    public ListObj(int colorflag, String hCoin, String hJsonBaseVol, String hJsonQuoteVol, String hJsonPerChange, String hJsonLastPrice, String hJsonDayHighPrice, String hJsonLowPrice, String hJsonLowAsk, String hJsonHighBid) {
        this.colorflag = colorflag;
        this.hCoin = hCoin;
        this.hJsonBaseVol = hJsonBaseVol;
        this.hJsonQuoteVol = hJsonQuoteVol;
        this.hJsonPerChange = hJsonPerChange;
        this.hJsonLastPrice = hJsonLastPrice;
        this.hJsonDayHighPrice = hJsonDayHighPrice;
        this.hJsonLowPrice = hJsonLowPrice;
        this.hJsonLowAsk = hJsonLowAsk;
        this.hJsonHighBid = hJsonHighBid;
    }


    // colorflag, hCoin, hJsonBaseVol, hJsonQuoteVol, hJsonPerChange,
    // hJsonLastPrice ,hJsonDayHighPrice, hJsonLowPrice, hJsonLowAsk, hJsonHighBid));
}
