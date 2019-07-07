package model;

public final class Left extends Direction
{
	//Actions possibles quand l'orientation du joueur est égale à LEFT
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */

	public Direction turnClockwise() {
		return UP;
	}

	public Direction turnCounterClockwise() {
		return DOWN;
	}

	public Position deplace(Position p) {
		return  new Position(p.getX()-1,p.getY());
	}

	@Override
	public String toString() {
		return "W";
	}

}
