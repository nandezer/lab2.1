package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.GridView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.ButtonStart_Create;
import se.kth.csc.iprog.dinnerplanner.android.view.DetailsDinner;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;


public class ChooseMenu extends Activity {
    private DinnerModel model;
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.choose_menu);

        DinnerModel modelG = ((DinnerPlannerApplication) this.getApplication()).getModel();
        this.model = modelG;
        Banner bannerView = new Banner(findViewById(R.id.this_is_banner_view_id));
        ExampleView starters = new ExampleView(findViewById(R.id.starters), "Starters");
        DishDisplay startersItems = new DishDisplay(this, findViewById(R.id.startersImage), model.getDishesOfType(1));

        ExampleView mainCourses = new ExampleView(findViewById(R.id.mainCourses), "Main Courses");
        DishDisplay mainCourseItems = new DishDisplay(this,findViewById(R.id.mainCourseImage), model.getDishesOfType(2));
        ExampleView desserts = new ExampleView(findViewById(R.id.desserts), "Desserts");
        DishDisplay dessertsItems = new DishDisplay(this,findViewById(R.id.dessertsImage), model.getDishesOfType(3));
        DetailsDinner details = new DetailsDinner(findViewById(R.id.this_is_details_dinner_view_id), model);
        ButtonStart_Create start = new ButtonStart_Create(findViewById(R.id.this_is_buttons_start_create_view_id), "Create");

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                DinnerModel modelSend = this.model;
                Intent i = new Intent(this, InstructionsMenu.class);
                //i.putExtras("DinnerModel", modelSend);
                startActivity(i);
                break;
            case R.id.banner:
                this.model = new DinnerModel();
                ((DinnerPlannerApplication)this.getApplication()).setModel(model);

        }
    }


}