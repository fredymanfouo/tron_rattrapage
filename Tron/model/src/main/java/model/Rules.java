package model;

public class Rules implements Ticks 
{
	//Cette classe défini quelques paramètres comme la taille du terrain de jeu ou encore la vitesse du jeu
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	public static final int DEFAULT_GRID_WIDTH = 600;
	public static final int DEFAULT_GRID_HEIGHT = 400;
	public static final int DEFAULT_TURN_TIME_MS = (int) (0.01 * 1000);
	
	private Grid grid;
	private Timer timer;
	
	public Rules() {
		this.grid = new Grid(DEFAULT_GRID_WIDTH,DEFAULT_GRID_HEIGHT);
		this.timer = new Timer(DEFAULT_TURN_TIME_MS);
	}
	
	public Grid getGrid() {
		return grid;
	}

	public Player getP1() {
		return grid.getP1();
	}

	public Player getP2() {
		return grid.getP2();
	}

	public Timer getTimer() {
		return timer;
	}
	
	public void nextTick() throws GameEndException {
		grid.nextTick();
		try {
			grid.checkCollision(null);
		} catch (CollisionException e) {
			throw new GameEndException();
		}
		timer.nextTick();
	}
}
