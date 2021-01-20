package projetkpwrgradle;

import java.util.Vector;

public class Wilk extends zwierze {
	int glod_w=50;
	
	public void rozmnozenie(Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa,int  i)
	{
		int pozycja_x1 = los_nex_pozx(wilk.get(i).pozycja_x, 3);
		int pozycja_y1 = los_nex_pozy(wilk.get(i).pozycja_y, 3);
		if (sprawdz(pozycja_x1, pozycja_y1, "sarna",wilk,sarna,niedzwiedz,trawa)) {

			wilk.addElement(new Wilk());
			wilk.lastElement().pozycja_x = pozycja_x1;
			wilk.lastElement().pozycja_y = pozycja_y1;
			wilk.lastElement().id = 1;
			wilk.lastElement().wytrzymalosc = 1;
			wilk.lastElement().wiek = 0;
			wilk.lastElement().glod = glod_w;
			

			wilk.get(i).wiek();
		} 
	}
	
	
	
	public void smierc(Vector<Wilk>wilk,int i)
	
	{
	
		wilk.remove(i);
		
		
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
