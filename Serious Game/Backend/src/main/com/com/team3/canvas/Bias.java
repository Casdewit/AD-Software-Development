package com.team3.canvas;

public class Bias {

    private char biasChar;
    private String biasName;
    private String biasDescription;
    private String biasExample;
    private int points;

    public Bias(char biasChar, String biasName, String biasDescription, String biasExample, int points) {
        this.biasChar = biasChar;
        this.biasName = biasName;
        this.biasDescription = biasDescription;
        this.biasExample = biasExample;
        this.points = points;
    }

    public char getChar() {
        return biasChar;
    }

    public void setChar(char aChar) {
        biasChar = aChar;
    }

    public String getBiasName() {
        return biasName;
    }

    public void setBiasName(String biasName) {
        this.biasName = biasName;
    }

    public String getBiasDescription() {
        return biasDescription;
    }

    public void setBiasDescription(String biasDescription) {
        this.biasDescription = biasDescription;
    }

    public String getBiasExample() {
        return biasExample;
    }

    public void setBiasExample(String biasExample) {
        this.biasExample = biasExample;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}

