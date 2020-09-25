package com.example.lab8testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;
    Button b1;
    RadioButton c,f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.name);
        b1 = findViewById(R.id.convert);
        t1 = findViewById(R.id.result);
        c = findViewById(R.id.celsus);
        f = findViewById(R.id.franhight);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_LONG).show();
                    return;
                }

                float inputvalue = Float.parseFloat(e1.getText().toString());

                if(c.isChecked())
                {
                    t1.setText("Result: "+String.valueOf(convertTOCelsius(inputvalue))+"'c");
                    c.setChecked(true);
                    f.setChecked(false);
                }
                else
                {
                    t1.setText("Result: "+String.valueOf(convertTOFranhight(inputvalue))+"'f");
                    c.setChecked(false);
                    f.setChecked(true);
                }
            }
        });
    }
    public static float convertTOCelsius(float number)
    {
        return ((number - 32) * 5 /9);
    }
    public static float convertTOFranhight(float number)
    {
        return ((number * 9) / 5) +32;
    }
}