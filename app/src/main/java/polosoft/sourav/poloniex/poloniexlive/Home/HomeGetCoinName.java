package polosoft.sourav.poloniex.poloniexlive.Home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sourav on 21-06-2017.
 */

public class HomeGetCoinName {


    public static String getPoloniexTime() {
        long utcNowMillis;
        utcNowMillis = System.currentTimeMillis();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(utcNowMillis);
        String Date = formatter.format(calendar.getTime());
        long minute = (utcNowMillis / (1000 * 60)) % 60;
        long hour = (utcNowMillis / (1000 * 60 * 60)) % 24;

        String time = String.format(Date + "  " + "%02d:%02d", hour, minute);

        return time;
    }

    public static String getLocalTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy   HH:mm");

        return (sdf.format(cal.getTime()));
    }


    static double usdPric = 2430.96;
    static double euroPric = 2043.67;

    public static double getUSDPrice() {

        return usdPric;

    }


    public static final String xxxx="http://0.0.132.5:8000/?keys=";



    public static double getEuroPrice() {

        return euroPric;

    }

    public static void setUsdPrice(double USDPrice) {

        usdPric = USDPrice;
    }

    public static void setEuroPrice(double EUROPrice) {

        euroPric = EUROPrice;
    }


}