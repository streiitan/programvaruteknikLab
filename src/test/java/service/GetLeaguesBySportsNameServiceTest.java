package service;

import broker.BrokerFactory;
import broker.SportBroker;
import db.DbConn;
import domain.League;
import domain.Sport;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Tests the service get LeaguesBySportNameService so the method execute returns
 * a list
 * @author jenniferstreit
 */
public class GetLeaguesBySportsNameServiceTest {
    private final String name = "fotboll";
    
    @Test
    public void testGetAllLeauges() {
        GetLeaguesBySportsNameService testService = new GetLeaguesBySportsNameService(name);
        DbConn dbConn = mock(DbConn.class);
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithBrokersSetup();
        testService.init(dbConn, brokerFactory);
        List<League> leagues = testService.execute();
        assertEquals("list", leagues.toString());
    }
    
    private BrokerFactory getMockedBrokerFactory() {
        SportBroker sportBroker = mock(SportBroker.class);
        BrokerFactory brokerFactory = mock(BrokerFactory.class);
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        return brokerFactory;
    }
    
    private BrokerFactory getMockedBrokerFactoryWithBrokersSetup() {
        BrokerFactory brokerFactory = getMockedBrokerFactory();
        Sport sport = mock(Sport.class);
        List<League> list = mock(List.class);
        SportBroker sportBroker = brokerFactory.getSportBroker();
        when(sportBroker.findByName(name)).thenReturn(sport);
        when(sport.getAllConnectedLeagues()).thenReturn(list);
        when(list.toString()).thenReturn("list"); 
        
        return brokerFactory;
    }
    
}
