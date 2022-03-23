package service;

import broker.BrokerFactory;
import db.DbConn;
import exceptions.SportstatServiceException;

/**
 *
 * @author jenniferstreit
 */
public class ServiceRunner<T> {
    private final SportstatService<T> service; 
    T result;
    
    public ServiceRunner(SportstatService<T> service) {
        this.service = service;
    }
    
    public T execute() {
        DbConn dbConn = DbConn.getInstance();
        service.init(new BrokerFactory());
        dbConn.open();
        try {
        result = service.execute();
        } catch (SportstatServiceException e) {
            throw new SportstatServiceException(e.getMessage(), e);
        } finally {
        dbConn.close();
        }
        return result;
    }
}
