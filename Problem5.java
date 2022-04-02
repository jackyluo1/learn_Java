import java.util.Scanner;

// Find factorial of a number. 
// The factorial of a positive number n is given by: 
// factorial of n, (n!) = 1 * 2 * 3 * 4 * ... * n
// 

public class Problem5 {
    public static void main(String[] args) {
        int num;
        System.out.println("Please enter your number: ");
        Scanner keyboard = new Scanner(System.in);
        num = keyboard.nextInt();
        long factorial = 1;
        // Put your code here:

        factorial = factorial(num);

        System.out.println("Factorial of " + num + " is: " + factorial + ". ");
        keyboard.close();
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1; // base 1
        } else if (n == 2) {
            return 2; // base 2
        } else {
            return factorial(n - 1) * n; // recursion
        }

    }
}
