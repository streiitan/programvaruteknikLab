package spike;

import broker.SportBroker;
import db.DbConn;
import domain.Sport;

/**
 * A fast insert to sport
 * 
 * @author jenniferstreit
 */
public class SportInsert {
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        System.out.println("Databasen öppen");
        
        Sport s = new Sport("fotboll");
        SportBroker sportBroker = new SportBroker();
        sportBroker.save(s);
        System.out.println(s.getName());
        
        dbConn.close();
        System.out.println("Databasen stängd");
    }
}
