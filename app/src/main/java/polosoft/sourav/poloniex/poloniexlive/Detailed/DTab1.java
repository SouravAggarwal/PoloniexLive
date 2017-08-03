package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import polosoft.sourav.poloniex.poloniexlive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sourav on 20-06-2017.
 */

public class DTab1 extends Fragment {
    DetailedMain mCallback1;
    List<DTab1_Objclass> DataTab1;
    View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback1 = (DetailedMain) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         rootView = inflater.inflate(R.layout.detailed_tab1, container, false);


        try {
            ArrayList<DTab1_Objclass> arr= new ArrayList<DTab1_Objclass>(mCallback1.DataListTab1Ask);
            DTab1_AdapterAsk adapter = new DTab1_AdapterAsk(getContext(),arr );
            ListView listView = (ListView) rootView.findViewById(R.id.dt1AskList);
            listView.setAdapter(adapter);


            ArrayList<DTab1_Objclass> ar2= new ArrayList<DTab1_Objclass>(mCallback1.DataListTab1Bid);
            DTab1_AdapterAsk adapter2 = new DTab1_AdapterAsk(getContext(),ar2 );
            ListView listView2 = (ListView) rootView.findViewById(R.id.dt1BidList);
            listView2.setAdapter(adapter2);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return rootView;


    }


}
