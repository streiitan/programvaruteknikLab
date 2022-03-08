package service;

import db.DbConn;
import domain.League;
import domain.Season;
import java.sql.Date;

/**
 * Gives the user the ability to creates new Seasons
 * @author jenniferstreit
 */
public class CreateNewSeasonService {
    private final String leagueName;
    private final League l;
    private final Date startDate;
    private final Date endDate;
    private Season s;
    
    /**
     * 
     * @param leagueName, the name of the league that is connected to the new season
     * @param startDate, the start date of the season
     * @param endDate, the end date of the season
     */
    public CreateNewSeasonService(String leagueName, String startDate, String endDate) {
        this.leagueName = leagueName; 
        l = League.findByName(leagueName);
        this.startDate = Date.valueOf(startDate);
        this.endDate = Date.valueOf(endDate);
    }
    
    /**
     * 
     * @return s, the new season that was created
     */
    public Season execute() {
        DbConn.getInstance().open();
        s = new Season();
        s.setStartDate(startDate);
        s.setEndDate(endDate);
        s.setLeague(l);
        s.saveIt();
        DbConn.getInstance().close();
        return s;
    }
}
