package spike;

import broker.LeagueBroker;
import db.DbConn;
import domain.League;
import domain.Sport;
import domain.records.SportRecord;

/**
 * A fast insert to league
 * 
 * @author jenniferstreit
 */
public class LeagueInsert {
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        System.out.println("Databasen öppen");
        
        League l = new League();
        LeagueBroker leagueBroker = new LeagueBroker();
        l.setName("Allsvenskan");
        Sport s = new Sport(SportRecord.findById(10));
        l.setSport(s);
        leagueBroker.save(l);
        System.out.println(l.getName());
        
        dbConn.close();
        System.out.println("Databasen stängd");
    }
}
