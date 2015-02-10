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
    DinnerModel model;

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public DishDisplay(View view, DinnerModel model) {
        this.view = view;
        this.model = model;

        /*Set<Dish> dishes = model.getDishes();
        for(Dish d : dishes){
            ImageButton ImageDish = (ImageButton) view.findViewById(R.id.dish_display_type);
            //ImageDish.setBackground(Drawable.createFromPath("@drawable/"+d.getImage()));

        }*/
    }










}



