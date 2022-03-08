package service;

import db.DbConn;
import domain.Sport;
import exceptions.SportExistsException;

/**
 * This class gives the user the ability to creates new sports
 *
 * @author jenniferstreit
 */
public class CreateNewSportService {

    private final String name;
    private Sport sport;

    /**
     *
     * @param name, the name of the sport that the user want to create
     */
    public CreateNewSportService(String name) {
        this.name = name;
    }

    /**
     * An execute method that creates a new sport but throws an exception if the
     * sport already exists.
     * @return sport, returns the created sport
     */
    public Sport execute() {
        DbConn.getInstance().open();
        
        if (Sport.doesSportExist(name)) {
            sport = new Sport(name);
            sport.saveIt();
        } else {
            throw new SportExistsException("This sport already exists");
        }

        DbConn.getInstance().close();
        
        return sport;

    }
}
