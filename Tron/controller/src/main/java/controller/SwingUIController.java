package controller;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Rules;
import view.GridJFrameAdapter;

public class SwingUIController implements Runnable, KeyListener 
{

	private final Rules rules;
	private final JFrame frame;
	private final GridJFrameAdapter panel;
	private final SwingWorkerTimerAdapter timerTask;

	public SwingUIController() 
	{
		//Définition d'options avancées de la fenêtre comme son moyen de fermeture
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-03
		 */
		rules = new Rules();
		frame = new JFrame("TRON");
		panel = new GridJFrameAdapter(rules);
		frame.setLayout(new GridLayout(1, 1));
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		timerTask = new SwingWorkerTimerAdapter(rules, panel, frame);
	}


	public void run() {
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setMinimumSize(frame.getSize());
		frame.setVisible(true);
		timerTask.execute();
	}

	public void waitForEnd() 
	{
		//Affichage de fin de partie
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-03
		 */
		try 
		{
			timerTask.get();
		} catch (InterruptedException | ExecutionException e1) 
		{
			e1.printStackTrace();
		}
		javax.swing.SwingUtilities.invokeLater(() -> { JOptionPane.showMessageDialog(null, "Bien jou� au gagnant ! �a m�rite une revanche non?"); });
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		//Définition des actions au moment ou on appuie sur la touche
		//Ici aucune car l'action se passe pendant l'appuie
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-04
		 */
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		//Détection des différentes actions possibles pour les joueurs
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-04
		 */
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			rules.getP2().turnClockwise();
			break;
		case KeyEvent.VK_LEFT:
			rules.getP2().turnCounterClockwise();
			break;
		case KeyEvent.VK_D:
			rules.getP1().turnClockwise();
			break;
		case KeyEvent.VK_Q:
			rules.getP1().turnCounterClockwise();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		//Pas d'actions au moment du relachement de la touche
		/**
		 * @author     fredy Manfouo 
		 * @since       2019-07-04
		 */
	}

}
