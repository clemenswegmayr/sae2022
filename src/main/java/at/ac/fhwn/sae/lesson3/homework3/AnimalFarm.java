package at.ac.fhwn.sae.lesson3.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {
    public static void main(String[] args){
        boolean systemexit = false;
        List<Animal> list = new ArrayList<>();

        while (!systemexit){
            System.out.println("Was möchten Sie tun:");
            System.out.println("1. Tiere hinzugügen\n" + "2. Tiere anzeigen\n" + "3. Tiere nach Art anzeigen\n" + "4. Tiere entfernen\n" + "5. Programm beenden");

            Scanner in = new Scanner(System.in);
            int selected= in.nextInt();

            if (selected == 1) {
                System.out.println("Welche Tierart wollen Sie hinzufügen?");
                System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");

                new Scanner(System.in);
                int selectedanimal = in.nextInt(); // mit read line austauschen!!!!

                System.out.println("Geben Sie einen Namen für das Tier ein: ");
                new Scanner(System.in);
                String animalname = in.next();

                switch (selectedanimal) {
                    case 1:
                        list.add(new Horse(animalname));
                        break;
                    case 2:
                        list.add(new Cow(animalname));
                        break;
                    case 3:
                        list.add(new Pig(animalname));
                        break;
                    case 4:
                        list.add(new Chicken(animalname));
                        break;
                }
            }

            if (selected == 2) {
                printHead();
                int count = 0;
                for (Animal animal:list ){
                    count ++;
                    System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
                }
            }

            if (selected == 3) {
                System.out.println("Welche Tierart wollen Sie anzeigen?");
                System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");
                new Scanner(System.in);
                int selectedanimal = in.nextInt();
                printAnimalList(list, selectedanimal);
            }

            if (selected == 4) {
                System.out.println("Welche Tierart wollen Sie entfernen?");
                System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");

                new Scanner(System.in);
                int selectedanimal = in.nextInt();
                printAnimalList(list, selectedanimal);

                System.out.println("Nummer des Tieres das gelöscht werden soll: ");
                String animalnumber = in.next();

                for (Animal animal:list) {
                    if (animal.getId().equals(animalnumber)) {
                        list.remove(animal);
                        break;
                    }
                }

            }
            if (selected == 5) {
                    systemexit = true;
            }

        }
    }


    /**
     * prints the head of the list
     **/
    private static void printHead(){
        System.out.printf("%-5s|%-5s|%-8s\n", "Nr.", "Id", "Name");
        System.out.println("—---------------------");
    }

    /**
     * prints an anmimal list of the selected Animaltype
     * 1 = Horse
     * 2 = Cow
     * 3 = Pig
     * 4 = Chicken
     *@param selectedanimal the animal that is selected
     **/
    private static void printAnimalList(List<Animal> list, int selectedanimal) {
        printHead();
        int count;
        switch (selectedanimal){
            case 1:
                count = 0;
                for (Animal animal:list ){
                    if(animal instanceof Horse) {
                        count++;
                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
                    }
                }
                break;
            case 2:
                count = 0;
                for (Animal animal:list ){
                    if(animal instanceof Cow) {
                        count++;
                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
                    }
                }
                break;
            case 3:
                count = 0;
                for (Animal animal:list ){
                    if(animal instanceof Pig) {
                        count++;
                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
                    }
                }
                break;
            case 4:
                count = 0;
                for (Animal animal:list ){
                    if(animal instanceof Chicken) {
                        count++;
                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
                    }
                }
                break;
        }

    }
}
