package service;

import domain.League;
import domain.Season;
import domain.Team;
import java.util.List;

/**
 * Gets all teams that plays a specific sport, but only gets the teams that are 
 * connected to a season
 * @author jenniferstreit
 */
public class GetAllTeamsBySportService extends BaseService<List<Team>> {
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
     * Gets all the teams connected to a specific sport. This requires that the
     * team is connected to a season
     * @return A list of teams that plays a specific sport
     */
    @Override
    public List<Team> execute() {
        seasons = getBrokerFactory().getSeasonBroker().findAll();
        GetLeaguesBySportNameService getLeagues = new GetLeaguesBySportNameService(sportName);
        List<League> leagues = getLeagues.execute();
        leagues.forEach(l -> {
            seasons.addAll(l.getAllConnectedSeasons());
        });
        seasons.forEach(s -> {
            teams.addAll(s.getAllTeamsConnected());
        });
        return teams;
    }
    
}
