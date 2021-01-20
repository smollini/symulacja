package projetkpwrgradle;
import java.util.Random;
import java.util.Vector;

public class sarna extends zwierze {
	
	int glod_s=30;
	
	
	
	
	
	
	
	
	public void rozmnozenie(Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,Vector<Trawa> trawa,int  i)
	{
		int pozycja_x1 = los_nex_pozx(sarna.get(i).pozycja_x, 3);
		int pozycja_y1 = los_nex_pozy(sarna.get(i).pozycja_y, 3);
		if (sprawdz(pozycja_x1, pozycja_y1, "sarna",wilk,sarna,niedzwiedz,trawa)) {
             
			sarna.addElement(new sarna());
			sarna.lastElement().pozycja_x = pozycja_x1;
			sarna.lastElement().pozycja_y = pozycja_y1;
			sarna.lastElement().id = 2;
			sarna.lastElement().wytrzymalosc = 1;
			sarna.lastElement().wiek = 0;
			sarna.lastElement().glod = glod_s;
			

			sarna.get(i).wiek++;
		} 
	}
	
	
	public void zjedzenie_trawy()
	{ 
		//interakcja z trawa
		
		 glod++;
		
		
	}
	
	public void smierc(Vector<sarna> sarna,int i)
	{
		
		sarna.remove(i);  
	}
	
	
	public void glod()
	{
		glod--;
	}
	public void wiek() {
		wiek--;
	}
	
	
	
	

}
