package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class ExampleView {

	View view;

	public ExampleView(View view, String text) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView example = (TextView) view.findViewById(R.id.example_text);
		example.setText(text);
		// Setup the rest of the view layout
	}

}
