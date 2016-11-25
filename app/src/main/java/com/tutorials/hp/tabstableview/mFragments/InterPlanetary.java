package com.tutorials.hp.tabstableview.mFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutorials.hp.tabstableview.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by Oclemy on 9/29/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class InterPlanetary extends Fragment {

    //ROWS DATA SOURCE
       static String[][] spaceProbes={
               {"1","Pioneer","Chemical","Jupiter"},
               {"2","Apollo 15","Chemicla","Mars"},
               {"3","Hubble","Solar","Saturn"},
               {"4","Opportunity","Chemical","Venus"},
               {"5","Apollo 17","Chemical","Moon"},
               {"6","Curiosity","Solar","Mars"},


       };
    //HEADER DATA SOURCE
       static String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};


    public static InterPlanetary newInstance()
    {
        return new InterPlanetary();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.interplanetary,null);

        final TableView<String[]> tableView = (TableView<String[]>) rootView.findViewById(R.id.interPlanetary_TB);

        //SET TABLE PROPERTIES
        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getActivity(),spaceProbeHeaders));
        tableView.setColumnCount(4);

        //ADAPTER
        tableView.setDataAdapter(new SimpleTableDataAdapter(getActivity(), spaceProbes));

        //ROW CLICK LISTENER
        tableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(getActivity(), ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    @Override
    public String toString() {
        return "Inter-Planetary";
    }
}
