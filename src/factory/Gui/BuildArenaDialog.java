package factory.Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import factory.ArenaFactory;
import factory.RaceBuilder;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.decorator.CloneFactory;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class BuildArenaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblChooseArena;
	private JComboBox<String> cmbArena;
	private JTextField txtArenaLength;
	private JTextField txtMaxRacers;
	private RacePanel racePan;
	private Arena arena;
	private Mainframe FRAME;
	private String arenaChoose;
	private int length;
	private int maxRacers;
	private String arenaFullName;
	private BufferedImage image;


	/**
	 * Create the dialog.
	 */
	public BuildArenaDialog(Mainframe mainframe, RacePanel race_Panel) {
		racePan=race_Panel;
		FRAME=mainframe;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblChooseArena = new JLabel("Choose Arena:");
		}

		cmbArena = new JComboBox<String>();
		for (String string : RacingClassesFinder.getInstance().getArenasNamesList()) {
			cmbArena.addItem(string);
		}
		JLabel lblArenaLength = new JLabel("Arena Length:");
		txtArenaLength = new JTextField();
		txtArenaLength.setText("1000");
		txtArenaLength.setColumns(10);
		JLabel lblMaxRacers = new JLabel("Max Racers:");
		txtMaxRacers = new JTextField();
		txtMaxRacers.setText("8");
		txtMaxRacers.setColumns(10);

		JButton btnBuildAutoCar = new JButton("Build Auto Car Race");
		btnBuildAutoCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AutoRaceBuilder(arg0);
				} catch (ClassNotFoundException| NoSuchMethodException| InstantiationException|
						IllegalAccessException| InvocationTargetException| RacerLimitException| RacerTypeException|IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());				
				}
			}
		});
		btnBuildAutoCar.setActionCommand("Auto");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(132, Short.MAX_VALUE)
						.addComponent(lblChooseArena)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cmbArena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(169))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
						.addComponent(lblArenaLength)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtArenaLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblMaxRacers)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtMaxRacers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(153, Short.MAX_VALUE)
						.addComponent(btnBuildAutoCar)
						.addGap(137))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChooseArena)
								.addComponent(cmbArena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArenaLength)
								.addComponent(txtArenaLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaxRacers)
								.addComponent(txtMaxRacers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBuildAutoCar)
						.addContainerGap(106, Short.MAX_VALUE))
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							arenaButtonActionPreformed(e);
						} catch (SecurityException | IllegalArgumentException | IOException e1) {
							JOptionPane.showMessageDialog(null,"Please enter Values");
						}
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
		}
	}
	/**
	 * the button action function that adds the arena and throws exceptions if needed
	 * @param e,the action the button got
	 * @throws IOException 
	 */
	public void arenaButtonActionPreformed(ActionEvent e) throws IOException {

		String action = e.getActionCommand();
		if (action.equals("OK")) {
			intiArenaFromGui();
			Mainframe.setArena(new ArenaFactory().getArena(arenaChoose));
			Mainframe.getArena().setLength(length);
			Mainframe.getArena().setMAX_RACERS(maxRacers);
			image = ImageIO.read(Mainframe.class.getResource("icons/arena/"+arenaChoose+".jpg"));
			int newRacePanelWidth =length;
			int newRacePanelHight = (int) (87.5*maxRacers);
			int newFrameWidth= newRacePanelWidth;
			int newFrameHeight = newRacePanelHight+90;

			if((maxRacers)>=8) {
				racePan.setSize(newRacePanelWidth,newRacePanelHight);
				FRAME.setSize(newFrameWidth, newFrameHeight);
			}
			racePan.changeImage(image);
		}
	}
	public void AutoRaceBuilder(ActionEvent e) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
	IllegalAccessException, InvocationTargetException, RacerLimitException, RacerTypeException,IOException {

		String action = e.getActionCommand();
		ArenaReset();
		if (action.equals("Auto")) {	
			Mainframe.setArena(new ArenaFactory().getArena("LandArena"));
			arena=Mainframe.getArena();
			Mainframe.getArena().setLength(Integer.valueOf(txtArenaLength.getText()));
			Mainframe.getArena().setMAX_RACERS(Integer.valueOf(txtMaxRacers.getText()));
			image = ImageIO.read(Mainframe.class.getResource("icons/arena/LandArena.jpg"));
			int newRacePanelWidth =Integer.valueOf(txtArenaLength.getText());
			int newRacePanelHight = (int) (87.5*Integer.valueOf(txtMaxRacers.getText()));
			int newFrameWidth= newRacePanelWidth;
			int newFrameHeight = newRacePanelHight+90;
			if((Integer.valueOf(txtMaxRacers.getText()))>=8) {
				racePan.setSize(newRacePanelWidth,newRacePanelHight);
				FRAME.setSize(newFrameWidth, newFrameHeight);
			}
			racePan.changeImage(image);
			
			RaceBuilder builder=RaceBuilder.getInstance();
			Racer car=builder.buildRacer("game.racers.land.Car");
			arena.addRacer(car);
			car.addObserver(FRAME);
			Mainframe.getRacers().add(car);
			JLabel label=new JLabel();
			FRAME.addPicToRace(car, label, car.getClass().getSimpleName(), car.getColor().toString());
			CloneFactory cloneFactory=new CloneFactory();
			Racer newRacer;
			for(int i=1;i<Integer.valueOf(txtMaxRacers.getText());i++) {
				newRacer=cloneFactory.getRacer(car);
				newRacer.setName("Car#"+Integer.toString(newRacer.getSerialNumber()));
				newRacer.setColor(car.getColor());
				Mainframe.getArena().addRacer(newRacer);
				Mainframe.getRacers().add(newRacer);
				label=new JLabel();
				newRacer.addObserver(FRAME);
				FRAME.addPicToRace(newRacer, label, newRacer.getClass().getSimpleName(), newRacer.getColor().toString());
			}
			setVisible(false);
		}
	}
	/**
	 * 
	 */
	public void ArenaReset() {
		racePan.removeAll();
		
		if(arena !=null) {
			Mainframe.setArena(null);
			Mainframe.setRacers(new ArrayList<Racer>());
			FRAME.setRacersPics(new ArrayList<JLabel>());
			FRAME.setyPlacement(0);
			FRAME.setOnGoingRaceFlag(false);
		}
	}

	/**
	 * function for initializing the parameters for the arena build
	 */
	public void intiArenaFromGui(){
		ArenaReset();
		arenaChoose = (String)cmbArena.getSelectedItem();
		length = Integer.parseInt(txtArenaLength.getText());
		maxRacers = Integer.parseInt(txtMaxRacers.getText());
		arenaFullName = "";
		for(String string:RacingClassesFinder.getInstance().getArenasList()) {
			if(string.contains(arenaChoose)) {
				arenaFullName=string;
			}
		}
	}
}
