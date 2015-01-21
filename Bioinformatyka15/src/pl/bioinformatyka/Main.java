package pl.bioinformatyka;

import pl.bioinformatyka.common.AdjacencyMatrix;
import pl.bioinformatyka.common.InputReader;
import pl.bioinformatyka.common.NeighbourJoining;
import pl.bioinformatyka.common.Pair;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader reader = new InputReader("input2.txt");
        AdjacencyMatrix ret = reader.readAdjacencyMatrix();
        System.out.println(ret.getMatrix().length);

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(ret.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }

        Pair pair = ret.findNearest();
        System.out.println(pair.getX() + "|" + pair.getY());
        NeighbourJoining NJ = new NeighbourJoining();
        NJ.algorithm(ret.getMatrix());
    }
}
