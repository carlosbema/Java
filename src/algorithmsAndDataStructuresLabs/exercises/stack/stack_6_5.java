package algorithmsAndDataStructuresLabs.exercises.stack;

import java.util.Stack;

public class stack_6_5 {
    public void cleanStack(Stack<Integer> S) {
        if (S.isEmpty()) {
            return;
        }
        S.pop();
        cleanStack(S);
    };

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        System.out.println(S);

        stack_6_5 r = new stack_6_5();
        r.cleanStack(S);

        System.out.println(S);
    }
}
