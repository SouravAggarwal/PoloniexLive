package polosoft.sourav.poloniex.poloniexlive.Prefered_Coin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import polosoft.sourav.poloniex.poloniexlive.Home.SharedPreference;

import java.util.ArrayList;
import java.util.List;

public class Prefered_Coin_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(polosoft.sourav.poloniex.poloniexlive.R.layout.prefered_coin_list);


        Toolbar toolbar = (Toolbar) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.newsToolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        try {
            List<String> coinList = SharedPreference.getPreferedCoinList(this);
            List<String> newCoinList = new ArrayList<>();
            if (coinList != null) {
                for (String i : coinList) {
                    if (i.contains("_")) {
                        String[] CoinNames = i.split("_", 2);  //CoinName[0]+"car"+CoinName[1

                        newCoinList.add(CoinNames[0] + " / " + CoinNames[1]);
                    }
                }


                ListView lv = (ListView) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.prefered_Coin_list);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, newCoinList);

                lv.setAdapter(arrayAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
