package polosoft.sourav.poloniex.poloniexlive.Detailed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab3_JsonParsing {
    public static List<DTab3_Obj> getSimpleDataTab3(String jsonData) throws JSONException {

        ArrayList<DTab3_Obj> datalist = new ArrayList<>();
        JSONArray rootJsonArray = new JSONArray(jsonData);
        String hCoin;

        for (int i = 0; i < rootJsonArray.length(); i++) {
            JSONObject  properties = rootJsonArray.getJSONObject(i);

            long hdate = properties.getLong("date");
            float hhigh = (float) properties.getDouble("high");
            float hlow = (float) properties.getDouble("low");
            float hopen = (float) properties.getDouble("open");
            float hclsoe = (float) properties.getDouble("close");
            float hvolume = (float) properties.getDouble("volume");
            float hquoteVol = (float) properties.getDouble("quoteVolume");
            float hweightAvg = (float) properties.getDouble("weightedAverage");

            datalist.add(new DTab3_Obj(hdate, hhigh, hlow,
                    hopen, hclsoe, hvolume, hquoteVol, hweightAvg));

        }


        return datalist;
    }
}


