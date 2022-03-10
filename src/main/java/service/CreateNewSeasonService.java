package service;

import broker.BrokerFactory;
import db.DbConn;
import domain.League;
import domain.Season;
import java.sql.Date;

/**
 * Gives the user the ability to creates new Seasons
 * @author jenniferstreit
 */
public class CreateNewSeasonService {
    private final Long leagueId;
    private final League l;
    private final Date startDate;
    private final Date endDate;
    private Season s;
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    
    /**
     * 
     * @param leagueId, the id of the league that is connected to the new season
     * @param startDate, the start date of the season
     * @param endDate, the end date of the season
     */
    public CreateNewSeasonService(Long leagueId, String startDate, String endDate) {
        this.leagueId = leagueId; 
        l = brokerFactory.getLeagueBroker().findById(this.leagueId);
        this.startDate = Date.valueOf(startDate);
        this.endDate = Date.valueOf(endDate);
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
     * 
     * @return s, the new season that was created
     */
    public Season execute() {
        return null;
    }
}
