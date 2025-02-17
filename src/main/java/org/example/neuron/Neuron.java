package org.example.neuron;

import org.example.utils.Function;

public class Neuron {
    private Double weigth;
    private Double bias;
    private Function inputFunction;

    public Neuron(Function inputFunction){
        // Neuron receive a function as input, search for the record class to understand
        this.inputFunction = inputFunction;
        this.weigth = Math.random();
        this.bias = Math.random();
    }

    public Double predict(){
        return (weigth * (this.inputFunction.x()) ) + bias;
    }

    public Integer realY(){
        return this.inputFunction.x() + this.inputFunction.Constant();
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    public Double getWeigth() {
        return this.weigth;
    }

    public Double getBias(){
        return this.bias;
    }

}
