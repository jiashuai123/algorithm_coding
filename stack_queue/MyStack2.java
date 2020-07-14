package stack_queue;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(Integer newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum < this.getMin()){
            this.stackMin.push(newNum);
        }else {
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }else {
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }

    public int getMin() {
        if(this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        return this.stackMin.peek();
    }


    public static void main(String[] args) {

        MyStack2 myStack2 = new MyStack2();

        int[] arr = gennerateArray(10, 100);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        for(int i=0;i<arr.length;i++){
            myStack2.push(arr[i]);
        }

        System.out.println();
        System.out.println(myStack2.getMin());

    }

    public static int[] gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

}
