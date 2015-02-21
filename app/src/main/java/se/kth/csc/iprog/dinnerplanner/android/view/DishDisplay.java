package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;


import android.widget.TextView;
import android.widget.BaseAdapter;


import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.InstructionsMenu;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Marc on 10/02/2015.
 */
public class DishDisplay extends BaseAdapter implements Observer{

    private Context mContext;
    View viewG;
    DinnerModel model;
    Set<Dish> dishes;
    String[] dishesName;
    Vector<Dish> vecDish;
    int[] dishesPrice;
    String[] dishesImages;
    GridView grid;
    boolean chooseMenu = true;
    int positionClick;
    Button btnChoosePopup;
    ImageButton btnClosePopup;
    ChooseMenu menuActivity;
    InstructionsMenu instructionActivity;

    public DishDisplay(Context c, View view, Set<Dish> dishes, boolean chooseMenu, DinnerModel model, Activity act) {
        creator(c, view, dishes, chooseMenu, model,act);
     }
    public void creator(Context c, View view, Set<Dish> dishes, boolean chooseMenu, DinnerModel model,Activity act){
        this.mContext = c;
        this.chooseMenu =chooseMenu;
        viewG = view;
        this.dishes =dishes;
        this.model = model;
        dishesName = new String[dishes.size()];
        dishesImages = new String[dishes.size()];
        dishesPrice = new int[dishes.size()];
        vecDish = new Vector<Dish>(dishes.size());
        if(chooseMenu)menuActivity = (ChooseMenu)act;
        else instructionActivity = (InstructionsMenu)act;
        int i = 0;
        for(Dish d : dishes ){
            dishesName[i]= d.getName();
            dishesImages[i]= d.getImage();
            vecDish.add(d);
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
                positionClick = position;
                if(chooseMenu){

                    initiatePopupWindow(view, position);
                }
                else{
                    //instructionActivity.runOnUiThread(vecDish.get(positionClick).getName());
                    instructionActivity.runOnUiThread(positionClick);
                }
            }
        });

    }
    private PopupWindow pwindo;

    private void initiatePopupWindow(View view, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.screen_popup,(ViewGroup) view.findViewById(R.id.popup_element));
        pwindo = new PopupWindow(layout, 900, 650, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

        ExampleView popDishName = new ExampleView(layout.findViewById(R.id.nameDish), dishesName[position]);
        ExampleView popDescription = new ExampleView(layout.findViewById(R.id.priceDish),
                "Cost: "+String.valueOf(dishesPrice[position]*model.getNumberOfGuests()+" kr\n ("+ String.valueOf(dishesPrice[position])
                +" / Person)"));
        ImageView imageDishPopUp = (ImageView)layout.findViewById(R.id.image_selected_dish);
        imageDishPopUp.setImageResource(getImageId(mContext, dishesImages[position]));


        btnChoosePopup = (Button) layout.findViewById(R.id.btn_choose_popup);
        btnClosePopup = (ImageButton) layout.findViewById(R.id.btn_close_popup);
        btnClosePopup.setOnClickListener(close_button_click_listener);
        btnChoosePopup.setOnClickListener(choose_button_click_listener);
    }
    private OnClickListener choose_button_click_listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            model.addDishToMenu(vecDish.get(positionClick));
            //creator(mContext,view,dishes,chooseMenu,model);
            if(chooseMenu)menuActivity.runOnUiThread();
            pwindo.dismiss();
        }
    };
    private OnClickListener close_button_click_listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            pwindo.dismiss();
        }
    };

    @Override
    public void update(Observable observable, Object data) {
        // This method is notified after data changes.

    }

  }














