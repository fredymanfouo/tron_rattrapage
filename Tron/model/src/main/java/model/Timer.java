package model;

public class Timer implements Ticks
{
	//Définition d'un système permettant l'exécution automatique de certains éléments, comme la vitesse par exemple
	/**
	  * @author     fredy Manfouo 
	 * @since       2019-07-07
	 */
	private int tick;
	private final int tickms;

	public Timer(int tickms) {
		this.tick = 0;
		this.tickms = tickms;
	}
	public int getTick() {
		return tick;
	}
	
	public int getTickms() {
		return tickms;
	}
	public int getTimeMS() {
		return tick * tickms;
	}
	public void nextTick() {
		tick++;
		
	}
}
