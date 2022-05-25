package JavaAdvanced.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int searchNumber = Integer.parseInt(scanner.nextLine());

        //Positions search

        List<String> outputList = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == searchNumber) {
                    outputList.add(row + " " + col);
                }
            }
        }
        if(outputList.isEmpty()) {
            System.out.println("not found");
        }else {
            for (String pos : outputList) {
                System.out.println(pos);
            }
        }
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
