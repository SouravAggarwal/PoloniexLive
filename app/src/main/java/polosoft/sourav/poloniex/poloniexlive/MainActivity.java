package polosoft.sourav.poloniex.poloniexlive;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.google.firebase.analytics.FirebaseAnalytics;
import polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName;
import polosoft.sourav.poloniex.poloniexlive.Home.LJsonParsing;
import polosoft.sourav.poloniex.poloniexlive.Home.LUtils;
import polosoft.sourav.poloniex.poloniexlive.Home.ListObj;
import polosoft.sourav.poloniex.poloniexlive.Home.ListviewAdapter;
import polosoft.sourav.poloniex.poloniexlive.Home.SharedPreference;
import polosoft.sourav.poloniex.poloniexlive.Sort.Sortprice;
import polosoft.sourav.poloniex.poloniexlive.Sort.sort24PriceHigh;
import polosoft.sourav.poloniex.poloniexlive.Sort.sort24PriceLow;
import polosoft.sourav.poloniex.poloniexlive.Sort.sortChange;
import polosoft.sourav.poloniex.poloniexlive.Sort.sortVolume;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<List<ListObj>>, SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener{

        public String  getAPP = "<  contact: polosofts@gmail.com   " +
                "{for getting poloniex api (breaking reCAPTCHA on Poloniex Api/ Web } ";



    boolean setusdPricFirstTime = true;
    Context context = this;
    String TAG = "Home.MainActivity";
    public static FirebaseJobDispatcher dispatcher;
    String sample = null;
    final int LOADERID = 1;
    RecyclerView hRecyclerView;
    ListviewAdapter hListviewAdapter;
    List<ListObj> myData;
    LinearLayoutManager layoutManager;
    int flag = 0;
    LoaderManager loaderManager;
    Loader<String> githubSearchLoader;
    MaterialFavoriteButton favorite;
    Spinner sortdialog;

    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_drawer_navig1);
        dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(getApplicationContext()));
        getAPP.equals(" ");

        LoaderManager.LoaderCallbacks<List<ListObj>> callback = MainActivity.this;

        getSupportLoaderManager().initLoader(LOADERID, null, callback);

        loaderManager = getSupportLoaderManager();
        githubSearchLoader = loaderManager.getLoader(LOADERID);
        loaderManager.initLoader(LOADERID, null, MainActivity.this);

        //=========Recycler view
        //mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        hRecyclerView = (RecyclerView) findViewById(R.id.hRecyclerview);
        layoutManager = new LinearLayoutManager(this);
        hRecyclerView.setLayoutManager(layoutManager);
        hRecyclerView.setHasFixedSize(true);

        //  myData = new ArrayList<ListObj>();
         // hListviewAdapter = new ListviewAdapter(this, myData);

        hRecyclerView.setAdapter(hListviewAdapter);


        NavigationDrawer();                          // Navigation Drawer

//--------------Spinner
        sortdialog = (Spinner) findViewById(R.id.sortdialog);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SortingOrder, android.R.layout.preference_category);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
// Apply the adapter to the spinner
        sortdialog.setAdapter(adapter);
        sortdialog.setOnItemSelectedListener(this);

//----------------Firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Stetho.initializeWithDefaults(this);
    }

    //-----------------------------------------------OnCreate Ends
//-------------Loader
    @Override
    public Loader<List<ListObj>> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<List<ListObj>>(this) {

            @Override
            protected void onStartLoading() {
                //mLoadingIndicator.setVisibility(View.VISIBLE);
                forceLoad();

            }

            @Override
            public List<ListObj> loadInBackground() {
                try {
                    // if(args.getString("bundKey")==null) {     // showign Exception
                    // }
                    String jsonResponse = LUtils
                            .getResponseFromHttpUrl();

                    List<ListObj> simpleJsonWeatherData = LJsonParsing
                            .getSimpleWeatherStringsFromJson(MainActivity.this, jsonResponse);

                    return simpleJsonWeatherData;


                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }


    @Override
    public void onLoadFinished(Loader<List<ListObj>> loader, List<ListObj> data) {
        try {
            this.myData = data;
            if (this.flag == 0) {
                this.flag = 1;
                this.hListviewAdapter = new ListviewAdapter(this, data);
                this.hRecyclerView.setAdapter(this.hListviewAdapter);

                this.hListviewAdapter.notifyDataSetChanged();

            } else {
                this.hListviewAdapter.swap(Sortdata(data));     //
            }
            //this.hListviewAdapter.notifyDataSetChanged();

            if (this.newText != null) {
                onQueryTextChange(MainActivity.this.newText);
            }

            if (setusdPricFirstTime) {
                setusdPricFirstTime = false;

                for (int i = 0; i < data.size(); i++) {
                    ListObj d = data.get(i);
                    if (d.gethCoin().equals("USDT_BTC")) {
                        HomeGetCoinName.setUsdPrice(Double.parseDouble(d.gethJsonLastPrice()));

                    }
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<ListObj>> loader) {
        loader.reset();
    }

    //=-------------------------Add full name
    //---------------------Recycler view Sorting Start
    public List<ListObj> Sortdata(List<ListObj> data) {
        try {
            String order = SharedPreference.getPref(this, "sortpref");

            switch (order) {
                case "Preferred":
                    List<String> preferedCoinList = SharedPreference.getPreferedCoinList(this);

                    if (preferedCoinList != null) {
                        for (int i = 0; i < data.size(); i++) {
                            for (int j = 0; j < preferedCoinList.size(); j++) {
                                if (data.get(i).gethCoin().equals(preferedCoinList.get(j))) {
                                    ListObj temp = data.get(i);
                                    data.remove(i);
                                    data.add(0, temp);
                                }


                            }
                        }


                    }
                    return data;

                case "Last Price High":
                    Collections.sort(data, Collections.reverseOrder(new Sortprice()));
                    return data;
                case "Last Price Low":
                    Collections.sort(data, new Sortprice());
                    return data;
                case "24hr Change High":
                    Collections.sort(data, Collections.reverseOrder(new sortChange()));
                    return data;
                case "24hr Change Low":
                    Collections.sort(data, new sortChange());
                    return data;
                case "Volume High":
                    Collections.sort(data, Collections.reverseOrder(new sortVolume()));
                    return data;
                case "Volume Low":
                    Collections.sort(data, new sortVolume());
                    return data;
                case "24hr High":
                    Collections.sort(data, Collections.reverseOrder(new sort24PriceHigh()));
                    return data;
                case "24hr Low":
                    Collections.sort(data, new sort24PriceLow());
                    return data;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

//-----------------------------On TextChangeQuery

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;


    }

    String newText;

    @Override
    public boolean onQueryTextChange(String newText) {
        try {
            this.newText = newText;

            final String lowerCaseQuery = newText.toLowerCase();
            List<ListObj> filteredModelList = new ArrayList<>();

            // for full name


            for (ListObj model : this.myData) {
                String text = model.gethCoin().toLowerCase();
                if (text.contains(lowerCaseQuery)) {    // || add more filter
                    filteredModelList.add(model);
                }
            }


            this.hListviewAdapter.swap(filteredModelList);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    //---------------------------------------OnCreateOptionMenu
    Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {   // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);

            final MenuItem searchItem = menu.findItem(R.id.action_search);
            final SearchView searchView = (SearchView) searchItem.getActionView();
            searchView.setOnQueryTextListener(this);
            searchView.setQueryHint("btc_eth");

        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_sort) {
            sortdialog.performClick();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //--------------------------------Navigation Drawer

//-----------------Favourite button


//----calling wtih timer

    Timer timer;

    public void callAsynchronousTask() {
        final Handler handler = new Handler();
        this.timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            //LoaderManager loaderManager = getSupportLoaderManager();
                            //Loader<String> githubSearchLoader = loaderManager.getLoader(LOADERID);


                            if (MainActivity.this.githubSearchLoader == null) {
                                Bundle b = new Bundle();
                                b.putString("bundKey", "11");
                                MainActivity.this.loaderManager.initLoader(LOADERID, b, MainActivity.this);

                            } else {
                                Bundle b = new Bundle();
                                b.putString("bundKey", "22");
                                MainActivity.this.loaderManager.restartLoader(LOADERID, b, MainActivity.this);

                            }

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 50000 ms
    }

    @Override
    protected void onPause() {
        //  unregisterReceiver(networkStateReceiver);

        super.onPause();
        timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        callAsynchronousTask();

        if (!isNetworkAvailable()) {
            Snackbar.make(getWindow().getDecorView().getRootView(), "No Internet Connection", Snackbar.LENGTH_LONG)
                    .setAction("", null).show();
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String x = (String) parent.getItemAtPosition(position);
        boolean bools = SharedPreference.setPref(this, "sortpref", x);
        // String m = SharedPreference.getPref(this, "sortpref");
        Snackbar.make(getWindow().getDecorView().getRootView(), "Sorting by  " + x, Snackbar.LENGTH_LONG)
                .setAction("", null).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


