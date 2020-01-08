package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Car extends Racer implements LandRacer {


	private static int numOfWheels=4;
	private static double  maxSpeed =400;
	private static double acceleration=20;
	private static Color color =Color.RED;
	private Engine engine =Engine.BOXER;
	private Wheeled wheeled;
	public Car(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);	
	}
	public Car(String name, double maxSpeed, double acceleration, Color color,int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);	
	}


	public Car() {
		super("Car #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);
		this.wheeled=new Wheeled(numOfWheels);

	}
	
	/**
	 * describes the racer specifics
	 */
	/* (non-Javadoc)
	 * @see game.racers.Racer#describeSpecific()
	 */
	@Override
	public String describeSpecific() {
		
		return " NumOfWheels: "+ this.wheeled.getNumOfWheels()+","+" Engine: "+this.getEngine();
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}
	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	/**
	 * @return the serialNumber
	 */





}
