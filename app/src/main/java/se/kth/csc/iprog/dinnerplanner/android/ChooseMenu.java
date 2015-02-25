package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Spinner;


import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.Banner_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_Create;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_CreateController;
import se.kth.csc.iprog.dinnerplanner.android.view.DetailsDinner;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.android.view.GuestsSpinner;
import se.kth.csc.iprog.dinnerplanner.android.view.GuestsSpinnerController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;


public class ChooseMenu extends Activity  {
    private DinnerModel model;
    GridView grid;
    ExampleView totalCost;
    float totalPrice;
    Spinner spinnerDropDown;
    String[] numGuestsPossible = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "9",
            "10"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.choose_menu);
        DinnerModel modelG = ((DinnerPlannerApplication) this.getApplication()).getModel();
        this.model = modelG;

        displayScreen();
        displayPrice();
    }
    public void runOnUiThread() {
        displayPrice();
    }

    public void displayScreen() {
    
        DinnerModel modelG = ((DinnerPlannerApplication) this.getApplication()).getModel();
        model = modelG;
        //Set banner
        Banner bannerView = new Banner(findViewById(R.id.banner),model);
        Banner_Controller bannerViewController = new Banner_Controller(bannerView,model,this,this);
        //Set Starters Area
        ExampleView starters = new ExampleView(findViewById(R.id.starters), "Starters");
        //Set list of Starters to show
        DishDisplay startersItems = new DishDisplay(model, findViewById(R.id.startersImage));
        DishDisplay_Controller startersController = new DishDisplay_Controller(this.model,startersItems,this,true, this,1);

        ExampleView mainCourses = new ExampleView(findViewById(R.id.mainCourses), "Main Courses");
        DishDisplay mainCoursesItems = new DishDisplay(model, findViewById(R.id.mainCourseImage));
        DishDisplay_Controller mainCoursesController = new DishDisplay_Controller(this.model,mainCoursesItems,this,true, this,2);

        ExampleView desserts = new ExampleView(findViewById(R.id.desserts), "Desserts");
        DishDisplay dessertsItems = new DishDisplay(model, findViewById(R.id.dessertsImage));
        DishDisplay_Controller dessertsController = new DishDisplay_Controller(this.model,dessertsItems,this,true, this,3);

        DetailsDinner details = new DetailsDinner(findViewById(R.id.guestsID), this.model);

        //Set "Create" button
        ButtonStart_Create start = new ButtonStart_Create(findViewById(R.id.button_start), "Create", this.model);
        ButtonStart_CreateController startController = new ButtonStart_CreateController(this.model, start, false);

        //Number of Guests
        GuestsSpinner spinner = new GuestsSpinner(findViewById(R.id.spinner),this.model);
        GuestsSpinnerController spinner_Controller = new GuestsSpinnerController(this.model,spinner,this,this);

        /*
        spinnerDropDown =(Spinner)findViewById(R.id.spinner);
        spinnerDropDown.setSelection(this.model.getNumberOfGuests());
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item , numGuestsPossible);
        spinnerDropDown.setAdapter(adapter);
        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=spinnerDropDown.getSelectedItemPosition();
                spinnerDropDown.setSelection(sid);
                setNumberGuests(sid + 1);
                displayPrice();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });*/
    }

    public void displayPrice(){
        totalPrice = model.getTotalMenuPrice()*this.model.getNumberOfGuests();
        totalCost = new ExampleView(findViewById(R.id.price_menu), "Total Cost: " + String.valueOf(totalPrice) + " kr");
    }
    /*
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.banner:
                ((DinnerPlannerApplication) this.getApplication()).setModel(new DinnerModel());
                displayScreen();
                displayPrice();


        }
    }*/

   /*
    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.
    }
    */
}