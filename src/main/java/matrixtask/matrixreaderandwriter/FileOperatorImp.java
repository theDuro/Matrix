package matrixtask.matrixreaderandwriter;

import java.io.IOException;

public class FileOperatorService {
    private static final String FIRST_MATRIX_FILE_NAME = "matrix1.txt";
    private static final String SECOND_MATRIX_FILE_NAME = "matrix2.txt";
    private static final String RESULT_MATRIX_FILE_NAME = "result.txt";

    FileOperator fileOperator = new FileOperator();
    SizeValidator sizeValidator = new SizeValidator();

   public double[][] getFirsMatrix(){
       try {
           return  fileOperator.readFromFile(FIRST_MATRIX_FILE_NAME);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
   //todo public or private ?
   public double[][] getSecendMatrix(){
        try {
            return  fileOperator.readFromFile(SECOND_MATRIX_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeMatrixToFile(double[][] matrix){
       FileOperator.saveResult(matrix,RESULT_MATRIX_FILE_NAME);
    }
    public void writeDeterminantToMatrix(double determinant){
       fileOperator.saveResult(determinant,RESULT_MATRIX_FILE_NAME);
    }
    public
}
