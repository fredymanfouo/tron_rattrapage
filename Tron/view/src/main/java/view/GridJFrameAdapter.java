package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JApplet;
import model.Grid;
import model.Position;
import model.Rules;
import model.Wall;

public class GridJFrameAdapter extends JApplet {

	private static final Color[] PLAYER_COLORS = { null, Color.BLUE, Color.RED };
	private final Grid grid;

	public GridJFrameAdapter(Rules rules) 
	{
		//Mise en place d'une adaptation automatique de la taille de la fenêtre
		
		super();
		this.grid = rules.getGrid();
		int width = rules.getGrid().getWidth();
		int height = rules.getGrid().getHeight();
		setLayout(null);
		setPreferredSize(new Dimension(width+2, height+2));
		//setSize(width+100, height+100);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		doPaintWalls(g, grid.getWalls());
	}

	private void doPaintWalls(Graphics g, Wall... walls) 
	{
		//Définition du fond de base de la fenêtre de jeu
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, grid.getWidth(), grid.getHeight());
		g.setColor(Color.GREEN);
		g.drawRect(0, 0, grid.getWidth(), grid.getHeight());
		for (Wall wall : walls)
			doPaintWall(g,wall);
			
	}

	private void doPaintWall(Graphics g, Wall wall) 
	{
		//Coloration de chaque joueur en fonction de son équipe
		//L'équipe permet simplement de définir une couleur pour chaque joueur mais n'a pas d'influence sur le jeu
		Position depart = wall.getDepart();
		Position fin = wall.getFin();
		g.setColor(PLAYER_COLORS[wall.getPlayer().getTeam()]);
		g.drawLine(
				depart.getX(), depart.getY(),
				fin.getX(), fin.getY()
		);		
	}

}
