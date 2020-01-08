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
public interface RacerClone extends Cloneable {

    public Racer clone();

    // for testing purposes , we want to know the hashcode
    public int getHashCode();

}
