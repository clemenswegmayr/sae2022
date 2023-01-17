package at.ac.fhwn.sae.lesson3;

public class Dog extends Animal{

    public static final String CLASS_DESCRIPTION = "This class is a dog";

    private  static final String DEFAULT_DOG_NAME = "default dog name";

    public static int count = 0;
    private String id;

    public Dog(){
        this.name = DEFAULT_DOG_NAME;
        this.id = "D" + ++count;
    }

    /**
     *  Ctor with name parameter
     * @param name the name of the dog
     */
    public Dog(String name){
        this.name = name;
        this.id = "D" + ++count; // ++count Variable wird um 1 erhöht, count++ die Variable wird einesetzt und dann erhöht
    }

    public void bark(){
        System.out.println("Wuff");
    }

    public String getId() {
        return id;
    }

    /**
     * return the number of dogs
     * @return
     */
    public static int getCount(){
        return count;
    }
}
