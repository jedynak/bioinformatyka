package pl.bioinformatyka;

import pl.bioinformatyka.common.Cluster;
import pl.bioinformatyka.common.DistanceMatrix;
import pl.bioinformatyka.common.InputReader;
import pl.bioinformatyka.common.TopologyComparator;
import pl.bioinformatyka.upgma.UpgmaAlgorithm;
import pl.bioinformatyka.common.NeighbourJoining;import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length==0){
            System.out.println("Nie podano pliku z macierzą");
        } else {
            InputReader reader = new InputReader(args[0]);
            DistanceMatrix ret = reader.readDistanceMatrix();
            DistanceMatrix ret2 = reader.readDistanceMatrix();

            System.out.println("Upgma:");
            UpgmaAlgorithm alg = new UpgmaAlgorithm(ret);
            Cluster cluster = alg.runAlgorithm();

            cluster.simplePrint(1);


            System.out.println("NJ:");
            NeighbourJoining NJ = new NeighbourJoining();
            Cluster cluster2 = NJ.algorithm(ret2.getMatrix());

            cluster2.simplePrint(1);

            if(TopologyComparator.compareTopology(alg.getEdgeList(), NJ.getEdgeList())==true){
                System.out.println("Drzewa są takie same");
            } else {
                System.out.println("Drzewa są różne");
            }
        }
    }
}
