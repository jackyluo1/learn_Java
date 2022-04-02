package HW2;

import java.util.Scanner;

public class BillProgram {
    public static final Double taxRate = 0.0625;

    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        System.out.println("Input name of item 1:");
        String name1 = info.nextLine();
        System.out.println("Input quantity of item 1:");
        int quantity1 = info.nextInt();
        System.out.println("Input price of item 1:");
        float price1 = info.nextFloat();

        Scanner info2 = new Scanner(System.in);
        System.out.println("Input name of item 2:");
        String name2 = info2.nextLine();
        System.out.println("Input quantity of item 2:");
        int quantity2 = info2.nextInt();
        System.out.println("Input price of item 2:");
        float price2 = info2.nextFloat();

        Scanner info3 = new Scanner(System.in);
        System.out.println("Input name of item 3:");
        String name3 = info3.nextLine();
        System.out.println("Input quantity of item 3:");
        int quantity3 = info3.nextInt();
        System.out.println("Input price of item 3:");
        float price3 = info3.nextFloat();

        info.close();
        info2.close();
        info3.close();

        float total1 = (float) quantity1 * price1;
        float total2 = (float) quantity2 * price2;
        float total3 = (float) quantity3 * price3;
        float subtotal = (float) total1 + total2 + total3;
        Double tax = (Double) taxRate * subtotal;
        Double total = subtotal + tax;

        // To make my output visual, use 'printf'. and '\t','%s' for string,'%d' for
        // int, '%f' for float
        System.out.printf("\n\nYour bill:\n\n");
        System.out.printf("Item" + "\t" + "\t" + "Quantity" + "\t" + "Price" + "\t" + "Total\n");
        System.out.printf("%s %10d %14.2f %10.2f\n", name1, quantity1, price1, total1);
        System.out.printf("%s %10d %14.2f %10.2f\n", name2, quantity2, price2, total2);
        System.out.printf("%s %10d %14.2f %10.2f\n", name3, quantity3, price3, total3);
        System.out.printf("Subtotal %37.2f\n", subtotal);
        System.out.printf("6.25 percent sales tax %23.2f\n", tax);
        System.out.printf("Total%41.2f\n", total);

    }
}
