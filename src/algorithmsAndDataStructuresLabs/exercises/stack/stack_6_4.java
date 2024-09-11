package algorithmsAndDataStructuresLabs.exercises.stack;

import java.util.Stack;

public class stack_6_4 {
    public Stack<Integer> stackTrade(Stack<Integer> S, Stack<Integer> T) {
        while (!S.isEmpty()){
            T.push(S.pop());
            }
        return T;
    };
}
