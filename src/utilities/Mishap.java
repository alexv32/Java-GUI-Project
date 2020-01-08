package utilities;
import java.text.DecimalFormat;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class Mishap {
	
	private boolean fixable;
	private double reductionFactor;
	private int turnsToFix;
	DecimalFormat decimalFormat = new DecimalFormat("0.00");
	public Mishap(boolean fixable, int turnsToFix, float reductionFactor) {
		this.setFixable(fixable);
		this.setReductionFactor(reductionFactor);
		this.setTurnsToFix(turnsToFix);
	}
	/**
	 * decreases the turns left to fix the mishap
	 */
	public void nextTurn() {
		this.turnsToFix-=1;
		}
	public String toString() {
		return "("+isFixable()+","+getTurnsToFix()+","+decimalFormat.format(getReductionFactor())+")";
		
	}
	/**
	 * @return the reductionFactor
	 */
	public double getReductionFactor() {
		return reductionFactor;
	}
	/**
	 * @param reductionFactor the reductionFactor to set
	 */
	public void setReductionFactor(double reductionFactor) {
		this.reductionFactor = reductionFactor;
	}
	/**
	 * @return the fixable
	 */
	public boolean isFixable() {
		return fixable;
	}
	/**
	 * @param fixable the fixable to set
	 */
	public void setFixable(boolean fixable) {
		this.fixable = fixable;
	}
	/**
	 * @return the turnsToFix
	 */
	public int getTurnsToFix() {
		return turnsToFix;
	}
	/**
	 * @param turnsToFix the turnsToFix to set
	 */
	public void setTurnsToFix(int turnsToFix) {
		this.turnsToFix = turnsToFix;
	}
}
