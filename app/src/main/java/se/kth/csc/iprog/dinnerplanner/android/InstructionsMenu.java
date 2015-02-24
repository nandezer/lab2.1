package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Set;
import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;


public class InstructionsMenu extends Activity {


    private DinnerModel model;
    private  String listIngredients = "";
    private ExampleView toDisplay;
    Vector<Dish> vecDish;

    DishDisplay selectedItems;
    ExampleView headerInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        //STATIC
        this.model = ((DinnerPlannerApplication)this.getApplication()).getModel();
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.instructions_menu);
        Banner bannerView = new Banner(findViewById(R.id.banner_instructions));
        ExampleView ingredients = new ExampleView(findViewById(R.id.selectedIngredients),"Ingredients");


        float totalPrice = model.getTotalMenuPrice();
        ExampleView totalCost = new ExampleView(findViewById(R.id.price_instructions),"Total Cost: "+String.valueOf(totalPrice)+" kr");
        ExampleView instructions = new ExampleView(findViewById(R.id.instruction_header),"Instructions");
        //DYNAMIC
        headerInstructions = new ExampleView(findViewById(R.id.header),"Ingredients");
        //selectedItems = new DishDisplay(this, findViewById(R.id.ingredientsDish), model.getFullMenu(),false, model,this);
        selectedItems = new DishDisplay(model, findViewById(R.id.ingredientsDish));
        DishDisplay_Controller selectedItemsController = new DishDisplay_Controller(this.model,selectedItems,this,false, this,1);

        vecDish = new Vector<Dish>((model.getFullMenu()).size());
        Set<Dish> allMaterial = model.getFullMenu();
        for (Dish d : allMaterial){
            vecDish.add(d);
            for(Ingredient i : d.getIngredients()){
                listIngredients += i.getName()+"  "+String.valueOf(i.getQuantity())+" "+i.getUnit()+"\n";
            }
        }
        toDisplay = new ExampleView(findViewById(R.id.instruction_dish),listIngredients);

    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goBack:
                startActivity(new Intent(this, ChooseMenu.class));
                break;
            case R.id.dish_display:
                toDisplay = new ExampleView(findViewById(R.id.instruction_dish),listIngredients);
                headerInstructions = new ExampleView(findViewById(R.id.header),"Ingredients");
                break;
            case R.id.selectedIngredients:
                toDisplay = new ExampleView(findViewById(R.id.instruction_dish),listIngredients);
                headerInstructions = new ExampleView(findViewById(R.id.header),"Ingredients");
                break;
            case R.id.ingredient_button:
                toDisplay = new ExampleView(findViewById(R.id.instruction_dish),listIngredients);
                headerInstructions = new ExampleView(findViewById(R.id.header),"Ingredients");
                break;

        }
    }

    public void runOnUiThread(int dishposition) {
        String dishName = (vecDish.get(dishposition)).getName();
        String dishDescription = (vecDish.get(dishposition)).getDescription();
        toDisplay = new ExampleView(findViewById(R.id.instruction_dish),dishDescription);
        headerInstructions = new ExampleView(findViewById(R.id.header),dishName);
    }
}
