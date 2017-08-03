package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Context;
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
/**
 * Created by Sourav on 25-06-2017.
 */

public class DTab1_AdapterBid extends ArrayAdapter<DTab1_Objclass> {
    ArrayList<DTab1_Objclass> listBid;

    View listItemView;

    public DTab1_AdapterBid(Context context, ArrayList<DTab1_Objclass> listBid) {
        super(context, 0, listBid);
        this.listBid = listBid;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.detailed_tab1_oneitem, parent, false);
            }

            TextView textView1 = (TextView) listItemView.findViewById(R.id.dt1oneItemPrice);
            TextView textView2 = (TextView) listItemView.findViewById(R.id.dt1oneItemAmount);
            DTab1_Objclass currentItem = getItem(position);

            DecimalFormat mf8= new DecimalFormat("0.00000000");
            DecimalFormat mf5= new DecimalFormat("0.0000");

            textView1.setText(mf8.format(currentItem.getPrice()));
            textView2.setText(mf5.format(currentItem.getQuantity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listItemView;
    }
}




