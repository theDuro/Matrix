package matrixreaderandwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;
import java.util.List;

public class FileOperator {

    public static double[][] readFromFile(String fileName) throws IOException {
        //String fileName = "mat.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<double[]> matrixList = new ArrayList<>();
        String[] strArray;
        double[] numbArray;
        String line;
        try {
            while ((line = br.readLine()) != null) {
                strArray = line.split(" ");
                numbArray = Arrays.stream(strArray)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                matrixList.add(numbArray);


            }
        } catch (IOException e) {

        } finally {
            br.close();
        }
        double[][] matrix = convertListToMatrix(matrixList);

        return matrix;
    }

    public static double[][] convertListToMatrix(List<double[]> matrixList) {
        return matrixList.stream()
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .mapToDouble(Double::doubleValue).toArray())
                .toArray(double[][]::new);
    }

    public static void saveResult(double[][] matrix, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (double[] row : matrix) {
                for (double element : row) {
                    writer.print(element + " ");
                }
                writer.println();
            }
            System.out.println("Matrix saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the matrix.");
            e.printStackTrace();
        }

    }

    public void saveResult(double determinant, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.print(determinant);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the determinant");
            e.printStackTrace();
        }
    }
}

