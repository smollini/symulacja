package projetkpwrgradle;

import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

public class Swiat_zw {
	
	Random los = new Random();
	
	public int[][] plansza = new int[45][45];
	int ilosc_w ;
	int ilosc_t =70;
	int ilosc_n ;
	int ilosc_d ;
	int ilosc_s;
	int glod_s;
	int glod_w;
	int glod_n;
	
	Vector<Wilk> wilk = new Vector();
	Vector<sarna> sarna = new Vector();
	Vector<Trawa> trawa = new Vector();
	Vector<Niedzwiedz> niedzwiedz = new Vector();
	zwierze zwierz = new zwierze();
//generowanie trawy
	///////////////////////////////////////////////////////////////////////////////////
	public void trawa() {
		for (int i = 0; i < ilosc_t; i++) {
			trawa.add(i, new Trawa());
			trawa.get(i).id = 4;
			trawa.get(i).pozycja_x = (los.nextInt(44));
			trawa.get(i).pozycja_y = (los.nextInt(44));

			while (plansza[trawa.get(i).pozycja_x][trawa.get(i).pozycja_y] == 1
					|| plansza[trawa.get(i).pozycja_x][trawa.get(i).pozycja_y] == 2
					|| plansza[trawa.get(i).pozycja_x][trawa.get(i).pozycja_y] == 3) {
				trawa.get(i).pozycja_x = (los.nextInt(44));
				trawa.get(i).pozycja_y = (los.nextInt(44));
			}
			plansza[trawa.get(i).pozycja_x][trawa.get(i).pozycja_y] = trawa.get(i).id;
		}

	}
//generowanie wilkow
	//////////////////////////////////////////////////////////////////////////////////
	public void wilki() {

		for (int i = 0; i < ilosc_w*2; i++) {
			wilk.add(i, new Wilk());
			wilk.get(i).id = 1;
			wilk.get(i).sila = 10;
			wilk.get(i).wytrzymalosc = 1;
			wilk.get(i).pozycja_x = (los.nextInt(44));
			wilk.get(i).pozycja_y = (los.nextInt(44));
			wilk.lastElement().glod =  glod_w;
			while (plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] == 2) {
				wilk.get(i).pozycja_x = (los.nextInt(44));
				wilk.get(i).pozycja_y = (los.nextInt(44));
			}

			plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] = wilk.get(i).id;

		}

	}
	////////////////////////////////////////////////////////////////////////////////
//generowanie saren
	public void sarny() {

		for (int i = 0; i < ilosc_s; i++) {
			sarna.add(i, new sarna());
			sarna.get(i).id = 2;
			sarna.get(i).sila = 2;
			sarna.get(i).wytrzymalosc = 1;
			sarna.get(i).pozycja_x = (los.nextInt(44));
			sarna.get(i).pozycja_y = (los.nextInt(44));
			sarna.get(i).glod =  glod_s;

			while (plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] == 1
					|| plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] == sarna.get(i).id) {
				sarna.get(i).pozycja_x = (los.nextInt(44));
				sarna.get(i).pozycja_y = (los.nextInt(44));
			}

			plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] = sarna.get(i).id;
		}

	}
//generowanie niedzwiedzi
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public void niedzwiedzie() {

		for (int i = 0; i < ilosc_n; i++) {
			niedzwiedz.add(i, new Niedzwiedz());
			niedzwiedz.get(i).id = 3;
			niedzwiedz.get(i).wytrzymalosc = 1;
			niedzwiedz.get(i).pozycja_x = (los.nextInt(44));
			niedzwiedz.get(i).pozycja_y = (los.nextInt(44));
			niedzwiedz.get(i).glod=glod_n;

			while (plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] == 1
					|| plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] == 2
					|| plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] == 3) {
				niedzwiedz.get(i).pozycja_x = (los.nextInt(44));
				niedzwiedz.get(i).pozycja_y = (los.nextInt(44));
			}

			 plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y]=niedzwiedz.get(i).id;

		}

	}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	public void spr_trawa() {
		for (int i = 0; i < trawa.size(); i++) {
			plansza[trawa.get(i).pozycja_x][trawa.get(i).pozycja_y] = 4;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////
	private void nowa_trawa() {
		trawa.addElement(new Trawa());
		trawa.lastElement().pozycja_x = los.nextInt(45);
		trawa.lastElement().pozycja_y = los.nextInt(45);
		trawa.lastElement().id = 4;
		while (plansza[trawa.lastElement().pozycja_x][trawa.lastElement().pozycja_y] == 1
				|| plansza[trawa.lastElement().pozycja_x][trawa.lastElement().pozycja_y] == 2
				|| plansza[trawa.lastElement().pozycja_x][trawa.lastElement().pozycja_y] == 3) {
			trawa.lastElement().pozycja_x = (los.nextInt(44));
			trawa.lastElement().pozycja_y = (los.nextInt(44));
		}
		plansza[trawa.lastElement().pozycja_x][trawa.lastElement().pozycja_y] = trawa.lastElement().id;

	}
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
//funkcja odpowiadajaca za sprawdzanie czy zachodzi jakas interrakcja
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public void spr_sarny() {

		for (int i = 0; i < sarna.size(); i++) {
			if (sarna.get(i).glod == 0 && sarna.get(i).wiek == 25) {
				sarna.remove(i);
			}
		}
		for (int i = 0; i < sarna.size(); i++) {
			switch (plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y]) {
			
			case 2:
				//spotkanie sarny (rozmnozenie)
				if (sarna.get(i).wiek < 4) {
					//sprawdzenie czy sarna osagnela dobry wiek do rozmnozenia
					plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] = sarna.get(i).id;
					break;
				}
				//romnozenie sarny
                sarna.get(i).rozmnozenie(wilk, sarna, niedzwiedz, trawa, i);
                
				break;
			
			    case 4:
				
				int y =zwierz.sprawdz("szukajintrawy", sarna.get(i).pozycja_x, sarna.get(i).pozycja_y,wilk,sarna,niedzwiedz,trawa);
				trawa.get(i).smierc_trawy(trawa, i);
				nowa_trawa();
				plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] = sarna.get(i).id;
				break;
			    default:	
				plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y] = sarna.get(i).id;
				sarna.get(i).wiek();
				sarna.get(i).glod();
				break;

			   }
			    plansza[sarna.get(i).pozycja_x][sarna.get(i).pozycja_y]=sarna.get(i).id;

		        }
		        }
/////////////////////////////////////////////////////////////////////////////////////////////
	public void spr_wilki() {
		for (int i = 0; i < wilk.size(); i++) {
			if (wilk.get(i).wiek > 1000 || wilk.get(i).glod == 0) {
				wilk.remove(i);
			}
		}
		for (int i = 0; i < wilk.size(); i++) {
			switch (plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y]) {
			case 1:
				//interakcja wilka z wilkiem mechanizm taki sam jak u sarny
				if (wilk.get(i).wiek < 4) {
					plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] = wilk.get(i).id;
					break;
				}
				wilk.get(i).rozmnozenie(wilk, sarna, niedzwiedz, trawa, i);
				plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] = wilk.get(i).id;
				break;

			case 2:
				//spotkanie sarny
				plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] = wilk.get(i).id;
				int y =zwierz.sprawdz("szukajinsar", wilk.get(i).pozycja_x, wilk.get(i).pozycja_y,wilk,sarna,niedzwiedz,trawa);
				wilk.get(i).glod = 30;
				sarna.get(y).smierc(sarna,y);
				break;
				
			    default:
				wilk.get(i).glod();
				wilk.get(i).wiek();
				plansza[wilk.get(i).pozycja_x][wilk.get(i).pozycja_y] = wilk.get(i).id;
				break;
				}
			}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void spr_niedzw() {
		for (int i = 0; i < niedzwiedz.size(); i++) {

			if(niedzwiedz.get(i).glod==0)
			{
				niedzwiedz.get(i).smierc(niedzwiedz, i);
				break;
			}
			
			
			
			
			switch (plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y]) {
			case 1:
				//spotkanie wilka
				int z = 5;
				if (z >= los.nextInt(10)) {
					plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] = niedzwiedz.get(i).id;
					int y =zwierz.sprawdz("szukajinwilk", niedzwiedz.get(i).pozycja_x, niedzwiedz.get(i).pozycja_y,wilk,sarna,niedzwiedz,trawa);
					wilk.get(i).smierc(wilk, y);
					niedzwiedz.get(i).glod();
				}
				break;
			case 2:
				//spotkanie sarny
				plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] = niedzwiedz.get(i).id;
				int y =zwierz.sprawdz("szukajinsar", niedzwiedz.get(i).pozycja_x, niedzwiedz.get(i).pozycja_y,wilk,sarna,niedzwiedz,trawa);
				sarna.get(y).smierc(sarna,y);
				niedzwiedz.get(i).glod = glod_n;
			case 3:
				//rozmnozenie niedzwiedzia mechanizm taki sam jak u innych zwierzat
				if (niedzwiedz.get(i).wiek < 4) {
					
					plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] = niedzwiedz.get(i).id;
					break;
				}
				
				niedzwiedz.get(i).rozmnozenie(wilk, sarna, niedzwiedz, trawa, i);
				
					plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] = niedzwiedz.get(i).id;
				
				break;
			
			default:
				plansza[niedzwiedz.get(i).pozycja_x][niedzwiedz.get(i).pozycja_y] = 3;
				niedzwiedz.get(i).wiek++;
				break;

			}

		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
   
	
	
	
	
	
	
	
	
	
	
}
