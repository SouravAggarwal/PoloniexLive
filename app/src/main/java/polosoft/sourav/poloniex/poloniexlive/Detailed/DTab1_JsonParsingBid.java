package polosoft.sourav.poloniex.poloniexlive.Detailed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab1_JsonParsingBid {

    public static List<DTab1_Objclass> getSimpleDataTab1Bid(String jsonData) throws JSONException {

        ArrayList<DTab1_Objclass> datalist = new ArrayList<>();
        JSONObject rootJson = new JSONObject(jsonData);
        String hCoin;
        JSONArray jsonArraytBid = rootJson.getJSONArray("bids");

        for (int i = 0; i < jsonArraytBid.length(); i++) {
            //  for(int ask=0;ask<jsonArraytAsk.length();ask++){

            JSONArray jsonArray = jsonArraytBid.getJSONArray(i);

            datalist.add(new DTab1_Objclass(jsonArray.getDouble(0), jsonArray.getDouble(1)));
        }


        return datalist;
    }
}