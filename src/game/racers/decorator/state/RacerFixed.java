package game.racers.decorator.state;

import game.racers.Racer;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class RacerFixed implements RacerState {
	Racer racer;
	public RacerFixed(Racer iracer) {
	racer =iracer;
	ChangedState();
	}

	@Override
	public void ChangedState() {
		racer.getArena().getBrokenRacers().remove(racer);

	}

}
