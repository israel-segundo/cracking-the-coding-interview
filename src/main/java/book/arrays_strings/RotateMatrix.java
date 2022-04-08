package book.arrays_strings;

/**
 * 1.7 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
 * the image by 90 degrees. Can you do this in-place?
 */
public class RotateMatrix {
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
                {0, 1, 1, 1, 3},
                {0, 5, 0, 6, 1},
                {0, 5, 9, 6, 1},
                {0, 5, 0, 6, 1},
                {2, 0, 0, 0, 0}
        };

        System.out.println("Matrix before rotation:");
        printMatrix(matrix);

        rotateMatrix90degrees(matrix);

        System.out.println("Matrix after rotation:");
        printMatrix(matrix);
    }
    public static void rotateMatrix90degrees(int[][] matrix) {

        // TODO: I'm tired
    }
}
