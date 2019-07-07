package model;

public class Player implements Tourner, Ticks
{
	//Instanciation des joueurs
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	private final int team;
	private Direction direction;
	private Position position;
	private final Grid grid;
	
	public Player(int team,Position position, Direction direction, Grid grid) 
	{
		//Instanciation de l'�quipe du jour (pour la couleur), de sa position...
		/**
		  * @author     fredy Manfouo 
		 * @since       2019-07-07
		 */
		this.team = team;
		this.grid = grid;
		this.position = position;
		this.direction = direction;
	}
	
	public Player(int team,Position position, Direction direction) 
	{
		this(team, position, direction, null);
	}
	
	//D�finition des méthodes pour déclencher un virage
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	public Direction turnClockwise() 
	{
		direction = direction.turnClockwise();
		if (grid!=null) grid.notifyTurn(this);
		return direction;
	}

	public Direction turnCounterClockwise() 
	{
		direction = direction.turnCounterClockwise();
		if (grid!=null) grid.notifyTurn(this);
		return direction;
	}
	
	//Récupération de la direction du joueur pour indiquer sa nouvelle direction après un virage
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	public Direction getDirection() {
		return direction;
	}

	public void nextTick() {
		position = direction.deplace(position);
		
	}

	public Position getPosition() 
	{
		return position;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + team;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (team != other.team)
			return false;
		return true;
	}

	public int getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "P" + team + position + direction;
	}
	
	
}
