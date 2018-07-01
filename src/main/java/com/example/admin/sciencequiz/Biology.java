package com.example.admin.sciencequiz;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Biology extends AppCompatActivity {

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


    int score = 0;
    int verifySubmission = 0;
    String leg = "Leg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biology);

    }

    public void home(View view) {
        Intent homePage = new Intent(this, Category.class);
        startActivity(homePage);
    }

    public void submitAnswers(View view) {

        checkQuestions();

    }

    public void resetQuiz(View view) {
        startActivity(getIntent());
    }

    /**
     * This calculates all the correct answers that are selected.
     *
     * @param addOneB      is selected, one is added to the score.
     * @param addTwoA      and addTwoB are selected, one is added to the score.
     * @param addThreeA,   addThreeB and addThreeD are selected, one is added to the score.
     * @param addFourA     is selected, and one is added to the score
     * @param addFiveB     is selected and one is added to the score
     * @param addSixB      is selected and one is added to the score
     * @param addSevenC    is selected and one is added to the score
     * @param addEightD    is selected and one is added to the score
     * @param questionNine is answered, one is added to the score
     * @param addTenA      is selected and one is added to the score
     * @return accepts the total score if all correct radio button was clicked.
     */

    private int calculateScore(boolean addOneB, boolean addTwoA, boolean addTwoB, boolean addThreeA, boolean addThreeB, boolean addThreeD, boolean addFourA, boolean addFiveB, boolean addSixB, boolean addSevenC, boolean addEightD, String questionNine, boolean addTenA) {
        int baseScore = 0;
        if (addOneB) {
            baseScore += 1;
        }
        if (addTwoA && addTwoB) {
            baseScore += 1;
        }
        if (addThreeA && addThreeB && addThreeD) {
            baseScore += 1;
        }
        if (addFourA) {
            baseScore += 1;
        }
        if (addFiveB) {
            baseScore += 1;
        }
        if (addSixB) {
            baseScore += 1;
        }
        if (addSevenC) {
            baseScore += 1;
        }
        if (addEightD) {
            baseScore += 1;
        }
        if (questionNine.trim().equalsIgnoreCase(leg)) {
            baseScore += 1;
        }
        if (addTenA) {
            baseScore += 1;
        }
        score = baseScore;
        return score;
    }

    private void checkQuestions() {
        // obtaining the ID of radio group Question 1 to ascertain if a radio button has been ticked
        RadioGroup groupOne = findViewById(R.id.groupOne);
        int groupOneId = groupOne.getCheckedRadioButtonId();

        RadioGroup groupFour = findViewById(R.id.groupFour);
        int groupFourId = groupFour.getCheckedRadioButtonId();

        RadioGroup groupFive = findViewById(R.id.groupFive);
        int groupFiveId = groupFive.getCheckedRadioButtonId();

        RadioGroup groupSix = findViewById(R.id.groupSix);
        int groupSixId = groupSix.getCheckedRadioButtonId();

        RadioGroup groupSeven = findViewById(R.id.groupSeven);
        int groupSevenId = groupSeven.getCheckedRadioButtonId();

        RadioGroup groupEight = findViewById(R.id.groupEight);
        int groupEightId = groupEight.getCheckedRadioButtonId();

        RadioGroup groupTen = findViewById(R.id.groupTen);
        int groupTenId = groupTen.getCheckedRadioButtonId();


        // Getting the values of any question that has been selected in question 2
        CheckBox questionTwoCheckBox = findViewById(R.id.question_two_a);
        boolean hasTwoA = questionTwoCheckBox.isChecked();
        CheckBox questionTwoBCheckBox = findViewById(R.id.question_two_b);
        boolean hasTwoB = questionTwoBCheckBox.isChecked();
        CheckBox questionTwoCCheckBox = findViewById(R.id.question_two_c1);
        boolean hasTwoC = questionTwoCCheckBox.isChecked();
        CheckBox questionTwoDCheckBox = findViewById(R.id.question_two_d1);
        boolean hasTwoD = questionTwoDCheckBox.isChecked();

        // Getting the values of any question that has been selected in question 3
        CheckBox questionThreeACheckBox = findViewById(R.id.question_three_a);
        boolean hasThreeA = questionThreeACheckBox.isChecked();
        CheckBox questionThreeBCheckBox = findViewById(R.id.question_three_b);
        boolean hasThreeB = questionThreeBCheckBox.isChecked();
        CheckBox questionThreeCCheckBox = findViewById(R.id.question_three_c1);
        boolean hasThreeC = questionThreeCCheckBox.isChecked();
        CheckBox questionThreeDCheckBox = findViewById(R.id.question_three_d);
        boolean hasThreeD = questionThreeDCheckBox.isChecked();

        // Getting value of question 9
        EditText biologyAnswerField = findViewById(R.id.biology_answer_field);
        String questionNine = biologyAnswerField.getText().toString();
        leg = "Leg";
        if (questionNine.trim().equalsIgnoreCase(leg)) {
            score += 1;
        }


        //Calculating Radio Buttons
        RadioButton questionOneRadioButton = findViewById(R.id.question_one_b);
        boolean hasOneB = questionOneRadioButton.isChecked();

        RadioButton questionFourARadioButton = findViewById(R.id.question_four_a);
        boolean hasFourA = questionFourARadioButton.isChecked();

        RadioButton questionFiveBRadioButton = findViewById(R.id.question_five_b);
        boolean hasFiveB = questionFiveBRadioButton.isChecked();


        RadioButton questionSixBRadioButton = findViewById(R.id.question_six_b);
        boolean hasSixB = questionSixBRadioButton.isChecked();

        RadioButton questionSevenCRadioButton = findViewById(R.id.question_seven_c);
        boolean hasSevenC = questionSevenCRadioButton.isChecked();

        RadioButton questionEightDRadioButton = findViewById(R.id.question_eight_d);
        boolean hasEightD = questionEightDRadioButton.isChecked();

        RadioButton questionTenARadioButton = findViewById(R.id.question_ten_a);
        boolean hasTenA = questionTenARadioButton.isChecked();


        // To check if at least one has been selected
        // for question 2
        boolean questionTwo = hasTwoA || hasTwoB || hasTwoC ||
                hasTwoD;

        // To check if at least one has been selected
        // for question 3
        boolean questionThree = hasThreeA || hasThreeB || hasThreeC ||
                hasThreeD;


        // checking if no radio button has been selected
        if (groupOneId == -1) {
            Toast.makeText(this, "Please answer Question 1", Toast.LENGTH_SHORT).show();
        }
        // checking if no checkbox has been selected
        if (!questionTwo) {
            Toast.makeText(this, "Please answer Question 2",
                    Toast.LENGTH_SHORT).show();
        }
        // checking if no checkbox has been selected
        else if (!questionThree) {
            Toast.makeText(this, "Please answer Question 3",
                    Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupFourId == -1) {
            Toast.makeText(this, "Please answer Question 4", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupFiveId == -1) {
            Toast.makeText(this, "Please answer Question 5", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupSixId == -1) {
            Toast.makeText(this, "Please answer Question 6", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupSevenId == -1) {
            Toast.makeText(this, "Please answer Question 7", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupEightId == -1) {
            Toast.makeText(this, "Please answer Question 8", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (groupTenId == -1) {
            Toast.makeText(this, "Please answer Question 10", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(biologyAnswerField.getText())) {
            biologyAnswerField.setError("Please answer Question 9");
        } // resetting before questions can be answered
        else if (verifySubmission > 0) {
            Toast.makeText(this, "Play again", Toast.LENGTH_SHORT).show();
        } else {
            //To prevent the score from being recalculated
            verifySubmission += 1;


            int score = calculateScore(hasOneB, hasTwoA, hasTwoB, hasThreeA, hasThreeB, hasThreeD, hasFourA, hasFiveB, hasSixB, hasSevenC, hasEightD, questionNine, hasTenA);
            String showScore = showScores(score, leg);

            displayScore(showScore);


            if (score >= 7) {
                Toast toast = Toast.makeText(this, "Good job!\nYou scored: " + score, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else {
                Toast toast = Toast.makeText(this, "You scored: " + score + "\nTry harder", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }


    }

    private String showScores(int score, String leg) {
        String showScore = "Score: " + score + " out of 10";
        showScore = showScore + "\n\nAnswers";
        showScore = showScore + "\nQuestion 1. " + " \t " + getString(R.string.bio_b_one);
        showScore = showScore + "\nQuestion 2. " + " \t " + getString(R.string.bio_a_two) + " and " + getString(R.string.bio_b_two);
        showScore = showScore + "\nQuestion 3. " + " \t " + getString(R.string.bio_a_three) + " and " + "\n" + getString(R.string.bio_b_three) + " and " + getString(R.string.bio_d_three);
        showScore = showScore + "\nQuestion 4. " + " \t " + getString(R.string.bio_a_four);
        showScore = showScore + "\nQuestion 5. " + " \t " + getString(R.string.bio_b_five);
        showScore = showScore + "\nQuestion 6. " + " \t " + getString(R.string.bio_b_six);
        showScore = showScore + "\nQuestion 7. " + " \t " + getString(R.string.bio_c_seven);
        showScore = showScore + "\nQuestion 8. " + " \t " + getString(R.string.bio_d_eight);
        showScore = showScore + "\nQuestion 9. " + " \t " + leg;
        showScore = showScore + "\nQuestion 10. " + "\t " + getString(R.string.bio_a_ten);

        return showScore;
    }

    private void displayScore(String message) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }




}


