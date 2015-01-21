package pl.bioinformatyka;

import pl.bioinformatyka.common.Cluster;
import pl.bioinformatyka.common.DistanceMatrix;
import pl.bioinformatyka.common.InputReader;
import pl.bioinformatyka.upgma.UpgmaAlgorithm;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader reader = new InputReader("input.txt");
        DistanceMatrix ret = reader.readDistanceMatrix();

        UpgmaAlgorithm alg = new UpgmaAlgorithm(ret);
        Cluster cluster = alg.runAlgorithm();
    }
}
