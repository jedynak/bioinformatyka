package pl.bioinformatyka.upgma;

import pl.bioinformatyka.common.Cluster;
import pl.bioinformatyka.common.DistanceMatrix;
import pl.bioinformatyka.common.Edge;
import pl.bioinformatyka.common.Pair;

import java.util.ArrayList;
import java.util.List;

public class UpgmaAlgorithm {
    private DistanceMatrix distanceMatrix;
    private List<Edge> edgeList;

    public UpgmaAlgorithm(DistanceMatrix distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public Cluster runAlgorithm() {
        List<Cluster> clusters = new ArrayList<Cluster>();
        edgeList = new ArrayList<Edge>();

        for (int i=0; i<distanceMatrix.getMatrix().length; i++) {
            clusters.add(new Cluster(Character.toString((char) (97 + i))));
        }

        while (clusters.size() > 1) {
            // find nearest clusters
            Pair nearestPair = distanceMatrix.findNearest();
            double minDistance = distanceMatrix.getMatrix()[nearestPair.getX()][nearestPair.getY()];

            // create new cluster and set its children
            Cluster newCluster = new Cluster(clusters.get(nearestPair.getX()).getId().concat(clusters.get(nearestPair.getY()).getId()));
            Cluster leftChild = clusters.get(nearestPair.getX());
            leftChild.setDistanceToParent(minDistance / 2.0);
            leftChild.setParent(newCluster);
            Cluster rightChild = clusters.get(nearestPair.getY());
            rightChild.setDistanceToParent(minDistance / 2.0);
            rightChild.setParent(newCluster);
            newCluster.setLeftChild(leftChild);
            newCluster.setRightChild(rightChild);
            edgeList.add(new Edge(newCluster.getId(), leftChild.getId()));
            edgeList.add(new Edge(newCluster.getId(), rightChild.getId()));
            if (nearestPair.getX() < nearestPair.getY()) {
                clusters.remove(nearestPair.getX());
                clusters.remove(nearestPair.getY() - 1);
            } else {
                clusters.remove(nearestPair.getY());
                clusters.remove(nearestPair.getX() - 1);
            }
            clusters.add(newCluster);

            // update distance matrix
            double[][] newDistanceMatrix = new double[distanceMatrix.getMatrix().length - 1][distanceMatrix.getMatrix()[0].length - 1];
            int jIndexInNewMatrix = 0, kIndexInNewMatrix = 0;
            for (int j=0; j<distanceMatrix.getMatrix().length; j++) {
                if (j != nearestPair.getX() && j != nearestPair.getY()) {
                    kIndexInNewMatrix = jIndexInNewMatrix + 1;
                    for (int k=j+1; k<distanceMatrix.getMatrix()[0].length; k++) {
                        if (k != nearestPair.getX() && k != nearestPair.getY()) {
                            newDistanceMatrix[jIndexInNewMatrix][kIndexInNewMatrix] = distanceMatrix.getMatrix()[j][k];
                            kIndexInNewMatrix++;
                        }
                    }
                    if (j < nearestPair.getY()) {
                        if (j < nearestPair.getX()) {
                            newDistanceMatrix[jIndexInNewMatrix][newDistanceMatrix[0].length - 1] = (distanceMatrix.getMatrix()[j][nearestPair.getX()]
                                    + distanceMatrix.getMatrix()[j][nearestPair.getY()]) / 2.0;
                        } else {
                            newDistanceMatrix[jIndexInNewMatrix][newDistanceMatrix[0].length - 1] = (distanceMatrix.getMatrix()[nearestPair.getX()][j]
                                    + distanceMatrix.getMatrix()[j][nearestPair.getY()]) / 2.0;
                        }
                    } else {
                        if (j < nearestPair.getX()) {
                            newDistanceMatrix[jIndexInNewMatrix][newDistanceMatrix[0].length - 1] = (distanceMatrix.getMatrix()[j][nearestPair.getX()]
                                    + distanceMatrix.getMatrix()[nearestPair.getY()][j]) / 2.0;
                        } else {
                            newDistanceMatrix[jIndexInNewMatrix][newDistanceMatrix[0].length - 1] = (distanceMatrix.getMatrix()[nearestPair.getX()][j]
                                    + distanceMatrix.getMatrix()[nearestPair.getY()][j]) / 2.0;
                        }
                    }
                    jIndexInNewMatrix++;
                }
            }
            distanceMatrix.setMatrix(newDistanceMatrix);
        }
        return clusters.get(0);
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }
}
