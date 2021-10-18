package com.team3.gamehandler;

public class GamePhases {
    private Round one;
    private Round two;
    private Round three;
    private Round four;
    private Round five;
    private Round six;

    // Een volledig spel bevat 6 rondes in data en wat naar elkaar doorstuurt.
    // 6x object bRound nodig
    public  GamePhases(Round one, Round two, Round three, Round four, Round five, Round six){
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }


    public Round getOne() {
        return one;
    }

    public void setOne(Round one) {
        this.one = one;
    }

    public Round getTwo() {
        return two;
    }

    public void setTwo(Round two) {
        this.two = two;
    }

    public Round getThree() {
        return three;
    }

    public void setThree(Round three) {
        this.three = three;
    }

    public Round getFour() {
        return four;
    }

    public void setFour(Round four) {
        this.four = four;
    }

    public Round getFive() {
        return five;
    }

    public void setFive(Round five) {
        this.five = five;
    }

    public Round getSix() {
        return six;
    }

    public void setSix(Round six) {
        this.six = six;
    }
}
