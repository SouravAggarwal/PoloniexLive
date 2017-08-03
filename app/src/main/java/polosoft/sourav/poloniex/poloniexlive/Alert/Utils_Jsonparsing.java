package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 18-06-2017.
 */

public class Utils_Jsonparsing {
    public static List<UtilsListObj> getAlerSimpleData(Context context, String jsondata) throws JSONException {
        int colorflag = 0;              // 0 =RED #F44336    #8BC34A

        final String TAG = "LJsonParsing";
        String[] parsedData = null;


        ArrayList<UtilsListObj> datalist = new ArrayList<UtilsListObj>();
        JSONObject rootJson = new JSONObject(jsondata);
        for (int i = 0; i < rootJson.length(); i++) {
            String hCoin = rootJson.names().getString(i);
            JSONObject properties = rootJson.getJSONObject(hCoin);


            double hJsonLastPricee = properties.getDouble("last");
            //double hJsonLowaske = properties.getDouble("lowestAsk");
            //double hJsonHighbide = properties.getDouble("highestBid");
            //double hJsonPercChange = properties.getDouble("percentChange");


          /*  double hPerChange = (hJsonPercChange * 100);
            if (String.valueOf(hPerChange).contains("-")) {
                colorflag = 0;
            } else {
                colorflag = 1;
            }
            // String hchangeSymbol = hJsonPercChange.substring(0,1);
            // String remainingString = hJsonPercChange.substring(1);




            String hJsonPerChange = magnitudeFormat.format(hPerChange);

            DecimalFormat magnitudeFormat8 = new DecimalFormat("0.00000000");
            String hJsonLowask = magnitudeFormat8.format(hJsonLowaske);
            String hJsonHighbid = magnitudeFormat8.format(hJsonHighbide);*/

          String hJsonLowask="a",hJsonHighbid="a",hJsonPerChange="a";

            DecimalFormat magnitudeFormat8 = new DecimalFormat("0.00000000");
            String hJsonLastPrice = magnitudeFormat8.format(hJsonLastPricee);

            datalist.add(new UtilsListObj(hCoin,hJsonLastPrice,hJsonLowask,hJsonHighbid,hJsonPerChange));

        }


        return datalist;
    }

}
