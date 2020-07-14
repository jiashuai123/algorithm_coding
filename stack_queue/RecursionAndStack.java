package stack_queue;

import java.util.Stack;

public class RecursionAndStack {

    /**
     * 用于返回并删除栈底元素
     * @param stack
     * @return
     */
    public int getAndRemoveLastElement(Stack<Integer> stack){
        //取出并删除栈顶元素
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;//设定递归的返回条件
        }else {
            int last = getAndRemoveLastElement(stack);//递归直到返回栈底元素
            stack.push(result);//将栈底上面的元素重新压回去
            return last;//返回栈底元素
        }
    }

    /**
     * 对栈元素转置
     * @param stack
     */
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){//设置地规定返回条件
            return;
        }
        int last = getAndRemoveLastElement(stack);//取出栈底元素
        reverse(stack);//递归进行，直到栈为空
        stack.push(last);//栈中元素取完之后在将系统栈中保存的元素依次压入
    }

    public static void main(String[] args) {

        //创建一个数组
        GenerateArray generateArray = new GenerateArray();
        int[] arr = generateArray.gennerateArray(10,100);

        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]);
        }

        //验证目标函数的效果
        System.out.println(stack);
        RecursionAndStack recursionAndStack = new RecursionAndStack();
        recursionAndStack.reverse(stack);
        System.out.println(stack);

    }
}
