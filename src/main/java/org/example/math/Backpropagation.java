package org.example.math;

public class Backpropagation {

    public double errorInFunctionOfWeight(Double realY, Double predict, Integer x){
        return -2*( ( realY - predict) ) * x;
    }

    public double errorInFunctionOfBias(Double realY, Double predict){
        return -2*( ( realY - predict) ) ;
    }

}

