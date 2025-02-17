package org.example;

public class Main {
    public static void main(String[] args) {

        Neuron neuron = new Neuron(1.2,1.2,10.0);
        System.out.println(neuron.error());
    }
}