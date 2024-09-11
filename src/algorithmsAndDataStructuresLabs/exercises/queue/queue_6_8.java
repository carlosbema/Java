package algorithmsAndDataStructuresLabs.exercises.queue;

//Which are the returned value after the following operations, if executed in a empty queue?
//enqueue(5), enqueue(3), dequeue(), enqueue(2), enqueue(8), dequeue(), dequeue(), enqueue(9),
//enqueue(1), dequeue(), enqueue(7), enqueue(6), dequeue(), dequeue(), enqueue(4), dequeue(),
//dequeue().
import algorithmsAndDataStructuresLabs.queue.ArrayQueue;
public class queue_6_8 {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(5);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(9);
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(7);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
