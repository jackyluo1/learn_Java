import java.util.ArrayList;
import java.util.Stack;

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().getDecoded("[ab[cd]{1}]{2}"));

    }

    public String getDecoded(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a != '}') {
                stack.push(a);
                continue;
            }

            int x = 0;
            int y = 1;

            while (stack.peek() != '{') {
                x = ((stack.pop() - '0') * y) + x;
                y *= 10;
            }

            stack.pop();
            stack.pop();

            ArrayList<Character> list = new ArrayList<>();
            while (stack.peek() != '[') {
                list.add(stack.pop());
            }

            stack.pop();

            while (x-- > 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack.push(list.get(j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();

    }
}