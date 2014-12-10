package pl.bioinformatyka;

import java.util.LinkedList;
import java.util.Queue;

public class DNAsimulator{
    private double simulationTime;
    private RandomTimeGenerator timeGenerator;
    private Tree tree;
    private Kimura kimura;
    public DNAsimulator(double _simulationTime, RandomTimeGenerator _timeGenerator, Tree _tree, Kimura _kimura){
        simulationTime = _simulationTime;
        timeGenerator = _timeGenerator;
        tree = _tree;
        kimura = _kimura;
    }
    public void startSimulation(){
        double generatedTime;
        Tree.Node node = tree.getRoot();

        Queue<Tree.Node> queue = new LinkedList<Tree.Node>();
        queue.add(node);

        while(queue.size()>0) {
            node = queue.remove();
            generatedTime = timeGenerator.getRandomTime();
            double actualTime = node.getTimeDistanceFromRoot() + generatedTime;
            if(actualTime < simulationTime){
                node.createChildren(kimura.mutateDNA(node.getDNA(),actualTime),kimura.mutateDNA(node.getDNA(),actualTime),generatedTime);

                queue.add(node.getLeftChild());
                queue.add(node.getRightChild());
            }
        }
    }

}