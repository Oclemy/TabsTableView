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
public class InterStellar  extends Fragment {

    //ROWS DATA SOURCE
    static String[][] spaceProbes={
            {"1","WMAP","Laser Beam","Uranus"},
            {"2","Juno","Nuclear","Asteroid Belt"},
            {"3","Casini","Solar","Saturn"},
            {"4","Kepler","Laser","Jupiter"},
            {"5","Chandra","Chemical","Saturn"},
            {"6","Curiosity","Solar","Mars"},


    };
    //HEADER DATA SOURCE
    static String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};

    public static InterStellar newInstance() {
        return new InterStellar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.interstellar, null);

        final TableView<String[]> tableView = (TableView<String[]>) rootView.findViewById(R.id.interStellar_TB);

        //SET TABLE PROPERTIES
        tableView.setHeaderBackgroundColor(Color.parseColor("#03a9f4"));
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
        return "Inter-Stellar";
    }
}