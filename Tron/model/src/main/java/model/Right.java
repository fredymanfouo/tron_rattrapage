package model;

public final class Right extends Direction
{
	//Actions possibles quand l'orientation du joueur est égale à Right
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */

	public Direction turnClockwise() {
		return DOWN;
	}

	public Direction turnCounterClockwise() {
		return UP;
	}

	public Position deplace(Position p) {
		return  new Position(p.getX()+1,p.getY());
	}

	@Override
	public String toString() {
		return "E";
	}

}
