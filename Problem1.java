import java.util.Scanner;

/**
 * p1
 */
public class Problem1 {

    public static void main(String[] args) {

        Scanner start = new Scanner(System.in);
        System.out.println("-- Enter the text below:");
        String target = start.nextLine();
        System.out.print("-- Enter E for Encryption, D for Decryption, X to exit:");
        String cmd = start.nextLine();

        while (!cmd.equals("X")) {

            while (!cmd.equals("D") && !cmd.equals("E") && !cmd.equals("X")) {
                System.out.println("-- Input not recognized. Try again.");
                Scanner newcmd = new Scanner(System.in);
                System.out.print("-- Enter E for Encryption, D for Decryption, X to exit:");
                cmd = newcmd.nextLine();
                if (cmd.equals("X")) {
                    System.exit(0);
                    newcmd.close();
                }
            }

            String[] targetarr = target.split("");
            char result[] = new char[targetarr.length];

            if (cmd.equals("E")) {
                System.out.print("-- Enter key:");
                int key = start.nextInt();

                if (key < 0) {
                    System.out.println("The key k should be a positive integer!");
                    System.exit(0);
                }
                for (int i = 0; i < targetarr.length; i++) {
                    int each = target.charAt(i);
                    if (each >= 65 && each <= 90) { // for "A"-"Z"
                        int x = target.charAt(i) + key - 65;
                        int index = x % 26; // A to Z, it is 26. A = 1 ..... Z = 26
                        char res = (char) (index + 65); // reture the true index

                        result[i] = res;
                    } else if (each >= 97 && each <= 122) { // for "a"-"z"
                        int x = target.charAt(i) + key - 97;
                        int index = x % 26; // a to z, it is 26. a = 1 ..... z = 26
                        char res = (char) (index + 97); // reture the true index

                        result[i] = res;
                    } else {
                        char res = target.charAt(i);

                        result[i] = res;
                    }
                }
                System.out.println("-- The encrypted text is below");
                System.out.println(result);
            }

            if (cmd.equals("D")) {
                System.out.print("-- Enter key:");
                int key = start.nextInt();

                if (key < 0) {
                    System.out.println("The key k should be a positive integer!");
                    System.exit(0);
                }
                for (int i = 0; i < targetarr.length; i++) {
                    int each = target.charAt(i);

                    if (each >= 65 && each <= 90) {
                        int x = 90 - target.charAt(i) + key;
                        int index = x % 26;
                        char res = (char) (90 - index);

                        result[i] = res;
                    } else if (each >= 97 && each <= 122) {
                        int x = 122 - target.charAt(i) + key;
                        int index = x % 26;
                        char res = (char) (122 - index);

                        result[i] = res;
                    } else {
                        char res = target.charAt(i);

                        result[i] = res;
                    }
                }
                System.out.println("-- The decrypted text is below");
                System.out.println(result);
            }

            Scanner info = new Scanner(System.in);
            System.out.println("Another example");
            System.out.println("-- Enter the text below:");
            target = info.nextLine();
            System.out.print("-- Enter E for Encryption, D for Decryption, X to exit:");
            cmd = info.nextLine();
            if (cmd.equals("X")) {
                System.exit(0);
                info.close();
            }

        }
        start.close();
    }
}