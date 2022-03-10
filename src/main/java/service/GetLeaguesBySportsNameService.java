package service;

import broker.BrokerFactory;
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
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    
    /**
     * Constructor to save the sportName
     * @param sportName,  the name of the sport that the selected League should play
     */
    public GetLeaguesBySportsNameService(String sportName) {
        this.sportName = sportName;
    }
    
    /**
     * Gets the necessary dependencies 
     * @param dbConn, the connection to database
     * @param brokerFactory, enables the class to get a broker without creating
     * a dependency
     */
    public void init(DbConn dbConn, BrokerFactory brokerFactory) {
        this.dbConn = dbConn;
        this.brokerFactory = brokerFactory;
    }
    
    /**
     * Gets a the leagues connected to a specific sport 
     * @return a list if Leagues 
     */
    public List<League> execute() {
        dbConn.open();
        this.sport = brokerFactory.getSportBroker().findByName(this.sportName);
        this.leagues = sport.getAllConnectedLeagues();
        dbConn.close();
        return leagues;
    }
    
}
