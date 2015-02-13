package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;


import android.widget.TextView;
import android.widget.BaseAdapter;


import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Marc on 10/02/2015.
 */
public class DishDisplay extends BaseAdapter{

    private Context mContext;
   // View view;
    DinnerModel model;
    Set<Dish> dishes;
    String[] dishesName;
    int[] dishesPrice;
    String[] dishesImages;
    GridView grid;
    boolean chooseMenu = true;
    int positionClick;
    Button btnClosePopup;

    public DishDisplay(Context c, View view, Set<Dish> dishes, boolean chooseMenu, DinnerModel model) {
        this.mContext = c;
        this.chooseMenu =chooseMenu;
        this.dishes =dishes;
        this.model = model;
        dishesName = new String[dishes.size()];
        dishesImages = new String[dishes.size()];
        dishesPrice = new int[dishes.size()];
        int i = 0;
        for(Dish d : dishes ){
            dishesName[i]= d.getName();
            dishesImages[i]= d.getImage();
            for(Ingredient in : d.getIngredients()) {
                dishesPrice[i] += (in.getPrice());
            }
            i++;
        }
        displayDishes(view.findViewById(R.id.dish_display));

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
    public int getPosition(){
        return this.positionClick;
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
    private void displayDishes(View view) {
        grid = (GridView) view.findViewById(R.id.dish_display);
        grid.setAdapter(this);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(chooseMenu){

                    initiatePopupWindow(view, position);
                }
                else{

                }
            }
        });

    }
    private PopupWindow pwindo;

    private void initiatePopupWindow(View view, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.screen_popup,(ViewGroup) view.findViewById(R.id.popup_element));
        pwindo = new PopupWindow(layout, 900, 570, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

        ExampleView popDishName = new ExampleView(layout.findViewById(R.id.nameDish), dishesName[position]);
        ExampleView popDescription = new ExampleView(layout.findViewById(R.id.priceDish),
                "Cost: "+String.valueOf(dishesPrice[position]*model.getNumberOfGuests()+"\n ("+ String.valueOf(dishesPrice[position])
                +" / Person)"));


        btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
        btnClosePopup.setOnClickListener(cancel_button_click_listener);
    }
    private OnClickListener cancel_button_click_listener = new OnClickListener() {
        public void onClick(View v) {
            pwindo.dismiss();

        }
    };

  }














