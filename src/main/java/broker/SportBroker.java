package broker;

import domain.Sport;
import domain.records.SportRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for sport
 * @author jenniferstreit
 */
public class SportBroker {
    
    /**
     * This method returns a list of the sports in the database
     * @return a list of all sports
     */
    public List<Sport> findAll() {
        return SportRecord.findAll()
                .stream()
                .map(rec -> new Sport((SportRecord)rec))
                .collect(Collectors.toList());
    } 
    
    /**
     * The method gets a sport from the database based on the id
     * @param sportId, the id of a sport in the database
     * @return a sport object
     */
    public Sport findById(Long sportId) {
        return new Sport(SportRecord.findById(sportId));
    }
    
    /**
     * Searches the database after a sport by a specific name
     * @param name, the name of the sport 
     * @return a sport object or null if the list is empty
     */
    public Sport findByName(String name) {
        List<SportRecord> sr = SportRecord.where("name = ?", name);
        if (sr.isEmpty()) {
            return null; 
        }
        return new Sport(sr.get(0));
    }
    
//    /**
//     * Checks the database if a specific sport exists
//     * @param name, the name of the sport
//     * @return true if the sport exists otherwise false
//     */
//    public boolean doesSportNameExist(String name) {
//        List<SportRecord> sr = SportRecord.where("name = ?", name);
//        if (sr.isEmpty()) {
//            return false; 
//        } else {
//            return true;
//        }
//    }
    
    /**
     * Method that creates a new sport
     * @return a new sport object
     */
    public Sport create() {
        return new Sport(new SportRecord()); 
    }
    
    /**
     * Saves the changes for a specific sport
     * @param s, the selected sport for saving changes
     */
    public void save(Sport s) {
        s.getRecord().saveIt();
    }
    
    
}
