package service;

import domain.Sport;
import exceptions.SportstatServiceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A integration test for the service createNewSportService
 * 
 * @author jenniferstreit
 */
public class CreateNewSportServiceIT {
    
    private ServiceRunner<Sport> serviceRunner;
    private SportstatService<Sport> service;
    private Sport s;
    private final String newSportName = "hockey";
    private final String sportNameAlreadyExist = "Fotboll";

    /**
     * Test to create new sport that does not exist in database.
     * Remember to chance the name or edit the database
     */
    @Test
    public void testCreatingNewSport() {
        service = new CreateNewSportService(newSportName);
        serviceRunner = new ServiceRunner<>(service);
        s = serviceRunner.execute();
        assertEquals(newSportName, s.getName());
    }
    
    /**
     * Test that the service throws an exception if the sport that is being created
     * already exists
     */
    @Test
    public void testCreatingNewSportException() {
        service = new CreateNewSportService(sportNameAlreadyExist);
        serviceRunner = new ServiceRunner<>(service);
        assertThrows(SportstatServiceException.class, () -> serviceRunner.execute());
    }
}