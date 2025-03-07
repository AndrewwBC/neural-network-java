package org.example.math.Gauss;

import java.util.*;

public class GaussElimination {
    double[][] array = {
            {1,1,1,0},
            {10,-8,0,65},
            {8,0,-3,120}
    };
    private int lines = this.array.length;
    private int columns = this.array.length + 1;
    private double[][] B = new double[lines][1];
    private double[][] L = new double[lines][columns - 1];
    private double[][] U = new double[lines][columns - 1];
    private double[][] Y = new double[lines][1];
    private double[][] X = new double[lines][1];
    private List<Double> ls = new ArrayList<>();

    // this method will populate de pivotVector list in order to do the math
    // related do the pivot, and will invoke gaussElimation
    // to find the pivots of each line after the first
    public void loop(){

        List<Double> pivotVector = new ArrayList<>();
        this.populateB();

        for (int i = 0; i < lines; i++) {
            pivotVector.clear();
            for (int j = 0; j < Arrays.stream(this.array[0]).count(); j++) {
                pivotVector.add(array[i][j]);
            }
            this.gaussElimination(pivotVector, i);
        }
        this.L();
        //this.unknowns();
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

    private void gaussElimination(List<Double> pivotVector, int currentLine){
        List<Double> nextVector = new ArrayList<>();
        List<Double> afterMathVector = new ArrayList<>();

        for (int i = currentLine + 1; i < columns; i++) {
            nextVector.clear();
            afterMathVector.clear();

            if(i >= this.array.length) return;

            for (int j = 0; j < Arrays.stream(this.array[0]).count(); j++) {
                nextVector.add(array[i][j]);
            }

            if (pivotVector.get(currentLine) == 0) continue;
            double m = this.myRound(nextVector.get(currentLine) / pivotVector.get(currentLine));
            ls.add(m);

            for (int k = 0; k < nextVector.size(); k++) {
                afterMathVector.add(this.myRound(nextVector.get(k) - (pivotVector.get(k) * m)));
            }

            for (int j = 0; j < Arrays.stream(this.array[0]).count() ; j++) {
                array[i][j] = afterMathVector.get(j);
            }
        }
    }

    private void L() {
        // create identity
        this.identityOfL();

        for (int i = 1; i < lines ; i++) {
            for (int j = 0; j < i ; j++) {
                this.L[i][j] = this.ls.get(i - 1 + j);
            }
        }
        this.findYArray();
    }

    private void findXArray() {
        this.U = this.array;
        this.showArray(U);

        for (int i = lines - 1; i >= 0 ; i--) {
            double sum = 0;
            for (int j = columns - 2; j >= i; j--) {
                if(i != j) {
                    sum += (this.U[i][j] * this.X[j][0]);
                }
            }

            if((this.Y[i][0] + (sum*-1)) == 0 || this.U[i][i] == 0) {
                this.X[i][0] = 0;
            } else {
                this.X[i][0] = (this.Y[i][0] + (sum*-1)) / this.U[i][i];
            }
        }

        for (int i = 0; i <= 2 ; i++) {
            System.out.println("Valor de x"+i + ": " + myRound(this.X[i][0]) + "    Valor de Y"+i + ": " + this.Y[i][0]);
        }

    }

    private void findYArray(){
        this.populateYAndX();
        Map<String, Double> ys = new HashMap<>();
        for (int i = 0; i < lines; i++) {
            double sumOfOthersCoeficients = 0;
            for (int k = 0; k < columns - 2; k++) {
                if(k != i) {
                    sumOfOthersCoeficients += (this.L[i][k]);
                }
            }
            double currentY = (this.B[i][0] - sumOfOthersCoeficients);
            for (int k = i + 1; k < lines; k++) {
                this.L[k][i] = this.L[k][i] * currentY;
            }
            System.out.println(currentY);
            this.Y[i][0] = currentY;
            ys.put("y" + i, currentY);
        }

        this.findXArray();
    }

    private void identityOfL(){
        for (int i = 0; i < lines ; i++) {
            for (int j = 0; j < columns - 1 ; j++) {
                this.L[i][j] = i == j ? 1 : 0;
            }
        }
    }
    private void populateB(){
        for (int i = 0; i < lines ; i++) {
            this.B[i][0] = this.array[i][this.array.length];
        }
    }

    private void populateYAndX(){
        for (int i = 0; i < lines ; i++) {
            this.Y[i][0] = 1;
            this.X[i][0] = 1;
        }
    }

    private void showArray(double[][] array) {
        System.out.println("---------------------");
        for (int j = 0; j < lines; j++) {
            for (int k = 0; k <  columns - 1; k++) {
                System.out.print(String.format("%.2f", array[j][k]) + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    private double myRound(double value) {
        return Math.ceil((value * 100)) / 100;
    }

}


