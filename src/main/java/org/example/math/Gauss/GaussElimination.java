package org.example.math.Gauss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaussElimination {

    private int lines = 6;
    private int columns = 7;

    double[][] array = {
            {1,2,3,4,0,8,1},
            {4,5,2,9,1,9,1},
            {8,9,5,7,0,9,1},
            {2,5,9,7,1,8,1},
            {8,0,4,1,6,8,1},
            {8,0,4,1,6,4,6}
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
    }

    private void math(List<Double> pivotVector, int currentLine){
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
            double m = (double) nextVector.get(currentLine) / pivotVector.get(currentLine);

            for (int k = 0; k < nextVector.size(); k++) {
                afterMathVector.add(nextVector.get(k) - (pivotVector.get(k) * m) );
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
            System.out.println(); // Quebra de linha após cada linha da matriz
        }
        System.out.println("---------------------");
    }

}


