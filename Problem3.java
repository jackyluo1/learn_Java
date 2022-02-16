/**
 * [40 pts]
 * Design and implement an ArrayTool.class
 * - You will have an int array in this class, and this array CANNOT be visited by other class directly.
 * - You could construct this class with TWO options:
 *     - Construct without parameters -> the class will create an array of length 5
 *     - Construct with an int value -> the class will create an array of that length
 *         - If the parameter is invalid, then use 5 instead.
 * - Implement a method reverse(), which will reverse the numbers in the array.
 *     - You don't have to return anything.
 *     - For example, [1,2,3,4,5] -> [5,4,3,2,1]
 * - Implement a method set(), which allows user to modify the numbers in the array.
 *     - You don't have to return anything.
 *     - Two int parameters -- index and value.
 *     - Check the parameters, if they are invalid, then don't change anything.
 * - Implement methods decrease()
 *     - You don't have to return anything.
 *     - Without parameter -> decrease all numbers in the array by 1.
 *     - With an int value -> decrease all numbers in the array by that parameter.
 *     - Try to avoid duplicate code
 * - Implement a static method numOfTools(), return the number of ArrayTool we have created.
 *     - public static int numOfTools()
 *     - Tip: Maybe you need to declare something to count the number.
 * - Override toString()
 *     - Should return the size of the array and the numbers in it.
 *     - Format: "size: 5, [1,2,3,4,5]"
 */
