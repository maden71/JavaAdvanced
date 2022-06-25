package JavaAdvanced.Exam;

import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String[] inputRow = scanner.nextLine().split("\\s+");
            matrix[row] = inputRow;
        }
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[i][j].equals("D")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        int stolenMoney = 0;

        for (String command : commands) {
            matrix[row][col] = "+";
            switch (command) {
                case "right": {
                    col++;
                    if (inBounds(row, col, matrixSize)) {
                        if (matrix[row][col].equals("$")) {
                            matrix[row][col] = "D";
                            int money = row * col;
                            stolenMoney += money;
                            System.out.printf("You successfully stole %d$.%n", money);
                        } else if (matrix[row][col].equals("P")) {
                            matrix[row][col] = "#";
                            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                            printMatrix(matrix);
                            return;
                        } else {
                            matrix[row][col] = "D";
                        }
                    } else {
                        col--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = "D";
                    }
                    break;
                }
                case "left": {
                    col--;
                    if (inBounds(row, col, matrixSize)) {
                        if (matrix[row][col].equals("$")) {
                            matrix[row][col] = "D";
                            int money = row * col;
                            stolenMoney += money;
                            System.out.printf("You successfully stole %d$.%n", money);
                        } else if (matrix[row][col].equals("P")) {
                            matrix[row][col] = "#";
                            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                            printMatrix(matrix);
                            return;
                        } else {
                            matrix[row][col] = "D";
                        }

                    } else {
                        col++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = "D";
                    }
                    break;
                }
                case "up": {
                    row--;
                    if (inBounds(row, col, matrixSize)) {

                        if (matrix[row][col].equals("$")) {
                            matrix[row][col] = "D";
                            int money = row * col;
                            stolenMoney += money;
                            System.out.printf("You successfully stole %d$.%n", money);
                        } else if (matrix[row][col].equals("P")) {
                            matrix[row][col] = "#";
                            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                            printMatrix(matrix);
                            return;
                        } else {
                            matrix[row][col] = "D";
                        }
                    } else {
                        row++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = "D";
                    }
                    break;
                }
                case "down": {
                    row++;
                    if (inBounds(row, col, matrixSize)) {
                        if (matrix[row][col].equals("$")) {
                            matrix[row][col] = "D";
                            int money = row * col;
                            stolenMoney += money;
                            System.out.printf("You successfully stole %d$.%n", money);
                        } else if (matrix[row][col].equals("P")) {
                            matrix[row][col] = "#";
                            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                            printMatrix(matrix);
                            return;
                        } else {
                            matrix[row][col] = "D";
                        }

                    } else {
                        row--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = "D";
                    }
                    break;
                }

            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        printMatrix(matrix);
    }

    static boolean inBounds(int row, int col, int size) {
        return (row >= 0 && row < size) && (col >= 0 && col < size);
    }

    static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
