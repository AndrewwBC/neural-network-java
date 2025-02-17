package org.example;

import org.example.utils.Function;

public class Training {

    private Double oldWeigth;
    private Double oldBias;

    public void trainNeuron(){
        Function inputFunction = new Function(4, 1);
        Neuron neuron = new Neuron(inputFunction);

        for (int i = 0; i < 10000 ; i++) {
            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());
            neuron.gradient();
            System.out.println(neuron.getWeigth() + ", " + neuron.getBias());
        }
    }
}