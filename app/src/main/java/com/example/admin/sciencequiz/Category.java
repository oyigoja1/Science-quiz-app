package com.example.admin.sciencequiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Category extends AppCompatActivity {

    int doubleBackToExitPressed = 1;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressed == 2) {
            finishAffinity();
            System.exit(0);
        } else {
            doubleBackToExitPressed++;
            Toast.makeText(this, "Please press Back again to exit", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressed = 1;
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_file);


        TextView displayUserName = findViewById(R.id.category_text_view);
        displayUserName.setText(displayName());
    }

    private String displayName() {
        Intent startIntent = getIntent();
        String nameField = startIntent.getStringExtra("userName");
        return getString(R.string.choose, nameField);
    }

    public void compSci(View view) {
        Intent csc = new Intent(this, ComputerScience.class);
        startActivity(csc);
    }

    public void biology(View view) {
        Intent bio = new Intent(this, Biology.class);
        startActivity(bio);
    }

    public void chemistry(View view) {
        Intent chem = new Intent(this, Chemistry.class);
        startActivity(chem);
    }

    public void maths(View view) {
        Intent mathematics = new Intent(this, Maths.class);
        startActivity(mathematics);
    }


    public void sendMail(View view) {
        Toast.makeText(this, "Send Feedback", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:dorisogar76@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}



