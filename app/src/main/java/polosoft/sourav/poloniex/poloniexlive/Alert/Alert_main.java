package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import polosoft.sourav.poloniex.poloniexlive.BaseActivity;
import polosoft.sourav.poloniex.poloniexlive.R;

import java.util.ArrayList;
import java.util.List;

import static polosoft.sourav.poloniex.poloniexlive.Alert.UtilsFirebaseJobDefined.toCancelThisJob;

public class Alert_main extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xalert_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView listView = (ListView) findViewById(R.id.alertListView);

        View child = getLayoutInflater().inflate(R.layout.xalert_emptyview, null);
        ((ViewGroup) listView.getParent()).addView(child);
        listView.setEmptyView(child);


        //-------
        //  List<Alert_UIListObject> mArrayList = new ArrayList<Alert_UIListObject>();
        //   mArrayList = displayDatabaseInfo();
        //mArrayList.add(new Alert_UIListObject("a", "a", "a", "a", "a", "a"));
    try {if(displayDatabaseInfo(this) !=null) {
        adapter = new Alert_UIListViewAdapter(this, 0, displayDatabaseInfo(this));
    }
        listView.setAdapter(adapter);
        // displayDatabaseInfo();


        StartStopService();
    }catch (Exception e){
        e.printStackTrace();
    }

    }
    Cursor m;
    public void StartStopService() {

        try {
            Alert_UIDatabaseHelper mDbHelper = new Alert_UIDatabaseHelper(this);

            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getReadableDatabase();

            int count = 0;
             m = db.rawQuery("select * from Alerts", null);
            count = m.getCount();
            if (count >= 1) {
                UtilsFirebaseJobDefined.scheduleChargingReminder(this);
            } else {

                toCancelThisJob();
            }

            Toast.makeText(this, "" + count, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (m != null) {
                m.close();
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }
    public void notifyAdapter(){
        adapter.notifyDataSetChanged();

    }

    Alert_UIListViewAdapter adapter;

    static Cursor cursor;


    public  static List<Alert_UIListObject> displayDatabaseInfo(Context context) {

        try {
            List<Alert_UIListObject> mArrayList = new ArrayList<Alert_UIListObject>();

            Alert_UIDatabaseHelper mDbHelper = new Alert_UIDatabaseHelper(context);
            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getReadableDatabase();


            cursor = db.rawQuery("select * from Alerts", null);


            int COLUMN_ALERT_NAM = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinCode);
            int COLUMN_ALERT_KEYNOT = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinName);
            int COLUMN_ALERT_ACTIV = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLowHigh);
            int COLUMN_ALERT_PRIC = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLow);
            int COLUMN_ALERT_TYP = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_Note);
            int COLUMN_ALERT_HIGHLO = cursor.getColumnIndex(Alert_UIPetContract.PetEntry.COLUMN_ALERT_Type);

            boolean pos=true;
            pos=cursor.moveToFirst();
            while (pos) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                String a_name = cursor.getString(COLUMN_ALERT_NAM);
                String a_keynote = cursor.getString(COLUMN_ALERT_KEYNOT);
                String a_active = cursor.getString(COLUMN_ALERT_ACTIV);
                String a_price = cursor.getString(COLUMN_ALERT_PRIC);
                String a_type = cursor.getString(COLUMN_ALERT_TYP);
                String a_highlow = cursor.getString(COLUMN_ALERT_HIGHLO);
                mArrayList.add(new Alert_UIListObject(a_name, a_keynote, a_active, a_price, a_type, a_highlow));
pos=cursor.moveToNext();

            }
            return mArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.

            if (cursor != null) {
                cursor.close();
            }
        }


        return null;
    }

}
