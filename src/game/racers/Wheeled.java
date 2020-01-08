package game.racers;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Wheeled  {
	private int numOfWheels;
	
	public Wheeled(int numOfWheeles){
		this.setNumOfWheels(numOfWheeles);
	}
	public Wheeled() {
		this.setNumOfWheels(0);
	}
	/**
	 * @return the numOfWheels
	 */
	public int getNumOfWheels() {
		return numOfWheels;
	}
	/**
	 * @param numOfWheels the numOfWheels to set
	 * @return 
	 */
	public boolean setNumOfWheels(int numOfWheels) {
		if(numOfWheels>=0) {
		this.numOfWheels = numOfWheels;
		return true;
		}
		return false;
	}

}
