package service;

import broker.BrokerFactory;
import broker.SportBroker;
import domain.Sport;
import exceptions.SportstatServiceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Testing the service to create a new sport
 *
 * @author jenniferstreit
 */
public class CreateNewSportServiceTest {

    @Test
    public void testCreateNewSport() {
        CreateNewSportService testService = new CreateNewSportService("gymnastik");
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithBrokersSetup();
        testService.init(brokerFactory);
        Sport s = testService.execute();
        assertEquals("gymnastik", s.getName());
    }

    @Test
    public void testCreateNewSportThatAllreadyExists() {
        CreateNewSportService testService = new CreateNewSportService("fotboll");
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithBrokersSetup();
        testService.init(brokerFactory);
        assertThrows(SportstatServiceException.class, () -> testService.execute());
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
        SportBroker sportBroker = brokerFactory.getSportBroker();
        when(sportBroker.findByName("fotboll")).thenReturn(sport);
        when(sportBroker.findByName("gymnastik")).thenReturn(null);
        when(sportBroker.create("gymnastik")).thenReturn(sport);
        when(sport.getName()).thenReturn("gymnastik");
        return brokerFactory;
    }
}
