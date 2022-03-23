package service;

import domain.Sport;
import exceptions.SportstatServiceException;

/**
 * This class gives the user the ability to creates new sports
 * @author jenniferstreit
 */
public class CreateNewSportService extends BaseService<Sport> {

    private final String name;
    private Sport sport;

    /**
     * Saves the name for the new sport
     * @param name, the name of the sport that the user want to create
     */
    public CreateNewSportService(String name) {
        name = name.trim();
        this.name = name.toLowerCase();
        
        
    }

    /**
     * An execute method that creates a new sport but throws an exception if the
     * sport already exists.
     * @return sport, returns the created sport
     */
    @Override
    public Sport execute() {
        if (getBrokerFactory().getSportBroker().findByName(name) == null) {
            sport = getBrokerFactory().getSportBroker().create(name);
            getBrokerFactory().getSportBroker().save(sport);
        } else {
            throw new SportstatServiceException("This sport already exists");
        }
        return sport;
    }
}
