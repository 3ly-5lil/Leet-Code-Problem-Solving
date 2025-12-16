package stack.minStack;

import java.util.LinkedList;
import java.util.List;

// problem 155
public class MinStackWithMap {
    private final List<Integer> stack;
    private final List<Integer> mins;

    public MinStackWithMap() {
        stack = new LinkedList<>();
        mins = new LinkedList<>();
    }

    public void push(int val) {
        int min = Math.min(getMin(), val);
        stack.add(val);
        mins.add(min);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.removeLast();
            mins.removeLast();
        }
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.getLast();

        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if (!stack.isEmpty())
            return mins.getLast();

        return Integer.MAX_VALUE;
    }
}
