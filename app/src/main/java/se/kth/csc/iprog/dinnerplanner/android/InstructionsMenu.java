package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.android.view.Ingredients_header;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;


public class InstructionsMenu extends Activity {


    private DinnerModel model;
    private  String listIngredients = "";
    private  String instructionsStarter = "";
    private  String instructionsMainCourse = "";
    private  String instructionsDesserts = "";
    private ExampleView toDisplay;
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
        //TODO: change to selected dishes!
        Ingredients_header selected_items = new Ingredients_header(this, findViewById(R.id.selectedIngredients),  model);
        //selectedItems = new DishDisplay(this, findViewById(R.id.ingredientsDish), model.getDishesOfType(1),false, model);

        Set<Dish> allMaterial = model.getFullMenu();
        for (Dish d : allMaterial){
            for(Ingredient i : d.getIngredients()){
                listIngredients += i.getName()+"  "+String.valueOf(i.getQuantity())+" "+i.getUnit()+"\n";
            }
            if(d.getType() == 1){
                instructionsStarter = d.getName()+"\n" + d.getDescription()+"\n";
            }
            else if(d.getType() == 2){
                instructionsMainCourse = d.getName()+"\n" + d.getDescription()+"\n";
            }
            else if(d.getType() == 3){
                instructionsDesserts = d.getName()+"\n" + d.getDescription()+"\n";
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
            case R.id.ingredientsDish:
              int selected = selectedItems.getPosition();
              headerInstructions = new ExampleView(findViewById(R.id.header),String.valueOf(selected));

        }
    }


}
