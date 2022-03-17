package service;

import broker.BrokerFactory;
import domain.League;
import domain.Season;
import exceptions.SportstatServiceException;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jenniferstreit
 */
public class CreateNewSeasonServiceIT {

    ServiceRunner<Season> seasonServiceRunner;
    ServiceRunner<League> leagueServiceRunner;
    CreateNewSeasonService service;
    GetLeagueByIdService leagueService;
    Season s;
    String mars = "2022-03-22";
    String april = "2022-04-22";

    /**
     * Test to create a new season
     */
    @Test
    public void testCreatingNewSeason() {
        leagueService = new GetLeagueByIdService(10L);
        leagueServiceRunner = new ServiceRunner<>(leagueService);
        League l = leagueServiceRunner.execute();
        service = new CreateNewSeasonService(l, mars, april);
        seasonServiceRunner = new ServiceRunner<>(service);
        s = seasonServiceRunner.execute();
        assertEquals(Date.valueOf(mars), s.getStartDate());
    }
    
    /**
     * Test to test that the season throws an exception if the start date is 
     * after the end date. It is also a test to make sure that nothing ends up 
     * in the database
     */
    @Test
    public void testCreatingNewSeasonException() {
        leagueService = new GetLeagueByIdService(10L);
        leagueServiceRunner = new ServiceRunner<>(leagueService);
        League l = leagueServiceRunner.execute();
        service = new CreateNewSeasonService(l, april, mars);
        seasonServiceRunner = new ServiceRunner<>(service);
        assertThrows(SportstatServiceException.class, () -> seasonServiceRunner.execute());
    }
}
