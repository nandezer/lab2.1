package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ButtonStart_Create implements Observer {

	View view;
    DinnerModel model;
    Button start;

	public ButtonStart_Create(View view, String text, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
        this.model = model;
        model.addObserver(this);
        start = (Button) view.findViewById(R.id.button_start);
        start.setText(text);
	}
    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.

    }
}
