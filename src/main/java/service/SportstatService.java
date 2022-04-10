package service;

import broker.BrokerFactory;

/**
 * An interface for services
 * @author jenniferstreit
 * @param <T> Object type for executes return type
 */
public interface SportstatService<T> {
    
    public void init(BrokerFactory brokerFactory);
    public T execute();
    
}
