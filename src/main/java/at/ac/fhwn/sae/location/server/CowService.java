package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson3.homework3.Cow;
import at.ac.fhwn.sae.lesson4.homework4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class CowService {

    Hashtable<Integer, Cow> cows = new Hashtable<>();

//    static int iterator = 0;

    public void helloWorld(Cow cow, int index){
        System.out.println("Hello World");

        cows.put(index, cow);
    }

    public Hashtable<Integer, Cow> getCows(){
        return cows;
    }

    //List
//    public List<Cow> getCows(){
//        return cows;
//    }




}

