package model;

import java.sql.SQLException;
import java.util.List;


public interface IModel 
{
	//Definition de l'interface du model et d'exceptions
	/**
	 * @author     fredy Manfouo 
	 * @since       2019-07-03
	 */

    Example getExampleById(int id) throws SQLException;


    Example getExampleByName(String name) throws SQLException;


    List<Example> getAllExamples() throws SQLException;
}
