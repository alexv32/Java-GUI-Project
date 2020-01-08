package factory;

import factory.Gui.Mainframe;
import game.arenas.Arena;

public interface CarRaceBuildPlan {

	public Arena initRace(int numOfRacers, String arenaType,String racerType, Mainframe mainFrame);
	
}
