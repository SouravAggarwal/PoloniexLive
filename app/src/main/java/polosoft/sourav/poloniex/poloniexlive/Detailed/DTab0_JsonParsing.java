package polosoft.sourav.poloniex.poloniexlive.Detailed;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab0_JsonParsing {
    String hCoin;
    public  static List<DTab0_Objclass> getSimpleDataTab0(String jsonData, String COIN_mainactvity) throws JSONException {
        int colorflag = 0;              // 0 =RED #F44336    #8BC34A

        final String TAG = "DTab0_JsonParsing";
        String[] parsedData = null;


        ArrayList<DTab0_Objclass> datalist = new ArrayList<DTab0_Objclass>();
        JSONObject rootJson = new JSONObject(jsonData);
        for (int i = 0; i < rootJson.length(); i++) {

           String hCoin = rootJson.names().getString(i);
            if (hCoin.equals( COIN_mainactvity)) {
                JSONObject properties = rootJson.getJSONObject(hCoin);


                double hJsonLastPricee = properties.getDouble("last");
                double hJsonLowaske = properties.getDouble("lowestAsk");
                double hJsonHighbide = properties.getDouble("highestBid");
                double hJsonPercChange = properties.getDouble("percentChange");
                double hJsonBaseVolume = properties.getDouble("baseVolume");
                double hJsonQuoteVolume = properties.getDouble("quoteVolume");
                double hJsonDayHighPricee = properties.getDouble("high24hr");
                double hJsonLowPricee = properties.getDouble("low24hr");


                double hPerChange = (hJsonPercChange * 100);
// colorflag,hCoin,hJsonLastPrice,hJsonBaseVol,hJsonQuoteVol,hJsonPerChange,hJsonDayHighPrice,hJsonLowPrice,hJsonLowestPrice,hJsonHighestPrice,
//int,String,String,String,
                if (String.valueOf(hPerChange).contains("-")) {
                    colorflag = 0;
                } else {
                    colorflag = 1;
                }
                // String hchangeSymbol = hJsonPercChange.substring(0,1);
                // String remainingString = hJsonPercChange.substring(1);


                DecimalFormat magnitudeFormat = new DecimalFormat("0.000");
                String hJsonBaseVol = magnitudeFormat.format(hJsonBaseVolume);
                String hJsonQuoteVol = magnitudeFormat.format(hJsonQuoteVolume);

                String hJsonPerChange = magnitudeFormat.format(hPerChange);

                DecimalFormat magnitudeFormat2 = new DecimalFormat("0.00000000");
                String hJsonLastPrice = magnitudeFormat2.format(hJsonLastPricee);
                String hJsonDayHighPrice = magnitudeFormat2.format(hJsonDayHighPricee);
                String hJsonLowPrice = magnitudeFormat2.format(hJsonLowPricee);
                String hJsonLowask = magnitudeFormat2.format(hJsonLowaske);
                String hJsonHighbid = magnitudeFormat2.format(hJsonHighbide);

                datalist.add(new DTab0_Objclass(hCoin, hJsonBaseVol, hJsonQuoteVol, hJsonPerChange,
                        hJsonLastPrice, hJsonDayHighPrice, hJsonLowPrice, hJsonLowask, hJsonHighbid));
            }
        }


        return datalist;
    }


}
