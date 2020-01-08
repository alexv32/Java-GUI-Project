package factory.Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

import factory.RaceBuilder;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import utilities.EnumContainer.Color;

public class AddRacerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRacerName;
	private JLabel lblRacerName;
	private JTextField txtMaxSpeed;
	private JLabel lblChooseColor;
	private JComboBox<Color> cmbColor;
	private JTextField txtAcceleration;
	private JComboBox<String> cmbRacers;
	private JButton okButton;
	private JButton cancelButton;
	private String racerChoose;
	private String racerName;
	private double maxSpeed;
	private double acceleration;
	private String racerFullName;
	private Racer buildRacer;
	private Color color;
	private Mainframe FRAME;
	private static RaceBuilder builder = RaceBuilder.getInstance();
	private Arena arena;
	private JButton prototype=new JButton("Registered Racers");
	private JButton decorator=new JButton("Decorator");
	/**
	 * Create the dialog.
	 * @param mainframe 
	 */
	public AddRacerDialog(Mainframe mainframe, RacePanel race_Panel,Arena garena) {
		setTitle("Add Racer");
		//		super(new JFrame(),"Add Racer",true);
		arena=garena;
		FRAME=mainframe;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel racerChoosePanel = new JPanel();
		contentPanel.add(racerChoosePanel, BorderLayout.NORTH);

		JLabel lblChooseRacer = new JLabel("Choose Racer:");
		racerChoosePanel.add(lblChooseRacer);


		cmbRacers = new JComboBox<String>();
		for (String string : RacingClassesFinder.getInstance().getRacersNamesList()) {
			cmbRacers.addItem(string);
		}
		racerChoosePanel.add(cmbRacers);
		racerChoosePanel.add(prototype);
		prototype.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prototypeButtonActionPerformed(e);
				
			}
		});


		JPanel colorAndAccPanel = new JPanel();
		contentPanel.add(colorAndAccPanel, BorderLayout.EAST);
		lblChooseColor = new JLabel("Choose Color:");
		cmbColor = new JComboBox<Color>();
		for (Color string : Arrays.asList(Color.values())) {
			cmbColor.addItem(string);
		}
		
		JLabel lblAcceleration = new JLabel("Acceleration:");
		txtAcceleration = new JTextField();
		txtAcceleration.setColumns(10);
		GroupLayout gl_colorAndAccPanel = new GroupLayout(colorAndAccPanel);
		gl_colorAndAccPanel.setHorizontalGroup(
				gl_colorAndAccPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_colorAndAccPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_colorAndAccPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_colorAndAccPanel.createSequentialGroup()
										.addComponent(lblChooseColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cmbColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_colorAndAccPanel.createSequentialGroup()
										.addComponent(lblAcceleration)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtAcceleration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_colorAndAccPanel.setVerticalGroup(
				gl_colorAndAccPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_colorAndAccPanel.createSequentialGroup()
						.addGap(8)
						.addGroup(gl_colorAndAccPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChooseColor))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_colorAndAccPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAcceleration)
								.addComponent(txtAcceleration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(129, Short.MAX_VALUE))
				);
		colorAndAccPanel.setLayout(gl_colorAndAccPanel);


		JPanel nameAndSpeedPanel = new JPanel();
		contentPanel.add(nameAndSpeedPanel, BorderLayout.WEST);

		lblRacerName = new JLabel("Racer Name:");


		txtRacerName = new JTextField();
		txtRacerName.setColumns(10);


		JLabel lblMaxSpeed = new JLabel("Max Speed:");

		txtMaxSpeed = new JTextField();
		txtMaxSpeed.setColumns(10);
		GroupLayout gl_nameAndSpeedPanel = new GroupLayout(nameAndSpeedPanel);
		gl_nameAndSpeedPanel.setHorizontalGroup(
				gl_nameAndSpeedPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_nameAndSpeedPanel.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_nameAndSpeedPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_nameAndSpeedPanel.createSequentialGroup()
										.addComponent(lblMaxSpeed)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtMaxSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_nameAndSpeedPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblRacerName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtRacerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		gl_nameAndSpeedPanel.setVerticalGroup(
				gl_nameAndSpeedPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_nameAndSpeedPanel.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_nameAndSpeedPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRacerName)
								.addComponent(txtRacerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(4)
						.addGroup(gl_nameAndSpeedPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMaxSpeed)
								.addComponent(txtMaxSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(123, Short.MAX_VALUE))
				);
		nameAndSpeedPanel.setLayout(gl_nameAndSpeedPanel);

		JPanel clickPanel=new JPanel();
		clickPanel.setLayout(new BorderLayout());
		clickPanel.add(decorator, BorderLayout.NORTH);
		JPanel buttonPane = new JPanel();
		clickPanel.add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(clickPanel, BorderLayout.SOUTH);
		decorator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				decoratorActionPerformed(e);
			}
		});
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OkactionPerformed(e);
				} catch (StringIndexOutOfBoundsException | ClassNotFoundException | NoSuchMethodException
						| InstantiationException | IllegalAccessException | InvocationTargetException
						| RacerLimitException | RacerTypeException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				setVisible(false);
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);


		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);



	}
	public void decoratorActionPerformed(ActionEvent e) {
		DecoratorDialog dialog=null;
		try {
			dialog=new DecoratorDialog(this,FRAME);
			dialog.setVisible(true);
		}
		catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "No Arena");
		}
		setVisible(false);
	}
	public void prototypeButtonActionPerformed(ActionEvent e) {
		PrototypeDialog dialog = null;
		try {
			dialog = new PrototypeDialog(this,FRAME);
			dialog.setVisible(true);
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "No Arena");
		}setVisible(false);
		
	}
	public void OkactionPerformed(ActionEvent e) throws StringIndexOutOfBoundsException, RacerLimitException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, RacerTypeException {
		if(e.getSource() == okButton) {
			initRacerFromGui();
			addRacerAndPaint();

		}

	}
	public void addRacerAndPaint() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
	IllegalAccessException, InvocationTargetException, RacerLimitException, RacerTypeException {
		buildRacer = builder.buildRacer(racerFullName, racerName, maxSpeed, acceleration, color);
		arena.addRacer(buildRacer);
		Mainframe.getRacers().add(buildRacer);
		buildRacer.addObserver(FRAME);
		JLabel jLabel = new JLabel();
		FRAME.addPicToRace(buildRacer,jLabel,racerChoose,color.toString());
	}
	/**
	 * gets the racer data from the gui and handles it, throws exception if a problem occurs
	 * @throws StringIndexOutOfBoundsException
	 * @throws RacerLimitException
	 */
	public void initRacerFromGui() throws StringIndexOutOfBoundsException,RacerLimitException {
		if(arena ==null) {
			throw new StringIndexOutOfBoundsException("There is no arena!!!!");
		}
		if(txtRacerName.getText().isEmpty() || txtMaxSpeed.getText().isEmpty() || txtAcceleration.getText().isEmpty()
				|| Double.parseDouble(txtMaxSpeed.getText())<0|| Double.parseDouble(txtAcceleration.getText())<0 ) {
			throw  new StringIndexOutOfBoundsException("Invalid Data Input! Please try again.");
		}
		if(arena.getActiveRacers().size()>=arena.getMAX_RACERS()) {
			throw new RacerLimitException("Racer Limit Exceeded.");
		}
		racerChoose = (String)cmbRacers.getSelectedItem();
		racerName = txtRacerName.getText();
		maxSpeed = Double.parseDouble(txtMaxSpeed.getText());
		acceleration = Double.parseDouble(txtAcceleration.getText());
		racerFullName = null;
		buildRacer = null;
		color = (Color)cmbColor.getSelectedItem();
		for(String string:RacingClassesFinder.getInstance().getRacersList()) {
			if(string.contains(racerChoose)) {
				racerFullName=string;
			}
		}

	}

}
