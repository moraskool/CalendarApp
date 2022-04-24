package com.example.calendarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import nl.bryanderidder.themedtogglebuttongroup.ThemedButton;
import nl.bryanderidder.themedtogglebuttongroup.ThemedToggleButtonGroup;

public class ChooseLayoutActivity extends AppCompatActivity {
    public boolean widgetModeSelected = false;
    public boolean scribbleModeSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_layout);

        Button nextbutton = findViewById(R.id.nextOutlineButton);
        MaterialButtonToggleGroup toggleButton = findViewById(R.id.toggleButtonChooseMode);


        toggleButton.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                if (checkedId == R.id.btnWidget) {
                   widgetModeSelected = true;
                   scribbleModeSelected = false;
                }
                if (checkedId == R.id.btnScribble) {
                    scribbleModeSelected = true;
                    widgetModeSelected = false;
                }
            }
        });

        // next button after choosing which calendar theme
        nextbutton.setOnClickListener(view -> startCalendarWithThemeChosen(scribbleModeSelected, widgetModeSelected));
    }

    // start the next activity based on the mode selected
    private void startCalendarWithThemeChosen(boolean scrMdeSelected, boolean wgtMdeSelected) {
        Intent WidgetIntent = new Intent(this, mastermonthDetailActivity.class);
        Intent ScribbleIntent = new Intent(this, mastermonthDetailActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        if(scrMdeSelected)
            startActivity(ScribbleIntent);
        else if (widgetModeSelected)
            startActivity(WidgetIntent);
    }
}