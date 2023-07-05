class MatrixOperations {

    public static Matrix addtMatrix(Matrix A, Matrix matrixB) {
        double[][] mA = A.getArr();
        double[][] mB = matrixB.getArr();
        double[][] result = new double[A.getRowsNum()][];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < A.getColsNum(); j++) {
                result[i][j] = mA[i][j] + mB[i][j];
            }
        }
        Matrix matrixC = new Matrix(result);
        return matrixC;
    }
    static Matrix substractMatrix(Matrix A, Matrix B) {
        double[][] mA = A.getArr();
        double[][] mB = B.getArr();
        double[][] result = new double[A.getRowsNum()][B.getColsNum()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < A.getColsNum(); j++) {
                result[i][j] = mA[i][j] - mB[i][j];
            }
        }
        Matrix matrixC = new Matrix(result);
        return matrixC;
    }

    static Matrix multiplyMatrix(Matrix A, Matrix B) {
        double[][] mA = A.getArr();
        double[][] mB = B.getArr();
        double[][] result = new double[A.getRowsNum()][B.getColsNum()];
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                for(int k = 0; k < A.getColsNum(); k++) {
                    result[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
        Matrix matrixC = new Matrix(result);
        return matrixC;
    }

    public static  Matrix transposeMatrix(Matrix A) {
        double[][] mA = A.getArr();
        double[][] result = new double[A.getColsNum()][A.getRowsNum()];

        for(int i = 0; i < A.getRowsNum(); i++) {
            for(int j = 0; j < A.getColsNum(); j++) {
                result[j][i] = mA[i][j];
            }
        }
        return new Matrix(result);
    }

    public static double[][] reduce(int row , int column , double[][] mat){
        int n=mat.length;
        double[][] res = new double[n- 1][n- 1];
        int r=0,c=0;
        for (int i = 0; i < n; i++) {
            c=0;
            if(i==row)
                continue;
            for (int j = 0; j < n; j++) {
                if(j==column)
                    continue;
                res[r][c] = mat[i][j];

                c++;
            }
            r++;
        }
        return res;
    }

    public static double det(Matrix matrix){
        double[][] mat = matrix.getArr();
        int n = mat.length;
        if(n==1)
            return mat[0][0];
        if(n==2)
            return mat[0][0]*mat[1][1] - (mat[0][1]*mat[1][0]);

        double[][] m11 = reduce(0,0,mat);
        Matrix matrix11 = new Matrix(m11);
        double[][] m1n = reduce(0,n-1,mat);
        Matrix matrixm1n = new Matrix(m1n);
        double[][] mn1 = reduce(n-1 , 0 , mat);
        Matrix matrixmn1 = new Matrix(mn1);
        double[][] mnn = reduce(n-1,n-1,mat);
        Matrix matrixmnn = new Matrix(mnn);
        double[][] m11nn = reduce(0,0,reduce(n-1,n-1,mat));
        Matrix matrixm11nn = new Matrix(m11nn);
        return (det(matrix11)*det(matrixmnn) - det(matrixm1n)*det(matrixmn1))/det(matrixm11nn);
    }
}
