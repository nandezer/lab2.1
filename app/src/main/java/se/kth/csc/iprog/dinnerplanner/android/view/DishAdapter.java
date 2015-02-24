package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Isaac Rondon on 21-02-2015.
 */
public class DishAdapter extends BaseAdapter {
    private Set<Dish> dishes;
    private Context mContext;
    private String[] dishesName;
    private String[] dishesImages;

    public DishAdapter(Set<Dish>  dishes, Context mContext, String[] dishesName, String[] dishesImages){
        this.dishes = dishes;
        this.mContext = mContext;
        this.dishesName = dishesName;
        this.dishesImages = dishesImages;

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
}
