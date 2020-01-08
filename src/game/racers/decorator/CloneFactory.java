/**
 * 
 */
package game.racers.decorator;

import game.racers.Racer;

/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class CloneFactory{
	
    public Racer getRacer(Racer racer){
        Racer clone =racer.clone();
		return clone;
    }


}
