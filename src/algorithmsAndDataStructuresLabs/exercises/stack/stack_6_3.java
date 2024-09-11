package algorithmsAndDataStructuresLabs.exercises.stack;
import algorithmsAndDataStructuresLabs.stack.ArrayStack;
import algorithmsAndDataStructuresLabs.stack.Stack;

public class stack_6_3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();

        stack.push(5);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(9);
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(7);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
