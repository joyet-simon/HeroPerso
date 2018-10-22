package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Hero;

public class HeroController {
	private List<Hero> listHero = new ArrayList<Hero>();

	public HeroController() {
		super();
	}

	public HeroController(List<Hero> listHero) {
		super();
		this.listHero = listHero;
	}

	public void showHero(JPanel pan, List<Hero> lh) {
		JCheckBox check;
		if (lh.size() == 0) {
			JLabel str = new JLabel("Aucun hero existant!!");
			pan.add(str);
		} else {
			for (Hero hero : lh) {
				check = new JCheckBox(hero.getNom());
				pan.add(check);

			}
		}
	}

	public void createHero(JPanel pan, String hero, List<Hero> lh) {
		if (!hero.isEmpty()) {
			Hero h = new Hero(hero);
			lh.add(h);
			pan.removeAll();
			pan.setVisible(false);
			pan.setVisible(true);
			showHero(pan, lh);

		}
	}

	public void deleteHero(JPanel pan, List<Hero> lh, String name) {
		for (Hero hero : lh) {
			if (hero.getNom().equals(name)) {
				lh.remove(hero);
			}
		}
		Iterator<Hero> it = lh.iterator();
		while (it.hasNext()) {
			if (it.next().equals(name)) {
				it.remove();
			}
		}
		pan.removeAll();
		pan.setVisible(false);
		pan.setVisible(true);
		showHero(pan, lh);

	}

	public List<Hero> getListHero() {
		return listHero;
	}

	public void setListHero(List<Hero> listHero) {
		this.listHero = listHero;
	}

}
