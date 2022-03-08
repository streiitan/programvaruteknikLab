package domain;

import domain.records.SportRecord;
import exceptions.NameIsEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This is a test for the class Sport
 * @author jenniferstreit
 */
public class SportTest {
    private SportRecord sportRecordMock;
    private Sport s;
    
    /**
     * Setting up a sportRecord by mocking the class and by dependency injection
     * creating a new sport. This is done before each test to make sure that it 
     * is a "blank canvas" for every test.
     */
    @BeforeEach
    public void setUp() {
        sportRecordMock = mock(SportRecord.class);
        s = new Sport(sportRecordMock, "name");
    }
    
    @AfterEach
    public void tearDown() {
        s = null;
        sportRecordMock = null;
    }

    /**
     * This test makes sure that you can't put in a blank name for a Sport.
     */
    @Test
    public void testSetBlankName() {
        assertThrows(NameIsEmptyException.class, () -> s.setName(" "));
    }
    
    /**
     * Tests the getName method to verify that the method sportRecord.getString
     * is called on and also that it's only called on once.
     * 
     */
    @Test
    public void testGetName() {
        when(sportRecordMock.getString("name")).thenReturn("");
        
        String expValue = "";
        String returnValue = s.getName();
        
        assertEquals(expValue, returnValue);
        
        verify(sportRecordMock, times(1)).getString("name");
    }   
    
    /**
     * Tests the method getRecord, verifying that the same record that was
     * put in is getting out
     */
    @Test
    public void testGetRecord() {
        assertEquals(sportRecordMock, s.getRecord());
    }
}
