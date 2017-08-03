package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import polosoft.sourav.poloniex.poloniexlive.R;

public class Alert_main_Editor extends AppCompatActivity {


EditText xhigh,xlow,xNote;
    TextView xcode,xname,xcurrentPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xalert_main__editor);


        Intent ii = getIntent();
        String cCode = ii.getStringExtra("coinCode");
        String cName = ii.getStringExtra("coinName");
        String cPrice = ii.getStringExtra("price");


        xcode = (TextView) findViewById(R.id.meditCoinCode);
        xname = (TextView) findViewById(R.id.meditCoinName);
        xcurrentPrice = (TextView) findViewById(R.id.meditCoinPrice);  // not in db

        xcode.setText(cCode);
        xname.setText(cName);
        xcurrentPrice.setText(cPrice);
//------
        xhigh = (EditText) findViewById(R.id.meditHigh);
        xlow = (EditText) findViewById(R.id.meditLow);
        xNote = (EditText) findViewById(R.id.meditNote);
    }

    private void insertPet() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String mCoinNamee = xcode.getText().toString().trim();
        ;
        String mkeynotee = xname.getText().toString().trim();
        String mActivee = xhigh.getText().toString().trim();
        String mPricee = xlow.getText().toString().trim();
        String mTypee = xNote.getText().toString().trim();
        String mHighLowee ="1";
        Alert_UIDatabaseHelper mDbHelper = new Alert_UIDatabaseHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinCode, mCoinNamee);
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinName, mkeynotee);
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLowHigh, mActivee);
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLow, mPricee);
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_Note, mTypee);
        values.put(Alert_UIPetContract.PetEntry.COLUMN_ALERT_Type, mHighLowee);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(Alert_UIPetContract.PetEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Alert Saved" , Toast.LENGTH_SHORT).show();
        }


    }






























    //--------------------------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.alert_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertPet();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
