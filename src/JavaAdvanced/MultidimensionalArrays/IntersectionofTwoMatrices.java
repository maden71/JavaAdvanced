package JavaAdvanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionofTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    }
    public static int[][] readMatrix(Scanner scanner) {
        int[] input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] data = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = data;
        }
        return matrix;
    }
}
