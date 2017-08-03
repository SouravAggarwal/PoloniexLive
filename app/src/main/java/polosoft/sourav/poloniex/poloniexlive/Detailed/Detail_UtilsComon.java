package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.net.Uri;
import android.util.Log;

import polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;


public class Detail_UtilsComon {

    //  private static final String stringUrl = " https://poloniex.com/public?command=returnTicker";

    //String static urlTab0="https://poloniex.com/public?command=returnTicker";
    //String urlTab1 = "https://poloniex.com/public?command=returnOrderBook&currencyPair=BTC_NXT&depth=10";


    //String urlTab3 = "https://poloniex.com/public?command=returnChartData&currencyPair=BTC_XMR&start=1405699200&end=9999999999&period=14400";


    private static final String TAG = "Home.LUtils";
    static String stringUrl = HomeGetCoinName.xxxx + "command&values=returnTicker";

    public static Uri getUriBuild(int numTab, String coin) {

        switch (numTab) {
            case 0:
             /*   String url0 = "https://poloniex.com/public?command=returnTicker";
               Uri tab0Uri = Uri.parse(url0).buildUpon()
                        .build();
*/

                Uri tab0Uri = Uri.parse(HomeGetCoinName.xxxx + "command&values=returnTicker");

                return tab0Uri;
            case 1:
                String url1 = "https://poloniex.com/public";
             /*   Uri tab1Uri = Uri.parse(url1).buildUpon()
                        .appendQueryParameter("command", "returnOrderBook")
                        .appendQueryParameter("currencyPair", coin)
                        .appendQueryParameter("depth", Integer.toString(70))
                        .build();
*/

                Uri tab1Uri = Uri.parse(HomeGetCoinName.xxxx + "command,currencyPair,depth&values=returnOrderBook"+","+coin+","+Integer.toString(70));

                return tab1Uri;
            case 2:
                String url2 = "https://poloniex.com/public";
              /*  Uri tab2Uri = Uri.parse(url2).buildUpon()
                        .appendQueryParameter("command", "returnTradeHistory")
                        .appendQueryParameter("currencyPair", coin)
                        .appendQueryParameter("depth", Integer.toString(70))
                        .build();
*/

                Uri tab2Uri = Uri.parse(HomeGetCoinName.xxxx + "command,currencyPair,depth&values=returnTradeHistory"+","+coin+","+Integer.toString(70));


                return tab2Uri;


            case 3:
                Date now = new Date();
                Long endtime = new Long(now.getTime() / 1000);
                Long starttime = endtime - 86400;


                int arr[] = {300, 900, 1800, 7200, 14400, 86400};

                String url3 = "https://poloniex.com/public";
             /*   Uri tab3Uri = Uri.parse(url3).buildUpon()
                        .appendQueryParameter("command", "returnChartData")
                        .appendQueryParameter("currencyPair", coin)
                        .appendQueryParameter("start", String.valueOf(starttime))
                        .appendQueryParameter("end", String.valueOf(endtime))
                        .appendQueryParameter("period", String.valueOf(arr[2]))
                        .build();
*/
                Uri tab3Uri = Uri.parse(HomeGetCoinName.xxxx + "command,currencyPair,start,end,period&values=returnChartData"+","+coin+","+
                        String.valueOf(starttime)+","+String.valueOf(endtime)+","+String.valueOf(1800));



                return tab3Uri;


        }
        return null;
    }


    public static String makehttpResponse(Uri uri) {
        String jsonResponse = null;

        // Uri baseUri = Uri.parse(stringUrl);
        //Uri.Builder uriBuilder = baseUri.buildUpon();

        try {
            URL url = new URL(uri.toString());
            jsonResponse = makeHttpRequest(url);
            return jsonResponse;


        } catch (MalformedURLException e) {
        } catch (Exception e) {
        }
        return null;
    }

    private static String makeHttpRequest(URL url) {
        String NULL = "null";

        // If the URL is null, then return early.
        if (url == null) {
            return NULL;
        }

        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(10000); // milliseconds
            urlConnection.setConnectTimeout(15000); // milliseconds
            urlConnection.setRequestMethod("GET");

            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            // if (urlConnection.getResponseCode() == 200) {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return NULL;
            }
//             else {
//                Log.e(TAG, "Error response code: " + urlConnection.getResponseCode());
//            }
        } catch (IOException e) {
            Log.e(TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

        }
        return NULL;
    }


}
