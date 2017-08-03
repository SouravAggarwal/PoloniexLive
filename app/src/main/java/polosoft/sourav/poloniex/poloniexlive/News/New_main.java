package polosoft.sourav.poloniex.poloniexlive.News;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import polosoft.sourav.poloniex.poloniexlive.BaseActivity;
import polosoft.sourav.poloniex.poloniexlive.R;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//------------------------------------------------carrr
public class New_main extends BaseActivity {
    List<String> nListWebViewLink;
    List<String> nListTitle;
    List<String> nListImageUrl;
    List<String> nListDesc;
    NewsViewAdapter hListviewAdapter;
    List<Bitmap> nListBitImage;
    ImageView imageView;
    DoubleBounce wave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_main);
        try {
        Toolbar toolbar = (Toolbar) findViewById(R.id.newsToolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }
        imageView=(ImageView) findViewById(R.id.spin_kit);
        wave = new DoubleBounce();
        wave.setColor(Color.parseColor("#8BC34A"));
        imageView.setImageDrawable(wave);

        RecyclerView hRecyclerView = (RecyclerView) findViewById(R.id.nRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        hRecyclerView.setLayoutManager(layoutManager);
        hRecyclerView.setHasFixedSize(true);

        nListImageUrl = new ArrayList<>();
        nListTitle = new ArrayList<>();
        nListDesc = new ArrayList<>();
        nListWebViewLink = new ArrayList<>();
        nListBitImage = new ArrayList<>();


        hListviewAdapter = new NewsViewAdapter(this, nListImageUrl, nListTitle, nListDesc, nListWebViewLink);

        hRecyclerView.setAdapter(hListviewAdapter);



            new NewDownload().execute();      // thread=new AsyncTaskBackThread();

        } catch (Exception e) {
            // TODO Auto-generated catch block
        }

    }


    public class NewDownload extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {

                String   htmlResponse = News_LUtils.getResponseFromHttpUrl(1);
                // htmlResponse += News_LUtils.getResponseFromHttpUrl(1);

                Pattern p1 = Pattern.compile("class=\"standard-format-icon\" href=\"(.*?)\" title=");
                Matcher mWebViewLink = p1.matcher(htmlResponse);
                while (mWebViewLink.find()) {
                    nListWebViewLink.add(mWebViewLink.group(1));
                }

                Pattern p2 = Pattern.compile("title=\"(.*?)\">\n" +
                        "\t\t\t\t\t<img width=\"200\" height=\"135\" ");
                Matcher mtitle = p2.matcher(htmlResponse);
                while (mtitle.find()) {
                    nListTitle.add(mtitle.group(1));
                }


                Pattern p3 = Pattern.compile("width=\"200\" height=\"135\" src=\"(.*?)\" class=\"");
                Matcher mImageUrl = p3.matcher(htmlResponse);
                while (mImageUrl.find()) {
                    nListImageUrl.add(mImageUrl.group(1));

                }
                //nListBitImage.add(getBitmapSingle(mImageUrl.group(1)));

                // nListBitImage =getBitmapFromURL(nListImageUrl);

                Pattern p4 = Pattern.compile("<p class=\"desc\">(.*?)</p>");
                Matcher mDescrption = p4.matcher(htmlResponse);
                while (mDescrption.find()) {
                    nListDesc.add(mDescrption.group(1));
                }


                return htmlResponse;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String sss) {
            super.onPostExecute(sss);
            wave.stop();
            imageView.setVisibility(View.GONE);
            hListviewAdapter.notifyDataSetChanged();



        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            wave.start();
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
//--------}----------------------------Navigation

 /*   public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this,New_main.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(this,Alert_main.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void NavigationDrawerr() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}*/
