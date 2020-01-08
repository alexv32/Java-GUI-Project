package factory.Gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */

public class RacePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

	/**
	 * Create the panel.
	 */
	public RacePanel() {

	}

    @Override
    protected void paintComponent(Graphics g){ 
        super.paintComponent(g);    
        g.drawImage(image, 0, 0, null);
    } 

    public void changeImage(Image img) {
        this.image = img;
        image = img.getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        repaint();

    }

}