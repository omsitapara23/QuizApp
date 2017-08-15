package com.android.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private RadioButton yes;
    private RadioButton no;
    private CheckBox INT;
    private CheckBox DOUBLE;
    private CheckBox FLOAT;
    private CheckBox ADD;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox0;
    private CheckBox checkBoxnegative;
    private EditText editText;
    private Button submitbutton;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        yes = (RadioButton) findViewById(R.id.radiobuttonyes);
        no = (RadioButton) findViewById(R.id.radiobuttonno);
        INT = (CheckBox) findViewById(R.id.checkboxint);
        DOUBLE = (CheckBox) findViewById(R.id.checkboxdouble);
        FLOAT = (CheckBox) findViewById(R.id.checkboxfloat);
        ADD = (CheckBox) findViewById(R.id.checkboxadd);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox0 = (CheckBox) findViewById(R.id.checkbox0);
        checkBoxnegative = (CheckBox) findViewById(R.id.checkbox_1);
        editText = (EditText) findViewById(R.id.edittext);
        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ques1();
                ques2();
                ques3();
                ques4();
                Toast.makeText(QuizActivity.this, "You had " + count + " question right out of 4", Toast.LENGTH_SHORT).show();
                count = 0;
            }
        });

    }

    private boolean checkboxChecker(CheckBox checkBox) {
        boolean isCheckbox = checkBox.isChecked();
        if (isCheckbox == true) {
            return true;
        } else
            return false;
    }

    private boolean radiobuttonChecker(RadioButton radioButton) {
        boolean isRadioButton = radioButton.isChecked();
        if (isRadioButton == true) {
            return true;
        } else
            return false;
    }

    private boolean stringAnswer(String s) {
        String answer1 = "int A=10;";
        String answer2 = "int A =10;";
        String answer3 = "int A= 10;";
        String answer4 = "int A = 10;";
        if (s.equals(answer1) || s.equals(answer2) || s.equals(answer3) || s.equals(answer4)) {
            return true;
        } else
            return false;
    }

    private void ques1() {
        if (radiobuttonChecker(yes) == true && radiobuttonChecker(no) == false) {
            count++;
        }
        return;
    }

    private void ques2() {
        if (checkboxChecker(INT) == true && checkboxChecker(DOUBLE) == true && checkboxChecker(FLOAT) == true && checkboxChecker(ADD) == false) {
            count++;
        }
        return;
    }

    private void ques3() {
        if (checkboxChecker(checkBox0) == true && checkboxChecker(checkBox1) == false && checkboxChecker(checkBox2) == false && checkboxChecker(checkBoxnegative) == false) {
            count++;
        }
        return;
    }

    private void ques4() {
        String givenByUser = editText.getText().toString().trim();
        if (stringAnswer(givenByUser) == true) {
            count++;
        }
        return;
    }
}
