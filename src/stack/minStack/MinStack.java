package stack.minStack;

import java.util.LinkedList;
import java.util.List;

// problem 155
public class MinStack {
    private final List<int[]> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        int min = Math.min(getMin(), val);
        stack.add(new int[]{val, min});
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.removeLast();
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.getLast()[0];

        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if (!stack.isEmpty())
            return stack.getLast()[1];

        return Integer.MAX_VALUE;
    }
}

