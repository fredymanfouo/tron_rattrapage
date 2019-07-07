package model;


public class Position 
{
	//Cette classe permet de facon globale de récupérer et vérifier la position d'un joueur
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static boolean isBetween(int depart, int position, int fin){
		if (fin>=depart)
			return (position>=depart) && (position <= fin);
		else
			return isBetween(fin, position, depart);
	}
	
	
}