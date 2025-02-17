package org.example;

import org.example.utils.Function;

public class Training {

    public void trainNeuron(){
        Function inputFunction = new Function(2, 1);

        Neuron neuron = new Neuron(inputFunction);
        System.out.println();
    }

}
