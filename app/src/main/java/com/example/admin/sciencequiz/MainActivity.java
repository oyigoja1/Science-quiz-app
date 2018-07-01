package com.example.admin.sciencequiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * It is called when the Start Quiz button is clicked by the user
     */
    public void startQuiz(View view) {
        Intent beginQuiz = new Intent(this, Category.class);
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        beginQuiz.putExtra("userName", name);
        if (TextUtils.isEmpty(nameField.getText())) {
            nameField.setError("Your Name is Required");
        } else {
            startActivity(beginQuiz);
            }

        }
    }



