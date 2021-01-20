package projetkpwrgradle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Zapis {
	public void zapis(Vector<Wilk> wilk,Vector<sarna> sarna,Vector<Niedzwiedz> niedzwiedz,int tury) throws IOException   
	{
		File plik= new File("stat.txt");
		boolean sukces=plik.createNewFile();
		
		float ilosc_calkowita=sarna.size()+wilk.size()+niedzwiedz.size();
		float iloscsaren= sarna.size();
		float iloscwilkow= wilk.size();
		float iloscniedzwiedzi= niedzwiedz.size();
		float proc_sarna= (iloscsaren/ilosc_calkowita)*100;
		float proc_wilk= (iloscwilkow/ilosc_calkowita)*100;
		float proc_niedzwiedz= (iloscniedzwiedzi/ilosc_calkowita)*100;
		
		
		
		PrintWriter writer=new PrintWriter(plik);
		writer.println("Saren jest "+sarna.size());
		writer.println("Wilkow jest "+wilk.size());
		writer.println("Niedzwiedzi jest "+niedzwiedz.size());
		writer.println("ilosc tur "+tury);
		writer.println("Procentowo");
		writer.println("Niedzwiedzi jest "+proc_niedzwiedz+"%");
		writer.println("Wilków jest "+proc_wilk+"%");
		writer.println("Saren jest "+proc_sarna+"%");
		
		writer.close();
		
	}

}
