package service;

import domain.League;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the service getLeagueByIdService
 *
 * @author jenniferstreit
 */
public class GetLeagueByIdServiceIT {
    
    private ServiceRunner<League> serviceRunner;
    private SportstatService<League> service; 
    private final String name = "Allsvenskan";

    /**
     * Test getting a League by id
     */
    @Test
    public void testGettingALeagueById() {
        service = new GetLeagueByIdService(10L);
        serviceRunner = new ServiceRunner<>(service);
        League l = serviceRunner.execute();
        assertEquals(name, l.getName());
    }
    
}
