package model;

import java.util.LinkedList;
import java.util.List;

public class Grid implements Ticks, CheckCollision, PlayerTurn {
	private final int width;
	private final int height;
	private Wall wallP1;
	private Wall wallP2;
	
	private List<Wall> walls;
	
	public Grid(int width, int height) 
	{
		//D�finition des positions et orientations de d�part des joueurs
		this.width = width;
		this.height = height;
		wallP1 = new Wall(new Player(1, new Position(width/3,height/2), Direction.DOWN,this));
		wallP2 = new Wall(new Player(2, new Position(2*width/3,height/2), Direction.UP,this));
		walls = new LinkedList<Wall>();
	}

	public void nextTick() {
		wallP1.nextTick();
		wallP2.nextTick();
	}

	public void checkCollision(Position p) throws CollisionException 
	{
		//Vérification de la collision ou non d'un jouer avec un mur
		Position posP1 = wallP1.getPlayer().getPosition();
		if (outOfBounds(posP1))
			throw new CollisionGridException();
		Position posP2 = wallP2.getPlayer().getPosition();
		if (outOfBounds(posP2))
			throw new CollisionGridException();
		wallP2.checkCollision(posP1);
		wallP1.checkCollision(posP2);
		for (Wall wall : walls) {
			wall.checkCollision(posP1);
			wall.checkCollision(posP2);
		}
	}

	private boolean outOfBounds(Position position) 
	{
		//On vérifie que les joueurs soit toujours dans la limite du terrain
		/**
		  * @author     fredy Manfouo 
		 * @since       2019-07-07
		 */
		return !(Position.isBetween(0, position.getX(), width) && Position.isBetween(0, position.getY(), height));
		
	}

	public void notifyTurn(Player player) 
	{
		//Ajout des murs en cas de virage
		if (wallP1.getPlayer().equals(player)){
			walls.add(wallP1);
			wallP1 = new Wall(wallP1);
		}
		if (wallP2.getPlayer().equals(player)){
			walls.add(wallP2);
			wallP2 = new Wall(wallP2);
		}
		
	}

	public Player getP1() {
		return wallP1.getPlayer();
	}
	public Player getP2() {
		return wallP2.getPlayer();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Wall[] getWalls() 
	{
		//Incrémentation permettant de définir des nouveaux murs
		/**
		  * @author     fredy Manfouo 
		 * @since       2019-07-07
		 */
		Wall[] allWalls = new Wall[walls.size() + 2];
		int i = 0;
		for (Wall wall : walls)
			allWalls[i++] = wall;
		allWalls[i++] = wallP1;
		allWalls[i++] = wallP2;
		return allWalls;
	}
	
	
}
