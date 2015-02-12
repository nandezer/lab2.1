package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.BaseAdapter;


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
public class DishDisplay extends BaseAdapter{

    private Context mContext;
   // View view;
    DinnerModel model;
    Set<Dish> dishes;
    String[] dishesName;
    String[] dishesImages;



    public DishDisplay(Context c, Set<Dish> dishes) {
        this.mContext = c;
        //this.view = view;
        this.dishes =dishes;
        dishesName = new String[dishes.size()];
        dishesImages = new String[dishes.size()];
        int i = 0;
        for(Dish d : dishes ){
            dishesName[i]= d.getName();
            dishesImages[i]= d.getImage();
            i++;
        }

/*
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
*/

     }
    public int getCount() {
        return dishes.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.single_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            //Set the text of the item
            textView.setText(dishesName[position]);
            //Set the image of the item
            imageView.setImageResource(getImageId(mContext, dishesImages[position]));
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
        /*Set<Dish> dishes = model.getDishes();
        for(Dish d : dishes){
            ImageButton ImageDish = (ImageButton) view.findViewById(R.id.dish_display_type);
            //ImageDish.setBackground(Drawable.createFromPath("@drawable/"+d.getImage()));

        }*/
 }














