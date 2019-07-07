package model;

public final class Up extends Direction
{

	//Actions possibles quand l'orientation du joueur est égale à UP
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	public Direction turnClockwise() {
		return RIGHT;
	}

	public Direction turnCounterClockwise() {
		return LEFT;
	}

	
	public Position deplace(Position p) {
		return new Position(p.getX(),p.getY()-1);
	}

	@Override
	public String toString() {
		return "N";
	}
}
