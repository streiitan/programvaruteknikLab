package domain;

import domain.records.GameRecord;
import domain.records.PlaceRecord;
import domain.records.ResultRecord;
import domain.records.TeamRecord;

/**
 *
 * @author jenniferstreit
 */
public class Game {
    private GameRecord theRecord;
    
    public Game() {
        this(new GameRecord());
    }
    
    public Game(GameRecord record) {
        theRecord = record;
    }
    
    public Team getHomeTeam() {
        return Team.findById(theRecord.getInteger("home_team_id"));
    }
    
    public Team getGuestTeam() {
        return Team.findById(theRecord.getInteger("guest_team_id"));
    }
    
    public Place getPlace() {
        return new Place(theRecord.parent(PlaceRecord.class));
    }
    
    public Integer getSpectators() {
        return theRecord.getInteger("spectators");
    }
    
    public Result getResult() {
        return new Result(theRecord.parent(ResultRecord.class));
    }
    
    public void setHomeTeam(Team t) {
        theRecord.set("home_team_id", t.getId());
    }
    
    public void setGuestTeam(Team t) {
        theRecord.set("guest_team_id", t.getId());
    }
    
    public void setPlace(Place place) {
        theRecord.setParent(place.getRecord());
    }
    
    public void setSpectators(Integer i) {
        theRecord.set("spectators", i);
    }
    
    public void setResult(Result r) {
        theRecord.setParent(r.getRecord());
    }
    
    public GameRecord getRecord() {
        return theRecord;
    }
    
    public void saveIt() {
        theRecord.saveIt();
    }
}
