package model;

public class Wall implements Ticks, CheckCollision{
	private final Player player;
	private final Position depart;
	private Position fin;
	
	public Wall(Wall precedent){
		this.player = precedent.player;
		this.depart = precedent.fin;
		this.fin = player.getPosition();
	}
	
	public Wall(Player j){
		this.player = j;
		this.depart=j.getPosition();
		this.fin=j.getPosition();
	}
	
	 //Suppose que le mur this est le dernier mur encore actif du joueur et que le joueur n'a pas changé de direction.
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */

	public void nextTick(){
		player.nextTick();
		fin = player.getPosition();
	}

	public void checkCollision(Position position) throws CollisionException {
		if (Position.isBetween(depart.getX(), position.getX(), fin.getX()) && Position.isBetween(depart.getY(), position.getY(), fin.getY()))
			throw new CollisionWallException();
		
	}
	public Player getPlayer(){
		return player;
	}
	

	public Position getDepart() {
		return depart;
	}

	public Position getFin() {
		return fin;
	}

	@Override
	public String toString() {
		return "Wall[p" + player.getTeam() + ", " + depart + "--" + fin + "]";
	}
	
	
}
