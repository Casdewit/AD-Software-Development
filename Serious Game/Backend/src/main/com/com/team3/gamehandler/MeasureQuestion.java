package com.team3.gamehandler;

public class MeasureQuestion {

    private char measureChar;
    private String measureAnswer;
    private int measurePoints;

    public MeasureQuestion(char measureaChar, String measureAnswer, int measurePoints) {
        this.measureChar = measureaChar;
        this.measureAnswer = measureAnswer;
        this.measurePoints = measurePoints;
    }

    public char getMeasureChar() {
        return measureChar;
    }

    public void setMeasureChar(char measureChar) {
        this.measureChar = measureChar;
    }

    public String getMeasureAnswer() {
        return measureAnswer;
    }

    public void setMeasureAnswer(String measureAnswer) {
        this.measureAnswer = measureAnswer;
    }

    public int getMeasurePoints() {
        return measurePoints;
    }

    public void setMeasurePoints(int measurePoints) {
        this.measurePoints = measurePoints;
    }



}
