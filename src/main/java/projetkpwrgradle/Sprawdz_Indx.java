package projetkpwrgradle;

import java.util.Vector;

public class Sprawdz_Indx {
	
	
	
	//funkcja odpowiadajaca za szukanie indexu napotkanego zwierzecia   
		public int spr_indx(String szukaj, int pozycja_x, int pozycja_y, Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa) {

			if (szukaj == "szukajinsar") {
				for (int i = 0; i < sarna.size(); i++) {
					if (sarna.get(i).pozycja_x == pozycja_x && sarna.get(i).pozycja_y == pozycja_y) {

						return (i);

					}

				}

			} else if (szukaj == "szukajinwilk") {

				for (int i = 0; i < wilk.size(); i++) {
					if (wilk.get(i).pozycja_x == pozycja_x && wilk.get(i).pozycja_y == pozycja_y) {
						return (i);

					}

				}

			} else if (szukaj == "szukajintraw") {
				for (int i = 0; i < trawa.size(); i++) {
					if (trawa.get(i).pozycja_x == pozycja_x && trawa.get(i).pozycja_y == pozycja_y) {
						return (i);

					}

				}

			} else if (szukaj == "szukajinniedzwiedz") {
				for (int i = 0; i < niedzwiedz.size(); i++) {
					if (niedzwiedz.get(i).pozycja_x == pozycja_x && niedzwiedz.get(i).pozycja_y == pozycja_y) {
						return (i);

					}

				}

			}

			return (0);

		}

}
