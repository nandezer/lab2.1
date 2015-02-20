package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_Create;
import se.kth.csc.iprog.dinnerplanner.android.view.DetailsDinner;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;


public class ChooseMenu extends Activity {
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

        displayScreen();
    }
    public void runOnUiThread() {
        displayScreen();
    }

    void displayScreen(){

        DinnerModel modelG = ((DinnerPlannerApplication) this.getApplication()).getModel();
        this.model = modelG;
        Banner bannerView = new Banner(findViewById(R.id.this_is_banner_view_id));
        ExampleView starters = new ExampleView(findViewById(R.id.starters), "Starters");
        DishDisplay startersItems = new DishDisplay(this, findViewById(R.id.startersImage), model.getDishesOfType(1),true, model,this);

        ExampleView mainCourses = new ExampleView(findViewById(R.id.mainCourses), "Main Courses");
        DishDisplay mainCourseItems = new DishDisplay(this,findViewById(R.id.mainCourseImage), model.getDishesOfType(2),true, model,this);
        ExampleView desserts = new ExampleView(findViewById(R.id.desserts), "Desserts");
        DishDisplay dessertsItems = new DishDisplay(this,findViewById(R.id.dessertsImage), model.getDishesOfType(3),true, model,this);
        DetailsDinner details = new DetailsDinner(findViewById(R.id.this_is_details_dinner_view_id), model);
        ButtonStart_Create start = new ButtonStart_Create(findViewById(R.id.this_is_buttons_start_create_view_id), "Create", this.model);

        totalPrice = model.getTotalMenuPrice();
        totalCost = new ExampleView(findViewById(R.id.price_menu),"Total Cost: "+String.valueOf(totalPrice)+" kr");


        spinnerDropDown =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item , numGuestsPossible);
        spinnerDropDown.setAdapter(adapter);
        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=spinnerDropDown.getSelectedItemPosition();
                spinnerDropDown.setSelection(sid);
                model.setNumberOfGuests(sid+1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });



    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                DinnerModel modelSend = this.model;
                Intent i = new Intent(this, InstructionsMenu.class);
                startActivity(i);
                break;
            case R.id.banner:
                ((DinnerPlannerApplication) this.getApplication()).setModel(new DinnerModel());
                displayScreen();


        }
    }
}