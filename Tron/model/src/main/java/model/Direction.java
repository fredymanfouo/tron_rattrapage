package model;

public abstract class Direction implements Tourner, Deplace
{
	//Ici sont définie les différentes positions que le joueur peut prendre
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	public static final Direction UP = new Up();
	public static final Direction DOWN = new Down();
	public static final Direction LEFT = new Left();
	public static final Direction RIGHT = new Right();
}
