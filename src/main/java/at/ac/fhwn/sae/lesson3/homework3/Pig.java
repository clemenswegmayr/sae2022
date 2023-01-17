package at.ac.fhwn.sae.lesson3.homework3;

public class Pig extends Animal{
    public static int count = 0;
    private String id;

    /**
     *  Ctor with name parameter
     * @param name the name of the pig
     */
    public Pig (String name) {
        this.name = name;
        if (count < 9) {
            this.id = "S00" + ++count;
        } else if (count < 99) {
            this.id = "S0" + ++count;
        } else {
            this.id = "S" + ++count;
        }
    }


    public String getId() {
        return id;
    }

}
