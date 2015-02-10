package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class Banner {

	View view;

	public Banner(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView banner = (TextView) view.findViewById(R.id.banner);
		banner.setText("Dinner Planner");

		// Setup the rest of the view layout
	}

}
