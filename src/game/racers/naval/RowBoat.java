package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;
import utilities.EnumContainer.Type;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class RowBoat extends Racer implements NavalRacer{
	
	private static double  maxSpeed =75;
	private static double acceleration=10;
	private static Color color =Color.RED;
	private Team team=Team.DOUBLE;
	private Type type =Type.SKULLING;
	
	public RowBoat(String name, double maxSpeed, double acceleration, Color color) {
		super(name, maxSpeed, acceleration, color);
		
	}
	public RowBoat() {
		super("RowBoat #"+Integer.toString(Racer.getSerialId()+1), maxSpeed, acceleration, color);
	}

	/* (non-Javadoc)
	 * @see game.racers.Racer#describeSpecific()
	 */
	@Override
	public String describeSpecific() {
		
		return "Team:"+this.getTeam()+","+"Type:"+this.getType();
	}

	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public void run() {
		super.run();
	}


}
