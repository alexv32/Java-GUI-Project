package game.racers.decorator;

import game.racers.IRacer;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class WheeledRacer extends RacerDecorator {
	

	public WheeledRacer(IRacer racerToDecorat,int numOfWheels) {
		super(racerToDecorat);
		racerToDecorat.addAttribute("wheels", numOfWheels);
	}
	@Override
	public void addAttribute(String name, Object obj) {
		super.addAttribute(name, obj);
	}
	@Override
	public void introduce() {
		super.introduce();
	}

}
