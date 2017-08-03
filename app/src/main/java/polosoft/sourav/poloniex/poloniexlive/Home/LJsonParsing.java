package polosoft.sourav.poloniex.poloniexlive.Home;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 18-06-2017.
 */

public class LJsonParsing {

    static ArrayList<String > roughpoloniex;
    public static List<ListObj> getSimpleWeatherStringsFromJson(Context context, String jsondata) throws JSONException {
        int colorflag = 0;              // 0 =RED #F44336    #8BC34A

        final String TAG = "LJsonParsing";
        String[] parsedData = null;


        ArrayList<ListObj> datalist = new ArrayList<ListObj>();
         roughpoloniex = new ArrayList<>();   //Delete
        JSONObject rootJson = new JSONObject(jsondata);


        for (int i = 0; i < rootJson.length(); i++) {
            String hCoin = rootJson.names().getString(i);
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

String []abcc=hCoin.split("_", 2);

            datalist.add(new ListObj(colorflag, hCoin, hJsonBaseVol, hJsonQuoteVol, hJsonPerChange,
                    hJsonLastPrice, hJsonDayHighPrice, hJsonLowPrice, hJsonLowask, hJsonHighbid));

        }

        return datalist;
    }


    public static List<String> getPolodata(){
        return roughpoloniex;
    }

}
