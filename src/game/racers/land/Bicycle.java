/**
 * 
 */
package game.racers.land;

import java.lang.reflect.Constructor;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;


/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Bicycle extends Racer implements LandRacer {

	private static int numOfWheels=2;
	private static double  maxSpeed =270;
	private static double acceleration=10;
	private static Color color =Color.GREEN;
	private Wheeled wheeled;
	/**
	 * 
	 * @param name
	 * @param maxSpeed
	 * @param acceleration
	 * @param color
	 * @param numOfWheels
	 * {@link Constructor}
	 */
	public Bicycle(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);
		
	}
	public Bicycle(String name, double maxSpeed, double acceleration, Color color,int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);
		
	}

	/**
	  * {@link Constructor} Default
	 */
	public Bicycle() {
		super("Bicycle #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);
		wheeled=new Wheeled(numOfWheels);

	}


/**
 * describeSpecific
 * @return The specific fildes string
 */
	public String describeSpecific() {
		
		return "NumOfWheels:"+ this.wheeled.getNumOfWheels();
	}

	@Override
	public void run() {
		super.run();
	}





}
