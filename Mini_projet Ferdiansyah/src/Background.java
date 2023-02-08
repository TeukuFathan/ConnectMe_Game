
import org.newdawn.slick.*;

public class Background {
	private int margin = 5;

	public void dessinerBackground(Graphics g) throws SlickException {

		Image fondecran = new Image("Image/background_def.png");
		fondecran.draw(0, 0);

		Image barNavigateur = new Image("Image/navigate.png");
		barNavigateur.draw(0, 500);

		for (int i = 0; i < 5; i++) { // couleur chaque carrés (sol)
			for (int a = 0; a < 5; a++) {
				g.setColor(Color.white);
				g.drawRect((i * 100) + margin, (a * 100) + margin, 90, 90);
			}
		}

	}
	
	// vérifier s'il tout les carrés sont connecter 
	public boolean AllConnected(Carre[] niveau) {
		
		int connected = 0;
		boolean finished = false;

		for (Carre c : niveau) {
			if (c.EstConnecter(niveau)) { 
				connected++;
			}

		}

		if (connected == niveau.length) {
			finished = true;
		}

		return finished;

	}

	public boolean retourAuMenu(GameContainer gc, int mouseX, int mouseY, Menu menu) {
		if (mouseY > 500 && mouseX <= 150) {
			menu.setMenuOuvert(true);
			menu.setDrawHelp(false);
			return true;
		} else {
			return false;
		}
	}

	public boolean afficheAide(GameContainer gc, int mouseX, int mouseY, Menu menu) {
		if (mouseY > 500 && (mouseX <= 300 && mouseX > 150)) {
			menu.setDrawHelp(true);
			return true;
		} else {
			return false;
		}
	}

	public boolean avancer(GameContainer gc, int mouseX, int mouseY) {
		if (mouseY > 500 && mouseX > 300) {
			return true;
		} else {
			return false;
		}

	}

	public void drawBravo(Graphics g, boolean jeuEstFini) throws SlickException {
		if (jeuEstFini) {
			Image img = new Image("Image/Bravo.png");
			img.draw(0, 0);
		}

	}
}
