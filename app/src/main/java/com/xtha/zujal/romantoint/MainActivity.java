package com.xtha.zujal.romantoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextromanornumber = findViewById(R.id.editTextRomanorNumber);
        TextView textViewanswer = findViewById(R.id.textViewanswer);
        Button buttonconverter =  findViewById(R.id.ButtonConverter);




        buttonconverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String romanornumber = editTextromanornumber.getText().toString();

                // check if given string is roman or number

                // if number is roman than perform roman to number function
               int answerfromconversion= romantoint(romanornumber);

                textViewanswer.setText("The correct answer is " + Integer.toString(answerfromconversion));
                editTextromanornumber.setText("");
                buttonconverter.setText("Convert Again");

            }
        });
    }

    static int romantoint(String s){
        int result=0;

        HashMap<Character,Integer> map = new HashMap();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        System.out.println("The given question is " + s);


        for(int i = 0; i<s.length(); i++)
        {
            result +=map.get(s.charAt(i));

            if(i>0 && map.get(s.charAt(i))>map.get(s.charAt(i-1)))
            {
                result -= 2*map.get(s.charAt(i-1));
            }
        }

        System.out.println("The result is " + result);
        return result;

    }
}