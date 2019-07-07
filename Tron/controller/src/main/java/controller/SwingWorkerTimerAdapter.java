package controller;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import model.GameEndException;
import model.Rules;

public class SwingWorkerTimerAdapter extends SwingWorker<String, Void> {

	private final Rules rules;
	private final Component paintedComponent;
	private final JFrame gameWindow;
	private final int tickms;
	
	public SwingWorkerTimerAdapter(Rules rules, Component paintedComponent, JFrame gameWindow) {
		super();
		this.rules = rules;
		this.paintedComponent = paintedComponent;
		this.gameWindow = gameWindow;
		tickms = rules.getTimer().getTickms();
	}

	@Override
	protected String doInBackground() throws Exception 
	{
		//Gestion d'un timer permettant le déplacement automatique
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-04
		 */
		try 
		{
			while(!isCancelled()) 
			{
				rules.nextTick();
				paintedComponent.repaint();
				Thread.sleep(tickms);
			}
		} 
		catch (GameEndException ex) 
		{
			gameWindow.dispose();
			return "GAME OVER";
		} 
		catch (InterruptedException e) 
		{
			//Pas d'action définie
			/**
			 * @author     fredy Manfouo 
			 * @since       2019-07-04
			 */
		}
		return null;
	}

}
