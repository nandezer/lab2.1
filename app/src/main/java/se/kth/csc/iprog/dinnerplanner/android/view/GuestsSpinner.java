package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Spinner;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 25-02-2015.
 */
public class GuestsSpinner implements Observer {

    View view;
    DinnerModel model;
    Spinner spinnerDropDown;

    public GuestsSpinner(View view, DinnerModel model){
        this.model = model;
        this.view = view;
        this.model.addObserver(this);
        spinnerDropDown =(Spinner) view.findViewById(R.id.spinner);

    }

    public void update(Observable observable, Object data) {
        // This method is notified after data changes.

    }

}
