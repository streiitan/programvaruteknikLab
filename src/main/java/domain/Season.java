package domain;

import domain.records.LeagueRecord;
import domain.records.SeasonRecord;
import domain.records.TeamRecord;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jenniferstreit
 */
public class Season {
    private SeasonRecord theRecord;
    
    public Season(){
        this(new SeasonRecord());
    }
    
    public Season(SeasonRecord record) {
        theRecord = record;
    }
    
    public Date getStartDate() {
        return theRecord.getDate("start_date");
    }
    
    public Date getEndDate() {
        return theRecord.getDate("end_date");
    }
    
    public League getLeague() {
        return new League(theRecord.parent(LeagueRecord.class));
    }
    
    public void setStartDate(Date d) {
        theRecord.setDate("start_date", d);
    }
    
    public void setEndDate(Date d) {
        theRecord.setDate("end_date", d);
    }
    
    public void setLeague(League l) {
        theRecord.setParent(l.getRecord());
    }
    
    public List<Team> getAllTeamsConnected() {
        List<Team> teams = new ArrayList<>();
        List<TeamRecord> records = theRecord.getAll(TeamRecord.class);
        for (TeamRecord record : records) {
            teams.add(new Team(record));
        }
        return teams;
    }
    
    public SeasonRecord getRecord() {
        return theRecord;
    }
    
//    public void saveIt() {
//        theRecord.saveIt();
//    }
}