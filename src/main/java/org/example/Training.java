package org.example;

import org.example.utils.Function;

public class Training {

    public void trainNeuron(){
        Function inputFunction = new Function(2, 1);

        Neuron neuron = new Neuron(inputFunction);

        for (int i = 0; i < 100000 ; i++) {
            neuron.gradient();
            System.out.println(neuron.getWeigth());
        }

        System.out.println(neuron.getWeigth() + ", " + neuron.getBias());

    }

}
