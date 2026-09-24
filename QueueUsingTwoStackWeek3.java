import java.util.*;

public class QueueUsingTwoStackWeek3 {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                stack1.push(x);
            } else if (type == 2) {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    stack2.pop();
                }
            } else if (type == 3) {
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peek());
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    System.out.println(stack2.peek());
                }
            }
        }

        sc.close();
    }
}
