import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ImplementStack<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public void push(T e ){
        this.list.add(e);
    }

    public T pop(){
        if ( this.list.size() > 0){
            T e = this.list.get(list.size() -1 );
            this.list.remove(list.size()-1);
            return e;
        }
        throw new EmptyStackException();
    }

    public boolean isEmpty(){
        return this.list.size() == 0;
    }

    public static void main(String[] args) {
        ImplementStack<String> stack = new ImplementStack<>();
        stack.push("A"); stack.push("B"); stack.push("C");
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}
