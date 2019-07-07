package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;

/**
 * <h1>The Class ExampleDAO.</h1>
 * @version 1.0
		 * @author     fredy Manfouo 
		 * @since       2019-07-05
		 */
 
public abstract class ExampleDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call findExampleById(?)}";

    /** The sql example by name. */
    private static String sqlExampleByName = "{call findExampleByName(?)}";

    /** The sql all examples. */
    private static String sqlAllExamples   = "{call findAllExamples()}";
    
    /** The sql that add a round. */
    private static String sqladdNewRound   = "{call addNewround()}";

    /** The id column index. */
    private static int    idColumnIndex    = 1;

    /** The name column index. */
    private static int    nameColumnIndex  = 2;

    /**
     Obtient l'exemple par id.
     *
     * @param id l'identité
     * @retour l'exemple par id
     * @throws SQLException
     * l'exception SQL
      * @author     fredy Manfouo 
		 * @since       2019-07-05
		 */

    public static Example getExampleById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        Example example = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }

    /**
     Obtient l'exemple par son nom.
     *
     * nom @param le nom
     * @retournez l'exemple par nom
     * @throws SQLException
     * l'exception SQL
      * @author     fredy Manfouo 
		 * @since       2019-07-05
		 */

    public static Example getExampleByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleByName);
        Example example = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }

    /**
     * Gets the all examples.
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
      @author     fredy Manfouo 
		 * @since       2019-07-05
		 */
    public static List<Example> getAllExamples() throws SQLException {
        final ArrayList<Example> examples = new ArrayList<Example>();
        final CallableStatement callStatement = prepareCall(sqlAllExamples);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                examples.add(new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
            }
            result.close();
        }
        return examples;
    }
    
    /**
     * Définissez les tiques.
     *tiques @param
     * les tiques
     * @throws SQLException
     * l'exception SQL
      *@author     fredy Manfouo 
		 * @since       2019-07-05
		 */
    public static Example addNewRound(final int ticks) throws SQLException {
        //final CallableStatement callStatement = prepareCall(sqladdNewRound);
        Example example = null;
        //callStatement.setInt(ticks);
        return example;
    }
}
