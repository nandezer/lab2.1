package se.kth.csc.iprog.dinnerplanner.android.view;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import se.kth.csc.iprog.dinnerplanner.android.view.DishDisplay;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 13-02-2015.
 */
public class Ingredients_header extends Activity {
    View view;
    DinnerModel model;
    Context mContext;

    public Ingredients_header(Context c, View view, DinnerModel model){
        this.view = view;
        this.model = model;
        this.mContext = c;
        DishDisplay selectedItems = new DishDisplay(mContext, view.findViewById(R.id.ingredientsDish), model.getDishesOfType(1),false,model,this);


    }

    public void runOnUiThread() {
        //displayScreen();
    }
}
