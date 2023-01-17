package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {

    public static void main(String[] args){
        Dog dog = new Dog("Rex");
        Dog noNameDog = new Dog();
        dog.setName("Hugo");
        //        dog.name = "Rex";
        System.out.println(dog.getName().charAt(0));
        System.out.println(noNameDog.getName());

        dog.bark();
        System.out.println(Dog.getCount()+"dogs created");

        Cat cat = new Cat();
        System.out.println(cat.getName());

        List<Animal> list = new ArrayList<>();
        list.add(dog);
        list.add(noNameDog);
        list.add(cat);

//        for (int i = 0; i<list.size();i++){
//            System.out.println(list.get(i).name);
//        }

        for (Animal animal:list ){
            System.out.println(animal.name);
            if(animal instanceof Dog){      //Abfragen ob es ein Hund ist dann darf er belllen
                ((Dog) animal).bark();
            }
        }


        Person p = buildPerson(42, "Karl");
    }
    static Person buildPerson(int number, String name){
        Person person = new Person(number, name);
        return person;
    }

}
