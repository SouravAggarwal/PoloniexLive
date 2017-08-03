package polosoft.sourav.poloniex.poloniexlive.Communicate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import polosoft.sourav.poloniex.poloniexlive.Home.SharedPreference;
import polosoft.sourav.poloniex.poloniexlive.R;

public class Abouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communicate_about);

        String Msg=SharedPreference.getMsg(this);

        if(Msg != null){
            TextView myKeyNote = (TextView) findViewById(R.id.myKeyNote);
            myKeyNote.setText(Msg);
        }



    }




    public void gmailclicked(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","polosofts@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Suggestions");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

}
