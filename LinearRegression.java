package com.company;

import java.util.ArrayList;

public class LinearRegression {
    private final ArrayList<Float> x = new ArrayList<>();
    private final ArrayList<Float> y = new ArrayList<>();

    public void addX(float xCoordinate){
        x.add(xCoordinate);
    }
    public void addY(float yCoordinate){
        y.add(yCoordinate);
    }
    private float calculateMeanX(){
        int sumX = 0;
        for (Float aFloat : x) {
            sumX += aFloat;
        }
        return sumX / (float) x.size();
    }
    private float calculateMeanY(){
        int sumY = 0;
        for (Float aFloat : y) {
            sumY += aFloat;
        }
        return sumY / (float) y.size();
    }
    public float calculateSlope(){
        float sumOfNumerator = 0;
        float sumOfDenominator = 0;
        for (int i = 0; i < x.size(); ++i){
            sumOfNumerator += (x.get(i) - calculateMeanX()) * (y.get(i) - calculateMeanY());
            sumOfDenominator += (x.get(i) - calculateMeanX()) * (x.get(i) - calculateMeanX());
        }
        return sumOfNumerator / sumOfDenominator;
    }
    public float calculateYIntercept(){
        return (calculateMeanY() - calculateSlope()*calculateMeanX());
    }
    public float predict(float xValue){
        return calculateSlope()*xValue + calculateYIntercept();
    }
    public static void main(String [] args){
        LinearRegression r = new LinearRegression();
    }
}
