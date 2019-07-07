package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class TronBDDConnector.</h1>
 *
 @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
final class TronBDDConnector {

    /** The instance. */
    private static TronBDDConnector instance;

    /** The login. */
    private static String                  user     = "root";

    /** The password. */
    private static String                  password = "";

    /** The url. */
    private static String                  url      = "jdbc:mysql://localhost/trongame?useSSL=false&serverTimezone=UTC";

    /** The connection. */
    private Connection                     connection;

    /** The statement. */
    private Statement                      statement;

    /**
     * Instantiates a new Tron BDD connector.
     */
    private TronBDDConnector() {
        this.open();
    }

    /**
     * Gets the single instance of TronBDDConnector.
     *
     * @return single instance of TronBDDConnector
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public static TronBDDConnector getInstance() {
        if (instance == null) {
            setInstance(new TronBDDConnector());
        }
        return instance;
    }

    /**
     * Sets the instance.
     *
     * @param instance
     *            the new instance
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    private static void setInstance(final TronBDDConnector instance) {
        TronBDDConnector.instance = instance;
    }

    /**
     * Open.
     *
     * @return true, if successful
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(TronBDDConnector.url, TronBDDConnector.user,
                    TronBDDConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
     
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection.
     *
     * @param connection
     *            the new connection
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement
     *            the new statement
      @return the java.sql. callable statement
      @author     fredy Manfouo 
		 * @since       2019-07-06
		 */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

}
