package org.example;

import org.example.utils.Function;

public class Neuron {
    private Double weigth;
    private Double bias;
    private Function inputFunction;

    private static final double LEARNING_RATE = 0.1;

    public Neuron(Function inputFunction){
        this.inputFunction = inputFunction;
        this.weigth = Math.random();
        this.bias = Math.random();
    }

    public Double predict(){
        return (weigth * (this.inputFunction.x() + this.inputFunction.Constant()) ) + bias;
    }

    public void gradient(){
        this.bias -= LEARNING_RATE * this.errorInFunctionOfBias();
        this.weigth -= LEARNING_RATE * this.errorInFunctionOfWeight();
    }

    public double errorInFunctionOfWeight(){
        return -2*( ( this.getYR() - this.predict()) ) * (-this.x);
    }

    public double errorInFunctionOfBias(){
        return -2*( (this.getYR()  - this.predict()) ) ;
    }

    public Integer getYR(){
        return this.inputFunction.x() + this.inputFunction.Constant();
    }

}
