package at.ac.fhwn.sae.lesson3.homework3;

public class Cow extends Animal{
    public static int count = 0;
    private String id;

    /**
     *  Ctor with name parameter
     * @param name the name of the cow
     */
    public Cow(String name){
        this.name = name;
        if (count < 9){
            this.id = "K00" + ++count;
        }
        else if (count < 99){
            this.id = "K0" + ++count;
        }
        else {
            this.id = "K" + ++count;
        }
    }

    public String getId() {
        return id;
    }

}
