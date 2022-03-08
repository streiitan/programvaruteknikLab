package domain;

import domain.records.LeagueRecord;
import domain.records.SeasonRecord;
import domain.records.SportRecord;
import exceptions.NameIsEmptyException;
import exceptions.ObjectIsEmptyException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jenniferstreit
 */
public class League {
    private LeagueRecord theRecord;
    
    public League() {
        this(new LeagueRecord());
    }
    
    public League(LeagueRecord record) {
        theRecord = record;
    }
    
    public String getName(){
        return theRecord.getString("name");
    }
    
    public Sport getSport() {
        return new Sport(theRecord.parent(SportRecord.class));
    }
    
    public void setName(String name) {
        if (!name.isBlank()) {
            theRecord.set("name", name);
        } else {
            throw new NameIsEmptyException("The name is blank");
        }
    }
    
    public List<Season> getAllConnectedSeasons() {
        List<Season> seasons = new ArrayList<>();
        List<SeasonRecord> records = theRecord.getAll(SeasonRecord.class);
        for (SeasonRecord record : records) {
            seasons.add(new Season(record));
        }
        return seasons;
    }
    
    public void setSport(Sport s) {
        if (s.getName()!= null) {
            theRecord.setParent(s.getRecord());
        } else {
            throw new ObjectIsEmptyException("This sport object is empty");
        }
    }
    
    public LeagueRecord getRecord() {
        return theRecord;
    }    
    
    public void saveIt() {
        theRecord.saveIt();
    }
    
    public static League findByName(String name) {
        List<LeagueRecord> lr = LeagueRecord.where("name = ?", name);
        return new League(lr.get(0));
    }
}
