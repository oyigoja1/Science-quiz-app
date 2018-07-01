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

public class Maths extends AppCompatActivity {

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
    String transitive = "Transitive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths);
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
     //     * This calculates all the correct answers that are selected.
     //     *
     //     * @param addOneC      is selected, one is added to the score.
     //     * @param addTwoA      and addTwoB are selected, one is added to the score.
     //     * @param addThreeA,   and addThreeC and addThreeD are selected, one is added to the score.
     //     * @param addFourB     is selected, and one is added to the score
     //     * @param addFiveD     is selected and one is added to the score
     //     * @param addSixB      is selected and one is added to the score
     //     * @param addSevenA    is selected and one is added to the score
     //     * @param addEightC    is selected and one is added to the score
     //     * @param questionNine is answered, one is added to the score
     //     * @param addTenA     is selected and one is added to the score
     //     * @return accepts the total score if all correct radio button was clicked.
     //     */

    private int calculateScore(boolean addOneC, boolean addTwoA, boolean addTwoB, boolean addThreeA, boolean addThreeC, boolean addThreeD, boolean addFourB, boolean addFiveD, boolean addSixB, boolean addSevenA, boolean addEightC, String questionNine, boolean addTenA) {
        int baseScore = 0;
        if (addOneC) {
            baseScore += 1;
        }
        if (addTwoA && addTwoB) {
            baseScore += 1;
        }
        if (addThreeA && addThreeC && addThreeD) {
            baseScore += 1;
        }
        if (addFourB) {
            baseScore += 1;
        }
        if (addFiveD) {
            baseScore += 1;
        }
        if (addSixB) {
           baseScore += 1;
        }
        if (addSevenA) {
            baseScore += 1;
        }
        if (addEightC) {
            baseScore += 1;
        }
        if (questionNine.trim().equalsIgnoreCase(transitive)) {
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
        RadioGroup groupOne = findViewById(R.id.mathsGroupOne);
        int mathsGroupOneId = groupOne.getCheckedRadioButtonId();

        RadioGroup groupFour = findViewById(R.id.mathsGroupFour);
        int mathsGroupFourId = groupFour.getCheckedRadioButtonId();

        RadioGroup groupFive = findViewById(R.id.mathsGroupFive);
        int mathsGroupFiveId = groupFive.getCheckedRadioButtonId();

        RadioGroup groupSix = findViewById(R.id.mathsGroupSix);
        int mathsGroupSixId = groupSix.getCheckedRadioButtonId();

        RadioGroup groupSeven = findViewById(R.id.mathsGroupSeven);
        int mathsGroupSevenId = groupSeven.getCheckedRadioButtonId();

        RadioGroup groupEight = findViewById(R.id.mathsGroupEight);
        int mathsGroupEightId = groupEight.getCheckedRadioButtonId();

        RadioGroup groupTen = findViewById(R.id.mathsGroupTen);
        int mathsGroupTenId = groupTen.getCheckedRadioButtonId();


        // Getting the values of any question that has been selected in question 2
        CheckBox questionTwoCheckBox = findViewById(R.id.question_two_a);
        boolean hasTwoA = questionTwoCheckBox.isChecked();
        CheckBox questionTwoBCheckBox = findViewById(R.id.question_two_b);
        boolean hasTwoB = questionTwoBCheckBox.isChecked();
        CheckBox questionTwoCCheckBox = findViewById(R.id.question_two_c3);
        boolean hasTwoC = questionTwoCCheckBox.isChecked();
        CheckBox questionTwoDCheckBox = findViewById(R.id.question_two_d3);
        boolean hasTwoD = questionTwoDCheckBox.isChecked();

        // Getting the values of any question that has been selected in question 3
        CheckBox questionThreeACheckBox = findViewById(R.id.question_three_a);
        boolean hasThreeA = questionThreeACheckBox.isChecked();
        CheckBox questionThreeBCheckBox = findViewById(R.id.question_three_b3);
        boolean hasThreeB = questionThreeBCheckBox.isChecked();
        CheckBox questionThreeCCheckBox = findViewById(R.id.question_three_c);
        boolean hasThreeC = questionThreeCCheckBox.isChecked();
        CheckBox questionThreeDCheckBox = findViewById(R.id.question_three_d);
        boolean hasThreeD = questionThreeDCheckBox.isChecked();

        // Getting value of question 9
        EditText mathsAnswerField = findViewById(R.id.maths_answer_field);
        String questionNine = mathsAnswerField.getText().toString();
        transitive = "Transitive";
        if (questionNine.trim().equalsIgnoreCase(transitive)) {
            score += 1;
        }


        //Calculating Radio Buttons
        RadioButton questionOneRadioButton = findViewById(R.id.question_one_c);
        boolean hasOneC = questionOneRadioButton.isChecked();

        RadioButton questionFourBRadioButton = findViewById(R.id.question_four_b);
        boolean hasFourB = questionFourBRadioButton.isChecked();

        RadioButton questionFiveDRadioButton = findViewById(R.id.question_five_d);
        boolean hasFiveD = questionFiveDRadioButton.isChecked();


        RadioButton questionSixBRadioButton = findViewById(R.id.question_six_b);
        boolean hasSixB = questionSixBRadioButton.isChecked();

        RadioButton questionSevenARadioButton = findViewById(R.id.question_seven_a);
        boolean hasSevenA = questionSevenARadioButton.isChecked();

        RadioButton questionEightCRadioButton = findViewById(R.id.question_eight_c);
        boolean hasEightC = questionEightCRadioButton.isChecked();

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
        if (mathsGroupOneId == -1) {
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
        else if (mathsGroupFourId == -1) {
            Toast.makeText(this, "Please answer Question 4", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (mathsGroupFiveId == -1) {
            Toast.makeText(this, "Please answer Question 5", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (mathsGroupSixId == -1) {
            Toast.makeText(this, "Please answer Question 6", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (mathsGroupSevenId == -1) {
            Toast.makeText(this, "Please answer Question 7", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (mathsGroupEightId == -1) {
            Toast.makeText(this, "Please answer Question 8", Toast.LENGTH_SHORT).show();
        }
        // checking if no radio button has been selected
        else if (mathsGroupTenId == -1) {
            Toast.makeText(this, "Please answer Question 10", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mathsAnswerField.getText())) {
            mathsAnswerField.setError("Please answer Question 9");
        } // resetting before questions can be answered
        else if (verifySubmission > 0) {
            Toast.makeText(this, "Play again", Toast.LENGTH_SHORT).show();
        } else {
            //To prevent the score from being recalculated
            verifySubmission += 1;

            int score = calculateScore(hasOneC, hasTwoA, hasTwoB, hasThreeA, hasThreeC, hasThreeD, hasFourB, hasFiveD, hasSixB, hasSevenA, hasEightC, questionNine, hasTenA);
            String showScore = showScores(score, transitive);

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

    private String showScores(int score, String transitive) {
        String showScore = "Score: " + score + " out of 10";
        showScore = showScore + "\n\nAnswers";
        showScore = showScore + "\nQuestion 1. " + " \t " + getString(R.string.maths_c_one);
        showScore = showScore + "\nQuestion 2. " + " \t " + getString(R.string.maths_a_two) + " and " + getString(R.string.maths_b_two);
        showScore = showScore + "\nQuestion 3. " + " \t " + getString(R.string.maths_a_three) + " and " + getString(R.string.maths_c_three) + " and " + "\n" + getString(R.string.maths_d_three);
        showScore = showScore + "\nQuestion 4. " + " \t " + getString(R.string.csc_b_four);
        showScore = showScore + "\nQuestion 5. " + " \t " + getString(R.string.maths_d_five);
        showScore = showScore + "\nQuestion 6. " + " \t " + getString(R.string.maths_b_six);
        showScore = showScore + "\nQuestion 7. " + " \t " + getString(R.string.maths_a_seven);
        showScore = showScore + "\nQuestion 8. " + " \t " + getString(R.string.maths_c_eight);
        showScore = showScore + "\nQuestion 9. " + " \t " + transitive;
        showScore = showScore + "\nQuestion 10. " + "\t " + getString(R.string.maths_a_ten);

        return showScore;
    }

    private void displayScore(String message) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }
}

