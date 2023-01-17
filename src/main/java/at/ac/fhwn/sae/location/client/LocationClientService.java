package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.homework4.SaePoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class LocationClientService{

    private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
    private static final String REQUEST_METHOD_GET_LOCATION = "/location";
    private static final String REQUEST_METHOD_GET_LOCATIONS = "/locations";
    private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/allLocations";
//    private static final String BASE_URL = "localhost:8080";
    private static final String BASE_URL = "https://location-server-wegmayr-spring-app-20230116160506.azuremicroservices.io";


    /**
     * returns the data from the url
     * @param url
     * @return stringBuffer.toString()
     */
    private static String getResponseString(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());

            StringBuffer stringBuffer = new StringBuffer();
            while (scanner.hasNextLine()){
                stringBuffer.append(scanner.nextLine());
            }
            return stringBuffer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * sends the current SaePoint to the server
     * @param pointToSend
     * @return saePoint
     */
    public static SaePoint sendLocation(SaePoint pointToSend, int id){
        try {
            String time = pointToSend.getTime();
            double lat = Double.parseDouble(pointToSend.getLatitude());
            double lon = Double.parseDouble(pointToSend.getLongitude());
            int satNr = Integer.parseInt(pointToSend.getnumberOfSatelites());
            int fix = Integer.parseInt(pointToSend.getfix());

            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL + REQUEST_METHOD_SET_LOCATION + "?id=" + id + "&lat=" + lat + "&lon=" + lon + "&time=" + time + "&satNr=" + satNr + "&fix=" + fix ).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            String input = scanner.nextLine();

            SaePoint saePoint = new ObjectMapper().readValue(input, SaePoint.class);
            return saePoint;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns the latest SaePoint of the Rover
     * @param id
     * @return point
     */
    public static SaePoint getLocation(int id){
        String json = getResponseString(BASE_URL + REQUEST_METHOD_GET_LOCATION+ "?id=" + id);

        try {
            SaePoint point = new ObjectMapper().readValue(json, SaePoint.class);
            return point;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns all SaePoints of the Rover
     * @param id
     * @return points
     */
    public static List<SaePoint> getLocations(int id){
        String jsonArray = getResponseString(BASE_URL + REQUEST_METHOD_GET_LOCATIONS+ "?id=" + id);

        List<SaePoint> points = null;
        try {
            points = new ObjectMapper().readValue(jsonArray, new TypeReference<List<SaePoint>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return points;
    }


    /**
     * retuns all SaePoints of all Rovers
     * @return alllocations
     */
    public static Hashtable<Integer,List<SaePoint>> getAllLocations() {
        String jsonArray = getResponseString(BASE_URL + REQUEST_METHOD_GET_ALL_LOCATIONS);

        Hashtable<Integer, List<SaePoint>> alllocations = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            alllocations = mapper.readValue(jsonArray, new TypeReference<Hashtable<Integer, List<SaePoint>>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return alllocations;
    }

}

