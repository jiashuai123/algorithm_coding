package stack_queue;

import java.util.Stack;

public class SortStackByStack {

    public Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> stack1 = new Stack<>();
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            while(!stack1.isEmpty() && tmp>stack1.peek())//此处两个条件不能交换，否者会产生栈空异常
                stack.push(stack1.pop());
            stack1.push(tmp);
        }
        while(!stack1.isEmpty()){
            stack.push(stack1.pop());
        }

        return stack;
    }

    public static void main(String[] args){
        SortStackByStack sortStackByStack = new SortStackByStack();
        GenerateArray generateArray = new GenerateArray();
        int[] arr = generateArray.gennerateArray(10,100);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        System.out.println(stack);
        System.out.println(sortStackByStack.sort(stack));
    }
}
