package at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Körpergröße in cm:");
        double size = in.nextDouble();

        System.out.print("Körpergewicht in kg:");
        double weight = in.nextDouble();

        double BMI_RESULT = weight / Math.pow((size/100), 2);

        if(BMI_RESULT < 18.5) {
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Untergewicht");
        } else if(BMI_RESULT <= 24.9){
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Normalgewicht");
        }  else if(BMI_RESULT <= 29.9){
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Übergewicht => Präadipositas");
        } else if(BMI_RESULT <= 34.9){
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Übergewicht => Adipositas Grad 1 (moderate Adipositas)");
        } else if(BMI_RESULT <= 39.9){
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Übergewicht => Adipositas Grad 2 (starke Adipositas)");
        } else {
            System.out.println(String.format("Ihr BMI liegt bei: %.2f", BMI_RESULT));
            System.out.println("Sie sind: Übergewicht => Adipositas Grad III (extreme Adipositas)");
        }

    }
}
