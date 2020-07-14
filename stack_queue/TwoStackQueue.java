package stack_queue;

import java.util.Stack;

/**
 * 这题有一种情况就是，一边入队一边出队的话(出队数少于入队数)是什么情况？
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    private Integer len = 0;

    public TwoStackQueue(){
        stackPop = new Stack<>();
        stackPush = new Stack<>();
    }

    public void pushToPop(){
        if(stackPop.isEmpty()){
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        }
    }

    public void add(Integer newNum){
        stackPush.push(newNum);
        len+=1;
    }

    public int peek(){
        if(stackPop.isEmpty()){
            if(stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }else pushToPop();
        }
        return stackPop.peek();
    }

    public int poll(){
        if(stackPop.isEmpty()){
            if(stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }else pushToPop();
        }
        len-=1;
        return stackPop.pop();
    }

    public static void main(String[] args) {

        TwoStackQueue twoStackQueue = new TwoStackQueue();

        int[] arr=gennerateArray(10, 100);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        for(int i=0;i<arr.length;i++){
            twoStackQueue.add(arr[i]);
        }

        System.out.println();
        System.out.println(twoStackQueue.peek());

        while(twoStackQueue.len > 0 ){
            System.out.print(twoStackQueue.poll()+" ");
        }

    }

    public static int[] gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }
}
