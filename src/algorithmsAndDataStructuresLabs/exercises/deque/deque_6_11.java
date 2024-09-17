package algorithmsAndDataStructuresLabs.exercises.deque;

import algorithmsAndDataStructuresLabs.deque.ArrayDeque;

public class deque_6_11 {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(9);
        deque.addFirst(1);
        System.out.println(deque.last());
        System.out.println(deque.isEmpty());
        deque.addFirst(2);
        System.out.println(deque.removeLast());
        deque.addLast(7);
        System.out.println(deque.first());
        System.out.println(deque.last());
        deque.addLast(4);
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
    }
}
