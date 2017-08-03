package polosoft.sourav.poloniex.poloniexlive;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import polosoft.sourav.poloniex.poloniexlive.Alert.Alert_main;
import polosoft.sourav.poloniex.poloniexlive.Communicate.Abouts;
import polosoft.sourav.poloniex.poloniexlive.Communicate.donate;
import polosoft.sourav.poloniex.poloniexlive.Detailed.DTab0_Calc;
import polosoft.sourav.poloniex.poloniexlive.News.New_main;
import polosoft.sourav.poloniex.poloniexlive.Prefered_Coin.Prefered_Coin_List;

/**
 * Created by Sourav on 25-06-2017.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;

    public String  getAPP = "<  contact: polosofts@gmail.com   " +
            "{for getting poloniex api (breaking reCAPTCHA on Poloniex Api/ Web } ";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        getAPP.isEmpty();
        NavigationDrawer();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.converter) {
            // Handle the camera action
            Intent i = new Intent(this, DTab0_Calc.class);
            //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(i);

        } else if (id == R.id.news) {

            Intent i = new Intent(this, New_main.class);
            //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        } else if (id == R.id.alerts) {
           // Prefered_Coin_List l= new Prefered_Coin_List();

            Intent i = new Intent(this, Alert_main.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);

        } else if (id == R.id.preferred) {

            Intent i = new Intent(this,Prefered_Coin_List.class);
            startActivity(i);

        } else if (id == R.id.about) {
            Intent i = new Intent(this,Abouts.class);
            startActivity(i);

        } else if (id == R.id.donate) {

            Intent i = new Intent(this,donate.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* @Override
    public void onBackPressed() {
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
*/

    public void NavigationDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getHeaderView(0);
    }
}
