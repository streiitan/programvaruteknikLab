package service;

import domain.League;

/**
 *
 * @author jenniferstreit
 */
public class GetLeagueByIdService extends BaseService<League> {
    
    private League l;
    private final Long id;

    /**
     * 
     * @param id, the id of the league
     */
    public GetLeagueByIdService(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return a league object
     */
    @Override
    public League execute() {
        l = getBrokerFactory().getLeagueBroker().findById(id);
        return l;
    }
    
}
