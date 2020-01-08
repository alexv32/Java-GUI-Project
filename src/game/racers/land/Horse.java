package game.racers.land;

import game.racers.Racer;
import utilities.EnumContainer.Breed;
import utilities.EnumContainer.Color;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Horse extends Racer implements LandRacer{
	
	private static double  maxSpeed =50;
	private static double acceleration=3;
	private  Breed breed =Breed.FRIESIAN ;
	private static  Color color=Color.BLACK;
	
	public Horse(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		
	}
	public Horse() {
		super("Horse #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);

	}
	
	/**
	 * describes the racer specifics
	 */
	/* (non-Javadoc)
	 * @see game.racers.Racer#describeSpecific()
	 */
	@Override
	public String describeSpecific() {
		
		return "Breed:"+this.getBreed();
	}

	/**
	 * @return the breed
	 */
	public Breed getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	@Override
	public void run() {
		super.run();
	}


}
