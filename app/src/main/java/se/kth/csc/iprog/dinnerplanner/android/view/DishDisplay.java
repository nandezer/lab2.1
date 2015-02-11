package se.kth.csc.iprog.dinnerplanner.android.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.view.Banner;
import se.kth.csc.iprog.dinnerplanner.android.view.DetailsDinner;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;

import static android.graphics.drawable.Drawable.*;

/**
 * Created by Marc on 10/02/2015.
 */
public class DishDisplay{

    View view;


    public DishDisplay(View view, Set<Dish> dishes, int type) {
        this.view = view;

        TextView dishType = (TextView) view.findViewById(R.id.example_text);
        switch (type) {
       case 1:
            dishType.setText("Starter");
           break;
       case 2:
            dishType.setText("Main Course");
           break;
       case 3:
            dishType.setText("Dessert");
           break;


        }
        /*Set<Dish> dishes = model.getDishes();
        for(Dish d : dishes){
            ImageButton ImageDish = (ImageButton) view.findViewById(R.id.dish_display_type);
            //ImageDish.setBackground(Drawable.createFromPath("@drawable/"+d.getImage()));

        }*/
    }










}



