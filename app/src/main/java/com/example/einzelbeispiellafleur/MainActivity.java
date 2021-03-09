package com.example.einzelbeispiellafleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate = findViewById(R.id.doCalculation);
        calculate.setOnClickListener(
                //Do Fancy Stuff
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       doCalculation();
                    }
                }
        );
    }


    public void doCalculation() {
        EditText mat = findViewById(R.id.matrikelnummer);
        String text = mat.getText().toString();
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (!isPrime(text.charAt(i))) {
                newText += text.charAt(i);
            }
        }
        newText = arrayToString(sortString(toArray(newText)));
        TextView calculatedMatNr = findViewById(R.id.calculatedResult);
        calculatedMatNr.setText(newText);
    }

    public boolean isPrime (int n) {
        return n == '2' || n == '3' || n == '5' || n == '7' ? true : false;
    }

    public char[] toArray(String s) {
        char[] array = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i);
        }

        return array;
    }

    public String arrayToString (char[] c) {
        String string = "";
        for (int i = 0; i < c.length; i++) {
            string += c[i];
        }

        return string;
    }

    public char[] sortString(char[] s) {
        for (int i = 0; i < s.length-1; i++) {
            for (int j = 0; j < s.length - i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    char temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
        return s;
    }
}