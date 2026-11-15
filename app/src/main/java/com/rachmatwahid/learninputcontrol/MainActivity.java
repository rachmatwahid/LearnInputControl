package com.rachmatwahid.learninputcontrol;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText phoneEditText;
    String phone;
    RadioGroup roomTypeRadio;
    RadioButton standardRadio;
    String roomType;
    CheckBox breakfastCheck;
    CheckBox wifiCheck;
    CheckBox housekeepingCheck;
    ArrayList<String> addition = new ArrayList<>();
    Button bookButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        phoneEditText = findViewById(R.id.phone_edittext);

        standardRadio = findViewById(R.id.standard_radio);
        standardRadio.setChecked(true);
        roomType = "Standard";

        roomTypeRadio = findViewById(R.id.roomtype_radiogroup);
        roomTypeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                if (i == R.id.standard_radio) {
                    roomType = "Standard";
                } else if (i == R.id.deluxe_radio) {
                    roomType = "Deluxe";
                } else if (i == R.id.president_radio) {
                    roomType = "Presidential";
                }
            }
        });


        breakfastCheck = findViewById(R.id.breakfast_checkbox);
        breakfastCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    addition.add("Breakfast");
                } else {
                    addition.remove("Breakfast");
                }
            }
        });

        wifiCheck = findViewById(R.id.wifi_checkbox);
        wifiCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    addition.add("Wi-Fi");
                } else {
                    addition.remove("Wi-Fi");
                }
            }
        });

        housekeepingCheck = findViewById(R.id.house_checkbox);
        housekeepingCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    addition.add("Housekeeping");
                } else {
                    addition.remove("Housekeeping");
                }
            }
        });

        bookButton = findViewById(R.id.book_button);
        bookButton.setOnClickListener(view -> {

            phone = phoneEditText.getText().toString();

            String addMessage = String.join(" ", addition);

            Toast.makeText(this, phone + " " + roomType + " " + addMessage, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}