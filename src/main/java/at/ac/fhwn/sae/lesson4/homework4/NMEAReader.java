package at.ac.fhwn.sae.lesson4.homework4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NMEAReader {

    private Scanner scanner;
    private final File file;

    public NMEAReader(File nmeaFile){
        file = nmeaFile;
        try {
            assert nmeaFile.exists();
            FileInputStream fis=new FileInputStream(nmeaFile);
            scanner = new Scanner(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SaePoint readPoint(){
        SaePoint saePoint = null;

        while (saePoint == null && scanner.hasNext()) {
            String line;
            line = scanner.nextLine();
            if(line==null){
                return null;
            }
            String[] values = line.split(",");

            if (values[0].equals("$GNGGA")){
                String time = values[1];
                double latitude = Double.parseDouble(values[2].substring(0,2)) +
                                  Double.parseDouble(values[2].substring(2))/60;
                double longitude = Double.parseDouble(values[4].substring(0,3)) +
                                   Double. parseDouble(values[4].substring(3))/60;
                int fix = Integer.parseInt(values[6]);
                int numberOfSatelites = Integer.parseInt(values[7]);

                saePoint = new SaePoint(time, latitude, longitude, fix, numberOfSatelites);
            }

            if(!scanner.hasNextLine()){
                assert file.exists();
                FileInputStream fis = null;
                try{
                    fis = new FileInputStream(file);
                    this.scanner= new Scanner(fis);
                } catch (FileNotFoundException e){
                    throw new RuntimeException(e);
                }
                return this.readPoint();
            }
        }
        return saePoint;
    }

}
