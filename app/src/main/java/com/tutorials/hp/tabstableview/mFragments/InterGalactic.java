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
public class InterGalactic extends Fragment {

    //ROWS DATA SOURCE
    static String[][] spaceProbes={
            {"1","Enterprise","Anti-Matter","Canis Majos"},
            {"2","Spitzer","Plasma","Centarus A"},
            {"3","Atlantis","Warp Drive","Whirlpool"},
            {"4","Challenger","Anti-Matter","Andromeda"},
            {"5","Discovery","Plasma","Small Magellanic Cloud"},
            {"6","Columbia","Anti-Matter","Large Magellanic Cloud"},
            {"7","Voyager","Anti-Matter","Large Magellanic Cloud"},



    };
    //HEADER DATA SOURCE
    static String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};


    public static InterGalactic newInstance() {
        return new InterGalactic();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //VIEWS
        View rootView = inflater.inflate(R.layout.intergalactic, null);


        final TableView<String[]> tableView = (TableView<String[]>) rootView.findViewById(R.id.interGalactic_TB);

        //SET TABLE PROPERTIES
        tableView.setHeaderBackgroundColor(Color.parseColor("#f38630"));
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
        return "Inter-Galactic";
    }
}
