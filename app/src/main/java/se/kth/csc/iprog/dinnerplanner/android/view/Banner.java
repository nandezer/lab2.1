package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class Banner implements Observer {

	View view;
    DinnerModel model;
    TextView banner;

	public Banner(View view, DinnerModel model) {
        this.model = model;
		this.view = view;
        this.model.addObserver(this);
		banner = (TextView) view.findViewById(R.id.bannerText);
		banner.setText("Dinner Planner");
    }
    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.

    }

}
