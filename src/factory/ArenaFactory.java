package factory;

import game.arenas.Arena;
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class ArenaFactory {
	
    public Arena getArena(String arenaType){
        switch (arenaType){
            case "AerialArena":
                return new AerialArena();   //creates new AerialArena
            case "LandArena":
                return new LandArena();    //creates new LandArena
            case "NavalArena":
                return new NavalArena();  //creates new NavalArena
            default:
                return null;
        }
    }
}
