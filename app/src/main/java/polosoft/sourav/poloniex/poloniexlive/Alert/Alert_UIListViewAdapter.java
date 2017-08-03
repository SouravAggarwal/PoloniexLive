package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Sourav on 24-06-2017.
 */

public class Alert_UIListViewAdapter extends ArrayAdapter<Alert_UIListObject> {
    int activityColor;

    public Alert_UIListViewAdapter(@NonNull Context context, @LayoutRes int resource, List<Alert_UIListObject> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(polosoft.sourav.poloniex.poloniexlive.R.layout.xalert_listview_oneitem, parent, false);
            }

            TextView textView1 = (TextView) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.aCoinCode);
            TextView textView2 = (TextView) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.aCoinName);
            TextView textView3 = (TextView) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.aHigher);

            TextView textView4 = (TextView) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.aLower);
            TextView textView5 = (TextView) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.anote);
            //     TextView textView6 = (TextView) listItemView.findViewById(R.id.alertsmallgreater);

            Alert_UIListObject currentItem = getItem(position);
            textView5.setText(currentItem.getKeyNote());
            textView1.setText(currentItem.getCoinCode());
            textView2.setText(currentItem.getCoinName());
            textView3.setText(currentItem.getPriceHigh());
            textView4.setText("" + currentItem.getPriceLow());

            //textView6.setText(currentItem.getHighLow());


            //for setting Background color of Textboxs (inner LinearLayout)
            //View textContainer = listItemView.findViewById(R.id.innerTextBoxLayout);
            //  textContainer.setBackgroundColor( ContextCompat.getColor(getContext(), activityColor));

            ImageButton btnNxt = (ImageButton) listItemView.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.alertDelete);
            btnNxt.setTag(position);
            btnNxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    int position = (Integer) arg0.getTag();

                    try {
                        Alert_UIDatabaseHelper mDbHelper = new Alert_UIDatabaseHelper(getContext());

                        // Gets the database in write mode
                        SQLiteDatabase db = mDbHelper.getReadableDatabase();
                        db.execSQL("DELETE FROM " + Alert_UIPetContract.PetEntry.TABLE_NAME + " WHERE " + Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinCode + "= '" + getItem(position).getCoinCode() + "'");
                        Toast.makeText(getContext(), "Removing Item", Toast.LENGTH_SHORT).show();
                        if (db != null) {
                            db.close();
                        }


                    } catch (Exception e) {
                        e.printStackTrace();


                    }






                }
            });
            notifyDataSetChanged();


            return listItemView;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

