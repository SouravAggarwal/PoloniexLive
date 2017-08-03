package polosoft.sourav.poloniex.poloniexlive.Communicate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class donate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(polosoft.sourav.poloniex.poloniexlive.R.layout.communicate_donate);


    }



    public void btcAddressedClicked(View v) {

        String textMessage = "16jPNVvABry6ui5uywi8MGaSFmLM3rjtDr";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);

        }
    }}
