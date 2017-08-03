package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import polosoft.sourav.poloniex.poloniexlive.Alert.Alert_main_Editor;
import polosoft.sourav.poloniex.poloniexlive.Home.GetCoinName;
import polosoft.sourav.poloniex.poloniexlive.Home.HomeGetCoinName;
import polosoft.sourav.poloniex.poloniexlive.R;

import java.text.DecimalFormat;
import java.util.List;


public class DTab0 extends Fragment {

    DetailedMain mCallback;
    static DetailedMain mCallback2_intentalert;
    static String coinnameIntentAlert;
    List<DTab0_Objclass> DataTab0;
    ImageButton fav;
    View rootView;

    public DTab0() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (DetailedMain) context;
            mCallback2_intentalert = mCallback;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.detailed_tab0, container, false);
        //--------------------
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabCalc);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent i = new Intent(getContext(), DTab0_Calc.class);
                    i.putExtra("coin", mCallback.DataListTab0.get(0).gethCoin());
                    i.putExtra("price", mCallback.DataListTab0.get(0).gethJsonLastPrice());

                    getActivity().startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            int colorflag = 0;

            TextView tv1 = (TextView) rootView.findViewById(R.id.dt0CoinName);
            TextView tv2 = (TextView) rootView.findViewById(R.id.dt0BTCPrice);
            TextView tv3 = (TextView) rootView.findViewById(R.id.dt0USDPrice);
            TextView tv4 = (TextView) rootView.findViewById(R.id.dt0PercentChange);
            ImageView tv5 = (ImageView) rootView.findViewById(R.id.dt0PerChangeImage);
            ImageView tv20 = (ImageView) rootView.findViewById(R.id.dt0ImageIcon);
            TextView tv6 = (TextView) rootView.findViewById(R.id.dt0Bid);
            TextView tv7 = (TextView) rootView.findViewById(R.id.dt0Ask);
            TextView tv8 = (TextView) rootView.findViewById(R.id.dt0PriceHigh);
            TextView tv9 = (TextView) rootView.findViewById(R.id.dt0PriceLow);
            TextView tv10 = (TextView) rootView.findViewById(R.id.dt0Volume);
            TextView tv11 = (TextView) rootView.findViewById(R.id.ht0PoloniexTime);
            TextView tv12 = (TextView) rootView.findViewById(R.id.ht0LocalTime);
            View tv13 = rootView.findViewById(R.id.dt0Line);


            String PercentChange = mCallback.DataListTab0.get(0).gethJsonPerChange();
            DecimalFormat fm3 = new DecimalFormat("0.000");


            if (PercentChange.contains("-")) {
                colorflag = 0;
                tv4.setTextColor(Color.parseColor("#F44336"));
                tv4.setText(fm3.format(Double.parseDouble(PercentChange)) + " %");
                tv13.setBackgroundColor(Color.parseColor("#F44336"));
                tv5.setImageResource(R.drawable.aadown0_24dp);

            } else {
                colorflag = 1;
                tv13.setBackgroundColor(Color.parseColor("#8BC34A"));
                tv5.setImageResource(R.drawable.aaup1_24dp);
                tv4.setText(fm3.format(Double.parseDouble(PercentChange)) + " %");
                tv4.setTextColor(Color.parseColor("#8BC34A"));


            }


            tv2.setText(mCallback.DataListTab0.get(0).gethJsonLastPrice());

            tv6.setText(mCallback.DataListTab0.get(0).gethJsonHighBid());
            tv7.setText(mCallback.DataListTab0.get(0).gethJsonLowAsk());
            tv8.setText(mCallback.DataListTab0.get(0).gethJsonDayHighPrice());
            tv9.setText(mCallback.DataListTab0.get(0).gethJsonLowPrice());
            tv10.setText(mCallback.DataListTab0.get(0).gethJsonBaseVol() + " / " + mCallback.DataListTab0.get(0).gethJsonQuoteVol());

            tv11.setText(HomeGetCoinName.getPoloniexTime());
            tv12.setText(HomeGetCoinName.getLocalTime());


            List<String> coname = GetCoinName.getCoinName(mCallback.DataListTab0.get(0).gethCoin());
            if (coname != null) {
                tv1.setText(coname.get(1));
                coinnameIntentAlert = coname.get(1);
                Glide.with(this).load(coname.get(0))
                        .thumbnail(0.5f)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(tv20);
            } else {
                if (mCallback.DataListTab0.get(0).gethCoin().contains("_")) {
                    String[] CoinName = mCallback.DataListTab0.get(0).gethCoin().split("_", 2);  //CoinName[0]+"car"+CoinName[1]

                    tv1.setText(CoinName[1]);


                }


            }
            if (mCallback.DataListTab0.get(0).gethCoin().contains("_")) {
                String[] CoinName = mCallback.DataListTab0.get(0).gethCoin().split("_", 2);  //CoinName[0]+"car"+CoinName[1]

                if (CoinName[0].equals("BTC")) {

                    Double priceinUSD = Double.parseDouble(mCallback.DataListTab0.get(0).gethJsonLastPrice()) * HomeGetCoinName.getUSDPrice();

                    tv3.setText(fm3.format(priceinUSD));
                }
//if(CoinName[0].equals("USDT")){
//    Double priceinUSD = Double.parseDouble(mCallback.DataListTab0.get(0).gethJsonLastPrice());
//
//                    tv3.setText(fm3.format(priceinUSD));



//

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;

    }


    public static void alertss(Context context) {

        try {
            Intent i = new Intent(context, Alert_main_Editor.class);

            i.putExtra("coinCode", mCallback2_intentalert.DataListTab0.get(0).gethCoin());
            i.putExtra("price", mCallback2_intentalert.DataListTab0.get(0).gethJsonLastPrice());
            i.putExtra("coinName", coinnameIntentAlert);
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


/*    public interface globalTab0 {
        public List<DTab0_Objclass> getDataTab0();

        public String getdata();
    }
*/