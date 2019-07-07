package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

public class ModelFacade implements IModel {


    public ModelFacade() {
        super();
    }


    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }


    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }

}
