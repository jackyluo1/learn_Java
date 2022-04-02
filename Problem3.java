import java.io.FileNotFoundException;
//import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;

public class Problem3 {
    public static void main(String[] args) {
        int[][] a = input(args);
        // int[][] A = { { 1, 2, 3, 4 }, { 2, 3, 5, 2 }, { 0, 9, 8, -2 } };
        int[][] res = transpose(a);
        for (int i = 0; i < res.length; i += 1) {
            for (int j = 0; j < res[0].length; j += 1) {
                System.out.print(" " + res[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public static int[][] input(String[] args) {
        Scanner input = null;
        File file = null;

        try {
            file = new File("Problem3.txt");
            input = new Scanner(file);
        }

        catch (FileNotFoundException exception) {
            System.out.println("File does not exist!");
        }

        String line = input.nextLine();
        String line1 = line.trim();
        String[] info = line1.split(" ");
        int row = Integer.parseInt(info[0]);
        int col = Integer.parseInt(info[1]);
        int[][] res = new int[row][col];

        line = input.nextLine();
        line1 = line.trim();
        info = line1.split(" ");

        int l = 0;
        while (input.hasNextLine()) {
            for (int index = 0; index < info.length; index++) {
                res[l][index] = Integer.parseInt(info[index]); // Store the integer into res[l][index]
            }
            l++; // use for the next line, and match with res
            line = input.nextLine(); // get the infomation of the next line
            line1 = line.trim();
            info = line1.split(" ");
        }
        return res;
    }

    public static int[][] transpose(int[][] myMatrix) {
        int row = myMatrix.length, col = myMatrix[0].length;

        if (row == col) {
            return trans(myMatrix);
        }

        int[][] res = new int[col][row]; // new arr[][] to store information

        for (int i = 0; i < col; i += 1) {
            for (int j = 0; j < row; j += 1) {
                res[i][j] = myMatrix[j][i]; // the key to transpose
            }
        }

        return res;
    }

    public static int[][] trans(int[][] myMatrix) {
        for (int i = 0; i < myMatrix.length; i += 1) {
            for (int j = i + 1; j < myMatrix[0].length; j += 1) { // swap
                int temp = myMatrix[i][j];
                myMatrix[i][j] = myMatrix[j][i];
                myMatrix[j][i] = temp;
            }
        }
        return myMatrix;
    }
}
