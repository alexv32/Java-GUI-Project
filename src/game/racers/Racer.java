package game.racers;

import java.util.ArrayList;
import java.util.Hashtable;

import game.arenas.Arena;
import game.racers.decorator.RacerClone;
import game.racers.decorator.state.RacerState;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.RacerEvent;
import utilities.Fate;
import utilities.Mishap;
import utilities.Point;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public abstract class Racer extends IRacer implements Runnable,RacerClone,Comparable<Racer>{
	private Arena arena;
	private String name;
	private Point currentLocation= new Point();
	private Point finish=new Point();
	private double maxSpeed;
	private double acceleration;
	private double currentSpeed;
	private double failurePropability =0.05;
	private Color color;
	protected static int SerialId=0;
	private int SerialNumber;
	
	private Mishap mishap ;
	private Hashtable<String, Object> properties;
	private RacerState racerState;
	private long elapsedTime;
	private long startTime;
	private long finishTime=0;

	@SuppressWarnings("unchecked")
	public Racer(String name, double maxSpeed, double acceleration, Color color) {
		this.name=name;
		this.maxSpeed=maxSpeed;
		this.acceleration=acceleration;
		this.color=color;
		this.SerialNumber=++Racer.SerialId;
		this.properties=new Hashtable<>();
		this.properties.put("name", this.name);
		this.properties.put("maxSpeed", this.maxSpeed);
		this.properties.put("acceleration", this.acceleration);
		this.properties.put("color",new ArrayList<Color>());
		((ArrayList<Color>) this.properties.get("color")).add(this.color);
		this.properties.put("SerialNumber", this.SerialNumber);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addAttribute(String name, Object obj) {
		if(name=="color") {
			((ArrayList<Color>) this.properties.get("color")).add((Color)obj);
			this.color=(Color)obj;
			}
		else
			if(!this.properties.containsKey("wheels")) {
				this.properties.put("wheels", new ArrayList<Integer>());
				((ArrayList<Integer>) this.properties.get("wheels")).add((int) obj);
				}
			else
				((ArrayList<Integer>) this.properties.get(name)).add((int)obj);
	}
	/* (non-Javadoc)
	 * @see game.racers.decorator.RacerClone#clone()
	 */
	@Override
	public Racer clone() {
		Racer racer=null;
		try {
			Racer.setSerialId(getSerialId()+1);
			racer=(Racer) super.clone();
			racer.SerialNumber=Racer.getSerialId();
			racer.properties=new Hashtable<String,Object> (this.properties);
			racer.properties.put("color",new ArrayList<Color>());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return racer;
	}
	public void setRacerState(RacerState newState) {
		racerState=newState;
	}
	@Override
	public int compareTo(Racer compareracer) {
		long compareage=((Racer)compareracer).getFinishTime();
		/* For Ascending order*/
		return (int)(compareage-this.getFinishTime());
	}

	/* (non-Javadoc)
	 * @see game.racers.decorator.RacerClone#getHashCode()
	 */
	@Override
	public int getHashCode() {
		return System.identityHashCode(this);
	}

	/**
	 * initializes the race
	 * @param arena
	 * @param start
	 * @param finish
	 */
	public void initRace(Arena arena, Point start, Point finish) {
		this.arena=arena;
		this.currentLocation=start;
		this.finish=finish;
	}
	/**
	 * function that moves the racer
	 * @param friction
	 * @return Point object, the new location
	 */
	public synchronized Point move(double friction) {
		double reductionFactor = 1;
		if(!this.arena.getDisabledRacers().contains(this)) {
			if (!(this.hasMishap()) && Fate.breakDown(failurePropability)) {
				this.mishap=Fate.generateMishap();
				this.setChanged();
				this.notifyObservers(RacerEvent.BROKENDOWN);
			}

			if (this.hasMishap()) {
				reductionFactor = mishap.getReductionFactor();
				if(this.mishap.isFixable()) {
					this.mishap.nextTurn();
				}
				else {
					this.setChanged();
					this.notifyObservers(RacerEvent.DISABLED);
				}
				if(this.mishap.getTurnsToFix()==0) {
					this.setChanged();
					this.notifyObservers(RacerEvent.REPAIRED);
				}
			}

			if (this.currentSpeed < this.maxSpeed) {
				this.currentSpeed += this.acceleration * friction * reductionFactor;
			}
			if (this.currentSpeed > this.maxSpeed) {
				this.currentSpeed = this.maxSpeed;
			}
			this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);

			if(this.currentLocation.getX()>=this.arena.getLength()) {
				this.currentLocation.setX(arena.getLength());
				this.setChanged();
				this.notifyObservers(RacerEvent.FINISHED);
				return this.currentLocation;

			}

		}
		this.setChanged();
		this.notifyObservers(RacerEvent.Moved);	
		return this.currentLocation;
	}
	public String describeRacer() {

		return "name:"+this.getName()+","+" SerialNumber: "+this.SerialNumber+" maxSpeed: "+this.getMaxSpeed()+","+
				" acceleration: "+this.acceleration+ ","+"Color: "+this.color+" ";
	}
	public abstract String describeSpecific();//abstract method 

	public void introduce() {
		System.out.println(properties);

	}
	public String className() {
		return this.getClass().getSimpleName();
	}
	/**
	 * @return the arena
	 */
	public Arena getArena() {
		return arena;
	}

	/**
	 * @param arena the arena to set
	 * @return 
	 */
	public boolean setArena(Arena arena) {
		if(arena!= null) {
			this.arena = arena;
			return true;
		}
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 * @return 
	 */
	public boolean setName(String name) {
		if(name.length()!=0) {
			this.name = name;
			return true;
		}
		return false;
	}

	/**
	 * @return the currentLocation
	 */
	public Point getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 * @return 
	 */
	public boolean setCurrentLocation(Point currentLocation) {
		if(currentLocation!=null) {
			this.currentLocation = currentLocation;
			return true;
		}
		return false;
	}

	/**
	 * @return the finish
	 */
	public Point getFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 * @return 
	 */
	public boolean setFinish(Point finish) {
		if(finish!=null) {
			this.finish = finish;
			return true;
		}
		return false;
	}

	/**
	 * @return the maxSpeed
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 * @return 
	 */
	public boolean setMaxSpeed(double maxSpeed) {
		if(maxSpeed>0) {
			this.maxSpeed = maxSpeed;
			return true;
		}
		return false;
	}

	/**
	 * @return the failurePropability
	 */
	public double getFailurePropability() {
		return failurePropability;
	}

	/**
	 * @param failurePropability the failurePropability to set
	 * @since Home Work 3
	 */
	public void setFailurePropability(double failurePropability) {
		this.failurePropability = failurePropability;
	}

	/**
	 * @return the currentSpeed
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * @param currentSpeed the currentSpeed to set
	 */
	public boolean setCurrentSpeed(double currentSpeed) {
		if(currentSpeed>=0) {
			this.currentSpeed = currentSpeed;
			return true;
		}
		return false;
	}

	/**
	 * @return the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public boolean setAcceleration(double acceleration) {
		if(acceleration>=0) {
			this.acceleration = acceleration;
			return true;
		}
		return false;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the serialNumber
	 */
	public static int getSerialId() {
		return SerialId;
	}
	/**
	 * @param serialNumber the serialNumber to set
	 * @return true if the SerialNumber is valid and false if not
	 */
	public static boolean setSerialId(int serialNumber) {
		if(serialNumber>=0) {
			SerialId = serialNumber;
			return true;
		}
		return false;
	}
	/**
	 * @return the mishap
	 */
	public Mishap getMishap() {
		return mishap;
	}
	/**
	 * @param mishap the mishap to set
	 */
	public void setMishap(Mishap mishap) {
		this.mishap = mishap;
	}

	public boolean threadIsStoped() {
		if(this.arena.getCompletedRacers().contains(this)) {return true;}
		return false;
	}
	@Override
	public synchronized void run() {
		startTime = System.currentTimeMillis();
		while(!arena.getCompletedRacers().contains(this) && !arena.getDisabledRacers().contains(this)) {
			this.move(Arena.getFRICTION());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().notify();
			}
			setElapsedTime(System.currentTimeMillis()-startTime);
		}
	}
	private boolean hasMishap() {
		if (this.mishap != null && this.mishap.getTurnsToFix() == 0)
			this.mishap = null;
		return this.mishap != null;
	}
	/**
	 * @return the properties
	 */
	public Hashtable<String, Object> getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Hashtable<String, Object> properties) {
		this.properties = properties;
	}
	public String showRacer() {
		return "name:"+this.getName()+","+" SerialNumber: "+this.SerialNumber+","+"Color: "+this.color;
	}
	/**
	 * @return the elapsedTime
	 */
	public long getElapsedTime() {
		return elapsedTime;
	}
	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	/**
	 * @return the finishTime
	 */
	public long getFinishTime() {
		return finishTime;
	}
	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(long finishTime) {
		this.finishTime = finishTime;
	}

	public int getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}
}
