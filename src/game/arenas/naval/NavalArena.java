package game.arenas.naval;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.IRacer;
import game.racers.Racer;
import game.racers.naval.NavalRacer;
import utilities.EnumContainer.Body;
import utilities.EnumContainer.Surface;
import utilities.EnumContainer.Water;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class NavalArena extends Arena{

	public static final int MAX_RACERS = 5;
	private static final double FRICTION = 0.7;
	private static double length=1000;
	private static Water water =Water.SWEET;
	private static Surface surface =Surface.FLAT;
	private static Body body =Body.LAKE;
	
	public NavalArena(double length, int maxRacers) {
		super(length,maxRacers,FRICTION);
	}
	public NavalArena() {
		super(length,MAX_RACERS,FRICTION);
	}
	/**
	 * function adds a new racer to the arena
	 * @param newRacer
	 */
	public void addRacer(IRacer newRacer) throws RacerLimitException, RacerTypeException {
		String message;
		if(!(newRacer instanceof NavalRacer)) {
			 message = "Invalid Racer of type"+" "+'"'+((Racer) newRacer).className()+'"'+"for "+this.getClass().getSimpleName();
			throw new RacerTypeException(message);
		}
		if(this.getActiveRacers().size()==this.getMAX_RACERS()) {
			message = "Arena is full!"+"("+this.getActiveRacers().size()+" active racers exist)."+"racer #"+Racer.getSerialId()+" was not added";
			throw new RacerLimitException(message);
		}

		else {
			this.getActiveRacers().add((Racer) newRacer);
		}
	}
	/**
	 * @return the water
	 */
	public static Water getWater() {
		return water;
	}
	/**
	 * @param water the water to set
	 */
	public static void setWater(Water water) {
		NavalArena.water = water;
	}
	/**
	 * @return the surface
	 */
	public static Surface getSurface() {
		return surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public static void setSurface(Surface surface) {
		NavalArena.surface = surface;
	}
	/**
	 * @return the body
	 */
	public static Body getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public static void setBody(Body body) {
		NavalArena.body = body;
	}


}
