package pl.bioinformatyka.common;

import java.util.List;

public class TopologyComparator {

    public static boolean compareTopology(List<Edge> firstToCompare, List<Edge> secondToCompare) {
        for (Edge edge : firstToCompare) {
            if (!secondToCompare.contains(edge)) {
                return false;
            }
        }

        return true;
    }
}
