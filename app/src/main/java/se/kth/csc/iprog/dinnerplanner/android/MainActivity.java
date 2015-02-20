package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_Create;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_CreateController;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class MainActivity extends Activity implements Observer{

    private DinnerModel model;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        // Get the model
        DinnerModel modelG = ((DinnerPlannerApplication)this.getApplication()).getModel();
        modelG.addObserver(this);
        this.model = modelG;
        // Creating the view class instance
        ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id),"Welcome to Dinner Planner! \n\n" +
                "Here you will be able to easily plan your dinner.\n\n" +
                "On the next page start by selecting number of participants. Then select your courses.\n\n"+
                " Watch Magic Happen!");
        Banner bannerView = new Banner(findViewById(R.id.this_is_banner_view_id));
        //Setting start button
        ButtonStart_Create start = new ButtonStart_Create(findViewById(R.id.start), "Start", this.model);
        ButtonStart_CreateController startController = new ButtonStart_CreateController(this.model, start, true);
}

    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.
    }



}
