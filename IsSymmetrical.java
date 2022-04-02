package HW2;

import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.lang.Math;

/**
 * IsSymmetrical
 */
public class IsSymmetrical {

    public static void main(String[] args) {

        String str1 = "0220";
        String str2 = "111";
        String str3 = "6890";
        String str4 = "6789876";
        String str5 = "333256";

        // Test the 5 case
        HasSymmetrical(str1);
        HasSymmetrical(str2);
        HasSymmetrical(str3);
        HasSymmetrical(str4);
        HasSymmetrical(str5);

    }

    public static void HasSymmetrical(String str) {
        int length = str.length();
        int mid = (int) Math.floor(length / 2);
        String leftside = str.substring(0, mid);
        String rightside = str.substring(mid);

        // We recerse rightside to match with the leftside.
        String reverserightside = new StringBuffer(rightside).reverse().toString();

        if (length % 2 != 0) {
            // Which means: it is odd and the mid item in the reverserightside
            // the mid item is the last one now, it is odd so we delet it
            reverserightside = reverserightside.substring(0, reverserightside.length() - 1);
        }

        // if leftside == reverserightside, it is symmetrical
        if (leftside.compareTo(reverserightside) == 0) {
            System.out.println(str + " is symmetrical!");
        } else {
            System.out.println(str + " is not symmetrical!");
        }
    }
}