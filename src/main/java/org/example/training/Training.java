package org.example.training;

import org.example.math.Backpropagation;
import org.example.neuron.Neuron;
import org.example.utils.Function;
import org.example.utils.WeightAndBiasAdjustment;

public class Training {
    public void trainNeuron(){
        Function inputFunction = new Function(4, 1);
        Neuron neuron = new Neuron(inputFunction);
        Backpropagation backpropagation = new Backpropagation();

        // epochs to be more AI style ;)
        var epochs = 10000;

        for (int i = 0; i < epochs; i++) {
            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());

            WeightAndBiasAdjustment weightAndBiasAdjustment = backpropagation.gradient(neuron.getWeigth(), neuron.getBias(), neuron.realY(), neuron.predict(), inputFunction.x());

            neuron.setWeigth(weightAndBiasAdjustment.weigth());
            neuron.setBias(weightAndBiasAdjustment.bias());

            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());
        }
    }
}