package pl.bioinformatyka;

import pl.bioinformatyka.common.Cluster;
import pl.bioinformatyka.common.DistanceMatrix;
import pl.bioinformatyka.common.InputReader;
import pl.bioinformatyka.common.TopologyComparator;
import pl.bioinformatyka.upgma.UpgmaAlgorithm;
import pl.bioinformatyka.common.NeighbourJoining;import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader reader = new InputReader("input.txt");
        DistanceMatrix ret = reader.readDistanceMatrix();
        DistanceMatrix ret2 = reader.readDistanceMatrix();

        System.out.println("Upgma:");
        UpgmaAlgorithm alg = new UpgmaAlgorithm(ret);
        Cluster cluster = alg.runAlgorithm();

        cluster.simplePrint(1);

        TopologyComparator.compareTopology(alg.getEdgeList(), alg.getEdgeList());

        System.out.println("NJ:");
        NeighbourJoining NJ = new NeighbourJoining();
        Cluster cluster2 = NJ.algorithm(ret2.getMatrix());

        cluster2.simplePrint(1);
    }
}
