//package at.ac.fhwn.sae.lesson3.homework3;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class AnimalFarm_new {
//    public static Scanner in = new Scanner(System.in);
//    public static List<Animal> list = new ArrayList<>();
//
//    private static MainMenuAction showMainMenu(){
//
//        System.out.println("Was möchten Sie tun:");
//        System.out.println("1. Tiere hinzugügen\n" + "2. Tiere anzeigen\n" + "3. Tiere nach Art anzeigen\n" + "4. Tiere entfernen\n" + "5. Programm beenden");
//
//        String enteredNumber = in.nextLine();
//        int parsedNumber = Integer.parseInt(enteredNumber);
//        System.out.println("Animals");
//        return MainMenuAction.values()[parsedNumber-1];
//    }
//
//
//    private static AnimalKind animalKind(){
//
//    }
//
//    public static void main(String[] args){
//
//        MainMenuAction currentaction = showMainMenu();
//
//
//        while (currentaction != MainMenuAction.EXIT){
//
//            if (currentaction == MainMenuAction.ADD_ANIMAL) {
//                addAnimal(list, in);
//            }
//
//            if (currentaction == MainMenuAction.SHOW_ALL_ANIMALS) {
//                printHead();
//                int count = 0;
//                for (Animal animal:list ){
//                    count ++;
//                    System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
//                }
//            }
//
//            if (currentaction == MainMenuAction.SHOW_ANIMAL_KIND) {
//                AnimalKind animalKind = askForAnimalKind("Weche Tiere wollen Sie anzeigen");
//
//                System.out.println("Welche Tierart wollen Sie anzeigen?");
//                System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");
//                new Scanner(System.in);
//                int selectedanimal = in.nextInt();
//                printAnimalList(list, selectedanimal);
//            }
//
//            if (currentaction == MainMenuAction.DELETE_ANIMAL) {
//                System.out.println("Welche Tierart wollen Sie entfernen?");
//                System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");
//
//                new Scanner(System.in);
//                int selectedanimal = in.nextInt();
//                printAnimalList(list, selectedanimal);
//
//                System.out.println("Nummer des Tieres das gelöscht werden soll: ");
//                String animalnumber = in.next();
//
//                for (Animal animal:list) {
//                    if (animal.getId().equals(animalnumber)) {
//                        list.remove(animal);
//                        break;
//                    }
//                }
//
//            }
//
//        }
//    }
//
//    private static void addAnimal(List<Animal> list, Scanner in) {
//
//        AnimalKind animalKind = animalKind("Welche Tierart wollen Sie hinzufügen?");
//        System.out.println("Bitte gebene Sie einen Namen für ihr Tier ein: ");
//        askForAnimalKind(animalKind);
//        String enteredName = in.nextLine();
//        Animal animal = new AnimalFactory().getAnimal(animalKind, enteredName);
//
//
//
//        System.out.println("1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn");
//
//        new Scanner(System.in);
//        int selectedanimal = in.nextInt(); // mit read line austauschen!!!!
//
//
//        new Scanner(System.in);
//        String animalname = in.next();
//
//        switch (animalKind) {
//            case HORSE:
//                list.add(new Horse(animalname));
//                break;
//            case COW:
//                list.add(new Cow(animalname));
//                break;
//            case PIG:
//                list.add(new Pig(animalname));
//                break;
//            case CHICKEN:
//                list.add(new Chicken(animalname));
//                break;
//        }
//    }
//
//    private static void askForAnimalKind(AnimalKind animalKind) {
//        System.out.println("Geben Sie einen Namen für das Tier " + animalKind + " ein: ");
//    }
//
//    static void printAnimals(List<Animal> animals){
//
//    }
//
//    static void printAnimals(List<Animal> animals, AnimalKind animalKind){
//        List <Animal> animalofKind = getAnimalKindList(animals, animalKind);
//        printAnimals(animalofKind);
//    }
//
//    private static List<Animal> getAnimalKindList(List<Animal> animals, AnimalKind animalKind) {
////        return animals.stream().filter(animal -> animalKind.getAnimalClass().isInstance(animal)).collect(Collectors.toList());
//    }
//
//
//
//
//    /**
//     * prints the head of the list
//     **/
//    private static void printHead(){
//        System.out.printf("%-5s|%-5s|%-8s\n", "Nr.", "Id", "Name");
//        System.out.println("—---------------------");
//    }
//
//    /**
//     * prints an anmimal list of the selected Animaltype
//     * 1 = Horse
//     * 2 = Cow
//     * 3 = Pig
//     * 4 = Chicken
//     *@param selectedanimal the animal that is selected
//     **/
//    private static void printAnimalList(List<Animal> list, int selectedanimal) {
//        printHead();
//        int count;
//        switch (selectedanimal){
//            case 1:
//                count = 0;
//                for (Animal animal:list ){
//                    if(animal instanceof Horse) {
//                        count++;
//                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
//                    }
//                }
//                break;
//            case 2:
//                count = 0;
//                for (Animal animal:list ){
//                    if(animal instanceof Cow) {
//                        count++;
//                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
//                    }
//                }
//                break;
//            case 3:
//                count = 0;
//                for (Animal animal:list ){
//                    if(animal instanceof Pig) {
//                        count++;
//                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
//                    }
//                }
//                break;
//            case 4:
//                count = 0;
//                for (Animal animal:list ){
//                    if(animal instanceof Chicken) {
//                        count++;
//                        System.out.printf("%-5s|%-5s|%-8s\n", count, animal.getId(), animal.name);
//                    }
//                }
//                break;
//        }
//
//    }
//}
