package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson4.homework4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class LocationService {
    Hashtable<Integer, List<SaePoint>> locations = new Hashtable<>();

    public void addLocation(int id, SaePoint location) {
        if(locations.containsKey(id)) {
            locations.get(id).add(location);
        } else {
            locations.put(id, new ArrayList<>());
            locations.get(id).add(location);
        }
    }

    public SaePoint getLocation(int id, Integer index){
        return locations.get(id).get(locations.get(id).size()-index);
    }

    public List<SaePoint> getLocations(int id){
        return locations.get(id);
    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations(){
        return locations;
    }

}
