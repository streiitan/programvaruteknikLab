package service;

import db.DbConn;
import domain.Sport;
import broker.BrokerFactory;
import exceptions.SportstatServiceException;

/**
 * This class gives the user the ability to creates new sports
 * @author jenniferstreit
 */
public class CreateNewSportService {

    private final String name;
    private Sport sport;
    private DbConn dbConn;
    private BrokerFactory brokerFactory; 

    /**
     * Saves the name for the new sport
     * @param name, the name of the sport that the user want to create
     */
    public CreateNewSportService(String name) {
        this.name = name;
    }
    
    /**
     * Gets the necessary dependencies 
     * @param dbConn, The database connection 
     * @param brokerFactory, enables the class to get a broker without creating
     * a dependency
     */
    public void init(DbConn dbConn, BrokerFactory brokerFactory) {
        this.dbConn = dbConn;
        this.brokerFactory = brokerFactory;
    }

    /**
     * An execute method that creates a new sport but throws an exception if the
     * sport already exists.
     * @return sport, returns the created sport
     */
    public Sport execute() {
        this.dbConn.open();
        if (brokerFactory.getSportBroker().findByName(name) == null) {
            sport = brokerFactory.getSportBroker().create(name);
            brokerFactory.getSportBroker().save(sport);
        } else {
            throw new SportstatServiceException("This sport already exists");
        }
        this.dbConn.close();
        return sport;
    }
}
