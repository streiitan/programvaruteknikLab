package domain;

import domain.records.LeagueRecord;
import domain.records.SportRecord;
import exceptions.NameIsEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



/**
 *
 * @author jenniferstreit
 */
public class LeagueTest {
    LeagueRecord leagueRecordMock;
    League l;
    
    @BeforeEach
    public void setUp() {
        leagueRecordMock = mock(LeagueRecord.class);
        l = new League(leagueRecordMock);
    }
    
    @AfterEach
    public void tearDown() {
        leagueRecordMock = null;
        l = null;
    }

    /**
     * Test of getName method of class League and verifies that the method is 
     * only called on once
     */
    @Test
    public void testGetName() {
        when(leagueRecordMock.getString("name")).thenReturn("");
        
        String expValue = "";
        String returnValue = l.getName();
        
        assertEquals(expValue, returnValue);
        
        verify(leagueRecordMock, times(1)).getString("name");
    }
    
    /**
     * Tests that setName method is throwing exception
     */
    @Test
    public void testSetName() {
        assertThrows(NameIsEmptyException.class, () -> l.setName(" "));
    }
    
}
