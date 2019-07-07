package model;

public interface CheckCollision 
{
	//Verification des collisions en fonction de la position du joueur
	/**
		      @author     fredy Manfouo 
				 * @since       2019-07-06
				 */
	public void checkCollision(Position p) throws CollisionException;
}
