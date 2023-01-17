package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson4.homework4.SaePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;

@RestController
public class LocationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;

    }

    @GetMapping ("setLocation")
    public SaePoint setLocation(
            @RequestParam("id") int id,
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam("time") String time,
            @RequestParam("satNr") int satNr,
            @RequestParam("fix") int fix

    ){
        SaePoint saePoint = new SaePoint(time, lat, lon, satNr, fix);
        locationService.addLocation(id, saePoint);
        logger.info("Point received: "+ lat + ";"+ lon);
        return saePoint;
    }

    @GetMapping("/location")
    public SaePoint location(
            @RequestParam("id") int id,
            @RequestParam(name = "index", required=false) Integer index
    ){
        if (index == null){
            return locationService.getLocation(id, 1);
        }else {
            return locationService.getLocation(id, index);
        }
    }

    @GetMapping("/locations")
    public List<SaePoint> locations(
            @RequestParam("id") int id
    ){
        return locationService.getLocations(id);
    }

    @GetMapping("/allLocations")
    public Hashtable<Integer, List<SaePoint>> allLocations(){
        return locationService.getAllLocations();
    }

}