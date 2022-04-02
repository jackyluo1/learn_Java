import java.util.ArrayList;

class Solution {
    public static double format(double value) {
        value = (double) Math.round(value * 100) / 100;
        return value;
    }

    public static String format1(double value) {
        return String.format("%.2f", value).toString();
    }

    public static String mean(int[] c) {
        double sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += Integer.valueOf(c[i]);
        }
        double m = sum / c.length;
        return format1(m);
    }

    public static String mode(int[] c) {
        int count = 1;
        int temp = c[0];

        for (int each : c) {
            if (each == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                temp = each;
            }
        }
        return format1(temp);
    }

    public static String[] meanandmode(int[] c) {
        String[] res = new String[2];
        res[0] = mode(c);
        res[1] = mean(c);
        return res;
    }

    static int sumDigits(int numX, int numY) {
        int res = 0;
        for (int i = 0; i <= numX; i++) {
            int sum = 0;
            int x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum == numY) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // Read the integers X and Y
        // int X = in.nextInt();
        // int Y = in.nextInt();
        // int Z = in.nextInt();
        int[] c = new int[5];
        c[0] = 2;
        c[1] = 4;
        c[2] = 2;
        c[3] = 4;
        c[4] = 4;

        // String[] a = meanandmode(c);
        ArrayList<String> m = isprime(c);
        for (String i : m) {
            System.out.println(i);
        }
        // int result = sumDigits(X, Y);
        // System.out.println(result);
        // .close();

    }

    public static void reverseString(char[] s) {
        int r = s.length - 1;
        int l = 0;
        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static boolean isOk(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static ArrayList<String> isprime(int[] a) {
        ArrayList<String> list = new ArrayList<>();
        for (int each : a) {
            if (isOk(each)) {
                list.add("Y");
            } else {
                list.add("N");
            }
        }
        return list;
    }
}