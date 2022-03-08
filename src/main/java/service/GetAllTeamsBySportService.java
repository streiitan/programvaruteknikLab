package service;

import db.DbConn;
import domain.League;
import domain.Season;
import domain.Sport;
import domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets all teams that plays a specific sport, but only gets the teams that are 
 * connected to a season
 * @author jenniferstreit
 */
public class GetAllTeamsBySportService {
    private final String sportName;
    private List<Season> seasons;
    private List<Team> teams;


    /**
     * 
     * @param sportName, the name of the sport the teams play
     */
    public GetAllTeamsBySportService(String sportName) {
        this.sportName = sportName;
    }
    
    
    
    /**
     * 
     * @return A list of teams that plays a specific sport
     */
    public List<Team> execute() {
        DbConn.getInstance().open();
        seasons = new ArrayList<>();
        GetLeaguesBySportsNameService getLeagues = new GetLeaguesBySportsNameService(sportName);
        List<League> leagues = getLeagues.execute();
        for (League l : leagues) {
            seasons.addAll(l.getAllConnectedSeasons());
        }
        for (Season s: seasons) {
            teams.addAll(s.getAllTeamsConnected());
        }
        DbConn.getInstance().close();
        return teams;
    }
    
}
