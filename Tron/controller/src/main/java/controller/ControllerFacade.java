package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;


public class ControllerFacade implements IController {

	//Définition des interfaces de la vue et du model dans l'interface du contrôleur
	/**
	 * @author     fredy Manfouo 
	 * @since       2019-07-03
	 */
    private final IView  view;
    private final IModel model;


    public ControllerFacade(final IView view, final IModel model) 
    {
        super();
        this.view = view;
        this.model = model;
    }


    public void start() throws SQLException 
    {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }


    public IView getView() 
    {
        return this.view;
    }


    public IModel getModel() 
    {
        return this.model;
    }
}
