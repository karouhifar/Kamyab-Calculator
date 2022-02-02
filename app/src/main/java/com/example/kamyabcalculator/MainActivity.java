//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.kamyabcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private final Calculator calculator = new Calculator();
    String err = "Not an Operator";
    boolean errFlag = false;
    boolean resultFlag = false;

    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        // --- Part 2
        Button advancedBtn = findViewById(R.id.advanced_button);
        LinearLayout advancedLayout = findViewById(R.id.advanced_page);
        TextView title = findViewById(R.id.title);
        advancedBtn.setOnClickListener((view) -> {
            if (advancedBtn.getText().toString().equalsIgnoreCase(this.getString(R.string.advance))) {
                advancedBtn.setText(this.getString(R.string.standard).toUpperCase());
                title.setText(this.getString(R.string.title_a));
                advancedLayout.setVisibility(View.VISIBLE);
            } else {
                advancedBtn.setText(this.getString(R.string.advance).toUpperCase());
                title.setText(getString(R.string.title_s));
                advancedLayout.setVisibility(View.GONE);
            }

        });
        Button module = findViewById(R.id.modulo);
        Button POW = findViewById(R.id.POW);
        Button MAX = findViewById(R.id.MAX);
        Button MIN = findViewById(R.id.MIN);

        module.setOnClickListener(this::calculateEvent);
        POW.setOnClickListener(this::calculateEvent);
        MAX.setOnClickListener(this::calculateEvent);
        MIN.setOnClickListener(this::calculateEvent);
    }

    public void calculateEvent(View view) {
        String data = ((Button)view).getText().toString();
        Log.d("Kamyab ", data);
        if (errFlag) {
            result.setText("");
        } else if (resultFlag) {
            result.setText("");
            resultFlag = false;
        }

        result.setText(String.format("%s %s", result.getText().toString(), data));
        calculator.push(data);
        errFlag = false;
    }

    public void clearEvent(View view) {
        Log.d("Kamyab ", "Event Cleared");
        calculator.clearData();
        result.setText("");
    }

    public void resultEvent(View view) {
        Log.d("Kamyab ", "Event Created result");
        int calculatedData = calculator.calculate();
        if (calculatedData != 0) {
            result.setText(String.format("%s = %s", result.getText().toString(), calculatedData));
            calculator.clearData();
            resultFlag = true;
        } else {
            errFlag = true;
            calculator.clearData();
            result.setText(err);
        }

    }
}
