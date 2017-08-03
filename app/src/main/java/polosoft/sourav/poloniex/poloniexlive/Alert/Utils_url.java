package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.net.Uri;
import android.util.Log;

import polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Sourav on 18-06-2017.
 */

public class Utils_url {
//    private static final String stringUrl = " https://poloniex.com/public?command=returnTicker";
static  String stringUrl = HomeGetCoinName.xxxx + "command&values=returnTicker";

    private static final String TAG = "Home.LUtils";

    public static String getAlerHttpResponse() {
        String jsonResponse = null;

        Uri baseUri = Uri.parse(stringUrl);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        try {
            URL url = new URL(uriBuilder.toString());
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
            if (urlConnection.getResponseCode() == 200) {
                InputStream in = urlConnection.getInputStream();

                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");

                boolean hasInput = scanner.hasNext();
                if (hasInput) {
                    return scanner.next();
                } else {
                    return NULL;
                }
            } else {
                Log.e(TAG, "Error response code: " + urlConnection.getResponseCode());
            }
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
