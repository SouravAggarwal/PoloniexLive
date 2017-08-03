package polosoft.sourav.poloniex.poloniexlive.Detailed;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polosoft.sourav.poloniex.poloniexlive.R;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class DTab3 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detailed_tab3, container, false);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        getGraph(rootView);
        return rootView;
    }

    DetailedMain mCallback3;
    List<DTab3_Obj> DataTab3;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback3 = (DetailedMain) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    public void getGraph(View rootView) {
        try {
            CandleStickChart chart = (CandleStickChart) rootView.findViewById(R.id.chart);
            //[] obj=[{"date":1405699200,"high":0.0045388,"low":0.00403001,"open":0.00404545,"close":0.00427592,"volume":44.11655644,
            //      "quoteVolume":10259.29079097,"weightedAverage":0.00430015}]

            chart.setTouchEnabled(true);
            chart.setDoubleTapToZoomEnabled(true);
            ArrayList<CandleEntry> entries = new ArrayList<CandleEntry>();

int x=1;
            for (DTab3_Obj i : mCallback3.DataListTab3) {

                entries.add(new CandleEntry(x, i.getHigh(), i.getLow(), i.getOpen(), i.getClose()));
x=x+3;
            }


            CandleDataSet cds = new CandleDataSet(entries, "Chart");
            cds.setColor(Color.rgb(80, 80, 80));
            cds.setShadowColor(Color.DKGRAY);
            cds.setShadowWidth(0.7f);
            cds.setDecreasingColor(Color.RED);
            cds.setDecreasingPaintStyle(Paint.Style.FILL);
            cds.setIncreasingColor(Color.GREEN);
            cds.setIncreasingPaintStyle(Paint.Style.FILL);
            cds.setNeutralColor(Color.BLUE);
            cds.setValueTextColor(Color.RED);
            //dataSet.setColor();
            CandleData cd = new CandleData(cds);
            chart.setData(cd);
            cds.setColors(ColorTemplate.COLORFUL_COLORS);
            chart.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
