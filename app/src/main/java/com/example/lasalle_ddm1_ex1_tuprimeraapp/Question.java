package com.example.lasalle_ddm1_ex1_tuprimeraapp;

public class Question {

    private int id;
    private boolean answer;

    public Question(int mTextResId, boolean answer) {
        this.id = mTextResId;
        this.answer = answer;
    }

    public int getId() {return id;}
    public boolean isAnswer() {return answer;}
}
