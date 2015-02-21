package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.InstructionsMenu;
import se.kth.csc.iprog.dinnerplanner.android.MainActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 20-02-2015.
 */
public class ButtonStart_CreateController implements OnClickListener  {

    DinnerModel model;
    ButtonStart_Create view;
    boolean start;

    public ButtonStart_CreateController( DinnerModel model , ButtonStart_Create view, boolean start ){
        this.model = model;
        this.view = view;
        this.start = start;
        view.start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(start && view.start == v){
                Intent intent;
                intent = new Intent(v.getContext(), ChooseMenu.class);
                v.getContext().startActivity(intent);

         }else if(!start && view.start == v){
                Intent intent = new Intent(v.getContext(), InstructionsMenu.class);
                v.getContext().startActivity(intent);
        }
    }
}
