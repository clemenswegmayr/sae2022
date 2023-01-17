package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.homework4.SaePoint;
import java.util.*;

import static at.ac.fhwn.sae.location.client.LocationClientService.*;
import static at.ac.fhwn.sae.location.client.LocationClientService.getLocations;

public class LocationReceiver {

    public static void main(String[] args) {
        boolean systemexit = false;

        while (!systemexit){
            System.out.println("Was wollen sie abfragen:");
            System.out.println( "1. Letze Position mit id\n2. Positon mit id\n3. Alle Positionen\n4. Programm beenden");
            Scanner in = new Scanner(System.in);
            int selected= in.nextInt();

            switch (selected) {
                case 1:
                    System.out.println("Geben Sie die id an");
                    int id = in.nextInt();

                    System.out.printf("%-12s|%-20s|%-20s|%-5s|%s\n", "time", "latitude", "longitude", "satNr", "fix");
                    SaePoint saePoint = getLocation(id);
                    System.out.printf("%-12s|%-20s|%-20s|%-5s|%s\n\n", saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getnumberOfSatelites(), saePoint.getfix());
                    break;

                case 2:
                    System.out.println("Geben Sie die id an");
                    id = in.nextInt();

                    System.out.printf("%-12s|%-20s|%-20s|%-5s|%s\n", "time", "latitude", "longitude", "satNr", "fix");

                    for(SaePoint points:getLocations(id)){
                        System.out.printf("%-12s|%-20s|%-20s|%-5s|%s\n", points.getTime(), points.getLatitude(), points.getLongitude(), points.getnumberOfSatelites(), points.getfix());
                    }
                    break;

                case 3:
                    System.out.printf("%-5s|%-12s|%-20s|%-20s|%-5s|%s\n", "id", "time", "latitude", "longitude", "satNr", "fix");
                    Hashtable<Integer,List<SaePoint>> allPoints= getAllLocations();
                    for (Map.Entry<Integer, List<SaePoint>> entry : allPoints.entrySet()) {
                        for(SaePoint points : entry.getValue()){
                            System.out.printf("%-5s|%-12s|%-20s|%-20s|%-5s|%s\n",  entry.getKey(),points.getTime(), points.getLatitude(), points.getLongitude(), points.getnumberOfSatelites(), points.getfix());
                        }
                    }
                    break;

                case 4:
                    systemexit = true;
                    break;
            }
        }
    }
}





