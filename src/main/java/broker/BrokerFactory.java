package broker;

/**
 * A factory for creating broker objects
 * @author jenniferstreit
 */
public class BrokerFactory {
    public SportBroker getSportBroker() {
        return new SportBroker(); 
    }
    
    public GameBroker getGameBroker() {
        return new GameBroker();
    }
    
    public LeagueBroker getLeagueBroker() {
        return new LeagueBroker();
    }
    
    public PlaceBroker getPlaceBroker() {
        return new PlaceBroker();
    }
    
    public PlayerBroker getPlayerBroker() {
        return new PlayerBroker();
    }
    
    public ResultBroker getResultBroker() {
        return new ResultBroker();
    }
    
    public SeasonBroker getSeasonBroker() {
        return new SeasonBroker();
    }
    
    public TeamBroker getTeamBroker() {
        return new TeamBroker();
    }
}
