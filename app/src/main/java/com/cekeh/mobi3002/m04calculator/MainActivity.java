package com.cekeh.mobi3002.m04calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input_1;
    private EditText input_2;
    private TextView output;

    private enum Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_1 = findViewById(R.id.input_1);
        input_2 = findViewById(R.id.input_2);
        output = findViewById(R.id.output);

        Log.i("MOBI3002", "MainActivity.onCreate()");
    }

    /**
     * Tell the program to take input_1 and add it to input_2 and print the result to output
     * @param view view of the button calling the function
     */
    public void addInputs(View view) {
        setOutput(String.valueOf(doMath(Operator.ADDITION)));
    }

    /**
     * Tell the program to take input_1 and subtract input_2 and print the result to output
     * @param view view of the button calling the function
     */
    public void subtractInputs(View view){
        setOutput(String.valueOf(doMath(Operator.SUBTRACTION)));
    }

    /**
     * Tell the program to take input_1 and multiply it by input_2 and print the result to output
     * @param view view of the button calling the function
     */
    public void multiplyInputs(View view){
        setOutput(String.valueOf(doMath(Operator.MULTIPLICATION)));
    }

    /**
     * Tell the program to take input_1 and divide it by input_2 and print the result to output
     * @param view view of the button calling the function
     */
    public void divideInputs(View view){
        setOutput(String.valueOf(doMath(Operator.DIVISION)));
    }

    /**
     * Take input_1 and input_2 EditText values, convert them to doubles, perform a math
     * operation based on the operator provided, and return the result
     * @param operator One of the options inside the Operator enum
     * @return result of the math operation
     */
    public double doMath(Operator operator){
        double a = Double.parseDouble(input_1.getText().toString());
        double b = Double.parseDouble(input_2.getText().toString());

        Log.i("MOBI3002", "MainActivity.doMath(" + operator + ")");

        switch(operator){
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                return a / b;
        }

        return 0;
    }

    /**
     * Set the value of the output TextView
     * @param string value to place in the TextView
     */
    public void setOutput(String string){
        output.setText(string);
    }
}