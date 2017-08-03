package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import polosoft.sourav.poloniex.poloniexlive.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Created by Sourav on 25-06-2017.
 */

public class DTab2_Adapter extends ArrayAdapter<DTab2_Obj> {
    ArrayList<DTab2_Obj> list;

    View listItemView;
    Context context;

    public DTab2_Adapter(Context context, ArrayList<DTab2_Obj> list) {
        super(context, 0, list);
        this.list = list;
        context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.detailed_tab2_oneitem, parent, false);
            }
            // View  textContainer = listItemView.findViewById(R.id.dt2listView);

            TextView textView1 = (TextView) listItemView.findViewById(R.id.dt2date);
            TextView textView2 = (TextView) listItemView.findViewById(R.id.dt2BuySell);
            TextView textView3 = (TextView) listItemView.findViewById(R.id.dt2Rate);
            TextView textView4 = (TextView) listItemView.findViewById(R.id.dt2Total);
            DTab2_Obj currentItem = getItem(position);

            if (String.valueOf(currentItem.getData()).contains(" ")) {
                String date[] = currentItem.getData().split(" ");
                textView1.setText(date[1]);
            }

            if (currentItem.getType().equals("buy")) {
                textView2.setText("Buy");
                textView2.setTextColor(Color.parseColor("#8BC34A"));
            } else {
                textView2.setText("Sell");
                textView2.setTextColor(Color.parseColor("#F44336"));
            }

            DecimalFormat formater8 = new DecimalFormat("0.00000000");
            String rate = formater8.format(currentItem.getPrice());
            String amount = formater8.format(currentItem.getAmount());

            textView3.setText(rate);
            textView4.setText(amount);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listItemView;
    }
}



