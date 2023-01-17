package at.ac.fhwn.sae.lesson3.homework3;

public class Chicken extends Animal{
    public static int count = 0;
    private String id;

    /**
     *  Ctor with name parameter
     * @param name the name of the chicken
     */
    public Chicken(String name){
        this.name = name;
        if (count < 9){
            this.id = "H00" + ++count;
        }
        else if (count < 99){
            this.id = "H0" + ++count;
        }
        else {
            this.id = "H" + ++count;
        }
    }

    public String getId() {
        return id;
    }
}
