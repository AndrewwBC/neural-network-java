package org.example;

import java.util.List;

public class Neuron {
    private Double weigth;
    private Double bias;
    private Double input;

    private static final double LEARNING_RATE = 0.1;

    public Neuron(Double weight, Double bias, Double input){
        this.weigth = weight;
        this.bias = bias;
        this.input = input;
    }

    public Double predict(){
        return (weigth * input) + bias;
    }


    public String error(){
        var x = 2;

        var YR = x + 1;

        var errorInFunctionOfWeight = -2*( ( YR - this.predict()) ) * x;

        var errorInFunctionOfBias = -2*( (YR - this.predict()) ) ;

        System.out.println(errorInFunctionOfWeight);
        System.out.println(errorInFunctionOfBias);
        return "Oi";
    }

}
