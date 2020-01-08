/**
 * 
 */
package game.racers.decorator.state;

import game.racers.Racer;

/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class RacerBrokeDown implements RacerState {
	Racer racer;
	public RacerBrokeDown(Racer newRacer) {
		racer= newRacer;
		ChangedState();
	}
	@Override
	public void ChangedState() {
		// TODO Auto-generated method stub
		racer.getArena().getBrokenRacers().add( racer);

	}
	public String toString() {
		return "BrokeDown";
	}
}
