package main;

import controller.SwingUIController;


public abstract class Main {

	//Main du jeu 
	/**
	 * @author     fredy Manfouo 
	 * @since       2019-07-08
	 */
	
    public static void main(final String[] args) {
        final SwingUIController controller = new SwingUIController();
        javax.swing.SwingUtilities.invokeLater(controller);
        controller.waitForEnd();
    }

}
