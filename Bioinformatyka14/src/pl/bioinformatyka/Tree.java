package pl.bioinformatyka;

public class Tree {
    private Node root;

    public Tree(String rootData) {
        root = new Node(rootData,0,null);
    }

    public Node getRoot(){
        return root;
    }

    public class Node{
        private String data;
        private double timeDistanceFromParent;
        private double timeDistanceFromRoot;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(String _data, double _timeDistanceFromParent, Node _parent){
            data = _data;
            parent = _parent;
            timeDistanceFromParent = _timeDistanceFromParent;
            timeDistanceFromRoot = 0.0;
            if(parent!=null){
                timeDistanceFromRoot = parent.timeDistanceFromRoot + timeDistanceFromParent;
            }
        }
        public void createChildren(String leftDNA, String rightDNA, double time){
            leftChild = new Node(leftDNA,time,this);
            rightChild = new Node(rightDNA,time,this);
        }
        public Node getLeftChild(){
            return leftChild;
        }
        public Node getRightChild(){
            return rightChild;
        }
        public String getDNA(){
            return data;
        }
        public double getTimeDistanceFromParent(){
            return timeDistanceFromParent;
        }
        public double getTimeDistanceFromRoot(){
            return timeDistanceFromRoot;
        }
    }

    public void simplePrint(double step){
        printNode(root,0,step);
    }
    private void  printNode(Node node, int depth,double step){
        int numOfSteps = (int)(node.getTimeDistanceFromParent() / step)+1;
        if(node.getRightChild()!=null) {
            printNode(node.getRightChild(),depth+numOfSteps,step);
        }
        for(int i=0;i<depth;++i){
            System.out.print(" ");
        }
        for(int i=0;i<numOfSteps;++i){
            System.out.print("-");
        }
        System.out.println(node.getDNA());
        if(node.getLeftChild()!=null) {
            printNode(node.getLeftChild(),depth+numOfSteps,step);
        }
    }
}