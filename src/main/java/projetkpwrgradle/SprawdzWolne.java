package projetkpwrgradle;

import java.util.Vector;

public class SprawdzWolne {
	//funkcja sprawdzajaca czy nowa pozycja jest wolna  
	public boolean spr_wolne(int poz_x, int poz_y, String zwierze,Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa) {
		boolean zajete = true;
		int ilosc = 0;
		if (zwierze == "sarna") {
			for (int i = 0; i < sarna.size(); i++) {
				if (poz_x == sarna.get(i).pozycja_x && poz_y == sarna.get(i).pozycja_y) {

					ilosc++;
					
				}
			}

			if (ilosc == 2) {
				zajete = false;

			}

		}
		if (zwierze == "wilk") {
			for (int i = 0; i < wilk.size(); i++) {
				if (poz_x == wilk.get(i).pozycja_x && poz_y == wilk.get(i).pozycja_y) {

					ilosc++;
					
				}
			}

			if (ilosc == 2) {
				zajete = false;

			}

		}
		if (zwierze == "niedzwiedz") {
			for (int i = 0; i < niedzwiedz.size(); i++) {
				if (poz_x == niedzwiedz.get(i).pozycja_x && poz_y == niedzwiedz.get(i).pozycja_y) {

					ilosc++;
					
				}
			}

			if (ilosc == 2) {
				zajete = false;

			}

		}

		return (zajete);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
