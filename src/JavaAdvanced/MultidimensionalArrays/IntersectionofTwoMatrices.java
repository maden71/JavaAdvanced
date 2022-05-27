package JavaAdvanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionofTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = new String[rows][cols];
        for (int row = 0; row < firstMatrix.length ; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            firstMatrix[row] = data;
        }
        String[][] secondMatrix = new String[rows][cols];
        for (int row = 0; row < secondMatrix.length; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            secondMatrix[row] = data;
        }
        compareAndPrintMatrix(firstMatrix,secondMatrix);
    }

    private static void compareAndPrintMatrix(String[][] firstMatrix, String[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length ; col++) {
                if(!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    System.out.print("* ");
                }else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
