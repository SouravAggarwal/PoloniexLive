package polosoft.sourav.poloniex.poloniexlive.News;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sourav on 18-06-2017.
 */

public class News_LUtils {
   private static final String stringUrl = "http://www.coindesk.com/category/news";
    //private static final String stringUrl = "http://coinmarketcap.com/currencies/views/all/";




    private static final String TAG = "Home.LUtils";

    public static String getResponseFromHttpUrl(int a) {
        String stringUrl="http://www.coindesk.com/category/news";
   switch (a){
       case 1:
            stringUrl = "http://www.coindesk.com/category/news";
      // case 2:
        //    stringUrl = "http://www.coindesk.com/category/news/page/2/";



   }


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


    public static Bitmap getBitmapSingle(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap", "returned");

            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
            return null;
        }

    }

    public static List<Bitmap> getBitmapFromURL(List<String> src) {
        List<Bitmap> nListImage = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            try {
                Log.e("src", src.get(i));
                URL url = new URL(src.get(i));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                Log.e("Bitmap", "returned");

                nListImage.add(myBitmap);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Exception", e.getMessage());

            }
        }
        return nListImage;
    }

}
