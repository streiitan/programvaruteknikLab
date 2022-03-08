package spike;

import db.DbConn;
import domain.Game;
import domain.Place;
import domain.Result;
import domain.Team;

/**
 *
 * @author jenniferstreit
 */
public class GameDemo {
    
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        
        dbConn.open();
        
        Result r = new Result();
        r.setHomeTeamScore(10);
        r.setGuestTeamScore(3);
        r.saveIt();
        
        Place p = Place.findById(1);
        
        Game game = new Game();
        game.setHomeTeam(Team.findById(1));
        game.setGuestTeam(Team.findById(3));
        game.setPlace(p);
        game.setResult(r);
        game.saveIt();
        
        System.out.println("Hemmalaget är: " + game.getHomeTeam().getName());
        System.out.println("Bortalaget är: " + game.getGuestTeam().getName());
        System.out.println("resultatet blev: " + game.getResult().getHomeTeamScore() + ":" + game.getResult().getGuestTeamScore());
        
        dbConn.close();
    }
}
