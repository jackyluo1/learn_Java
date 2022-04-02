
//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println("intput: " + Arrays.toString(arr));
        arr = doubleOddIndex(arr);
        System.out.println("-->output: " + Arrays.toString(arr));

        int[] arr1 = new int[6];
        Scanner input = new Scanner(System.in);
        System.out.println("Input a num:");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = input.nextInt();
        }

        System.out.println("intput: " + Arrays.toString(arr1));
        arr1 = doubleOddIndex(arr1);
        System.out.println("-->output: " + Arrays.toString(arr1));
        input.close();
    }

    public static int[] doubleOddIndex(int[] arr) {
        int[] res = new int[arr.length];
        for (int index = 0; index < arr.length; index++) {
            if (index % 2 != 0) {
                res[index] = arr[index] * 2; // double the value of the Odd Index num
            } else {
                res[index] = arr[index]; // just copy it
            }
        }
        return res;
    }

}
