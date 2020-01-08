/**
 * 
 */
package game.racers;

import java.util.Observable;

/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public abstract class IRacer extends Observable  {
	public IRacer(){
	}
	public abstract void addAttribute(String name,Object obj);

	public abstract void introduce();


}
