package service;

import broker.BrokerFactory;
import db.DbConn;
import domain.Sport;
import java.util.List;

/**
 * This class gets all sports as an ArrayList of sports
 * @author jenniferstreit
 */
public class GetAllSportsService extends BaseService<List<Sport>> {
    
    private List<Sport> sports;

    /**
     * Creates an ArrayList of new sports, these are created with the SportRecords
     * from the lazyList from the database
     * @return sports, a list with all sports in the Table "sports" in the database
     */
    @Override
    public List<Sport> execute() {
        sports = getBrokerFactory().getSportBroker().findAll();
        return sports;
    }
}
