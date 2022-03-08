package domain;

import domain.records.ResultRecord;

/**
 * A class with wrapper methods for administrating ResultRecord. 
 * @author jenniferstreit
 */
public class Result {
    private ResultRecord theRecord;
    
    public Result() {
        this(new ResultRecord());
    }
    
    public Result(ResultRecord record) {
        theRecord = record;
    }
    
    public Integer getHomeTeamScore() {
        return theRecord.getInteger("home_team_score");
    }
    
    public Integer getGuestTeamScore() {
        return theRecord.getInteger("guest_team_score");
    }
    
    public void setHomeTeamScore(Integer i) {
        theRecord.set("home_team_score", i);
    }
    
    public void setGuestTeamScore(Integer i) {
        theRecord.set("guest_team_score", i);
    }
    
    public ResultRecord getRecord() {
        return theRecord;
    }
    
//    public void saveIt() {
//        theRecord.saveIt();
//    }
}
