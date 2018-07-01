package com.example.admin.sciencequiz;

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

public class ComputerScience extends AppCompatActivity {

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
    String html = "Hyper Text Markup Language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_science);

    }

    public void home(View view) {
        finish();
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
     * @param addThreeA,   and addThreeB and addThreeC are selected, one is added to the score.
     * @param addFourB     is selected, and one is added to the score
     * @param addFiveB     is selected and one is added to the score
     * @param addSixB      is selected and one is added to the score
     * @param addSevenB    is selected and one is added to the score
     * @param addEightB    is selected and one is added to the score
     * @param questionNine is answered, one is added to the score
     * @param addTenD      is selected and one is added to the score
     * @return accepts the total score if all correct radio button was clicked.
     */
    private int calculateScore(boolean addOneB, boolean addTwoA, boolean addTwoB,
                               boolean addThreeA, boolean addThreeB, boolean addThreeC, boolean addFourB, boolean addFiveB,
                               boolean addSixB, boolean addSevenB, boolean addEightB, String questionNine, boolean addTenD) {
        int baseScore = 0;
        if (addOneB) {
            baseScore += 1;
        }
        if (addTwoA && addTwoB) {
            baseScore += 1;
        }
        if (addThreeA && addThreeB && addThreeC) {
            baseScore += 1;
        }
        if (addFourB) {
            baseScore += 1;
        }
        if (addFiveB) {
            baseScore += 1;
        }
        if (addSixB) {
            baseScore += 1;
        }
        if (addSevenB) {
            baseScore += 1;
        }
        if (addEightB) {
            baseScore += 1;
        }
        if (questionNine.trim().equalsIgnoreCase(html)) {
            baseScore += 1;
        }
        if (addTenD) {
            baseScore += 1;
        }
        score = baseScore;
        return score;
    }


    private void checkQuestions() {
        // obtaining the ID of radio group Question 1 to ascertain if a radio button has been ticked
        RadioGroup groupOne = findViewById(R.id.cscGroupOne);
        int cscGroupOneId = groupOne.getCheckedRadioButtonId();

        RadioGroup groupFour = findViewById(R.id.cscGroupFour);
        int cscGroupFourId = groupFour.getCheckedRadioButtonId();

        RadioGroup groupFive = findViewById(R.id.cscGroupFive);
        int cscGroupFiveId = groupFive.getCheckedRadioButtonId();

        RadioGroup groupSix = findViewById(R.id.cscGroupSix);
        int cscGroupSixId = groupSix.getCheckedRadioButtonId();

        RadioGroup groupSeven = findViewById(R.id.cscGroupSeven);
        int cscGroupSevenId = groupSeven.getCheckedRadioButtonId();

        RadioGroup groupEight = findViewById(R.id.cscGroupEight);
        int cscGroupEightId = groupEight.getCheckedRadioButtonId();

        RadioGroup groupTen = findViewById(R.id.cscGroupTen);
        int cscGroupTenId = groupTen.getCheckedRadioButtonId();

        // Getting the values of any question that has been selected in question 2
        CheckBox questionTwoCheckBox = findViewById(R.id.question_two_a);
        boolean hasTwoA = questionTwoCheckBox.isChecked();
        CheckBox questionTwoBCheckBox = findViewById(R.id.question_two_b);
        boolean hasTwoB = questionTwoBCheckBox.isChecked();
        CheckBox questionTwoCCheckBox = findViewById(R.id.question_two_c);
        boolean hasTwoC = questionTwoCCheckBox.isChecked();
        CheckBox questionTwoDCheckBox = findViewById(R.id.question_two_d);
        boolean hasTwoD = questionTwoDCheckBox.isChecked();

        // Getting the values of any question that has been selected in question 3
        CheckBox questionThreeACheckBox = findViewById(R.id.question_three_a);
        boolean hasThreeA = questionThreeACheckBox.isChecked();
        CheckBox questionThreeBCheckBox = findViewById(R.id.question_three_b);
        boolean hasThreeB = questionThreeBCheckBox.isChecked();
        CheckBox questionThreeCCheckBox = findViewById(R.id.question_three_c);
        boolean hasThreeC = questionThreeCCheckBox.isChecked();
        CheckBox questionThreeDCheckBox = findViewById(R.id.question_three_d);
        boolean hasThreeD = questionThreeDCheckBox.isChecked();

        // Getting value of question 9
        EditText cscAnswerField = findViewById(R.id.csc_answer_field);
        String questionNine = cscAnswerField.getText().toString();
        html = "Hyper Text Markup Language";
        if (questionNine.trim().equalsIgnoreCase(html)) {
            score += 1;
        }

        //Calculating Radio Buttons
        RadioButton questionOneRadioButton = findViewById(R.id.question_one_b);
        boolean hasOneB = questionOneRadioButton.isChecked();

        RadioButton questionFourBRadioButton = findViewById(R.id.question_four_b);
        boolean hasFourB = questionFourBRadioButton.isChecked();

        RadioButton questionFiveBRadioButton = findViewById(R.id.question_five_b);
        boolean hasFiveB = questionFiveBRadioButton.isChecked();


        RadioButton questionSixBRadioButton = findViewById(R.id.question_six_b);
        boolean hasSixB = questionSixBRadioButton.isChecked();

        RadioButton questionSevenBRadioButton = findViewById(R.id.question_seven_b);
        boolean hasSevenB = questionSevenBRadioButton.isChecked();

        RadioButton questionEightBRadioButton = findViewById(R.id.question_eight_b);
        boolean hasEightB = questionEightBRadioButton.isChecked();

        RadioButton questionTenDRadioButton = findViewById(R.id.question_ten_d);
        boolean hasTenD = questionTenDRadioButton.isChecked();


        // To check if at least one has been selected
        // for question 2
        boolean questionTwo = hasTwoA || hasTwoB || hasTwoC ||
                hasTwoD;

        // To check if at least one has been selected
        // for question 3
        boolean questionThree = hasThreeA || hasThreeB || hasThreeC ||
                hasThreeD;


        // checking if no radio button has been selected
        if (cscGroupOneId == -1) {
            Toast.makeText(this, "Please answer Question 1", Toast.LENGTH_SHORT).show();
        }
        // checking if no checkbox has been selected
        else if (!questionTwo) {
            Toast.makeText(this, "Please answer Question 2",
                    Toast.LENGTH_SHORT).show();
        }
        // checking if no checkbox has been selected
        else if (!questionThree) {
            Toast.makeText(this, "Please answer Question 3",
                    Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupFourId == -1) {
            Toast.makeText(this, "Please answer Question 4", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupFiveId == -1) {
            Toast.makeText(this, "Please answer Question 5", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupSixId == -1) {
            Toast.makeText(this, "Please answer Question 6", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupSevenId == -1) {
            Toast.makeText(this, "Please answer Question 7", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupEightId == -1) {
            Toast.makeText(this, "Please answer Question 8", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (cscGroupTenId == -1) {
            Toast.makeText(this, "Please answer Question 10", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(cscAnswerField.getText())) {
            cscAnswerField.setError("Please answer Question 9");
        } // resetting before questions can be answered
        else if (verifySubmission > 0) {
            Toast.makeText(this, "Play again", Toast.LENGTH_SHORT).show();
        } else {
            //To prevent the score from being recalculated
            verifySubmission += 1;

            int score = calculateScore(hasOneB, hasTwoA, hasTwoB, hasThreeA, hasThreeB, hasThreeC, hasFourB, hasFiveB, hasSixB, hasSevenB, hasEightB, questionNine, hasTenD);
            String showScore = showScores(score, html);

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


    private String showScores(int score, String html) {
        String showScore = "Score: " + score + " out of 10";
        showScore = showScore + "\n\nAnswers";
        showScore = showScore + "\nQuestion 1. " + " \t " + getString(R.string.csc_b_one);
        showScore = showScore + "\nQuestion 2. " + " \t " + getString(R.string.csc_a_two) + " and " + getString(R.string.csc_b_two);
        showScore = showScore + "\nQuestion 3. " + " \t " + getString(R.string.csc_a_three) + " and " + getString(R.string.csc_b_three) + " and " + "\n" + getString(R.string.csc_c_three);
        showScore = showScore + "\nQuestion 4. " + " \t " + getString(R.string.csc_b_four);
        showScore = showScore + "\nQuestion 5. " + " \t " + getString(R.string.csc_b_five);
        showScore = showScore + "\nQuestion 6. " + " \t " + getString(R.string.csc_b_six);
        showScore = showScore + "\nQuestion 7. " + " \t " + getString(R.string.csc_b_seven);
        showScore = showScore + "\nQuestion 8. " + " \t " + getString(R.string.csc_b_eight);
        showScore = showScore + "\nQuestion 9. " + " \t " + html;
        showScore = showScore + "\nQuestion 10. " + "\t " + getString(R.string.csc_d_ten);

        return showScore;
    }

    private void displayScore(String message) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }


}









