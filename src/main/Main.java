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
import javax.swing.JTextField;
import controller.HeroController;
import model.Hero;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	HeroController hc = new HeroController();
	List<Hero> list = new ArrayList<>();
	JPanel pan = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel panp = new JPanel();
	JTextField nameCreateHero = new JTextField();

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

	private Main() {
		super("ProjetPerso");

		setSize(600, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		hc.showHero(pan, list);
		buttonCreate(pan2, "Create");
		buttonCreate(pan2, "Delete");
		initialize(pan2, nameCreateHero);
		panp.setLayout(new GridLayout(3, 1));
		panp.add(pan2, BorderLayout.NORTH);
		panp.add(pan, BorderLayout.CENTER);
		add(panp);

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
			hc.createHero(pan, newHeroName, list);
		} else if (butName.equals("Delete")) {
			for (Component c : pan.getComponents()) {
				JCheckBox chk = (JCheckBox) c;
				System.out.println(chk.isSelected());
				if (chk.isSelected()) {
					String name= chk.getText().toString();
					Hero hero = new Hero(chk.getText().toString());
					hc.deleteHero(pan, list, name);
				}
			}
		}

	}

}
