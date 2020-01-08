package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Airplane extends Racer implements AerialRacer{
	private static int numOfWheels=3;
	private static double  maxSpeed =885;
	private static double acceleration=100;
	private static Color color =Color.BLACK;
	private Wheeled wheeled;
	
	public Airplane(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);
	}
	public Airplane(String name, double maxSpeed, double acceleration, Color color,int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);
	}

	public Airplane() {
		super("Airplane #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);
	}
	
	/* (non-Javadoc)
	 * @see game.racers.Racer#describeSpecific()
	 */
	@Override
	public String describeSpecific() {
		
		return "NumOfWheels:"+this.wheeled.getNumOfWheels();
	}

	@Override
	public void run() {
		super.run();
	}



}
