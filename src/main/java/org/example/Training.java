package org.example;

import org.example.math.Backpropagation;
import org.example.utils.Function;
import org.example.utils.WeightAndBiasAdjustment;

public class Training {

    private Double oldWeigth;
    private Double oldBias;

    public void trainNeuron(){
        Function inputFunction = new Function(4, 1);
        Neuron neuron = new Neuron(inputFunction);
        Backpropagation backpropagation = new Backpropagation();

        for (int i = 0; i < 10000 ; i++) {
            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());

            WeightAndBiasAdjustment weightAndBiasAdjustment = backpropagation.gradient(neuron.getWeigth(), neuron.getBias(), neuron.realY(), neuron.predict(), inputFunction.x());



            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());
        }
    }
}