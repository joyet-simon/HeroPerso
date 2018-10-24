package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.HeroController;
import model.Hero;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	HeroController herocontroller = new HeroController();
	List<Hero> listHero = new ArrayList<>();
	JPanel panListHero = new JPanel();
	JPanel panCreateHero = new JPanel();
	JPanel panDeleteHero = new JPanel();
	JPanel panMain = new JPanel();
	JTextField nameCreateHero = new JTextField();
	JTextArea name = new JTextArea("Name new hero:");

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

	private Main() {
		super("ProjetPerso");

		setSize(600, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		herocontroller.showHero(panListHero, listHero);
		panCreateHero.add(name);
		initialize(panCreateHero, nameCreateHero);
		buttonCreate(panDeleteHero, "Delete");
		buttonCreate(panCreateHero, "Create");
		panMain.setLayout(new GridLayout(3, 1));
		panMain.add(panCreateHero, BorderLayout.NORTH);
		panMain.add(panListHero, BorderLayout.CENTER);
		panMain.add(panDeleteHero, BorderLayout.SOUTH);
		add(panMain);

	}

	private void buttonCreate(JPanel pan, String str) {
		JButton button = new JButton(str);
		button.addActionListener(this);
		pan.add(button);
		button.setSize(10, 30);
	}

	private void initialize(JPanel pan, JTextField name) {
		name.setPreferredSize(new Dimension(100, 30));
		pan.add(name);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String butName = e.getActionCommand();
		if (butName.equals("Create")) {
			String newHeroName = nameCreateHero.getText();
			herocontroller.createHero(panListHero, newHeroName, listHero);
		} else if (butName.equals("Delete")) {
			for (Component c : panListHero.getComponents()) {
				JCheckBox chk = (JCheckBox) c;
				if (chk.isSelected()) {
					String name = chk.getText().toString();
					herocontroller.deleteHero(panListHero, listHero, name);
				}
			}
		}
		panListHero.removeAll();
		panListHero.setVisible(false);
		panListHero.setVisible(true);
		herocontroller.showHero(panListHero, listHero);

	}

}
