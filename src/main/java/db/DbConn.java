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
       Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://node96052-mysql.jls-sto3.elastx.net:11107/19jest01?"
               + "useSSL=false", "19jest01", "19jest01_pwd");
    }
    
    public void close() {
        Base.close();
    }
    
//    public static void _open() {
//        Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/sport_stats?serverTimezone=UTC", "root", "jennifer");
//    }
//    
//    public static void _close() {
//        Base.close();
//    }
}
