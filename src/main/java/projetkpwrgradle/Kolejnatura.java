package projetkpwrgradle;

import java.util.Vector;

public class Kolejnatura {
	

	//funkcja odowiadajaca za losowanie nowych pozycji dla zwierzat oraz wywolaniu funkcji sprawdzajacej czy pozycja jest wolna
		public void kolejna_tura(Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa,zwierze zwierze) {

			for (int i = 0; i < sarna.size(); i++) {
				int poz_y;
				int poz_x;

				
				poz_y = zwierze.los_nex_pozy(sarna.get(i).pozycja_y, sarna.get(i).wytrzymalosc);
				poz_x = zwierze.los_nex_pozx(sarna.get(i).pozycja_x, sarna.get(i).wytrzymalosc);

				String sarna1 = "sarna";
				if (zwierze.sprawdz(poz_x, poz_y, sarna1,wilk,sarna,niedzwiedz,trawa)) {
					sarna.get(i).pozycja_x = poz_x;
					sarna.get(i).pozycja_y = poz_y;
				}

			}

			

			for (int i = 0; i < wilk.size(); i++) {
				int poz_y;
				int poz_x;
			
				poz_y = zwierze.los_nex_pozy(wilk.get(i).pozycja_y, wilk.get(i).wytrzymalosc);
				poz_x = zwierze.los_nex_pozx(wilk.get(i).pozycja_x, wilk.get(i).wytrzymalosc);

				String sarna1 = "wilk";
				if (zwierze.sprawdz(poz_x, poz_y, sarna1,wilk, sarna,niedzwiedz,trawa)) {
					wilk.get(i).pozycja_x = poz_x;
					wilk.get(i).pozycja_y = poz_y;
				}

			}

		

			

			

			for (int i = 0; i < niedzwiedz.size(); i++) {
				int poz_y;
				int poz_x;
				
				poz_y = zwierze.los_nex_pozy(niedzwiedz.get(i).pozycja_y, niedzwiedz.get(i).wytrzymalosc);
				poz_x = zwierze.los_nex_pozx( niedzwiedz.get(i).pozycja_x, niedzwiedz.get(i).wytrzymalosc);

				String sarna1 = "niedzwiedz";
				if (zwierze.sprawdz(poz_x, poz_y, sarna1, wilk,sarna,niedzwiedz,trawa)) {
					niedzwiedz.get(i).pozycja_x = poz_x;
					 niedzwiedz.get(i).pozycja_y = poz_y;

				}

			}




		}

}
