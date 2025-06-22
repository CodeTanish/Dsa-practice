package leetcode;

import java.util.Stack;

public class Myqueue <T>{

    Stack <T> inStack;
    Stack <T> outStack;
    
    public Myqueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(T x){
        inStack.push(x);
    }

    public T pop (){
        shiftStack();
        return outStack.pop();
    }

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStack(){
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

}
