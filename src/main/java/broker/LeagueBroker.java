package broker;

import domain.League;
import domain.records.LeagueRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for League
 * @author jenniferstreit
 */
public class LeagueBroker {
    
    /**
     * Gets all the Leagues in the database
     * @return a list of all leagues in the database
     */
    public List<League> findAll() {
        return LeagueRecord.findAll().stream()
                .map(rec -> new League((LeagueRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a league from the database based on the id 
     * @param id, the id of a league in the database
     * @return a league object
     */
    public League findById(Long id) {
        return new League(LeagueRecord.findById(id));
    }
    
    /**
     * Method for creating a new league
     * @return a new League object
     */
    public League create() {
        return new League(new LeagueRecord());
    }
    
    /**
     * Saves the changes for a specific league
     * @param l, the selected league for saving changes 
     */
    public void save(League l) {
        l.getRecord().saveIt();
    }
}
