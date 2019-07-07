package model;

public final class Down extends Direction
{
	//Actions possibles quand l'orientation du joueur est égale à DOWN
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */

	public Direction turnClockwise() {
		return LEFT;
	}

	public Direction turnCounterClockwise() {
		return RIGHT;
	}

	public Position deplace(Position p) {
		return  new Position(p.getX(),p.getY()+1);
	}

	@Override
	public String toString() {
		return "S";
	}

}
