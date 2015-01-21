package pl.bioinformatyka.common;

/**
 * Created by Tomek on 2015-01-20.
 */
public class NeighbourJoining {
    public void NeighbourJoining(){}

    public void algorithm(double[][] matrix){
        AdjacencyMatrix QMatrix = new AdjacencyMatrix();
        while(matrix.length>2){
            QMatrix.setMatrix(createQMatrix(matrix));
            Pair pair = QMatrix.findNearest();
            matrix = updateMatrix( matrix, pair);
            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(pair.getX() + "|" + pair.getY());
        }
    }

    public double[][] updateMatrix(double[][] matrix, Pair pair){
        double[][] newMatrix = new double[matrix.length-1][matrix[0].length-1];
        if(pair.getX()>pair.getY()){
            int tmp = pair.getX();
            pair.setX(pair.getY());
            pair.setY(tmp);
        }
        // nodes with numbers pair.x and pair.y will be deleted
        //instead of them, we create node U
        double distanceX = 0.0;                         //distance from U to pair.Y
        for (int i=0; i<matrix.length; i++) {
            distanceX = distanceX + matrix[pair.getX()][i] - matrix[i][pair.getY()];
        }
        distanceX = distanceX / (2.0 * (matrix.length - 2.0));
        distanceX += matrix[pair.getX()][pair.getY()] / 2.0;

        double distanceY = matrix[pair.getX()][pair.getY()] - distanceX;   //distance from U to pair.Y

        newMatrix = new double[matrix.length-1][matrix[0].length-1];
        //rewrite matrix (without rows and columns number: pair.x and pair.y )
        for (int i=0, i2=0; i<matrix.length; i++,i2++) {
            if(i==pair.getX()||i==pair.getY()){
                --i2;
            } else {
                for (int j = 0, j2 = 0; j < matrix[0].length; j++, j2++) {
                    if (j == pair.getX() || j == pair.getY()) {
                        --j2;
                    } else {
                        newMatrix[i2][j2] = matrix[i][j];
                    }
                }
            }
        }
        // add new node U as the one with highest index
        for (int i=0, i2=0; i<matrix.length; i++,i2++) {
            if(i==pair.getX()||i==pair.getY()){
                --i2;
            } else {
                newMatrix[matrix.length - 2][i2] = (matrix[i][pair.getY()] + matrix[pair.getX()][i]-matrix[pair.getX()][pair.getY()])/2.0;
                newMatrix[i2][matrix.length - 2] = newMatrix[matrix.length - 2][i2];
            }
        }
        return newMatrix;
    }

    public double[][] createQMatrix(double[][] matrix){
        double[][] QMatrix;
        QMatrix = new double[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=i; j<matrix[0].length; j++) {
                if(i==j){
                    QMatrix[i][j] = 0;
                } else {
                    QMatrix[i][j] = (matrix.length - 2) * matrix[i][j];
                    for (int k=0; k<matrix.length; k++) {
                        QMatrix[i][j] = QMatrix[i][j] - matrix[i][k] - matrix[k][j];
                    }
                    QMatrix[j][i] = QMatrix[i][j];
                }
            }
        }
        return QMatrix;
    }
}
