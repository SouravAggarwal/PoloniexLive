package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import polosoft.sourav.poloniex.poloniexlive.BuildConfig;
import polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName;
import polosoft.sourav.poloniex.poloniexlive.Home.SharedPreference;
import polosoft.sourav.poloniex.poloniexlive.R;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import static polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName.getEuroPrice;
import static polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName.getUSDPrice;

public class DTab0_Calc extends AppCompatActivity {
    EditText textViewPriceCoin, textViewPriceBTC, textViewPriceUSD, textViewPriceEuro;
    TextView cViewCoin, cViewBtc, cViewUsd, cViewEuro;

    double PriceBTClastPrice ;
    double PriceUsd = getUSDPrice();
    double PriceEuro = getEuroPrice();
    View view;

    DecimalFormat formater8 = new DecimalFormat("0.00000000");
    DecimalFormat formater3 = new DecimalFormat("0.000");

    String coinName;

    FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_tab0_calc);
        try {
            Intent intent = getIntent();
            coinName = intent.getStringExtra("coin");
            PriceBTClastPrice = Double.parseDouble(intent.getStringExtra("price"));


            TextView textCoin = (TextView) findViewById(R.id.dt0calccoin);

            Toolbar toolbar = (Toolbar) findViewById(R.id.CalcToolbar);
            this.setTitle(coinName);
            setSupportActionBar(toolbar);
            if (toolbar != null) {

                Toast.makeText(this, "" + coinName, Toast.LENGTH_SHORT).show();
                if (coinName.contains("_")) {
                    String[] CoinNames = coinName.split("_", 2);  //CoinName[0]+"car"+CoinName[1

                    getSupportActionBar().setTitle(CoinNames[0] + " / " + CoinNames[1]);
                    textCoin.setText(CoinNames[1]);

               if(!CoinNames[0].equals("BTC")){
                   Toast.makeText(this, "Select Coin with BTC!", Toast.LENGTH_LONG).show();
               }
                }

            }
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


        EditText e = new EditText(this);

        textViewPriceCoin = (EditText) findViewById(R.id.cPriceCoin);
        textViewPriceBTC = (EditText) findViewById(R.id.cPriceBTC);
        textViewPriceUSD = (EditText) findViewById(R.id.cPriceUSD);
        textViewPriceEuro = (EditText) findViewById(R.id.cPriceEuro);
        textViewPriceCoin.addTextChangedListener(textWatcher);
        textViewPriceBTC.addTextChangedListener(textWatcher);
        textViewPriceUSD.addTextChangedListener(textWatcher);
        textViewPriceEuro.addTextChangedListener(textWatcher);

        cViewCoin = (TextView) findViewById(R.id.cViewCoin);
        cViewBtc = (TextView) findViewById(R.id.cViewBTC);
        cViewUsd = (TextView) findViewById(R.id.cViewUsd);
        cViewEuro = (TextView) findViewById(R.id.cViewEuro);
//---------------Firebase
        remoteConfig.setConfigSettings(new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(false)
                .build());
        HashMap<String, Object> defaults = new HashMap<>();
       // defaults.put("USDPRICE", getUSDPrice());
        defaults.put("EUROPRICE", getEuroPrice());
        defaults.put("MyKeyNote", "s");

        remoteConfig.setDefaults(defaults);

        final Task<Void> fetch = remoteConfig.fetch(
              BuildConfig.DEBUG ?
                        0 : TimeUnit.HOURS.toSeconds(12));
        fetch.addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                remoteConfig.activateFetched();

           //     HomeGetCoinName.setUsdPrice(remoteConfig.getDouble("USDPRICE"));
                HomeGetCoinName.setEuroPrice(remoteConfig.getDouble("EUROPRICE"));


String x = remoteConfig.getString("MyKeyNote");
                System.out.println("mymsg"+x);
                SharedPreference.setMsg(DTab0_Calc.this,remoteConfig.getString("MyKeyNote"));


            }
        });




    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            try {

                if (s.hashCode() == textViewPriceCoin.getText().hashCode()) {
                    cViewCoin.setText(formater3.format(Double.parseDouble(s + "")));
                    double btc = Double.parseDouble(s + "") * PriceBTClastPrice;
                    cViewBtc.setText(formater8.format(btc));
                    double usd = Double.parseDouble(s + "") * PriceBTClastPrice * PriceUsd;
                    cViewUsd.setText(formater3.format(usd));
                    double euro = Double.parseDouble(s + "") * PriceBTClastPrice * PriceEuro;
                    cViewEuro.setText(formater3.format(euro));
                    textViewPriceBTC.setText("");
                    textViewPriceEuro.setText("");
                    textViewPriceEuro.setText("");

                }

                if (s.hashCode() == textViewPriceBTC.getText().hashCode()) {

                    double coin = (Double.parseDouble(s + "") * (1 / PriceBTClastPrice));
                    cViewCoin.setText(formater3.format(coin));
                    cViewBtc.setText(formater8.format(Double.parseDouble(s + "")));
                    double usd1 = Double.parseDouble(s + "") * PriceUsd;
                    cViewUsd.setText(formater3.format(usd1));
                    double euro1 = Double.parseDouble(s + "") * PriceEuro;
                    cViewEuro.setText(formater3.format(euro1));
                    textViewPriceCoin.setText("");
                    textViewPriceUSD.setText("");
                    textViewPriceEuro.setText("");


                }

                if (s.hashCode() == textViewPriceUSD.getText().hashCode()) {

                    double coin = (Double.parseDouble(s + "") * (1 / PriceBTClastPrice));
                    cViewCoin.setText(formater3.format(coin));
                    cViewBtc.setText(formater8.format(Double.parseDouble(s + "")));
                    double usd1 = Double.parseDouble(s + "") * PriceUsd;
                    cViewUsd.setText(formater3.format(usd1));
                    double euro1 = Double.parseDouble(s + "") * PriceEuro;
                    cViewEuro.setText(formater3.format(euro1));
                    textViewPriceCoin.setText("");
                    textViewPriceBTC.setText("");
                    textViewPriceEuro.setText("");


                }
                if (s.hashCode() == textViewPriceEuro.getText().hashCode()) {

                    double coin = (Double.parseDouble(s + "") * (1 / PriceBTClastPrice));
                    cViewCoin.setText(formater3.format(coin));
                    cViewBtc.setText(formater8.format(Double.parseDouble(s + "")));
                    double usd1 = Double.parseDouble(s + "") * PriceUsd;
                    cViewUsd.setText(formater3.format(usd1));
                    double euro1 = Double.parseDouble(s + "") * PriceEuro;
                    cViewEuro.setText(formater3.format(euro1));
                    textViewPriceCoin.setText("");
                    textViewPriceBTC.setText("");
                    textViewPriceUSD.setText("");


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };





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
         if (id == android.R.id.home) {
            // Handle "up" button behavior here.
            finish();
             return true;
        }

        return super.onOptionsItemSelected(item);
    }








}
