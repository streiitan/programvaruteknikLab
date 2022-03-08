package db;

import org.javalite.activejdbc.Base;

/**
 *
 * @author awi
 */
public class DbConn {
    
    private static DbConn instance;
    
    private DbConn() {}
    
    public static DbConn getInstance() {
        if(instance == null)
            instance = new DbConn();
        
        return instance;
        
    }

   public void open() {
       Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/sport_stats?serverTimezone=UTC", "root", "jennifer");
    }
    
    public void close() {
        Base.close();
    }
    
    public static void _open() {
        Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/sport_stats?serverTimezone=UTC", "root", "jennifer");
    }
    
    public static void _close() {
        Base.close();
    }
}
