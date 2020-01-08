package game.racers.decorator.state;

import game.racers.Racer;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class RacerFinished implements RacerState {
	Racer racer;
	public RacerFinished(Racer iRacer) {
		racer =iRacer;
		ChangedState();
	}


	public String toString() {
		return "Finished";
	}


	@Override
	public void ChangedState() {
		// TODO Auto-generated method stub
		racer.getArena().getCompletedRacers().add( racer);
		racer.getArena().getActiveRacers().remove( racer);
		racer.setFinishTime(racer.getElapsedTime());

	}


}
