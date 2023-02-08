
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Menu {

	private boolean MenuOuvert = true;
	private boolean drawHelp = false;

	// Coordonnees de chaque button
	private int xniveau1 = (500 - 300) / 2;
	private int yniveau1 = 120;

	private int xniveau2 = (500 - 300) / 2;
	private int yniveau2 = 180;

	private int xhelp = (500 - 300) / 2;
	private int yhelp = 340;
	
	private int xaleatoire = (500 - 300) / 2;
	private int yaleatoire = 240;
	
	// getter & setter
	public boolean getMenuOuvert() {
		return MenuOuvert;
	}

	public void setMenuOuvert(boolean menuOuvert) {
		this.MenuOuvert = menuOuvert;
	}

	public boolean isDrawHelp() {
		return drawHelp;
	}

	public void setDrawHelp(boolean drawHelp) {
		this.drawHelp = drawHelp;
	}

	// Dessiner le button
	public void welcomeMenu(Graphics g, boolean menuOuvert) throws SlickException {
		if (menuOuvert) {

			Image FondEcran = new Image("Image/background_game.png");
			FondEcran.draw(0, 0);

			Image img = new Image("Image/ConnectMe.png");
			img.draw(50, 0);

			Image niveau1 = new Image("Image/Niveau1.png");
			niveau1.draw(xniveau1, yniveau1);

			Image niveau2 = new Image("Image/Niveau2.png");
			niveau2.draw(xniveau2, yniveau2);
			
			Image aleatoire = new Image("Image/aleatoire.png");
			aleatoire.draw(xaleatoire,yaleatoire);

			Image help = new Image("Image/Help.png");
			help.draw(xhelp, yhelp);
		}

	}

	public boolean niveau1Cliquer(GameContainer gc, int mouseX, int mouseY) {
		if (mouseY > 100 && mouseY <= 200) {
			return true;
		} else {
			return false;
		}

	}

	public boolean niveau2Cliquer(GameContainer gc, int mouseX, int mouseY) {
		if (mouseY > 200 && mouseY <= 290) {
			return true;
		} else {
			return false;
		}

	}
	public boolean aleatoireCliquer(GameContainer gc, int mouseX, int mouseY) {
		if (mouseY > 290 && mouseY <= 340) {
			return true;
		} else {
			return false;
		}

	}

	public boolean helpCliquer(GameContainer gc, int mouseX, int mouseY) {
		if (mouseY > 340 && mouseY <= 500) {
			return true;
		} else {
			return false;
		}
	}

	public int menuEstCliquer(GameContainer gc, int mouseX, int mouseY) {
		if (niveau1Cliquer(gc, mouseX, mouseY)) {
			setMenuOuvert(false);
			return 1;
		} else if (niveau2Cliquer(gc, mouseX, mouseY)) {
			setMenuOuvert(false);
			return 2;
		} else if (aleatoireCliquer(gc, mouseX, mouseY)) {
			setMenuOuvert(false);
			return 3;
		} else if (helpCliquer(gc, mouseX, mouseY)) {
			setMenuOuvert(false);
			return 4;
		} else {
			return 0;
		}

	}

	public void drawHelp(boolean drawHelp) throws SlickException {
		if (drawHelp) {
			Image help = new Image("Image/Helpp.png");
			help.draw(0, 0);
		}
	}

}
