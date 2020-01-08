package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer.Color;

/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */

public class RaceBuilder implements Runnable {

	private static RaceBuilder instance;

	public static RaceBuilder getInstance() {
		if (instance == null) {
			instance = new RaceBuilder();
		}
		return instance;
	}

	private ClassLoader classLoader;
	private Class<?> classObject;
	private Constructor<?> constructor;

	private RaceBuilder() {
		classLoader = ClassLoader.getSystemClassLoader();
	}

	public Arena buildArena(String arenaType, double length, int maxRacers)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.classObject = classLoader.loadClass(arenaType);
		this.constructor = classObject.getConstructor(double.class, int.class);
		return (Arena) this.constructor.newInstance(length, maxRacers);

	}

	public Racer buildRacer(String racerType, String name, double maxSpeed, double acceleration,
			utilities.EnumContainer.Color color)
					throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
					IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.classObject = classLoader.loadClass(racerType);
		this.constructor = classObject.getConstructor(String.class, double.class, double.class,
				utilities.EnumContainer.Color.class);
		return (Racer) this.constructor.newInstance(name, maxSpeed, acceleration, color);
	}
	public Racer buildRacer(String racerType)
					throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
					IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.classObject = classLoader.loadClass(racerType);
		this.constructor = classObject.getConstructor();
		return (Racer) this.constructor.newInstance();
	}


	public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, double acceleration, Color color,
			int numOfWheels) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
	InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.classObject = classLoader.loadClass(racerType);
		this.constructor = classObject.getConstructor(String.class, double.class, double.class,
				utilities.EnumContainer.Color.class, int.class);
		return (Racer) this.constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
