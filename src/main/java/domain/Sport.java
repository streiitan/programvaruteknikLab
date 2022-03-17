package domain;

import domain.records.LeagueRecord;
import domain.records.SportRecord;
import exceptions.NameIsEmptyException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to represent a sport 
 * @author jenniferstreit
 */
public class Sport {
    private SportRecord theRecord;
    
    public Sport(SportRecord record) {
        theRecord = record;
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
        List<LeagueRecord> records = theRecord.getAll(LeagueRecord.class);
        return records.stream()
                .map(rec -> new League((LeagueRecord)rec))
                .collect(Collectors.toList());
    }   
}
