package projetkpwrgradle;

import java.util.Vector;

public class Niedzwiedz extends zwierze{
	
	int id=3;
	int glod_n=80;

	
	public void rozmnozenie(Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa,int  i)
	{
		
		
		int pozycja_x1 = los_nex_pozx(niedzwiedz.get(i).pozycja_x, 3);
		int pozycja_y1 = los_nex_pozy(niedzwiedz.get(i).pozycja_y, 3);
		if (sprawdz(pozycja_x1, pozycja_y1, "niedzwiedz",wilk,sarna,niedzwiedz,trawa)) {

			niedzwiedz.addElement(new Niedzwiedz());
			niedzwiedz.lastElement().pozycja_x = pozycja_x1;
			niedzwiedz.lastElement().pozycja_y = pozycja_y1;
			niedzwiedz.lastElement().id = 3;
			niedzwiedz.lastElement().wytrzymalosc = 1;
			niedzwiedz.lastElement().wiek = 0;
			niedzwiedz.lastElement().glod = glod_n;
			

			niedzwiedz.get(i).wiek++;
		} 
		
		
		
	}
	
	
	
	public void smierc(Vector<Niedzwiedz> niedzwiedz ,int i)
	{
		niedzwiedz.remove(i);
	}
	
	public void glod()
	{
		glod++;
	}
	
	public void wiek()
	{
		wiek++;
	}
	
}
