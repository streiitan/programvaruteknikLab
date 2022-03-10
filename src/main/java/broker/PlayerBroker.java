package broker;

import domain.Player;
import domain.records.PlayerRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for Player
 * @author jenniferstreit
 */
public class PlayerBroker {
    
    /**
     * Gets all the players in the database
     * @return a list of all players in the database
     */
    public List<Player> findAll() {
        return PlayerRecord.findAll().stream()
                .map(rec -> new Player((PlayerRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a player from the database based on the id
     * @param id, the id of a player in the database
     * @return a player object
     */
    public Player findById(Long id) {
        return new Player(PlayerRecord.findById(id));
    }
    
    /**
     * Method for creating a new Player
     * @return a new player object
     */
    public Player create() {
        return new Player(new PlayerRecord());
    }
    
    /**
     * Saves the changes for a specific player
     * @param p, the selected player for saving changes
     */
    public void save(Player p) {
        p.getRecord().saveIt();
    }
}
