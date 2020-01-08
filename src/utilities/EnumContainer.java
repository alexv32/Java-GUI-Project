package utilities;

/**
 * Contains all Enums for the game.
 * 
 * To set a field type: 
 * 		EnumContainer.Vision vision;
 * To set a value:
 * 		this.vision = EnumContainer.Vision.Sunny
 * 
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class EnumContainer {
	public enum Color {
		RED,GREEN,BLUE,BLACK,YELLOW
	}
	
	public static enum Vision {
		CLOUDS, SUNNY, FOG
	}
	public static enum Weather{
		DRY,RAIN,SNOW
	}
	public static enum Height {
		LOW,MEDIUM,HIGH
	}
	public static enum Wind {
		LOW,MEDIUM,HIGH
	}
	public static enum Water{
		SALTED, SWEET
	}
	public static enum Surface{
		FLAT, WAVY,MOUNTAIN
	}
	public static enum Body{
		SEA,LAKE,RIVER,OCEAN
	}
	public static enum Coverage{
		SAND,GRASS,MUD
	}
	public static enum Engine{
		FOURSTROKE,VTYPE,STRAIGHT,BOXER,ROTARY
	}
	public static enum Breed{
		THOROUGHBRED,STANDARDBRED,MORGAN,FRIESIAN
	}
	public static enum Type{
		MOUNTAIN,HYBRID,CRUISER,ROAD,SKULLING,SWEEP
	}
	public static enum Team{
		SINGLE,DOUBLE,QUAD,EIGHT
		
	}
	public static enum RacerEvent{
		FINISHED,BROKENDOWN,REPAIRED,DISABLED, Moved
	}
}
