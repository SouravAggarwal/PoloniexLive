package polosoft.sourav.poloniex.poloniexlive.Detailed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab2_JsonParsing {

    public static List<DTab2_Obj> getSimpleDataTab2(String jsonData) throws JSONException {

        ArrayList<DTab2_Obj> datalist = new ArrayList<>();
        JSONArray rootJsonArray = new JSONArray(jsonData);
        String hCoin;

        for (int i = 0; i < rootJsonArray.length(); i++) {
            JSONObject properties = rootJsonArray.getJSONObject(i);

            double htradeID = properties.getDouble("tradeID");
            String hdate = properties.getString("date");
            String htype = properties.getString("type");
            double hrate = properties.getDouble("rate");
            double htotal = properties.getDouble("total");

            datalist.add(new DTab2_Obj(htradeID, hdate, htype, hrate, htotal));

        }


        return datalist;
    }
}


