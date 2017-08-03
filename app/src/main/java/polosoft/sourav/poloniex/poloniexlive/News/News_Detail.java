package polosoft.sourav.poloniex.poloniexlive.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class News_Detail extends AppCompatActivity {
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(polosoft.sourav.poloniex.poloniexlive.R.layout.news__detail);
        Intent i = getIntent();

        String title=i.getStringExtra("Title");
        String desc=i.getStringExtra("Desc");
       String imageLink= i.getStringExtra("imageLink");
        String webViewLink = i.getStringExtra("WebViewLink");
        // Uri baseUri =Uri.parse(webViewLink) ;

        wv1 = (WebView) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nDetailWebView);
        wv1.setWebViewClient(new WebViewClient());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(webViewLink);


        ImageView nImageView = (ImageView) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nImageView);
        TextView     nTitle = (TextView) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nTextViewHeaer);
        TextView  nDesc = (TextView) findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nTextViewDesc);

        nTitle.setText(title);
        nDesc.setText(desc);
        Glide.with(getApplicationContext()).load(imageLink)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(nImageView);
    }



    }

