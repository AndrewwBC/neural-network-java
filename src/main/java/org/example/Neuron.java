package org.example;

import java.util.List;

public class Neuron {
    private Double weigth;
    private Double bias;
    private Double input;

    public Neuron(Double weight, Double bias, Double input){
        this.weigth = weight;
        this.bias = bias;
        this.input = input;
    }

    public Double sum(){
        return (weigth * input) + bias;
    }


}
