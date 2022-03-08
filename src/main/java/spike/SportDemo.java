package spike;

import db.DbConn;
import domain.Sport;
import java.util.List;

/**
 *
 * @author jenniferstreit
 */
public class SportDemo {
    
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        
        dbConn.open();
        
        Sport sport = new Sport("Hockey");
        sport.saveIt();
        
        List<Sport> sports = sport.findAll();
        
        for (Sport s : sports) {
            System.out.println(s.getName());
        }
        
        dbConn.close();

        
    }   
}
