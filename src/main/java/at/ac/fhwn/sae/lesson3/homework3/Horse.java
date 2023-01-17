package at.ac.fhwn.sae.lesson3.homework3;

public class Horse extends Animal{
    public static int count = 0;
    private String id;

    /**
     *  Ctor with name parameter
     * @param name the name of the horse
     */
    public Horse(String name){
        this.name = name;
        if (count < 9){
            this.id = "P00" + ++count;
        }
        else if (count < 99){
            this.id = "P0" + ++count;
        }
        else {
            this.id = "P" + ++count;
        }

    }

    public String getId() {
        return id;
    }

}
