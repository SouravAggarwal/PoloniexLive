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

public class DTab2 extends Fragment {
    String TAG = "DTAB3";
    DetailedMain mCallback2;
    List<DTab2_Obj> DataTab2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback2 = (DetailedMain) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detailed_tab2, container, false);
      try {
          ArrayList<DTab2_Obj> ar2= new ArrayList<DTab2_Obj>(mCallback2.DataListTab2);



          DTab2_Adapter adapter2 = new DTab2_Adapter(getContext(),ar2 );
          ListView listView2 = (ListView) rootView.findViewById(R.id.dt2listView);
          listView2.setAdapter(adapter2);

      }catch (Exception e){
          e.printStackTrace();
      }
      return rootView;
    }


}
