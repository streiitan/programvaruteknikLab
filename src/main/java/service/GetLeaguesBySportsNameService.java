package service;

import domain.League;
import domain.Sport;
import java.util.List;

/**
 * Gets a list of the leagues in a specific sport
 * @author jenniferstreit
 */
public class GetLeaguesBySportsNameService extends BaseService<List<League>>{
    private Sport sport;
    private List<League> leagues;
    private final String sportName;
    
    /**
     * Constructor to save the sportName
     * @param sportName,  the name of the sport that the selected League should play
     */
    public GetLeaguesBySportsNameService(String sportName) {
        this.sportName = sportName;
    }
    
    /**
     * Gets a the leagues connected to a specific sport 
     * @return a list if Leagues 
     */
    public List<League> execute() {
        this.sport = getBrokerFactory().getSportBroker().findByName(this.sportName);
        this.leagues = sport.getAllConnectedLeagues();
        return leagues;
    }
    
}
