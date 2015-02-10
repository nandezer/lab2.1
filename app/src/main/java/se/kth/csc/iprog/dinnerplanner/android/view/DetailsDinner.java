package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Marc on 10/02/2015.
 */
public class DetailsDinner {

    View view;
    DinnerModel model;

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public DetailsDinner(View view, DinnerModel model) {
        this.view = view;
        this.model = model;
    }
}
