package polosoft.sourav.poloniex.poloniexlive.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import polosoft.sourav.poloniex.poloniexlive.Detailed.DetailedMain;
import polosoft.sourav.poloniex.poloniexlive.R;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Sourav on 18-06-2017.
 */

public class ListviewAdapter extends RecyclerView.Adapter<ListviewAdapter.ListViewHolder> {
    String TAG = "ListViewAdapter";
    private List<ListObj> mDataset;
    Context context;

    public ListviewAdapter(Context context, List<ListObj> mDataset) {
        this.mDataset = mDataset;
        this.context = context;
    }

    public void swap(List<ListObj> datas) {
        if (this.mDataset == null) {

        } else {
            this.mDataset.clear();
            this.mDataset.addAll(datas);
            notifyDataSetChanged();
        }

    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_recycleview, parent, false);

        return new ListViewHolder(itemView);
        //binds.setFocusable(true);
        //return new ListViewHolder(binds);

    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
// colorflag,hCoin,hJsonLastPrice,hJsonBaseVol,hJsonQuoteVol,hJsonPerChange,hJsonDayHighPrice,hJsonLowPrice,hJsonLowestPrice,hJsonHighestPrice,
        holder.setIsRecyclable(false);
        try {
            ListObj i = mDataset.get(position);

//------------------------Setting coin image & full name Ends
            switch (i.getColorflag()) {
                case 0:
                    holder.hChangeIcon.setImageResource(R.drawable.aadown0_24dp);
                    holder.hLine.setBackgroundColor(Color.parseColor("#F44336"));
                    //int id = R.mipmap.bitcoin;
                    // holder.hImageIcon.setImageResource(id);
                    break;
                case 1:
                    holder.hChangeIcon.setImageResource(R.drawable.aaup1_24dp);
                    holder.hLine.setBackgroundColor(Color.parseColor("#8BC34A"));

                    break;
                default:
                    throw new IllegalArgumentException("Invalid view type, value of Image id");

            }

            if (i.gethCoin().contains("_")) {
                String[] CoinName = i.gethCoin().split("_", 2);  //CoinName[0]+"car"+CoinName[1]

                holder.hTextViewShortName.setText(CoinName[1]);

                holder.hTextShortSecond.setText("/ " + CoinName[0]);

                if (CoinName[0].equals("BTC")) {
                    DecimalFormat magnitudeFormat = new DecimalFormat("0.000");
                    holder.hPriceDoll.setText(magnitudeFormat.format(Double.parseDouble(i.gethJsonLastPrice()) * HomeGetCoinName.getUSDPrice()));

                } if (CoinName[0].equals("USDT")) {
                    DecimalFormat magnitudeFormat = new DecimalFormat("0.000");
                    holder.hPriceDoll.setText(magnitudeFormat.format(Double.parseDouble(i.gethJsonLastPrice()) ));

                }

            }
            holder.hPriceBTC.setText(String.valueOf(i.gethJsonLastPrice()));
            //  holder.hPriceDoll.setText(i.gethPriceUSD());
            holder.hVolvalue.setText(i.gethJsonBaseVol());


            DecimalFormat magnitudeFormat = new DecimalFormat("0.000");

            holder.hchange.setCharacterList(TickerUtils.getDefaultNumberList());
            holder.hchange.setText(i.gethJsonPerChange() + " %");


            List<String> casedata = GetCoinName.getCoinName(i.gethCoin());

            if (casedata != null) {
                Glide.with(context).load(casedata.get(0))
                        .thumbnail(0.5f)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.hImageIcon);

                holder.hFullName.setText(casedata.get(1));
            } else {
                if (i.gethCoin().contains("_")) {
                    String[] CoinName = i.gethCoin().split("_", 2);  //CoinName[0]+"car"+CoinName[1]

                    holder.hFullName.setText(CoinName[1]);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        try {
            return mDataset.size();
        } catch (Exception e) {
            return 0;
        }
    }


    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView hImageIcon, hChangeIcon;
        TextView hTextViewShortName;
        TextView hTextShortSecond;
        TextView hPriceBTC;
        TextView hPriceDoll;
        TextView hVolvalue;
        TickerView hchange;
        View hLine;
        TextView hFullName;

        public ListViewHolder(View view) {
            super(view);
            hFullName = (TextView) view.findViewById(R.id.hfullName);
            hImageIcon = (ImageView) view.findViewById(R.id.hImageIcon);
            hChangeIcon = (ImageView) view.findViewById(R.id.hChangeIcon);
            hTextViewShortName = (TextView) view.findViewById(R.id.hTextViewShortName);
            hTextShortSecond = (TextView) view.findViewById(R.id.hsortsecondNmae);
            hPriceBTC = (TextView) view.findViewById(R.id.hPriceBTC);//
            hPriceDoll = (TextView) view.findViewById(R.id.hPriceDoll);//
            hVolvalue = (TextView) view.findViewById(R.id.hVolvalue);
            hchange = (TickerView) view.findViewById(R.id.hchange);
            hLine = view.findViewById(R.id.hLine);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

try {
    Intent i = new Intent(context, DetailedMain.class);

    i.putExtra("coinName", mDataset.get(getAdapterPosition()).gethCoin());
    String nm = mDataset.get(getAdapterPosition()).gethCoin();
    if (nm.contains("_")) {
        String[] CoinNames = nm.split("_", 2);  //CoinName[0]+"car"+CoinName[1]

        i.putExtra("titleCoinName", CoinNames);
    }

    context.startActivity(i);

}catch (Exception e){
    e.printStackTrace();
}
        }
    }


}


