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

public class Chemistry extends AppCompatActivity {

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
    String colour = "Purple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry);


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
         * @param addOneA      is selected, one is added to the score.
         * @param addTwoA      and addTwoC are selected, one is added to the score.
         * @param addThreeA,   and addThreeD are selected, one is added to the score.
         * @param addFourC     is selected, and one is added to the score
         * @param addFiveA     is selected and one is added to the score
         * @param addSixB      is selected and one is added to the score
         * @param addSevenC    is selected and one is added to the score
         * @param addEightD    is selected and one is added to the score
         * @param questionNine is answered, one is added to the score
         * @param addTenD      is selected and one is added to the score
         * @return accepts the total score if all correct radio button was clicked.
         */
        private int calculateScore(boolean addOneA, boolean addTwoA, boolean addTwoC, boolean addThreeA, boolean addThreeD, boolean addFourC, boolean addFiveA, boolean addSixB, boolean addSevenC, boolean addEightD, String questionNine, boolean addTenD){
            int baseScore = 0;
            if(addOneA){
                baseScore += 1;
            }
            if(addTwoA && addTwoC){
                baseScore += 1;
            }
            if(addThreeA && addThreeD){
                baseScore += 1;
            }
            if(addFourC){
                baseScore += 1;
            }
            if(addFiveA){
                baseScore += 1;
            }
            if(addSixB){
                baseScore += 1;
            }
            if(addSevenC){
                baseScore += 1;
            }
            if(addEightD){
                baseScore += 1;
            }
            if(questionNine.trim().equalsIgnoreCase(colour)){
                baseScore += 1;
            }
            if(addTenD){
                baseScore += 1;
            }
            score = baseScore;
            return score;
        }

        private void checkQuestions() {
            // obtaining the ID of radio group Question 1 to ascertain if a radio button has been ticked
            RadioGroup groupOne = findViewById(R.id.chemGroupOne);
            int chemGroupOneId = groupOne.getCheckedRadioButtonId();

            RadioGroup groupFour = findViewById(R.id.chemGroupFour);
            int chemGroupFourId = groupFour.getCheckedRadioButtonId();

            RadioGroup groupFive = findViewById(R.id.chemGroupFive);
            int chemGroupFiveId = groupFive.getCheckedRadioButtonId();

            RadioGroup groupSix = findViewById(R.id.chemGroupSix);
            int chemGroupSixId = groupSix.getCheckedRadioButtonId();

            RadioGroup groupSeven = findViewById(R.id.chemGroupSeven);
            int chemGroupSevenId = groupSeven.getCheckedRadioButtonId();

            RadioGroup groupEight = findViewById(R.id.chemGroupEight);
            int chemGroupEightId = groupEight.getCheckedRadioButtonId();

            RadioGroup groupTen = findViewById(R.id.chemGroupTen);
            int chemGroupTenId = groupTen.getCheckedRadioButtonId();

            // Getting the values of any question that has been selected in question 2
            CheckBox questionTwoCheckBox = findViewById(R.id.question_two_a);
            boolean hasTwoA = questionTwoCheckBox.isChecked();
            CheckBox questionTwoBCheckBox = findViewById(R.id.question_two_b2);
            boolean hasTwoB = questionTwoBCheckBox.isChecked();
            CheckBox questionTwoCCheckBox = findViewById(R.id.question_two_c);
            boolean hasTwoC = questionTwoCCheckBox.isChecked();
            CheckBox questionTwoDCheckBox = findViewById(R.id.question_two_d2);
            boolean hasTwoD = questionTwoDCheckBox.isChecked();

            // Getting the values of any question that has been selected in question 3
            CheckBox questionThreeACheckBox = findViewById(R.id.question_three_a);
            boolean hasThreeA = questionThreeACheckBox.isChecked();
            CheckBox questionThreeBCheckBox = findViewById(R.id.question_three_b2);
            boolean hasThreeB = questionThreeBCheckBox.isChecked();
            CheckBox questionThreeCCheckBox = findViewById(R.id.question_three_c2);
            boolean hasThreeC = questionThreeCCheckBox.isChecked();
            CheckBox questionThreeDCheckBox = findViewById(R.id.question_three_d);
            boolean hasThreeD = questionThreeDCheckBox.isChecked();

            // Getting value of question 9
            EditText chemistryAnswerField = findViewById(R.id.chem_answer_field);
            String questionNine = chemistryAnswerField.getText().toString();
            colour = "Purple";
            if (questionNine.trim().equalsIgnoreCase(colour)) {
                score += 1;
            }

            //Calculating Radio Buttons
            RadioButton questionOneRadioButton = findViewById(R.id.question_one_a);
            boolean hasOneA = questionOneRadioButton.isChecked();

            RadioButton questionFourCRadioButton = findViewById(R.id.question_four_c);
            boolean hasFourC = questionFourCRadioButton.isChecked();

            RadioButton questionFiveARadioButton = findViewById(R.id.question_five_a);
            boolean hasFiveA = questionFiveARadioButton.isChecked();


            RadioButton questionSixBRadioButton = findViewById(R.id.question_six_b);
            boolean hasSixB = questionSixBRadioButton.isChecked();

            RadioButton questionSevenCRadioButton = findViewById(R.id.question_seven_c);
            boolean hasSevenC = questionSevenCRadioButton.isChecked();

            RadioButton questionEightDRadioButton = findViewById(R.id.question_eight_d);
            boolean hasEightD = questionEightDRadioButton.isChecked();

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
            if (chemGroupOneId == -1) {
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
            else if (chemGroupFourId == -1) {
                Toast.makeText(this, "Please answer Question 4", Toast.LENGTH_SHORT).show();
            }
            // checking if no radio button has been selected
            else if (chemGroupFiveId == -1) {
                Toast.makeText(this, "Please answer Question 5", Toast.LENGTH_SHORT).show();
            }
            // checking if no radio button has been selected
            else if (chemGroupSixId == -1) {
                Toast.makeText(this, "Please answer Question 6", Toast.LENGTH_SHORT).show();
            }
            // checking if no radio button has been selected
            else if (chemGroupSevenId == -1) {
                Toast.makeText(this, "Please answer Question 7", Toast.LENGTH_SHORT).show();
            }
            // checking if no radio button has been selected
            else if (chemGroupEightId == -1) {
                Toast.makeText(this, "Please answer Question 8", Toast.LENGTH_SHORT).show();
            }
            // checking if no radio button has been selected
            else if (chemGroupTenId == -1) {
                Toast.makeText(this, "Please answer Question 10", Toast.LENGTH_SHORT).show();
            }
            else if (TextUtils.isEmpty(chemistryAnswerField.getText())) {
                chemistryAnswerField.setError("Please answer Question 9");
            } // resetting before questions can be answered
            else if (verifySubmission > 0) {
                Toast.makeText(this, "Play again", Toast.LENGTH_SHORT).show();
            } else {
                //To prevent the score from being recalculated
                verifySubmission += 1;

                int score = calculateScore(hasOneA, hasTwoA, hasTwoC, hasThreeA, hasThreeD, hasFourC, hasFiveA, hasSixB, hasSevenC, hasEightD, questionNine, hasTenD);
                String showScore = showScores(score, colour);

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


    private String showScores(int score, String colour){
        String showScore = "Score: " + score + " out of 10";
        showScore = showScore + "\n\nAnswers";
        showScore = showScore + "\nQuestion 1. " + " \t " + getString(R.string.chem_a_one);
        showScore = showScore + "\nQuestion 2. " + " \t " + getString(R.string.chem_a_two) + " and " + getString(R.string.chem_b_two);
        showScore = showScore + "\nQuestion 3. " + " \t " + getString(R.string.chem_a_three) + " and "  + getString(R.string.chem_d_three);
        showScore = showScore + "\nQuestion 4. " + " \t " + getString(R.string.chem_c_four);
        showScore = showScore + "\nQuestion 5. " + " \t " + getString(R.string.chem_a_five);
        showScore = showScore + "\nQuestion 6. " + " \t " + getString(R.string.chem_b_six);
        showScore = showScore + "\nQuestion 7. " + " \t " + getString(R.string.chem_c_seven);
        showScore = showScore + "\nQuestion 8. " + " \t " + getString(R.string.chem_d_eight);
        showScore = showScore + "\nQuestion 9. " + " \t " + colour;
        showScore = showScore + "\nQuestion 10. " + "\t " + getString(R.string.chem_d_ten);

        return showScore;
    }

    private void displayScore(String message) {
        TextView scoreTextView =  findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }

}





