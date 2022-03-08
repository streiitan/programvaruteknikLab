package domain;

import domain.records.PlaceRecord;
import org.javalite.activejdbc.Model;

/**
 *
 * @author jenniferstreit
 */
public class Place {
    public PlaceRecord theRecord;
    
    public Place() {
        this(new PlaceRecord());
    }
    
    public Place(PlaceRecord record) {
        theRecord = record;
    }
    
    public String getName() {
        return theRecord.getString("name");
    }
    
    public String getStreet() {
        return theRecord.getString("street");
    }
    
    public Integer getStreetNumber() {
        return theRecord.getInteger("street_number");
    }
    
    public String getCity() {
        return theRecord.getString("city");
    }
    
    public Integer getMaxSpectators() {
        return theRecord.getInteger("max_spectator");
    }
    
    public void setName(String name) {
        theRecord.set("name", name);
    }
    
    public void setStreet(String street) {
        theRecord.set("street", street);
    }
    
    public void setStreetNumber(Integer streetNumber) {
        theRecord.set("street_number", streetNumber);
    }
    
    public void setCity(String city) {
        theRecord.set("city", city);
    }
    
    public void setMaxSpectators(Integer i) {
        theRecord.set("max_spectator", i);
    }
    
    public PlaceRecord getRecord() {
        return theRecord;
    }
    
//    public static Place findById(Integer id) {
//        return new Place(PlaceRecord.findById(id));
//    }
    
    public Integer getId() {
        return theRecord.getLongId().intValue();
    }
}
