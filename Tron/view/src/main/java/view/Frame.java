package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Rules;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;

	public Frame(Rules rules) 
	{
		//Option simple de configuration de la fenêtre (nom, emplacement sur l'écran, contenu)
		/**
		  * @author     fredy Manfouo 
		 * @since       2019-07-07
		 */
		super("TRON");
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
