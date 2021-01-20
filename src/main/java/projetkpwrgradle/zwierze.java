package projetkpwrgradle;

import java.util.Random;
import java.util.Vector;

public class zwierze {
	//klasa odpowiadajaca za rozne parametry zwierzat
	int pozycja_x;
	int pozycja_y;
	int sila;
	int wytrzymalosc;
	int id;
	int wiek;
	int glod;
	
	
	
	
	
	
	
	
	
	//losowanie kolejnej pozycji x 
			public int los_nex_pozx(int pozycja_x, int wytrzymalosc) {
				Random los = new Random();
				int x = los.nextInt(10);

				if (x > 5) {
					pozycja_x = pozycja_x - wytrzymalosc;
				} else if (x < 5) {
					pozycja_x = pozycja_x + wytrzymalosc;
				}

				if (pozycja_x < 0) {
					pozycja_x = 0;

				} else if (pozycja_x > 44) {
					pozycja_x = 44;

				}

				return pozycja_x;
			}
		//losowanie kolejnej pozycji y 
			public int los_nex_pozy(int pozycja_y, int wytrzymalosc) {
				Random los = new Random();
				int x = los.nextInt(10);
				if (x > 5) {
					pozycja_y = pozycja_y - wytrzymalosc;
				} else if (x < 5) {
					pozycja_y = pozycja_y + wytrzymalosc;
				}
				if (pozycja_y < 0) {
					pozycja_y = 1;
					return pozycja_y;
				} else if (pozycja_y > 44) {
					pozycja_y = 44;
					return pozycja_y;
				}

				return pozycja_y;
			}
			//funkcja sprawdzajaca czy nowa pozycja jest wolna  
			public boolean sprawdz(int poz_x, int poz_y, String zwierze,Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa) {
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
return(zajete);
			}
			
			
			public int sprawdz(String szukaj, int pozycja_x, int pozycja_y, Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa) {

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
