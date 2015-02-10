package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;


public class ChooseMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.choose_menu);

        // Creating the view class instance
        //ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));
        //Banner bannerView = new Banner(findViewById(R.id.this_is_banner_view_id));
    }
    /*public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                startActivity(new Intent(this, DinnerPlannerApplication.class));
                break;
        }
    }*/


}
