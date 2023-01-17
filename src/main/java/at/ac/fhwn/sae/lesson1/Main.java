/* Alt und Enter kann man unterwelte Dinge auswählen und Probleme lösen*/
package at.ac.fhwn.sae.lesson1;

import at.ac.fhwn.sae.lesson3.Dog;

import java.util.Scanner;

public class Main {
    /* main ist immer der Einstiegspunkt für das Programm */
    public static void main(String[] args) {
        System.out.println("Hello world!");

// Steuerung dividiertzeichen am Nummernblock
        int number = 42;//this is a comment

        System.out.println(number);

        // Shift und F6 kann man den Namen im ganzen Code ändern
        final int constantVariable = 1; //constant

        boolean result = !(number != constantVariable);

        //Strg plus Leertaste
        System.out.println(result);

        number = 2;
        if(number >2){
            System.out.println("number " + number +  " is bigger than 2");
        }else{
            System.out.println("number " + number + " is smaller or equal 2");
        }

        double value = 56.532567464365;

        System.out.println(String.format("value is %.2f",value));

        Scanner in = new Scanner(System.in);
        System.out.print("Enter something:");
        String input = in.next();

        System.out.println("You entered: " + input);

        double enteredValue = Double.parseDouble(input);


        Dog dog = new Dog();
        dog.getName();


    }
}

