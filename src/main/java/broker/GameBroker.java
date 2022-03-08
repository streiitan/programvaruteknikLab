package broker;

import domain.Game;
import domain.records.GameRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for game
 * @author jenniferstreit
 */
public class GameBroker {
    
    /**
     * Gets all the games in the database
     * @return a list of all games in the database
     */
    public List<Game> findAll() {
        return GameRecord.findAll().stream()
                .map(rec -> new Game((GameRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a game from the database based on the id
     * @param id, the id of a game in the database
     * @return a game object
     */
    public Game findById(Long id) {
        return new Game(GameRecord.findById(id));
    }
    
    /**
     * Method for creating a new game
     * @return a new game object
     */
    public Game create() {
        return new Game(new GameRecord());
    }
    
    /**
     * Saves the changes for a specific game
     * @param g, the selected game for saving changes
     */
    public void save(Game g) {
        g.getRecord().saveIt();
    }
}
