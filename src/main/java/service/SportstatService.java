package service;

import broker.BrokerFactory;

/**
 *
 * @author jenniferstreit
 */
public interface SportstatService<T> {
    
    public void init(BrokerFactory brokerFactory);
    public T execute();
    
}
