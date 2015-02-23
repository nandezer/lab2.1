package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.Vector;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.InstructionsMenu;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Isaac Rondon on 21-02-2015.
 */
public class DishDisplay_Controller implements GridView.OnItemClickListener {
    DinnerModel model;
    DishDisplay view;
    boolean start;
    Context mContext;
    int positionClick;
    boolean chooseMenu;
    String[] dishesName;
    String[] dishesImages;
    Vector<Dish> vecDish;
    int[] dishesPrice;
    InstructionsMenu instructionActivity;
    private PopupWindow pwindo;
    Button btnChoosePopup;
    ImageButton btnClosePopup;
    ChooseMenu menuActivity;

    public DishDisplay_Controller(DinnerModel model , DishDisplay view,Context c, boolean menu, Activity act){
        this.model = model;
        this.view = view;
        this.mContext = c;
        this.chooseMenu = menu;
        if(chooseMenu)menuActivity = (ChooseMenu)act;
        else instructionActivity = (InstructionsMenu)act;
        int i = 0;
        for(Dish d : model.getDishes()){
            dishesName[i]= d.getName();
            dishesImages[i]= d.getImage();
            vecDish.add(d);
            for(Ingredient in : d.getIngredients()) {
                dishesPrice[i] += (in.getPrice());
            }
            i++;
        }
        view.grid.setAdapter(new DishAdapter(model.getDishes(),c ,dishesName, dishesImages));
        view.grid.setOnItemClickListener(this);
    }


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

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    private View.OnClickListener choose_button_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            model.addDishToMenu(vecDish.get(positionClick));
            //creator(mContext,view,dishes,chooseMenu,model);
            if(chooseMenu)menuActivity.runOnUiThread();
            pwindo.dismiss();
        }
    };
    private View.OnClickListener close_button_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pwindo.dismiss();
        }
    };

}