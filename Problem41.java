// Problem 4 [30pts]
// Mutiply two matrices, use method displayProduct() to display the result. 
// For matrix multiplication to take place, the number of columns of the first matrix must be equal to the number of rows of the second matrix. 
// In our example, i.e.c1 = r2
// Also, the final product matrix is of size r1 x c2, i.e.product[r1][c2]
class MultiplyMatrices {

    public static void main(String[] args) {
        // input matrix
        int[][] firstMatrix = { { 3, -2, 5 }, { 3, 0, 4 } };
        int[][] secondMatrix = { { 2, 3 }, { -9, 0 }, { 0, 4 } };

        // Input your code here:
        int[][] product = multiplyMatrices(firstMatrix, secondMatrix);
        displayProduct(product);
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix[0].length) {
            System.out.println();
            System.out.println(
                    "the number of columns of the first matrix must be equal to the number of rows of the second matrix!");
            return null;
        }

        int len = Math.min(firstMatrix.length, firstMatrix[0].length);
        int[][] res = new int[len][len];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = multiply_helper(firstMatrix, secondMatrix, i, j);
            }
        }
        return res;
    }

    public static void displayProduct(int[][] product) {
        System.out.println("Product of two matrices is: ");
        for (int[] row : product) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }

    public static int multiply_helper(int[][] firstMatrix, int[][] secondMatrix, int first, int second) {
        // the number of columns of the first matrix, also the the number of rows of the
        // second matrix
        int max = Math.max(firstMatrix.length, firstMatrix[0].length);
        int count = 0;
        for (int i = 0; i < max; i++) {
            // int[][] res = new int[2][2] for example;
            // firstMatrix = { { 3, -2, 5 }, { 3, 0, 4 } };
            // secondMatrix = { { 2, 3 }, { -9, 0 }, { 0, 4 } };
            // 0,0 = 0,0 * 0,0 + 0,1 * 1, 0 + 0,2 * 2,0
            // 0,1 = 0,0 * 0,1 + 0,1 * 1, 1 + 0,2 * 2,1
            // 1,0 = 1,0 * 0,0 + 1,1 * 1, 0 + 1,2 * 2,0
            // 1,1 = 1,0 * 0,1 + 1,1 * 1, 1 + 1,2 * 2,1
            if (firstMatrix.length < secondMatrix.length) {
                count = count + firstMatrix[first][i] * secondMatrix[i][second];
            }
            // firstMatrix = { { 2, 3 }, { -9, 0 }, { 0, 4 } };
            // secondMatrix = { { 3, -2, 5 }, { 3, 0, 4 } };
            // 0,0 = 0,0*0,0 + 1,0*0,1 + 3,0*0,3
            // 0,1 = ......
            // 1,0 = ......
            // 1,1 = ......
            else {
                count = count + firstMatrix[i][first] * secondMatrix[second][i];
            }
        }
        return count;
    }
}
