package service;

import db.DbConn;
import domain.Sport;

/**
 * This class gets the sport that equals the input in the constructor. If the 
 * sport does not exist the sport will be created by the CreateNewSportService
 * @author jenniferstreit
 */
public class GetSportByNameService {
    private final String sportName;
    private Sport s;

    public GetSportByNameService(String sportName) {
        this.sportName = sportName;
    }
    
    public Sport execute() {
        DbConn.getInstance().open();
        if (Sport.doesSportExist(sportName)) {
            s = Sport.findByName(sportName);
        } else {
            CreateNewSportService newSport = new CreateNewSportService(sportName);
            s = newSport.execute();
        }
        DbConn.getInstance().close();
        return s;
    }
    
    
}
