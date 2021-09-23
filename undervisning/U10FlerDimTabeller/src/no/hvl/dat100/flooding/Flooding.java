package no.hvl.dat100.flooding;

import easygraphics.*;

public class Flooding extends EasyGraphics {

	// nesten dekket hvis mindre en fra havoverflaten
	int NESTEN_DEKKET = 1;

	int RADIUS = 20; // radius for cirkler som skal tegnes
	int MARGIN = 50; // venstre/h�yre margin i tegneomr�det

	// terreng hogde
	int[][] terreng = { //
			{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 }, //
			{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 }, //
			{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("FLOODING", 800, 300);

		visualiser();

	}

	public void visualiser() {

		System.out.println("Angi havh�yde i tegnevinduet ...");
		int hav = Integer.parseInt(getText("havh�yde"));

		while (hav >= 0) {

			for (int i = 0; i < terreng.length; i++) {

				for (int j = 0; j < terreng[i].length; j++) {

					if (terreng[i][j] <= hav)
						setColor(0, 0, 255);
					else if (terreng[i][j] <= hav + 1)
						setColor(255, 140, 0);
					else
						setColor(222, 184, 135);

					fillCircle(MARGIN + 2 * j * RADIUS, MARGIN + 2 * i * RADIUS, RADIUS);
				}

			}

			System.out.println("Angi havh�yde i tegnevinduet ...");
			hav = Integer.parseInt(getText("havh�yde"));
			
		}
	}
}