package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Marc on 10/02/2015.
 */
public class DetailsDinner {

    View view;
    DinnerModel model;


    public DetailsDinner(View view, DinnerModel model) {
        this.view = view;
        this.model = model;

        TextView participants = (TextView) view.findViewById(R.id.participants);
        participants.setText("Guests");
    }
}
