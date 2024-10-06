package com.volumidev.myapplication;

import java.io.Serializable;

public class Question implements Serializable {
    private String title;
    private String[] possible_answers;
    private String correct_answer;
    public int difficulty; //from 0 to 2
    private boolean is_asked;

    Question(String t, String[] p_a, String c_a, int d, boolean i_a)
    {
        this.title = t;
        this.possible_answers = p_a;
        this.correct_answer = c_a;
        this.difficulty = d; // a lo mejor hay que borrarlo
        this.is_asked = i_a;
    }
    Question(int d, boolean i_a)
    {
        this.difficulty = d;
        this.is_asked = i_a;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getPossible_answers() {
        return possible_answers;
    }

    public void setPossible_answers(String[] possible_answers) {
        this.possible_answers = possible_answers;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public boolean isIs_asked() {
        return is_asked;
    }

    public void setIs_asked(boolean is_asked) {
        this.is_asked = is_asked;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
