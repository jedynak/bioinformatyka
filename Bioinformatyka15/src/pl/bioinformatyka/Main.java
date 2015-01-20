package pl.bioinformatyka;

import pl.bioinformatyka.common.InputReader;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader reader = new InputReader("input.txt");
        int[][] ret = reader.readAdjacencyMatrix();
    }
}
