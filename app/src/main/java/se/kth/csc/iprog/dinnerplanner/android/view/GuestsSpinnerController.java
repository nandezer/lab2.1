package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Isaac Rondon on 25-02-2015.
 */
public class GuestsSpinnerController {
    private GuestsSpinner view;
    private DinnerModel model;
    private Context mContext;
    private Spinner spinnerDropDown;
    private String[] numGuestsPossible = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "9",
            "10"};
    private ChooseMenu chooseMenu;
    public GuestsSpinnerController(DinnerModel model, GuestsSpinner view, Context c, ChooseMenu menu){
        this.model = model;
        this.view= view;
        this.mContext = c;
        this.chooseMenu=menu;
        this.spinnerDropDown= view.spinnerDropDown;

        spinnerDropDown.setSelection(this.model.getNumberOfGuests());
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.mContext,android.R.layout.simple_spinner_dropdown_item , numGuestsPossible);
        spinnerDropDown.setAdapter(adapter);

        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid= spinnerDropDown.getSelectedItemPosition();
                spinnerDropDown.setSelection(sid);
                setNumberGuests(sid + 1);
                chooseMenu.displayPrice();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    private void setNumberGuests(int i) {
        this.model.setNumberOfGuests(i);
    }

    public GuestsSpinner getView() {
        return view;
    }

    public void setView(GuestsSpinner view) {
        this.view = view;
    }

    public DinnerModel getModel() {
        return model;
    }

    public void setModel(DinnerModel model) {
        this.model = model;
    }
}
