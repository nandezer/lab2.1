package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.MainActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 20-02-2015.
 */
public class ButtonStart_CreateController implements OnClickListener  {

    DinnerModel model;
    ButtonStart_Create view;

    public ButtonStart_CreateController( DinnerModel model , ButtonStart_Create view){
        this.model = model;
        this.view = view;
        view.start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*switch (view.getId()) {
            case R.id.button_start:*/

        if(v == view.start){
                Intent intent;
                intent = new Intent(v.getContext(), ChooseMenu.class);
            //break;
            if(null!=intent)
                v.getContext().startActivity(intent);
        }
    }
}
