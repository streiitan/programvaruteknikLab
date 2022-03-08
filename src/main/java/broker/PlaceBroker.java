package broker;

import domain.Place;
import domain.records.PlaceRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for Place
 * @author jenniferstreit
 */
public class PlaceBroker {
    
    /**
     * Gets all the Places in the database
     * @return a list of all places in the database
     */
    public List<Place> findAll() {
        return PlaceRecord.findAll().stream()
                .map(rec -> new Place((PlaceRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a place from the database based on the id
     * @param id, the id of a place in the database
     * @return a place object
     */
    public Place findById(Long id) {
        return new Place(PlaceRecord.findById(id));
    }

    /**
     * Method for creating a new place
     * @return a new Place object
     */
    public Place create() {
        return new Place(new PlaceRecord());
    }
    
    /**
     * Saves the changes for a specific place
     * @param p, the selected place for saving changes
     */
    public void save(Place p) {
        p.getRecord().saveIt();
    }
}
