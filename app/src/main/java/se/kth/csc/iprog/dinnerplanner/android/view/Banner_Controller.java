package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.InstructionsMenu;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 24-02-2015.
 */
public class Banner_Controller implements View.OnClickListener {
    private Banner view;
    private DinnerModel model;
    private Activity act;
    private ChooseMenu chooseMenu;

    public Banner_Controller(Banner view, DinnerModel model, Activity act, ChooseMenu c){
        this.view= view;
        this.model = model;
        this.act = act;
        this.chooseMenu= c;
        view.banner.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bannerText:
                ((DinnerPlannerApplication)(act.getApplication())).setModel(new DinnerModel());
                chooseMenu.displayScreen();
                chooseMenu.displayPrice();
         }
    }

    public DinnerModel getModel() {
        return model;
    }

    public void setModel(DinnerModel model) {
        this.model = model;
    }

    public Banner getView() {
        return view;
    }

    public void setView(Banner view) {
        this.view = view;
    }
}
