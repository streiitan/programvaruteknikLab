package service;

import broker.BrokerFactory;
import db.DbConn;
import domain.League;
import domain.Season;
import domain.Team;
import java.util.List;

/**
 * Gets all teams that plays a specific sport, but only gets the teams that are 
 * connected to a season
 * @author jenniferstreit
 */
public class GetAllTeamsBySportService {
    private final String sportName;
    private List<Season> seasons;
    private List<Team> teams;
    private DbConn dbConn;
    private BrokerFactory brokerFactory;

    /**
     * 
     * @param sportName, the name of the sport the teams play
     */
    public GetAllTeamsBySportService(String sportName) {
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
     * Gets all the teams connected to a specific sport. This requires that the
     * team is connected to a season
     * @return A list of teams that plays a specific sport
     */
    public List<Team> execute() {
        dbConn.open();
        seasons = brokerFactory.getSeasonBroker().findAll();
        GetLeaguesBySportsNameService getLeagues = new GetLeaguesBySportsNameService(sportName);
        List<League> leagues = getLeagues.execute();
        for (League l : leagues) {
            seasons.addAll(l.getAllConnectedSeasons());
        }
        for (Season s: seasons) {
            teams.addAll(s.getAllTeamsConnected());
        }
        dbConn.close();
        return teams;
    }
    
}
