package pl.bioinformatyka.common;

public class Cluster {
    private String id;
    private Cluster parent;
    private Cluster leftChild;
    private Cluster rightChild;
    private double distanceToParent;

    public Cluster() {
    }

    public Cluster(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cluster getParent() {
        return parent;
    }

    public void setParent(Cluster parent) {
        this.parent = parent;
    }

    public Cluster getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Cluster leftChild) {
        this.leftChild = leftChild;
    }

    public Cluster getRightChild() {
        return rightChild;
    }

    public void setRightChild(Cluster rightChild) {
        this.rightChild = rightChild;
    }

    public double getDistanceToParent() {
        return distanceToParent;
    }

    public void setDistanceToParent(double distanceToParent) {
        this.distanceToParent = distanceToParent;
    }
}
