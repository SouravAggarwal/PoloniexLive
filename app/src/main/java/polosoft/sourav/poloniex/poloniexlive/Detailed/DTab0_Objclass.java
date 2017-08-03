package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab0_Objclass implements Parcelable{
    private String hCoin;
    private String hJsonBaseVol;
    private String hJsonQuoteVol;
    private String hJsonPerChange;
    private String hJsonLastPrice, hJsonDayHighPrice, hJsonLowPrice, hJsonLowAsk, hJsonHighBid;

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


    public DTab0_Objclass(String hCoin, String hJsonBaseVol, String hJsonQuoteVol, String hJsonPerChange, String hJsonLastPrice, String hJsonDayHighPrice, String hJsonLowPrice, String hJsonLowAsk, String hJsonHighBid) {
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

public DTab0_Objclass(Parcel parcel){

    this.hCoin = parcel.readString();
    this.hJsonBaseVol = parcel.readString();
    this.hJsonQuoteVol = parcel.readString();
    this.hJsonPerChange = parcel.readString();
    this.hJsonLastPrice = parcel.readString();
    this.hJsonDayHighPrice = parcel.readString();
    this.hJsonLowPrice = parcel.readString();
    this.hJsonLowAsk = parcel.readString();
    this.hJsonHighBid = parcel.readString();

}
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hCoin);
        parcel.writeString(this.hJsonBaseVol);
        parcel.writeString(this.hJsonQuoteVol);
        parcel.writeString(this.hJsonPerChange);
        parcel.writeString(this.hJsonLastPrice);
        parcel.writeString(this.hJsonDayHighPrice);
        parcel.writeString(this.hJsonLowPrice);
        parcel.writeString(this.hJsonLowAsk);
        parcel.writeString(this.hJsonHighBid);
    }

    public static Creator<DTab0_Objclass> CREATOR=new Creator<DTab0_Objclass>() {
        @Override
        public DTab0_Objclass createFromParcel(Parcel parcel) {
            return new DTab0_Objclass(parcel);
        }

        @Override
        public DTab0_Objclass[] newArray(int i) {
            return new DTab0_Objclass[i];
        }
    };
}
