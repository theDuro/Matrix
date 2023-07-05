package matrixoperations;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] a) {
        this.matrix = a;
    }

    public int getRowsNum(){
        return matrix.length;
    }

    public int getColsNum(){
        return matrix[0].length;
    }

    public double[][] getArr(){
        return matrix;
    }

    void show() {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] test = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test[i][j] = (i + j);
            }
        }

        double[][] a = {{1, 3}, {2, -2}};
        Matrix mA = new Matrix(a);
        double[][] b = {{2, 1, 3}, {-1, 2, 4}, {7, 4, 12}};
        Matrix mB = new Matrix(b);

        Matrix c = MatrixOperations.multiplyMatrix(mA, mB);
//        c.show();

        System.out.println(MatrixOperations.det(mB));

//        Matrix c = MatrixOperations.substractMatrix(mA, mB);
//        c.show();

    }
}
