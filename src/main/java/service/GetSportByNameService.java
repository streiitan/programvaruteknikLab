package service;

import domain.Sport;

/**
 * This class gets the sport that equals the input in the constructor. If the 
 * sport does not exist the sport will be created by the CreateNewSportService
 * @author jenniferstreit
 */
public class GetSportByNameService extends BaseService<Sport> {
    private final String sportName;
    private Sport s;

    /**
     * Constructor to save the name of the sport
     * @param sportName, the name of the sport
     */
    public GetSportByNameService(String sportName) {
        this.sportName = sportName;
    }
    
    /**
     * Gets a sport from the database, if the sport does not exists it will be
     * created by the class CreateNewSportService 
     * @return a sport object
     */
    @Override
    public Sport execute() {
        if (getBrokerFactory().getSportBroker().findByName(sportName) == null) {
            s = getBrokerFactory().getSportBroker().findByName(sportName);
        } else {
            CreateNewSportService newSport = new CreateNewSportService(sportName);
            s = newSport.execute();
        }
        return s;
    }
}
