package service;

import db.DbConn;
import domain.Sport;
import domain.records.SportRecord;
import java.util.ArrayList;
import java.util.List;

/**
 * This class gets all sports as an ArrayList of sports
 * @author jenniferstreit
 */
public class GetAllSportsService {
    List<SportRecord> records;
    List<Sport> sports;
    
    /**
     * Creates an ArrayList of new sports, these are created with the SportRecords
     * from the lazyList from the database
     * @return sports, a list with all sports in the Table "sports" in the database
     */
    public List<Sport> execute() {
        DbConn.getInstance().open();
        records = SportRecord.findAll();
        sports = new ArrayList<>();
        for (SportRecord record : records) {
            sports.add(new Sport(record));
        }
        DbConn.getInstance().close();
        return sports;
    }
}
