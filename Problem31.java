import java.util.ArrayList;
import java.util.List;

/**
 * [40 pts]
 * Design and implement an ArrayTool.class
 * - You will have an int array in this class, and this array CANNOT be visited
 * by other class directly.
 * - You could construct this class with TWO options:
 * - Construct without parameters -> the class will create an array of length 5
 * - Construct with an int value -> the class will create an array of that
 * length
 * - If the parameter is invalid, then use 5 instead.
 * - Implement a method reverse(), which will reverse the numbers in the array.
 * - You don't have to return anything.
 * - For example, [1,2,3,4,5] -> [5,4,3,2,1]
 * - Implement a method set(), which allows user to modify the numbers in the
 * array.
 * - You don't have to return anything.
 * - Two int parameters -- index and value.
 * - Check the parameters, if they are invalid, then don't change anything.
 * - Implement methods decrease()
 * - You don't have to return anything.
 * - Without parameter -> decrease all numbers in the array by 1.
 * - With an int value -> decrease all numbers in the array by that parameter.
 * - Try to avoid duplicate code
 * - Implement a static method numOfTools(), return the number of ArrayTool we
 * have created.
 * - public static int numOfTools()
 * - Tip: Maybe you need to declare something to count the number.
 * - Override toString()
 * - Should return the size of the array and the numbers in it.
 * - Format: "size: 5, [1,2,3,4,5]"
 */

class ArrayTool {
    private int[] arr;
    private static int count;

    public ArrayTool(int n) {
        if (n < 0) {
            n = 5;
        }

        int[] arr1 = new int[n];
        this.arr = arr1;
        count++;
    }

    public ArrayTool() {
        int[] arr1 = new int[5];
        this.arr = arr1;
        count++;
    }

    public void reverse() {
        // List<Object> list = Arrays.asList(this.arr);
        // Collections.reverse(list);
        int n = this.arr.length;
        int mid = n / 2;
        int[] newstr = new int[n];
        for (int i = 0; i <= mid; i++) {
            newstr[i] = this.arr[n - i - 1];
            newstr[n - i - 1] = this.arr[i];
        }

        for (int j = 0; j < newstr.length; j++) {
            this.arr[j] = newstr[j];
        }
    }

    public void set(int index, int value) {
        this.arr[index] = value;
    }

    public void decrease() {
        int n = this.arr.length;
        for (int i = 0; i < n; i++) {
            this.arr[i] = this.arr[i] - 1;
        }
    }

    public void decrease(int value) {
        int n = this.arr.length;
        for (int i = 0; i < n; i++) {
            this.arr[i] = this.arr[i] - value;
        }
    }

    public static int numOfTools() {
        int num = count;
        return num;
    }

    public String toString() {
        List<Integer> arrayList = new ArrayList<>();
        for (int each : this.arr) {
            arrayList.add(each);
        }
        return "size: " + this.arr.length + ", " + arrayList;
    }

    public static void main(String[] args) {
        ArrayTool a = new ArrayTool(5);
        ArrayTool b = new ArrayTool(4);
        ArrayTool c = new ArrayTool(-1);

        a.set(0, 1);
        a.set(1, 2);
        a.set(2, 3);
        a.set(3, 4);
        a.set(4, 5);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

        a.decrease(1);
        System.out.println("a - 1: " + a.toString());

        a.decrease(-1);
        System.out.println("a - (-1): " + a.toString());

        a.reverse();
        System.out.println("Reserve_a: " + a.toString());

        System.out.println("numOfTools: " + numOfTools());

    }

}
