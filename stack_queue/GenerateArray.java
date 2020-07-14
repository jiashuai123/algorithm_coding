package stack_queue;

import java.util.Stack;

public class GenerateArray {

    public int[] gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

    public void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
}
