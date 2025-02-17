package org.example;

public class Neuron {
    private Double weigth;
    private Double bias;
    private Double input;

    private Integer x = 2;

    private static final double LEARNING_RATE = 0.1;

    public Neuron(Double weight, Double bias, Double input){
        this.weigth = weight;
        this.bias = bias;
        this.input = input;
    }

    public Double predict(){
        return (weigth * input) + bias;
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
        return this.x + 1;
    }

}
