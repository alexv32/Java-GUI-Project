package factory;

import javax.swing.JLabel;

import factory.Gui.Mainframe;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.decorator.CloneFactory;
import game.racers.land.Car;

public class CarRaceBuild implements CarRaceBuildPlan {

	@Override
	public Arena initRace(int numOfRacers, String arenaType,String racerType, Mainframe mainFrame) {
		ArenaFactory getTheArena=new ArenaFactory();
		Arena arena=getTheArena.getArena(arenaType);
		arena.setMAX_RACERS(numOfRacers);
		Mainframe.setArena(arena);
		int i;
		Car car=new Car();
		CloneFactory cloneFactory =new CloneFactory();
		for(i=0;i<numOfRacers;i++) {
			try {
				JLabel icon=new JLabel();
				Racer racer = cloneFactory.getRacer(car);
				arena.addRacer(racer);
				mainFrame.addPicToRace(racer, icon, racerType, racer.getColor().toString());
			} catch (RacerLimitException | RacerTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arena;

	}

}
