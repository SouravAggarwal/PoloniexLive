package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import polosoft.sourav.poloniex.poloniexlive.Home.SharedPreference;
import polosoft.sourav.poloniex.poloniexlive.R;

import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class DetailedMain extends AppCompatActivity {                             //implements DTab0.globalizer
    int numTab = 0;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    AsyncTaskBackThread thread;
    TabLayout tabLayout;
    String COIN_mainactvity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_main);
        CreateTabLayout();
        // new AsyncTaskBackThread().execute();
        numTab = 0;

        // new AsyncTaskBackThread().execute();
        Intent intent = getIntent();
        COIN_mainactvity = intent.getStringExtra("coinName");
        this.setTitle(COIN_mainactvity);
        setPreferedImageIcon();
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailMainToolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (COIN_mainactvity.contains("_")) {
                String[] CoinNames = COIN_mainactvity.split("_", 2);  //CoinName[0]+"car"+CoinName[1

                getSupportActionBar().setTitle(CoinNames[0] + " / " + CoinNames[1]);
            }
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mViewPager.setCurrentItem(3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_detailed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //-----------------Creating Tab Layout Start
    public void CreateTabLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        // mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //  mViewPager.addOnPageChangeListener(new pageChangeListner());
 /*       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //mSectionsPagerAdapter.notifyDataSetChanged();
                switch (numTab) {
                    case 0:
                        mSectionsPagerAdapter.notifyDataSetChanged();
                        break;

                    case 1:
                        mSectionsPagerAdapter.notifyDataSetChanged();
                        break;

                    case 2:
                        mSectionsPagerAdapter.notifyDataSetChanged();
                        break;

                    default:
                        mSectionsPagerAdapter.notifyDataSetChanged();
                        break;
                }
            }



            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
*/


        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        numTab = tab.getPosition();

                        mViewPager.setOffscreenPageLimit(0);
                        if (count > 3) {
                            System.out.println("tab9");
                            new AsyncTaskBackThread().execute();
                        }
                    }
                });


    }
//
//    public class pageChangeListner implements ViewPager.OnPageChangeListener {
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();

        numTab = 0;
        new AsyncTaskBackThread().execute();

    }


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

        }


        /*    @Override
            public int getItemPosition(Object object) {
                // Causes adapter to reload all Fragments when
                // notifyDataSetChanged is called
                return POSITION_NONE;
            }
    */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return new DTab0();
                case 1:
                    return new DTab1();
                case 2:
                    DTab2 tab2 = new DTab2();


                    return tab2;
                case 3:
                    DTab3 tab3 = new DTab3();

                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return 4;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DETAILS";
                case 1:
                    return "ORDERS";
                case 2:
                    return "TRADES";
                case 3:
                    return "CHART";
                default:
                    return null;

            }


        }


    }


    String val22 = "souravv";

    //-----------------Creating Tab Layout End


    //----------------------AsynClass
    boolean flagasyncsTask = false;

    List<DTab0_Objclass> DataListTab0;
    List<DTab1_Objclass> DataListTab1Ask, DataListTab1Bid;
    List<DTab2_Obj> DataListTab2;
    List<DTab3_Obj> DataListTab3;


    public class AsyncTaskBackThread extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(URL... urls) {
            try {

                if (flagasyncsTask == false) {
                    flagasyncsTask = true;
                    int numTabInner = numTab;

                    switch (numTabInner) {
                        case 0:


                            Uri uriTab0 = Detail_UtilsComon.getUriBuild(numTabInner, COIN_mainactvity);
                            String jsonResponseTab0 = Detail_UtilsComon.makehttpResponse(uriTab0);

                            DataListTab0 = DTab0_JsonParsing.getSimpleDataTab0(jsonResponseTab0, COIN_mainactvity);

                            flagasyncsTask = false;
                            System.out.println("tab0");
                            break;


                        case 1:

                            Uri uriTab1 = Detail_UtilsComon.getUriBuild(numTabInner, COIN_mainactvity);
                            String JsonResponseTab1 = Detail_UtilsComon.makehttpResponse(uriTab1);

                            DataListTab1Ask = DTab1_JsonParsingAsk.getSimpleDataTab1Ask(JsonResponseTab1);
                            DataListTab1Bid = DTab1_JsonParsingBid.getSimpleDataTab1Bid(JsonResponseTab1);
                            flagasyncsTask = false;
                            System.out.println("tab1");

                            break;

                        case 2:
                            Uri uriTab2 = Detail_UtilsComon.getUriBuild(numTabInner, COIN_mainactvity);
                            String jsonResponseTab2 = Detail_UtilsComon.makehttpResponse(uriTab2);
                            DataListTab2 = DTab2_JsonParsing.getSimpleDataTab2(jsonResponseTab2);

                            System.out.println("tab2");
                            flagasyncsTask = false;


                            break;
                        case 3:
                            Uri uriTab3 = Detail_UtilsComon.getUriBuild(numTabInner, COIN_mainactvity);
                            String jsonResponseTab3 = Detail_UtilsComon.makehttpResponse(uriTab3);
                            DataListTab3 = DTab3_JsonParsing.getSimpleDataTab3(jsonResponseTab3);
                            flagasyncsTask = false;
                            System.out.println("tab3");
                            break;

                    }

                    //ArrayList<Integer> list = getSimpleWeatherStringsFromJson(this,jsonResponse);


                    // return list;
                    flagasyncsTask = false;

                }
            } catch (Exception e) {
                e.printStackTrace();
                flagasyncsTask = false;
            }
            return null;
        }


        @Override
        protected void onPostExecute(String list) {
            super.onPostExecute(list);
            getcall();

        }
    }

    int count = 0;
    boolean bools = false;

    public void getcall() {

        if ((count == 1 && bools == false) && DataListTab0 != null) {
            bools = true;
            mViewPager.setCurrentItem(0);
        } else {
            if (count == 2 && bools == false) {
                bools = true;
                mViewPager.setCurrentItem(0);

            }
        }


        count = count + 1;
        if (count < 4) {

            numTab = count;
            new AsyncTaskBackThread().execute();
        }

    }

    Timer timer;
    AsyncTask x;

    public void callAsynchronousTask() {
        final Handler handler = new Handler();
        this.timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            x = new AsyncTaskBackThread().execute();      // thread=new AsyncTaskBackThread();

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
    protected void onResume() {
        super.onResume();
        // callAsynchronousTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // timer.cancel();
    }


 /*   ImageButton fav = (ImageButton) findViewById(R.id.heartbutton);


        fav.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(DetailedMain.this, "test", Toast.LENGTH_SHORT).show();
        }
    });
*/


    public void favclicked(View v) {

        ImageButton imagebutton = (ImageButton) findViewById(R.id.heartbutton);
        boolean isPrefered = SharedPreference.sharedPrefcheckifExist(this, this.COIN_mainactvity);
        if (isPrefered) {
            boolean b = SharedPreference.sharedPrefRemoveItemfromList(this, COIN_mainactvity);
            imagebutton.setImageResource(R.drawable.ic_favorite_border_white_24dp);
        } else {
            boolean bb = SharedPreference.sharedPrefsetPreFavItem(this, COIN_mainactvity);
            imagebutton.setImageResource(R.drawable.ic_favorite_white_24dp);

        }


    }

    public void setPreferedImageIcon() {
        ImageButton imagebutton = (ImageButton) findViewById(R.id.heartbutton);
        boolean isPrefered = SharedPreference.sharedPrefcheckifExist(this, COIN_mainactvity);
        if (isPrefered) {
            imagebutton.setImageResource(R.drawable.ic_favorite_white_24dp);
        } else {
            imagebutton.setImageResource(R.drawable.ic_favorite_border_white_24dp);

        }
    }

    public void alertAdd(View v) {
        DTab0.alertss(this);

    }


}