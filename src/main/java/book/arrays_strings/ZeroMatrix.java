package book.arrays_strings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.8 Write an algorithm such that if an element in a NxN matrix is 0, its entire row and column are set to 0
 */
public class ZeroMatrix {

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1}
        };

        System.out.println("Matrix before marking:");
        printMatrix(matrix);

        propagateZeros(matrix);

        System.out.println("Matrix after marking:");
        printMatrix(matrix);
    }

    public static void propagateZeros(int[][] matrix) {

        // Find zeroes
        List<Point> zeroes = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroes.add(new Point(row, col));
                }
            }
        }

        // Propagate zeroes
        for(Point point: zeroes) {
            // Mark column
            for (int col = 0; col < matrix.length; col++) {
                matrix[point.x][col] = 0;
            }

            // Mark row
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][point.y] = 0;
            }
        }
    }
}
