package pl.bioinformatyka;

import pl.bioinformatyka.common.Cluster;
import pl.bioinformatyka.common.DistanceMatrix;
import pl.bioinformatyka.common.InputReader;
import pl.bioinformatyka.common.TopologyComparator;
import pl.bioinformatyka.upgma.UpgmaAlgorithm;
import pl.bioinformatyka.common.NeighbourJoining;import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader reader = new InputReader("input2.txt");
        DistanceMatrix ret = reader.readDistanceMatrix();

        UpgmaAlgorithm alg = new UpgmaAlgorithm(ret);
        Cluster cluster = alg.runAlgorithm();

        cluster.simplePrint(1);

        TopologyComparator.compareTopology(alg.getEdgeList(), alg.getEdgeList());
        NeighbourJoining NJ = new NeighbourJoining();
        NJ.algorithm(ret.getMatrix());
    }
}
