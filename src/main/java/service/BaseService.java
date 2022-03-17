package service;

import broker.BrokerFactory;

/**
 * A abstract class to implement the init-method to relate to the DRY principle 
 * 
 * @author jenniferstreit
 */
public abstract class BaseService<T> implements SportstatService<T> {
    private BrokerFactory brokerFactory; 
    
    /**
     * Gets the necessary dependencies 
     * @param brokerFactory, enables the class to get a broker without creating
     * a dependency
     */
    @Override
    public void init(BrokerFactory brokerFactory) {
        this.brokerFactory = brokerFactory;               
    }
    
    @Override
    public abstract T execute();
    
    /**
     * @return brokerFactory that was set in the constructor
     */
    public BrokerFactory getBrokerFactory() {
        return brokerFactory;
    }
            
}
