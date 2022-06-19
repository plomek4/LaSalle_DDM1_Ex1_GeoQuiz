package com.example.lasalle_ddm1_ex1_tuprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private TextView question;
    private Question[] mQuestions = new Question[]{
            new Question(R.string.quest_dublin,false),
            new Question(R.string.quest_london,true),
            new Question(R.string.quest_washington,true),
            new Question(R.string.quest_new_york,false),
            new Question(R.string.quest_pekin,true),
            new Question(R.string.quest_tokio,false),
            new Question(R.string.quest_atenas, false),
            new Question(R.string.quest_esparta, false),
    };

    private int ft = 1;
    private int questNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);

        question = findViewById(R.id.question_textView);


        if (ft == 1){
            Random r = new Random();

            questNum = r.nextInt(mQuestions.length - 1);
            setNextQuestion(questNum);
            ft++;
        }

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mQuestions[questNum].isAnswer()){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                Random r = new Random();
                int numQuestion = r.nextInt(mQuestions.length-1);
                setNextQuestion(numQuestion);
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mQuestions[questNum].isAnswer()){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                Random r = new Random();
                questNum = r.nextInt(mQuestions.length-1);
                setNextQuestion(questNum);

            }
        });
    }

    public void setNextQuestion(int nextNumber){
        question.setText(mQuestions[nextNumber].getId());
    }
}