package matrixreaderandwriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //FileOperator fileOperator = new FileOperator();
        List<Double[]> matrixList = new ArrayList<>();


        try {

            double[][] matrix = FileOperator.readFromFile("mat.txt");
           FileOperator.saveResult(matrix,"result.txt");

         //   System.out.println(FileOperator.readFromFile("mat.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    }
