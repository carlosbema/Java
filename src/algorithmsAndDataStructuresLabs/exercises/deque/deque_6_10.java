package algorithmsAndDataStructuresLabs.exercises.deque;

import algorithmsAndDataStructuresLabs.deque.Deque;
//Create a class to implement a Queue using a double-ended-queue
public class deque_6_10 {
    private Deque<Integer> deque;

    public Integer size(){
        return deque.size();
    }

    public Boolean isEmpty(){
        return deque.isEmpty();
    }

    public void enqueue(Integer item){
        deque.addFirst(item);
    }

    public Integer dequeue(){
        if(deque.isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        return deque.removeFirst();
    }

    public Integer first(){
        if(deque.isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        return deque.first();
    }
}
