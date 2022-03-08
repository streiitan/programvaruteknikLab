package domain;

import domain.records.PlayerRecord;
import domain.records.TeamRecord;
import org.javalite.activejdbc.Model;

/**
 *
 * @author jenniferstreit
 */
public class Player {
    private PlayerRecord theRecord;
    
    public Player() {
        this(new PlayerRecord());
    }
    
    public Player(PlayerRecord record) {
        theRecord = record;
    }
    
    public Team getTeam() {
        return new Team(theRecord.parent(TeamRecord.class));
    }
    
    public Integer getNumber() {
        return theRecord.getInteger("number");
    }
    
    public String getFirstName() {
        return theRecord.getString("first_name");
    }
    
    public String getLastName() {
        return theRecord.getString("last_name");
    }
    
    public String getPosition() {
        return theRecord.getString("position");
    }
    
    public void setTeam(Team team) {
        theRecord.setParent(team.getRecord());
    }
    
    public void setNumber(Integer i) {
        theRecord.set("number", i);
    }
    
    public void setFirstName(String name) {
        theRecord.set("first_name", name);
    }
    
    public void setLastName(String name) {
        theRecord.set("last_name", name);
    }
    
    public void setPosition(String pos) {
        theRecord.set("position", pos);
    }
    
    public PlayerRecord getRecord() {
        return theRecord;
    }
    
//    public void saveIt() {
//        theRecord.saveIt();
//    }
}
