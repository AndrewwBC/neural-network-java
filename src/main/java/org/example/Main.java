package org.example;

import org.example.math.Gauss.GaussElimination;
import org.example.training.Training;

public class Main {
    public static void main(String[] args) {

//        Training training = new Training();
//
//        training.trainNeuron();

        GaussElimination g = new GaussElimination();

        g.loop();

    }
}