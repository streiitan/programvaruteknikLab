package domain;

import domain.records.LeagueRecord;
import domain.records.SportRecord;
import exceptions.NameIsEmptyException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a sport 
 * @author jenniferstreit
 */
public class Sport {
    private SportRecord theRecord;
    
    public Sport(SportRecord record) {
        theRecord = record;
        if (getName() == null)
            throw new NameIsEmptyException("This instance doesn't have a name");
    }

    public Sport(String name) {
        this(new SportRecord(), name);
    }
    
    public Sport(SportRecord record, String name) {
        theRecord = record;
        setName(name);
    }
    
    public String getName() {
        return theRecord.getString("name");
    }
    
    public void setName(String name) {
        if (!name.isBlank()) {
            theRecord.set("name", name);
        } else {
            throw new NameIsEmptyException("Name is blank");
        }
    }

    public SportRecord getRecord() {
        return theRecord;
    }
    
    public List<League> getAllConnectedLeagues() {
        List<League> leagues = new ArrayList<>();
        List<LeagueRecord> records = theRecord.getAll(LeagueRecord.class);
        for (LeagueRecord record : records) {
            leagues.add(new League(record));
        }
        return leagues;
    }
    
//    public void saveIt() {
//        theRecord.saveIt();
//    }
    
//    public List<Sport> findAll() {
//        List<SportRecord> sportRecords = theRecord.findAll();
//        List<Sport> sports = new ArrayList<>();
//        
//        for (SportRecord s : sportRecords) {
//            sports.add(new Sport(s));
//        }
//        return sports;
//    }
    
//    public static boolean doesSportExist(String name) {
//        List<SportRecord> sr = SportRecord.where("name = ?", name);
//        if (sr.isEmpty()) {
//            return false; 
//        } else {
//            return true;
//        }
//    }
//    
//    public static Sport findById(Integer id) {
//        return new Sport(SportRecord.findById(id));
//    }
    
//    public static Sport findByName(String name) {
//        List<SportRecord> sr = SportRecord.where("name = ?", name);
//        return new Sport(sr.get(0));
//    }
    
//    public static boolean doesSportExist(String name) {
//        List<SportRecord> sr = SportRecord.where("name = ?", name);
//        if (sr.isEmpty()) {
//            return false; 
//        } else {
//            return true;
//        }
//    }
    
}
