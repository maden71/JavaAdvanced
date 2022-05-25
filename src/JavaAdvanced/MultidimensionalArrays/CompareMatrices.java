package JavaAdvanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.compare;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] firstMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] data = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[row] = data;
        }
        input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        rows = input[0];
        cols = input[1];
        int[][] secondMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] data = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[row] = data;
        }
        boolean compare = compare(firstMatrix, secondMatrix);
        if (compare) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


    }

    private static boolean compare(int[][] firstMatrix, int[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix.length != secondMatrix.length || firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            } else {
                for (int col = 0; col < firstMatrix[row].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
