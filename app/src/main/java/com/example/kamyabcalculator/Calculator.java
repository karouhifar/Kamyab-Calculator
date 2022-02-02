//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.kamyabcalculator;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<String> inputData;
    private int number;
    private int number2;
    private int index;
    private String operator;

    public Calculator() {
        inputData = new ArrayList<>();
        number = 0;
        number2 = 0;
        index = 0;
        operator = "";
    }

    void push(String value) {
        inputData.add(value);
    }

    public boolean validNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    int calculate() {
        boolean flag = true;
        number = 0;
        number2 = 0;
        operator = "";
        // --- Start Validation Input
        if (inputData.size() > 2) {
            for(String eachArray : inputData) {
                if (index % 2 == 0) {
                    if (!validNumber(eachArray)) {
                        return number = 0;
                    }
                } else if (validNumber(eachArray)) {
                    return number = 0;
                }

                if (validNumber(eachArray)) {
                    if (flag) number = Integer.parseInt(eachArray);
                     else number2 = Integer.parseInt(eachArray);
                    switch(operator) {
                        case "+":
                            number += number2;
                            break;
                        case "-":
                            number -= number2;
                            break;
                        case "*":
                            number *= number2;
                            break;
                        case "/":
                            number /= number2;
                            break;
                        case "%":
                            number %= number2;
                            break;
                        case "MAX":
                            number = Math.max(number, number2);
                            break;
                        case "MIN":
                            number = Math.min(number, number2);
                            break;
                        case "POW":
                            number = (int)Math.pow(number, number2);
                    }
                } else {
                    operator = eachArray;
                    flag = false;
                }
                // End Calculation logic
                index++;
            }
        }

        return number;
    }

    public void clearData() {
        inputData.clear();
        index = 0;
    }
}
