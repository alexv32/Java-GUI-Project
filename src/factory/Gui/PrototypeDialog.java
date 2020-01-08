package factory.Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.decorator.CloneFactory;
import utilities.EnumContainer.Color;
/**
 * 
 * @author Alex Weizman 314342064, 
 * @author Shmuel moha 204568323
 *
 */
public class PrototypeDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> cmbRegisteredRacers;
	private JLabel prototype=new JLabel("Registered Racers:");
	private Arena arena;
	private JButton okButton;
	private JButton cancelButton;
	private int cloneChoice;
	private Mainframe FRAME;
	private JPanel NameAndSpeed;
	private JComboBox<String> cmbColor=new JComboBox<>();
	private JLabel lblChangeColor;
	private JComboBox<Color> cmbChangeColor;
	private JLabel lblChangeNumber;
	private JTextField txtChangenumber;
	public PrototypeDialog(AddRacerDialog addRacer,Mainframe frame) {
		arena=Mainframe.getArena();
		FRAME=frame;
		setTitle("Copy Registered Racer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		JPanel registered=new JPanel();
		contentPanel.add(registered,BorderLayout.NORTH);

		cmbRegisteredRacers = fillCombo();
		cmbRegisteredRacers.setActionCommand("changed");
		registered.add(prototype);
		registered.add(cmbRegisteredRacers);

		NameAndSpeed = new JPanel();
		contentPanel.add(NameAndSpeed, BorderLayout.CENTER);
		NameAndSpeed.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblChangeColor = new JLabel("Change Color");
		NameAndSpeed.add(lblChangeColor);
		
		cmbChangeColor = new JComboBox<Color>();
		for (Color color : Arrays.asList(Color.values())) {
			cmbChangeColor.addItem(color);
		}
		NameAndSpeed.add(cmbChangeColor);

		lblChangeNumber = new JLabel("Change Number");
		NameAndSpeed.add(lblChangeNumber);

		txtChangenumber = new JTextField();
		NameAndSpeed.add(txtChangenumber);
		txtChangenumber.setColumns(10);

		for (Color color : Arrays.asList(Color.values())) {
			cmbColor.addItem(color.toString());
		}

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OkactionPerformed(e,addRacer);
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

	}
	@SuppressWarnings("unchecked")
	public void OkactionPerformed(ActionEvent e,AddRacerDialog addRacer) throws StringIndexOutOfBoundsException, RacerLimitException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, RacerTypeException {
		String action = e.getActionCommand();
		if (action.equals("OK")) {
			cloneChoice= (int)cmbRegisteredRacers.getSelectedItem();
			CloneFactory cloneFactory=new CloneFactory();
			Racer newRacer;
			for(Racer racer:Mainframe.getRacers()) {
				if(cloneChoice==racer.getSerialNumber()) {
					newRacer=cloneFactory.getRacer(racer);
					newRacer.setColor((Color)cmbChangeColor.getSelectedItem());
					((ArrayList<Color>) newRacer.getProperties().get("color")).add((Color)cmbChangeColor.getSelectedItem());
					Mainframe.getArena().addRacer(newRacer);
					Mainframe.getRacers().add(newRacer);
					JLabel label=new JLabel();
					FRAME.addPicToRace(newRacer, label, newRacer.getClass().getSimpleName(), cmbChangeColor.getSelectedItem().toString());
					break;
				}

			}
		}

	}
	public JComboBox<Object> fillCombo() throws NullPointerException
	{
		JComboBox<Object> combo=new JComboBox<Object>();
		combo.addItem("Select racer");
		for(Racer racer: arena.getActiveRacers())
			combo.addItem(racer.getSerialNumber());
		return combo;
	
	}
}
