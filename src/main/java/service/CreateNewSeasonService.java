package service;

import broker.BrokerFactory;
import db.DbConn;
import domain.League;
import domain.Season;
import exceptions.SportstatServiceException;
import java.sql.Date;

/**
 * Gives the user the ability to creates new Seasons
 * @author jenniferstreit
 */
public class CreateNewSeasonService {
    private final League l;
    private final Date startDate;
    private final Date endDate;
    private Season s;
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    
    /**
     * 
     * @param l, the id of the league that is connected to the new season
     * @param startDate, the start date of the season
     * @param endDate, the end date of the season
     */
    public CreateNewSeasonService(League l, String startDate, String endDate) {
        this.l = l;
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
     * Creates a new season, but first checks if the start date is before the 
     * end date
     * @throws SportstatServiceException
     * @return s, the new season that was created
     */
    public Season execute() {
        dbConn.open();
        s = brokerFactory.getSeasonBroker().create(); 
        if (startDate.before(endDate)) {
            s.setStartDate(startDate);
            s.setEndDate(endDate);
        } else {
            throw new SportstatServiceException("End date is before start date");
        }
        s.setLeague(l);
        brokerFactory.getSeasonBroker().save(s);
        dbConn.close();
        return s;
    }
}
