package broker;

import domain.Team;
import domain.records.TeamRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for Team
 * @author 19jest01
 */
public class TeamBroker {
    
    /**
     * Gets all the teams in the database
     * @return a list of all teams in the database
     */
    public List<Team> findAll() {
        return TeamRecord.findAll().stream()
                .map(rec -> new Team((TeamRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a team from the database based on the id
     * @param id, the id of a team in the database
     * @return a team object
     */
    public Team findById(Long id) {
        return new Team(TeamRecord.findById(id));
    }
    
    /**
     * Method for creating a new team
     * @return a new team object
     */
    public Team create() {
        return new Team(new TeamRecord());
    }
    
    /**
     * Saves the changes for a specific team
     * @param t, the selected team for saving changes
     */
    public void save(Team t) {
        t.getRecord().saveIt();
    }
}
