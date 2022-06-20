package ru.mikolaych.geekbrains1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fd = findViewById(R.id.firstDigit);
        EditText sd = findViewById(R.id.secondDigit);
        Button start = findViewById(R.id.start);
        EditText res = findViewById(R.id.result);
        Switch sw = findViewById(R.id.switchModul);





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a;
                String firstDigit = fd.getText().toString();
                String secondDigit = sd.getText().toString();


                try {
                    Integer firstValue = Integer.valueOf(firstDigit);
                    Integer secondValue = Integer.valueOf(secondDigit);
                    a = firstValue * secondValue;


                    String b = String.valueOf(a);

                    res.setText(b);
                } catch (NumberFormatException e) {

                    res.setText("Ошибка!");
                }
            }
        });
    }
}