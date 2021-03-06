package fis.com.training.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DatabaseUtility {
    public final static String URL = "jdbc:mysql://localhost:3306/criminal_system";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "nguyenquybong199";


    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER_NAME);
        cpds.setPassword(PASSWORD);

        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
        return cpds;
    }

    public static Connection getConnection() throws  Exception{
        // No connection pool
        // Connection con = DriverManager.getConnection (URL, USER_NAME, PASSWORD);

        // Has connection pool
        // C3P0
        //Connection con = getDataSource().getConnection();

        // HikariCP
        Connection con = ds.getConnection();
        return con;
    }

    static {
        config.setJdbcUrl(URL);
        config.setUsername( USER_NAME );
        config.setPassword( PASSWORD );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );

        ds = new HikariDataSource( config );
    }
}
