package at.ac.fhwn.sae.lesson4.homework4;

public class SaePoint{
    private String time;
    private double latitude;
    private  double longitude;
    private int numberOfSatelites;
    private int fix;

    public SaePoint(){
    }

    public SaePoint(String time, double latitude, double longitude, int numberOfSatelites, int fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfSatelites = numberOfSatelites;
        this.fix = fix;

    }

    public String getTime(){
        return time;
    }
    public String getLatitude(){
        return String.valueOf(latitude);
    }
    public String getLongitude(){
        return String.valueOf(longitude);
    }
    public String getnumberOfSatelites(){
        return String.valueOf(numberOfSatelites);
    }
    public String getfix(){
        return String.valueOf(fix);
    }

    @Override
    public String toString() {
        return "SaePoint{" +
                "time='" + time + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", numberOfSatelites=" + numberOfSatelites +
                ", fix=" + fix +
                '}';

    }

}