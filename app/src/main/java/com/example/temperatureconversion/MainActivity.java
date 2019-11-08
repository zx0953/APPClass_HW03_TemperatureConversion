package com.example.temperatureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTC;
    EditText editTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTC = findViewById(R.id.editTC);
        editTF = findViewById(R.id.editTF);
        editTC.setOnFocusChangeListener(mOnFocusChangeListener);
        editTF.setOnFocusChangeListener(mOnFocusChangeListener);

    }


    android.view.View.OnFocusChangeListener mOnFocusChangeListener = new android.view.View.OnFocusChangeListener(){
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Log.d("Rui", ""+ v.getResources().getResourceEntryName(v.getId()));
                String FocusEdit = v.getResources().getResourceEntryName(v.getId());
                if(FocusEdit.equals("editTC")){
                    editTF.setText("");
                }else{
                    editTC.setText("");
                }
            }
        }
    };

    public void BtnTransOnclick(View view) {
        String seditTC = editTC.getText().toString();
        float TemperatureC = 0;
        String seditTF = editTF.getText().toString();
        float TemperatureF = 0;

        if (seditTC.equals("") && seditTF.equals("")) {
            Toast.makeText(this, "請輸入溫度", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!seditTC.equals("") && seditTF.equals("")) {
            try {
                TemperatureC = Float.parseFloat(seditTC);
            } catch (NumberFormatException e) {
                TemperatureC = 0;
                Toast.makeText(this, "請輸入數字即可", Toast.LENGTH_SHORT).show();
                return;
            }
            TemperatureF = (TemperatureC * 9 / 5) + 32;
            editTF.setText("" + TemperatureF + "°F");
            editTC.clearFocus();
            return;
        }
        if (seditTC.equals("") && !seditTF.equals("")) {
            try {
                TemperatureF = Float.parseFloat(seditTF);
            } catch (NumberFormatException e) {
                TemperatureF = 0;
                Toast.makeText(this, "請輸入數字即可", Toast.LENGTH_SHORT).show();
                return;
            }
            TemperatureC = (TemperatureF - 32) * 5 / 9;
            editTC.setText("" + TemperatureC + "°C" );
            editTF.clearFocus();
            return;
        }

    }
}
