/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import db.DbConn;
import domain.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author jenniferstreit
 */
public class TeamDemo {
    
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        
        dbConn.open();
        
        Sport s = Sport.findById(1);
        
        
        League l = new League();
        l.setSport(s);
        l.setName("Korpen");
        l.saveIt();
        
        Date start = Date.valueOf("2022-03-22");
        Date end = Date.valueOf("2022-04-22");
        
        Season season = new Season();
        season.setLeague(l);
        season.setStartDate(start);
        season.setEndDate(end);
        season.saveIt();
        
        Team team = new Team();
        team.setName("SIF");
        team.setSeason(season);
        team.saveIt();
        
        List<Team> teams = Team.findAll();
        
        for (Team t : teams) {
            System.out.printf("Lagnamn: %s, Har %d st spelare%n", 
                t.getName(), t.getNrOfPlayers());
        }
        
        dbConn.close();
    }
    
}
