package game.racers.air;

import game.racers.Racer;
import utilities.EnumContainer.Color;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Helicopter extends Racer implements AerialRacer{
	private static double  maxSpeed =400;
	private static double acceleration=50;
	private static Color color =Color.BLUE;
	
	public Helicopter() {
		super("Helicopter #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);

	}
	public Helicopter(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
	}
	
	
	/* (non-Javadoc)
	 * @see game.racers.Racer#describeSpecific()
	 */
	@Override
	public String describeSpecific() {
		
		return "";
	}
	
	@Override
	public void run() {
		super.run();
	}



}
