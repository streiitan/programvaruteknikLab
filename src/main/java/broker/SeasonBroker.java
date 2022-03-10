package broker;

import java.util.List;
import domain.Season;
import domain.records.SeasonRecord;
import java.util.stream.Collectors;

/**
 * A broker class for Season
 * @author jenniferstreit
 */
public class SeasonBroker {
    
    /**
     * Gets all seasons in the database
     * @return a list of all Seasons in the database
     */
    public List<Season> findAll() {
        return SeasonRecord.findAll().stream()
                .map(rec -> new Season((SeasonRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a season from the database based on the id
     * @param id, the id of a season in the database
     * @return a season object
     */
    public Season findById(Long id) {
        return new Season(SeasonRecord.findById(id));
    }
    
    /**
     * Method that creates a new season
     * @return a new season object
     */
    public Season create() {
        return new Season(new SeasonRecord());
    }
    
    /**
     * Saves the changes for a specific season
     * @param s, the selected season for saving changes
     */
    public void save(Season s) {
        s.getRecord().saveIt();
    }
}
