package com.example.emran2020;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Classification {
    public InputStream inputStream;


    public Classification(InputStream inputStream) {
        this.inputStream = inputStream;

    }


    public int[][] read() {
        List resultList = new ArrayList ();

        BufferedReader reader = new BufferedReader ( new InputStreamReader ( inputStream ) );
        try {
            String csvLine;
            while ((csvLine = reader.readLine ()) != null) {
                String[] row = csvLine.split ( "," );
                resultList.add ( row );
            }
        } catch (IOException ex) {
            throw new RuntimeException ( "Error in reading CSV file: " + ex );
        } finally {
            try {
                inputStream.close ();
            } catch (IOException e) {
                throw new RuntimeException ( "Error while closing input stream: " + e );
            }
        }
        String[][] array = new String[resultList.size ()][0];
        resultList.toArray ( array );


        int[][] numbers = new int[array.length][];
        for (int row = 0; row < array.length; row++) {
            numbers[row] = new int[array[row].length];
            for (int col = 0; col < array[row].length; col++) {
                numbers[row][col] = Integer.parseInt ( array[row][col] );
            }
        }
        return numbers;
    }
}







