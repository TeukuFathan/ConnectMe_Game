import java.util.Arrays;

import org.newdawn.slick.*;

public class Carre {
	
	private String NomCarre;
	private int capability; // 1 = tourner , 2 = horizontal , 3 = vertical , 4 = horizontal et vertical ,5 =
							// rien
	private int[] connection = new int[4]; // numero de connection en un side qu'il a  -> [nHaut , nDroite,
											// nEnbas, nGauche]
	private int x, y; // leurs coordonnes de x et y
	private Image img = null;
	private int angle = 0;

	public Carre() throws SlickException {
		
		NomCarre = "4(3,2,2,4)"; // "Capability,[connection]"
		capability = 4;
		x = 4; // 5 éme carré horizontalement
		y = 4; // 5 éme carré Verticalement
		connection[0] = 3;
		connection[1] = 2;
		connection[2] = 2;
		connection[3] = 4;// [3 connection en haut, 2 connection a droite, 2 connection a droite , 4
							// connections a gauche]
		

	}

	public Carre(int capability, int[] connection, int x, int y, String NomCarre) {

		this.capability = capability;
		this.connection = connection;
		this.x = x;
		this.y = y;
		this.NomCarre = NomCarre;

	}

	// getter / setter

	public String getNomCarre() {
		return NomCarre;
	}

	public int getCapability() {
		return capability;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXcent() {
		return x * 100;
	}

	public int getYcent() {
		return y * 100;
	}
	
	@Override
	public String toString() {
		return "Carre [capability=" + capability + ", connection=" + Arrays.toString(connection) + ", x=" + x + ", y="
				+ y + ", img=" + img + ", NomCarre=" + NomCarre + "]";
	}

	public void dessiner(Graphics g) throws SlickException {

		if (NomCarre == "4(3,2,2,4)") { // "Capability,[connection]"
			img = new Image("Image/4(3,2,2,4).png");
		}
		if (NomCarre == "1(0,3,0,0)") {
			img = new Image("Image/1(0,3,0,0).png");
			img.setRotation(angle);
		}
		if (NomCarre == "5(2,0,0,0)") {
			img = new Image("Image/5(2,0,0,0).png");
		}
		if (NomCarre == "3(0,4,0,1)") {
			img = new Image("Image/3(0,4,0,1).png");
		}
		if (NomCarre == "2(0,0,3,0)") {
			img = new Image("Image/2(0,0,3,0).png");
		}
		if (NomCarre == "2(0,0,0,2)") {
			img = new Image("Image/2(0,0,0,2).png");
		}
		if (NomCarre == "5(0,1,3,0)") {
			img = new Image("Image/5(0,1,3,0).png");
		}
		if (NomCarre == "3(3,0,0,0)") {
			img = new Image("Image/3(3,0,0,0).png");
		}
		if (img != null) {
			img.draw(this.getXcent(), this.getYcent());
		}
	}
	
	public void mouvement(int newX, int newY) throws SlickException {

		switch (capability) {
		case 1:

			angle -= 90;
			int dernierectn = connection[0];
			for (int i = 0; i + 1 < connection.length; i++) { // changer le connection chaque tour
				connection[i] = connection[i + 1];
			}
			connection[3] = dernierectn;
			break;

		case 2:

			this.x = newX / 100;
			break;

		case 3:

			this.y = newY / 100;
			break;

		case 4:

			this.x = newX / 100;
			this.y = newY / 100;
			break;

		case 5:
			break;
		}
	}
	
	public boolean EstCliquer(int x, int y) {

		if ((this.getXcent() <= x && this.getXcent() + 100 >= x)
				&& (this.getYcent() <= y && this.getYcent() + 100 >= y)) { // pour verifier qu'on click bien sur le
																			// carre
			return true;
		} else {
			return false;
		}

	}

	public void drawAnime(Graphics g, Animation animation, Carre cselect) {
		if (cselect != null) {
			g.drawAnimation(animation, cselect.getXcent(), cselect.getYcent());
		}
	}

	public Carre trouverCarre(int x, int y, Carre[] niveau) {
		Carre carreTrouver = null;
		for (Carre c : niveau) {
			if (c.x == x && c.y == y) {
				carreTrouver = c;
				break;
			}
		}
		return carreTrouver;
	}


	public boolean EstConnecter(Carre[] niveau) {
		int flag = 0;
		int checker = 0;

		for (int i = 0; i < 4; i++) {

			if (this.connection[i] != 0) {

				checker++; // les nombres des connectors qui ne sont pas( = 0) sont egale a le nombre
							// connectors qui sont connectes

				switch (i) {

				case 0: // doit etre connecter a (x,y-1)
					Carre tch = trouverCarre(this.x, this.y - 1, niveau); 

					if (tch != null) { // pour eviter le bug (tch == null)
						if (this.connection[0] == tch.connection[2]) {
							flag++;
						} else {
							flag += 0;
						}

					}
					break;

				case 1: // doit etre connecter a (x + 1,y)
					Carre tcd = trouverCarre(this.x + 1, this.y, niveau);
					if (tcd != null) {
						if (this.connection[1] == tcd.connection[3]) {
							flag++;
						} else {
							flag += 0;
						}

					}
					break;

				case 2: // doit etre connecter a (x,y + 1)
					Carre tcb = trouverCarre(this.x, this.y + 1, niveau);
					if (tcb != null) {
						if (this.connection[2] == tcb.connection[0]) {
							flag++;

						} else {
							flag += 0;
						}
					}
					break;

				case 3: // doit etre connecter a (x - 1,y) nge check bagian kiri aja
					Carre tcg = trouverCarre(this.x - 1, this.y, niveau);
					if (tcg != null) {
						if (this.connection[3] == tcg.connection[1]) {
							flag++;
						} else {
							flag += 0;
						}
					}
					break;

				}

			}
		}

		return checker == flag;

	}

	public boolean EstEmpiles(int mouseX, int mouseY, Carre[] niveau) { // verifier qu'il sont pas empiler (fonction
																		// predefinir qu'il vas etre utiliser
																		// en class connectors)
		for (Carre c : niveau) {

			if ((mouseX / 100 == c.x && mouseY / 100 == c.y)
					|| (this.capability == 2 && mouseX / 100 == c.x && this.y == c.y)
					|| (this.capability == 3 && mouseY / 100 == c.y && this.x == c.x)) {
				return false;
			}

		}
		return true;
	}

}
