package HW2;

import java.util.Scanner;

import javax.naming.event.NamingExceptionEvent;

/**
 * slopeOfLine
 */
public class SlopeOfLine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the x-value of the first point: ");
        int xp = input.nextInt();
        System.out.print("Enter the y-value of the first point: ");
        int yp = input.nextInt();
        System.out.print("Enter the x-value of the second point: ");
        int xq = input.nextInt();
        System.out.print("Enter the y-value of the second point: ");
        int yq = input.nextInt();
        input.close();

        if (xp == xq) {
            if (yp != yq) {
                System.out.println("The line is vertical!");
            } else {
                System.out.println("This is not a line but a point!");
            }
        } else {
            float m = (float) (yp - yq) / (xp - xq);
            System.out.println("The slope of this line is " + m);
        }
    }
}