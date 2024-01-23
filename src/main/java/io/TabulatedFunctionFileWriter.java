package io;

import functions.*;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        try {
            try (BufferedWriter writerArray = new BufferedWriter(new FileWriter("C:\\Users\\dmitr\\IdeaProjects\\laba2-OOP\\output\\array function.txt"));
                 BufferedWriter writerLinked = new BufferedWriter(new FileWriter("C:\\Users\\dmitr\\IdeaProjects\\laba2-OOP\\output\\linked list function.txt"))) {

                double[] xValue = {1.1,2.2,3.3,4.4,5.5};
                double[] yValue = {1,2,3,4,5};
                TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValue, yValue);
                TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValue,yValue);

                io.FunctionsIO.writeTabulatedFunction(writerArray,arrayTabulatedFunction);
                io.FunctionsIO.writeTabulatedFunction(writerLinked,linkedListTabulatedFunction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
