package stack_queue.cat_dog_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private Queue<PetEnterQueue> catQ;
    private Queue<PetEnterQueue> dogQ;
    private Integer count;  //提供一个全局变量

    public CatDogQueue(){
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new RuntimeException("err,no cat and no dog!");
        }
    }

    public Pet pollAll(){

        if(!this.catQ.isEmpty()&&!this.dogQ.isEmpty()){

            if(this.catQ.peek().getCount() > this.dogQ.peek().getCount()){
                return this.catQ.poll().getPet();
            }else
                return this.dogQ.poll().getPet();

        }else if(!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();

        }else if(!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();

        }else
            throw new RuntimeException("The queue is empty!");
    }

    public Cat pollCat(){
        if(!this.catQ.isEmpty()){
            return (Cat) this.catQ.poll().getPet(); //将父类转换成子类
        }else
            throw new RuntimeException("The cat queue is empty");
    }

    public Dog pollDog(){
        if(!this.dogQ.isEmpty()){
            return (Dog) this.dogQ.poll().getPet();  //将父类转换成子类
        }else
            throw new RuntimeException("The dog queue is empty!");
    }

    public Boolean isEmptyAll(){
        return this.catQ.isEmpty()&&this.dogQ.isEmpty();
    }

    public Boolean isEmptyCat(){
        return this.catQ.isEmpty();
    }

    public Boolean isEmptyDog(){
        return this.dogQ.isEmpty();
    }
}
