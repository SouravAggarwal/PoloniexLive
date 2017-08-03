package polosoft.sourav.poloniex.poloniexlive.Detailed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 21-06-2017.
 */

public class DTab1_JsonParsingAsk {

    public static List<DTab1_Objclass> getSimpleDataTab1Ask(String jsonData) throws JSONException {

        ArrayList<DTab1_Objclass> datalist = new ArrayList<>();
        JSONObject rootJson = new JSONObject(jsonData);
        String hCoin;
        JSONArray jsonArraytAsk = rootJson.getJSONArray("asks");

        for (int i = 0; i < jsonArraytAsk.length(); i++) {

            JSONArray jsonArray = jsonArraytAsk.getJSONArray(i);

            datalist.add(new DTab1_Objclass(jsonArray.getDouble(0), jsonArray.getDouble(1)));
        }


        return datalist;
    }
}