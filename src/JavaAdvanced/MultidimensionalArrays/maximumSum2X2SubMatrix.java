package JavaAdvanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class maximumSum2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int[][] maxSumMatrix = new int[2][2];
        int maxSum = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            int sum = 0;
            for (int col = 0; col <matrix[row].length - 1 ; col++) {
                sum += matrix[row][col]  + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if(sum > maxSum) {
                    maxSum = sum;
                    maxSumMatrix[0][0] = matrix[row][col];
                    maxSumMatrix[0][1] = matrix[row][col+1];
                    maxSumMatrix[1][0] = matrix[row+1][col];
                    maxSumMatrix[1][1] = matrix[row+1][col+1];
                }
                sum = 0;
            }
        }
        for (int[] row : maxSumMatrix) {
            for (int number : row) {
                System.out.printf("%d ",number);
            }
            System.out.println();
        }
        System.out.println(maxSum);

    }
    public static int[][] readMatrix(Scanner scanner) {
        int[] input = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] data = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = data;
        }
        return matrix;
    }
}
