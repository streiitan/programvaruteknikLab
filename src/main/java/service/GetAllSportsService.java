package service;

import broker.BrokerFactory;
import db.DbConn;
import domain.Sport;
import java.util.List;

/**
 * This class gets all sports as an ArrayList of sports
 * @author jenniferstreit
 */
public class GetAllSportsService {
    
    private List<Sport> sports;
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    
    /**
     * Gets the necessary dependencies 
     * @param dbConn, the connection to database
     * @param brokerFactory, enables the class to get a broker without creating
     * a dependency
     */
    public void init(DbConn dbConn, BrokerFactory brokerFactory) {
        this.brokerFactory = brokerFactory;
        this.dbConn = dbConn;
    }
    
    /**
     * Creates an ArrayList of new sports, these are created with the SportRecords
     * from the lazyList from the database
     * @return sports, a list with all sports in the Table "sports" in the database
     */
    public List<Sport> execute() {
        dbConn.open();
        sports = brokerFactory.getSportBroker().findAll();
        dbConn.close();
        return sports;
    }
}
