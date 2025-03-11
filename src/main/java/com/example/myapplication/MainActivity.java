package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        // Set button click listeners
        buttonPlus.setOnClickListener(view -> performOperation('+'));
        buttonMinus.setOnClickListener(view -> performOperation('-'));
        buttonMultiply.setOnClickListener(view -> performOperation('*'));
        buttonDivide.setOnClickListener(view -> performOperation('/'));
    }

    private void performOperation(char operator) {
        String firstInput = inputFirstNumber.getText().toString();
        String secondInput = inputSecondNumber.getText().toString();

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            textResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(firstInput);
        double num2 = Double.parseDouble(secondInput);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    textResult.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;
        }
        textResult.setText("Result: " + result);
    }
}
