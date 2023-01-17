package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.homework4.NMEAReader;
import at.ac.fhwn.sae.lesson4.homework4.SaePoint;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import static at.ac.fhwn.sae.location.client.LocationClientService.sendLocation;

public class LocationTransmitter {

    public static void main(String[] args) {

        File file = new File(NMEAReader.class.getClassLoader().getResource("auto.txt").getFile());
        NMEAReader nmeaReader = new NMEAReader(file);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SaePoint saePoint = nmeaReader.readPoint();
                System.out.println(sendLocation(saePoint, 42));
            }
        };

        Timer timer = new Timer("timerTask");
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }
}
