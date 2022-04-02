public class Converter {
    /**
     * Converter HW1 Problem 2 Jing Luo
     */
    public static void main(String[] args) {
        long giga = 500;
        long gibi = 0;

        // your code for computing gibi from giga

        gibi = giga * 1000 * 1000 * 1000 / 1024 / 1024 / 1024;
        // we need not to convert it into 'K', we use 'M', 1Giga = 1000*1000*1000 , then
        // we divide 1024*1024*1024, so we can get the result.

        System.out.println(giga + "GB = " + gibi + "GiB");

    }
}