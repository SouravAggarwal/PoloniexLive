package polosoft.sourav.poloniex.poloniexlive.Detailed;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab3_Obj {

long date;
    float high,low,open,close,volume,quoteVolume,weightedAverage;


    public DTab3_Obj(long date, float high, float low, float open, float close, float volume, float quoteVolume, float weightedAverage) {
        this.date = date;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.weightedAverage = weightedAverage;
    }

    public long getDate() {
        return date;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getOpen() {
        return open;
    }

    public float getClose() {
        return close;
    }

    public float getVolume() {
        return volume;
    }

    public float getQuoteVolume() {
        return quoteVolume;
    }

    public float getWeightedAverage() {
        return weightedAverage;
    }
}
