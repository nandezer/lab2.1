package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_Create;
import se.kth.csc.iprog.dinnerplanner.android.view.DetailsDinner;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class InstructionsMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.choose_menu);

        DinnerModel model = new DinnerModel();
        DishDisplay dish =  new DishDisplay(findViewById(R.id.this_is_dish_view_id), model);
        DetailsDinner details =  new DetailsDinner(findViewById(R.id.this_is_details_dinner_view_id), model);
        


    }



    /*public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                startActivity(new Intent(this, .class));
                break;
        }
    }*/


}
