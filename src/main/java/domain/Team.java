package domain;

import domain.records.GameRecord;
import domain.records.PlayerRecord;
import domain.records.SeasonRecord;
import domain.records.TeamRecord;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jenniferstreit
 */
public class Team {
    private TeamRecord theRecord;
    
    public Team() {
        this(new TeamRecord());
    }
    
    public Team(TeamRecord record) {
        theRecord = record; 
    }
    
    public String getName() {
        return theRecord.getString("name");
    }
    
    public Integer getNrOfPlayers() {
        return theRecord.getAll(PlayerRecord.class).size();
    }
    
    public Integer getNrOfGamesPlayed() {
        return theRecord.getAll(GameRecord.class).size();
    }
    
    public Season getSeason() {
        return new Season(theRecord.parent(SeasonRecord.class));
    }
    
    public void setName(String name) {
        theRecord.set("name", name);
    }
    
    public void setSeason(Season s) {
        theRecord.setParent(s.getRecord());
    }
    
    public TeamRecord getRecord() {
        return theRecord;
    }
    
    public Integer getId() {
        return theRecord.getLongId().intValue();
    }
    
    public static Team findById(Integer id) {
        return new Team(TeamRecord.findById(id));
    }
    
    public void saveIt() {
        theRecord.saveIt();
    }
    
    public static List<Team> findAll() {
       List<TeamRecord> teamRecords = TeamRecord.findAll();
       List<Team> teams = new ArrayList<>();
       for (TeamRecord t : teamRecords) {
           teams.add(new Team(t));
       }
       return teams;
    }
    
    
}
