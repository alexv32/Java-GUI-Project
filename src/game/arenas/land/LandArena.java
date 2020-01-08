package game.arenas.land;

import utilities.EnumContainer.Surface;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.IRacer;
import game.racers.Racer;
import game.racers.land.LandRacer;
import utilities.EnumContainer.Coverage;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class LandArena extends Arena {
	
	public static final int MAX_RACERS = 8;
	private static final double FRICTION = 0.5;
	private static Surface surface=Surface.FLAT;
	private static Coverage coverage=Coverage.GRASS;
	private static double length=800;
	
	public LandArena(double length,int maxRacers) {
		super(length,maxRacers,FRICTION);
		
	}
	public LandArena(){
		super(length,MAX_RACERS,FRICTION);
		
	}
	/**
	 * function adds a new racer to the arena
	 * @param newRacer
	 */
	public void addRacer(IRacer newRacer) throws RacerLimitException, RacerTypeException {
		String message;
		if(!(newRacer instanceof LandRacer)) {
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
	 * @param surface the surface to set
	 */
	public static void setSurface(Surface surface) {
		LandArena.surface = surface;
	}
	/**
	 * @param coverage the coverage to set
	 */
	public static void setCoverage(Coverage coverage) {
		LandArena.coverage = coverage;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		LandArena.length = length;
	}

	
}
