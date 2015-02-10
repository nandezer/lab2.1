package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class ButtonStart_Create {

	View view;

	public ButtonStart_Create(View view, String text) {

		// store in the class the reference to the Android View
		this.view = view;
        Button start = (Button) view.findViewById(R.id.button_start);
        start.setText(text);
		// Setup the rest of the view layout
	}

}
