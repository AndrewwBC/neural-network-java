package org.example.math;

import org.example.utils.WeightAndBiasAdjustment;

public class Backpropagation {
    private static final double LEARNING_RATE = 0.001;

    private double errorInFunctionOfWeight(Integer realY, Double predict, Integer x){
        return -2*( ( realY - predict) ) * x;
    }
    // Both private methods receive params from gradient method above
    private double errorInFunctionOfBias(Integer realY, Double predict){
        return -2*( ( realY - predict) ) ;
    }

    // Receive values of weigth and bias and return then after adjustment
    public WeightAndBiasAdjustment gradient(Double weigth, Double bias, Integer realY, Double predict, Integer x){
        weigth -= LEARNING_RATE * this.errorInFunctionOfWeight(realY, predict, x);
        bias -= LEARNING_RATE * this.errorInFunctionOfBias(realY, predict);

        return new WeightAndBiasAdjustment(weigth, bias);
    }

}

