package service;

import broker.BrokerFactory;
import db.DbConn;

/**
 *
 * @author jenniferstreit
 */
public class ServiceRunner<T> {
    private final SportstatService<T> service; 
    
    public ServiceRunner(SportstatService<T> service) {
        this.service = service;
    }
    
    public T execute() {
        DbConn dbConn = DbConn.getInstance();
        service.init(new BrokerFactory());
        dbConn.open();
        T result = service.execute();
        dbConn.close();
        return result;
    }
}
