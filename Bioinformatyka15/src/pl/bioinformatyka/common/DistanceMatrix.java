package pl.bioinformatyka.common;

public class DistanceMatrix {
    private double[][] matrix;

    public DistanceMatrix() {}
    public DistanceMatrix(double[][] matrix) {
        this.matrix = new double[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public Pair findNearest() {
        Pair ret = new Pair();
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<matrix.length; i++) {
            for (int j=i+1; j<matrix[0].length; j++) {
                if (matrix[i][j] < minDistance) {
                    ret.setX(i);
                    ret.setY(j);
                    minDistance = matrix[i][j];
                }
            }
        }
        return ret;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = new double[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }
}
