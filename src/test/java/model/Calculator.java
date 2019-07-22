package model;

public class Calculator {
    private int first;
    private int second;

    public Calculator(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getMiltiply(){
        return first * second;
    }

    public int getSum(){
        return first + second;
    }

    public int getDivide(){
        return first / second;
    }

    public int getTraction(){
        return first - second;
    }
}