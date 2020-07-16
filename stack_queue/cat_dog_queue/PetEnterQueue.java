package stack_queue.cat_dog_queue;

public class PetEnterQueue {
    private Pet pet;
    private Integer count;

    public PetEnterQueue(Pet pet,Integer count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public Integer getCount(){
        return this.count;
    }

    public String getPetType(){
        return this.pet.getType();
    }
}
