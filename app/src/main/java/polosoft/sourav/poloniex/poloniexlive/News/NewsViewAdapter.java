package polosoft.sourav.poloniex.poloniexlive.News;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Sourav on 24-06-2017.
 */

public class NewsViewAdapter extends RecyclerView.Adapter<NewsViewAdapter.ListViewHolder> {
    List<String> nListWebViewLink;
    List<String> nListTitle;
    List<String> nListImageUrl;

    List<String> nListDesc;
    Context context;


    public NewsViewAdapter(Context context, List<String> nListImageUrl, List<String> nListTitle, List<String> nListDesc, List<String> nListWebViewLink) {
        this.nListWebViewLink = nListWebViewLink;
        this.nListTitle = nListTitle;
        this.nListImageUrl = nListImageUrl;
        this.nListDesc = nListDesc;
        this.context = context;
    }

    @Override
    public NewsViewAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(polosoft.sourav.poloniex.poloniexlive.R.layout.news_recycler_item, parent, false);

            return new ListViewHolder(itemView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(NewsViewAdapter.ListViewHolder holder, int position) {
        try {
            holder.nTitle.setText(nListTitle.get(position));
            holder.nDesc.setText(nListDesc.get(position));

            //   holder.nImageView.setImageBitmap(nListBitImage.get(position));

            Glide.with(context).load(nListImageUrl.get(position))
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.nImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        try {
            return nListTitle.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView nImageView;
        TextView nTitle, nDesc;

        public ListViewHolder(View view) {
            super(view);

            nImageView = (ImageView) view.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nImageView);
            nTitle = (TextView) view.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nTextViewHeaer);
            nDesc = (TextView) view.findViewById(polosoft.sourav.poloniex.poloniexlive.R.id.nTextViewDesc);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {
                Intent i = new Intent(context, News_Detail.class);
                i.putExtra("Title", nListTitle.get(getAdapterPosition()));
                i.putExtra("Desc", nListDesc.get(getAdapterPosition()));
                i.putExtra("imageLink", nListImageUrl.get(getAdapterPosition()));
                i.putExtra("WebViewLink", nListWebViewLink.get(getAdapterPosition()));
                context.startActivity(i);
            }catch(Exception e)

            {
                e.printStackTrace();
            }
        }
    }


}
