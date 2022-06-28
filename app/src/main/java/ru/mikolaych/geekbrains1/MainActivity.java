package ru.mikolaych.geekbrains1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Boolean newSession = true;
    private Boolean operation = true;
    private Boolean dot = true;
    private Boolean preDot = true;
    private Boolean plusMinus = true;
    private String operator;
    private String firstNumber;
    private String secondNumber;
    private Double resultNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        result = findViewById(R.id.calc_result);

    }


    @SuppressLint("NonConstantResourceId")
    public void clickNumber(View view) {
        if (newSession) {
            result.setText("");
            newSession = false;
        }
        String number = result.getText().toString();
        if (view.getId() == R.id.dot && dot && !preDot) {
            number = number + ".";
            dot = false;
        } else if (view.getId() == R.id.dot && dot && preDot) {
            number = number + "0.";
            dot = false;
        }

        if (view.getId() == R.id.plus_minus && plusMinus) {
            number = "-" + number;
            plusMinus = false;
        }
        switch (view.getId()) {
            case R.id.num_1:
                number = number + "1";
                break;
            case R.id.num_2:
                number = number + "2";
                break;
            case R.id.num_3:
                number = number + "3";
                break;
            case R.id.num_4:
                number = number + "4";
                break;
            case R.id.num_5:
                number = number + "5";
                break;
            case R.id.num_6:
                number = number + "6";
                break;
            case R.id.num_7:
                number = number + "7";
                break;
            case R.id.num_8:
                number = number + "8";
                break;
            case R.id.num_9:
                number = number + "9";
                break;
            case R.id.num_0:
                number = number + "0";
                break;
        }
        preDot = false;
        result.setText(number);
    }

    @SuppressLint("NonConstantResourceId")
    public void operate(View view) {
        String sign = result.getText().toString();
        firstNumber = result.getText().toString();

        if (!newSession && operation) {
            switch (view.getId()) {
                case R.id.divide:
                    sign = "/";
                    operator = "/";
                    break;
                case R.id.multiply:
                    sign = "*";
                    operator = "*";
                    break;
                case R.id.plus:
                    sign = "+";
                    operator = "+";
                    break;
                case R.id.minus:
                    sign = "-";
                    operator = "-";
                    break;
            }
            operation = false;
            dot = true;
            plusMinus = true;
            preDot = true;
        }
        result.setText(sign);
        newSession = true;

    }

    public void equals(View view) {
        secondNumber = result.getText().toString();
        switch (operator) {
            case "+":
                resultNumber = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
            case "-":
                resultNumber = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case "*":
                resultNumber = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case "/":
                resultNumber = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;


        }
        newSession = true;
        operation = true;
        dot=false;
        result.setText(resultNumber + "");

    }

    public void percent(View view) {
        secondNumber = result.getText().toString();
        if (view.getId() == R.id.percent) {
            resultNumber = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber) / 100;
        }
        result.setText(resultNumber + "");
    }

    public void ce(View view) {
        if (view.getId() == R.id.ce) {
            result.setText("0");
            newSession = true;
            operation = true;
            dot = true;
            plusMinus = true;
            preDot = true;
            resultNumber = 0.0;

        }
    }
}