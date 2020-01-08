package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer.Color;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class SpeedBoat extends Racer implements NavalRacer {

	private static double  maxSpeed =170;
	private static double acceleration=10;
	private static Color color =Color.RED;
	
	public SpeedBoat(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		
	}

	public SpeedBoat() {
		super("SpeedBoat #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);
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
