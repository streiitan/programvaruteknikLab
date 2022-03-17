package service;

import broker.BrokerFactory;
import broker.SeasonBroker;
import domain.Season;
import exceptions.SportstatServiceException;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A service that creates a new season
 * 
 * @author jenniferstreit
 */
public class CreateNewSeasonServiceTest {
    private final String mars = "2022-03-22";
    private final String april = "2022-04-22";

    @Test
    public void testCreatingNewSeason() {
        CreateNewSeasonService testService = new CreateNewSeasonService(null, mars, april);
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithBrokersSetup();
        testService.init(brokerFactory);
        Season s = brokerFactory.getSeasonBroker().create();
        assertEquals(Date.valueOf(mars), s.getStartDate());
    }
    
    @Test
    public void testCreatingNewSeasonException() {
        CreateNewSeasonService testService = new CreateNewSeasonService(null, april, mars);
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithBrokersSetup();
        testService.init(brokerFactory);
        Season s = brokerFactory.getSeasonBroker().create();
        assertThrows(SportstatServiceException.class, () -> testService.execute());
    }
    
    private BrokerFactory getMockedBrokerFactory() {
        SeasonBroker seasonBroker = mock(SeasonBroker.class);
        BrokerFactory brokerFactory = mock(BrokerFactory.class);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        return brokerFactory;
    }
    
    private BrokerFactory getMockedBrokerFactoryWithBrokersSetup() {
        BrokerFactory brokerFactory = getMockedBrokerFactory();
        Season season = mock(Season.class);
        SeasonBroker seasonBroker = brokerFactory.getSeasonBroker();
        when(seasonBroker.create()).thenReturn(season);
        when(season.getStartDate()).thenReturn(Date.valueOf(mars));
        return brokerFactory;
    }
    
}
