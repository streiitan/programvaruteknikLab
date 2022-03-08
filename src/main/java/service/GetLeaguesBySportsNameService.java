package service;

import db.DbConn;
import domain.League;
import domain.Sport;
import java.util.List;

/**
 * Gets a list of the leagues in a specific sport
 * @author jenniferstreit
 */
public class GetLeaguesBySportsNameService {
    private Sport sport;
    private List<League> leagues;
    private final String sportName;
    
    /**
     * 
     * @param sportName,  the name of the sport that the selected League should play
     */
    public GetLeaguesBySportsNameService(String sportName) {
        this.sportName = sportName;
    }
    
    /**
     * 
     * @return List, a list if Leagues 
     */
    public List<League> execute() {
        DbConn.getInstance().open();
        this.sport = Sport.findByName(this.sportName);
        this.leagues = sport.getAllConnectedLeagues();
        DbConn.getInstance().close();
        return leagues;
    }
    
}
