package game.racers.decorator.state;

import game.racers.Racer;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class RacerActive implements RacerState {
	Racer racer;
	public RacerActive(Racer iracer) {
		racer=iracer;
		ChangedState();
	}
	@Override
	public void ChangedState() {
		if(!racer.getArena().getActiveRacers().contains(racer)) {
			racer.getArena().getActiveRacers().add(racer);
		}


	}

	public String toString() {
		return "Moving";
	}
}
