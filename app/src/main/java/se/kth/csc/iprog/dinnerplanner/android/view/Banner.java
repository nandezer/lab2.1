package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class Banner implements Observer {

	View view;

	public Banner(View view) {

		this.view = view;
		TextView banner = (TextView) view.findViewById(R.id.bannerText);
		banner.setText("Dinner Planner");

	}
    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.

    }

}
