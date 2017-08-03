package polosoft.sourav.poloniex.poloniexlive.Home;

import android.content.Context;
import android.content.SharedPreferences;

import polosoft.sourav.poloniex.poloniexlive.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SharedPreference {
    public static boolean sharedPrefsetPreFavItem(Context context, String s) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Set<String> set1 = sharedPref.getStringSet("pref", null);
        if (set1 == null) {
            Set<String> setss = new HashSet<>();
            setss.add("hello");
            editor.clear();
            editor.putStringSet("pref", setss);

            editor.commit();

        }
        SharedPreferences sharedPref2 = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor2 = sharedPref2.edit();


        Set<String> set = sharedPref.getStringSet("pref", null);

        set.add(s);
        editor2.clear();

        editor2.putStringSet("pref", set);

        editor2.commit();

        return true;
    }

    public static boolean sharedPrefcheckifExist(Context context, String item) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        Set<String> set = sharedPref.getStringSet("pref", null);
        boolean flag = false;
        if (set != null) {

            for (String i : set) {
                if (item.equals(i)) {
                    flag = true;
                }
            }

        }
        return flag;
    }

    public static boolean sharedPrefRemoveItemfromList(Context context, String item) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Set<String> set1 = sharedPref.getStringSet("pref", null);
        if (set1 == null) {
            Set<String> setss = new HashSet<String>();
            setss.add("hello");
            editor.clear();
            editor.putStringSet("pref", setss);

            editor.commit();

        }
        SharedPreferences sharedPref2 = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor2 = sharedPref2.edit();

        Set<String> set = sharedPref.getStringSet("pref", null);


        boolean b = set.remove(item);
        editor2.clear();
        editor2.putStringSet("pref", set);
        editor2.commit();
        return b;
    }

    public static List<String> getPreferedCoinList(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        Set<String> set = sharedPref.getStringSet("pref", null);
        if (set != null) {
            List<String> coinList = new ArrayList<String>();

            for (String i : set) {
                coinList.add(i);
            }
            return coinList;
        }
        return null;
    }


//-------------------- for Main Activity Sorting

    public static boolean setPref(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(key, value);
        editor.commit();

        return true;
    }

    public static String getPref(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.mypref), Context.MODE_PRIVATE);
        String value = sharedPref.getString(key, null);
        SharedPreferences.Editor editor = sharedPref.edit();

        if (value == null) {


            editor.putString(key, "Preferred");
            editor.commit();
        }
        String values = sharedPref.getString(key, null);
        return values;
    }

    //---------keyMessage on Communicate
    public static void setMsg(Context context, String msg) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.myprefMsg), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (msg != null) {
            editor.putString("myMsg", msg);
            editor.commit();

        }

    }
 public static String getMsg(Context context){
     SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.myprefMsg), Context.MODE_PRIVATE);
     String value = sharedPref.getString("myMsg", null);
return value;
 }

}
