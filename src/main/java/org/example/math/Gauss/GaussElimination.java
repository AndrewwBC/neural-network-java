package org.example.math.Gauss;

import java.util.*;

public class GaussElimination {

    private int lines = 4;
    private int columns = 5;

    double[][] array = {
            {1,1,1,6,7},
            {2,-1,1,5,5},
            {1,2,-1,4,5},
            {1,2,-1,4,5},
    };
    public void loop(){

        List<Double> pivotVector = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            pivotVector.clear();

            for (int j = 0; j < Arrays.stream(this.array[0]).count(); j++) {
                pivotVector.add(array[i][j]);
            }
            this.math(pivotVector, i);
        }
        this.unknowns();
    }

    private void unknowns() {
        // loop para ir da ultima linha ate a primeira
        for (int i = lines - 1; i >= 0 ; i--) {
            double sumOfLine = 0;
            double currentUnknown = 0;
            double independentTerm = 0;

            // loop para iniciar incognita de baixo
            for (int j = columns - 2; j >= 0 ; j--) {
                currentUnknown = this.array[i][i];
                independentTerm = this.array[i][columns - 1];
                if(j <= columns -2 && j != i){
                    sumOfLine += this.array[i][j];
                }
            }
           System.out.println("Soma da linha: " + sumOfLine);

            sumOfLine = this.myRound(sumOfLine);

            double valueOfUnknown;

            if((independentTerm + sumOfLine*-1) == 0 || currentUnknown == 0 ) {
                valueOfUnknown = 0;
            } else {
                valueOfUnknown = this.myRound((independentTerm + sumOfLine*-1) / currentUnknown);
            }


            System.out.println(this.myRound(valueOfUnknown));

            for (int j = columns - 2; j >= 0; j--) {
                this.array[j][i] *= valueOfUnknown;
            }
        }
    }


    private void math(List<Double> pivotVector, int currentLine){
        List<Double> nextVector = new ArrayList<>();
        List<Double> afterMathVector = new ArrayList<>();

        for (int i = currentLine + 1; i < columns; i++) {
            this.showArray();
            nextVector.clear();
            afterMathVector.clear();

            if(i >= this.array.length) return;

            for (int j = 0; j < Arrays.stream(this.array[0]).count(); j++) {
                nextVector.add(array[i][j]);
            }

            if (pivotVector.get(currentLine) == 0) continue;
            double m = this.myRound(nextVector.get(currentLine) / pivotVector.get(currentLine));

            for (int k = 0; k < nextVector.size(); k++) {
                afterMathVector.add(this.myRound(nextVector.get(k) - (pivotVector.get(k) * m)));
            }

            for (int j = 0; j < Arrays.stream(this.array[0]).count() ; j++) {
                array[i][j] = afterMathVector.get(j);
            }

            this.showArray();
        }
    }

    private void showArray(){
        System.out.println("---------------------");
        for (int j = 0; j < lines; j++) {
            for (int k = 0; k < columns; k++) {
                System.out.print(String.format("%.2f",this.array[j][k]) + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    private double myRound(double value) {
        return Math.ceil((value * 100)) / 100;
    }

}


