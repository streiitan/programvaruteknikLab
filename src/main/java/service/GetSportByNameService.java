package service;

import db.DbConn;
import domain.Sport;
import broker.BrokerFactory;

/**
 * This class gets the sport that equals the input in the constructor. If the 
 * sport does not exist the sport will be created by the CreateNewSportService
 * @author jenniferstreit
 */
public class GetSportByNameService {
    private final String sportName;
    private Sport s;
    private DbConn dbConn;
    private BrokerFactory brokerFactory;

    /**
     * Constructor to save the name of the sport
     * @param sportName, the name of the sport
     */
    public GetSportByNameService(String sportName) {
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
     * Gets a sport from the database, if the sport does not exists it will be
     * created by the class CreateNewSportService 
     * @return a sport object
     */
    public Sport execute() {
        dbConn.open();
        if (brokerFactory.getSportBroker().findByName(sportName) == null) {
            s = brokerFactory.getSportBroker().findByName(sportName);
        } else {
            CreateNewSportService newSport = new CreateNewSportService(sportName);
            s = newSport.execute();
        }
        dbConn.close();
        return s;
    }
}
