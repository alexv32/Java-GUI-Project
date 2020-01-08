package game.racers.decorator.state;

import game.racers.Racer;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class RacerDisabled implements RacerState {
	Racer racer;
	public RacerDisabled(Racer iracer) {
		racer =iracer;
		ChangedState();
	}
	@Override
	public void ChangedState() {
		// TODO Auto-generated method stub
		racer.getArena().getDisabledRacers().add( racer);
		racer.getArena().getActiveRacers().remove( racer);

	}

	public String toString() {
		return "Disabled";
	}
}
