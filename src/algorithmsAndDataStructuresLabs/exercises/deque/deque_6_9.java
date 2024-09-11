package algorithmsAndDataStructuresLabs.exercises.deque;

import algorithmsAndDataStructuresLabs.deque.Deque;

//Create a class to implement a Stack using a double-ended-queue
public class deque_6_9 {
    private Deque<Integer> deque;

    public Integer size(){
        return deque.size();
    }

    public Boolean isEmpty(){
        return deque.isEmpty();
    }

    public void push(Integer e){
        deque.addFirst(e);
    }

    public Integer pop(){
        if(deque.isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        return deque.removeFirst();
    }

    public Integer top(){
        if(deque.isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        return deque.first();
    }
}
