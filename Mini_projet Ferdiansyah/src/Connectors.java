import org.newdawn.slick.*;
import java.util.concurrent.TimeUnit;

public class Connectors extends BasicGame {

	private Carre cselect;
	private Background bg = new Background();
	private Carre[] niveau1 = new Carre[7];
	private Carre[] niveau2 = new Carre[9];
	private Carre[] niveau;
	private Menu menu = new Menu();

	// L'initialisation des sprites
	private SpriteSheet sprite10;
	private Animation spriteAnimation10;

	private SpriteSheet sprite11;
	private Animation spriteAnimation11;

	private SpriteSheet sprite12;
	private Animation spriteAnimation12;

	private SpriteSheet sprite13;
	private Animation spriteAnimation13;

	private SpriteSheet sprite14;
	private Animation spriteAnimation14;

	private SpriteSheet sprite15;
	private Animation spriteAnimation15;

	private SpriteSheet sprite16;
	private Animation spriteAnimation16;

	private SpriteSheet sprite17;
	private Animation spriteAnimation17;

	public Connectors(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		bg.dessinerBackground(g);

		for (Carre carre : niveau) {
			if (cselect != carre) {
				carre.dessiner(g);
			}

			if (cselect != null) {
				if (cselect.getNomCarre() == "4(3,2,2,4)") {
					niveau[0].drawAnime(g, spriteAnimation10, cselect);
				}
				if (cselect.getNomCarre() == "1(0,3,0,0)") {
					niveau[0].drawAnime(g, spriteAnimation16, cselect);
				}
				if (cselect.getNomCarre() == "5(2,0,0,0)") {
					niveau[0].drawAnime(g, spriteAnimation14, cselect);
				}
				if (cselect.getNomCarre() == "3(0,4,0,1)") {
					niveau[0].drawAnime(g, spriteAnimation15, cselect);
				}
				if (cselect.getNomCarre() == "2(0,0,3,0)") {
					niveau[0].drawAnime(g, spriteAnimation11, cselect);
				}
				if (cselect.getNomCarre() == "2(0,0,0,2)") {
					niveau[0].drawAnime(g, spriteAnimation12, cselect);
				}
				if (cselect.getNomCarre() == "3(3,0,0,0)") {
					niveau[0].drawAnime(g, spriteAnimation17, cselect);
				}
				if (cselect.getNomCarre() == "5(0,1,3,0)") {
					niveau[0].drawAnime(g, spriteAnimation13, cselect);

				}
			}
		}

		menu.welcomeMenu(g, menu.getMenuOuvert());
		menu.drawHelp(menu.isDrawHelp());
		
		// Afficher bravo si le jeu est terminé
		bg.drawBravo(g, bg.AllConnected(niveau2));
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stu
		niveau = niveau1;

		menu.setMenuOuvert(true);

		// niveau 1

		// Connection possible de chaque carre

		int[] c1 = { 2, 0, 0, 0 };
		int[] c2 = { 0, 4, 0, 1 };
		int[] c3 = { 0, 0, 3, 0 };
		int[] c4 = { 0, 1, 3, 0 };
		int[] c5 = { 0, 0, 0, 2 };
		int[] c6 = { 0, 3, 0, 0 };

		// Initialisation de chaque carre de niveau 1
		niveau1[0] = new Carre();
		niveau1[1] = new Carre(5, c1, 3, 3, "5(2,0,0,0)");
		niveau1[2] = new Carre(3, c2, 2, 0, "3(0,4,0,1)");
		niveau1[3] = new Carre(2, c3, 0, 1, "2(0,0,3,0)");
		niveau1[4] = new Carre(5, c4, 1, 2, "5(0,1,3,0)");
		niveau1[5] = new Carre(2, c5, 2, 2, "2(0,0,0,2)");
		niveau1[6] = new Carre(1, c6, 1, 3, "1(0,3,0,0)");

		// niveau 2
		// Connection possible de chaque carre

		int[] c21 = { 2, 0, 0, 0 };
		int[] c22 = { 0, 4, 0, 1 };
		int[] c23 = { 0, 0, 3, 0 };
		int[] c24 = { 0, 1, 3, 0 };
		int[] c25 = { 0, 0, 0, 2 };
		int[] c26 = { 0, 3, 0, 0 };
		int[] c27 = { 3, 0, 0, 0 };
		int[] c28 = { 0, 3, 0, 0 };

		// Initialisation de chaque carre de niveau 1
		niveau2[0] = new Carre();
		niveau2[1] = new Carre(5, c21, 3, 3, "5(2,0,0,0)");
		niveau2[2] = new Carre(3, c22, 2, 0, "3(0,4,0,1)");
		niveau2[3] = new Carre(2, c23, 0, 1, "2(0,0,3,0)");
		niveau2[4] = new Carre(5, c24, 1, 2, "5(0,1,3,0)");
		niveau2[5] = new Carre(2, c25, 2, 2, "2(0,0,0,2)");
		niveau2[6] = new Carre(1, c26, 1, 3, "1(0,3,0,0)");
		niveau2[7] = new Carre(1, c28, 0, 0, "1(0,3,0,0)");
		niveau2[8] = new Carre(3, c27, 0, 4, "3(3,0,0,0)");

		// initialisation de l'animation

		// animation 1
		sprite10 = new SpriteSheet("Image/Sprite1.png", 100, 100);
		spriteAnimation10 = new Animation(sprite10, 100);
		// animation 2
		sprite11 = new SpriteSheet("Image/Sprite2.png", 100, 100);
		spriteAnimation11 = new Animation(sprite11, 100);
		// animation 3
		sprite12 = new SpriteSheet("Image/Sprite3.png", 100, 100);
		spriteAnimation12 = new Animation(sprite12, 100);
		// animation 4
		sprite13 = new SpriteSheet("Image/Sprite4.png", 100, 100);
		spriteAnimation13 = new Animation(sprite13, 100);
		// animation 5
		sprite14 = new SpriteSheet("Image/Sprite5.png", 100, 100);
		spriteAnimation14 = new Animation(sprite14, 100);
		// animation 6
		sprite15 = new SpriteSheet("Image/Sprite6.png", 100, 100);
		spriteAnimation15 = new Animation(sprite15, 100);
		// animation 6
		sprite16 = new SpriteSheet("Image/Sprite7.png", 100, 100);
		spriteAnimation16 = new Animation(sprite16, 100);
		// animation 7
		sprite17 = new SpriteSheet("Image/Sprite8.png", 100, 100);
		spriteAnimation17 = new Animation(sprite17, 100);
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		// Si niveau 1 est terminé vas automatiquement a niveau 2
		if (bg.AllConnected(niveau) && niveau == niveau1) {
			niveau = niveau2;
		}

		Input input = gc.getInput();
		int mouseX = input.getMouseX(); // coordonnees souris "x"
		int mouseY = input.getMouseY(); // ------------------ "y"

		Input InMouse = gc.getInput(); // pour voir si MOUSE_LEFT_BUTTON est cliquer
		Input InMouse1 = gc.getInput(); // pour voir si MOUSE_RIGHT_BUTTON est cliquer

		// Le Mouvement de carre en utilisant le souris
		if (InMouse.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

			while (menu.getMenuOuvert()) {
				switch (menu.menuEstCliquer(gc, mouseX, mouseY)) {
				case 1:
					 niveau = niveau1;

					break;
				case 2:
					 niveau = niveau2;

					break;
				case 3:
					int rand = (int)(Math.random() * 2) ;
					if(rand == 0) {
						niveau = niveau1;
					} else {
						niveau = niveau2;
					}
					
					break;
					
				case 4:
					menu.setDrawHelp(true);
					break;
				}
			}
			// button retour et Aide
			bg.retourAuMenu(gc, mouseX, mouseY, menu);
			bg.afficheAide(gc, mouseX, mouseY, menu);

			// button avance
			if (bg.avancer(gc, mouseX, mouseY)) {
				if (niveau == niveau1) {
					niveau = niveau2;
				} else if (niveau == niveau2) {
					niveau = niveau1;
				}
			}
			cselect = niveau[1].trouverCarre(mouseX / 100, mouseY / 100, niveau);
		}

		if (InMouse1.isMousePressed(Input.MOUSE_RIGHT_BUTTON) && cselect != null) {

			if (cselect.EstEmpiles(mouseX, mouseY, niveau) || cselect.getCapability() == 1) { // on veut verifier que le
																								// cap = 1 peut quand
																								// meme tourner
				cselect.mouvement(mouseX, mouseY);
			}

		}

	}
}
