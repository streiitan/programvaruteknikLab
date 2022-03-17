package service;

import domain.League;
import domain.Season;
import exceptions.SportstatServiceException;
import java.sql.Date;

/**
 * Gives the user the ability to creates new Seasons
 * 
 * @author jenniferstreit
 */
public class CreateNewSeasonService extends BaseService<Season> {
    
    private final League l;
    private final Date startDate;
    private final Date endDate;
    private Season s;
    
    /**
     * The constructor to set the final variables that will be used in the execute
     * method
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
     * Creates a new season, but first checks if the start date is before the 
     * end date
     * @throws SportstatServiceException
     * @return s, the new season that was created
     */
    @Override
    public Season execute() {
        s = getBrokerFactory().getSeasonBroker().create(); 
        if (startDate.before(endDate)) {
            s.setStartDate(startDate);
            s.setEndDate(endDate);
        } else {
            throw new SportstatServiceException("End date is before start date");
        }
        s.setLeague(l);
        getBrokerFactory().getSeasonBroker().save(s);
        return s;
    }
}
