package projetkpwrgradle;

import javax.swing.border.LineBorder;
import javax.swing.*;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.border.Border;

public class Main extends javax.swing.JFrame implements ActionListener {
	private javax.swing.JButton[][] table = null;
	Zapis zapis = new Zapis();
	
	Kolejnatura kolejna=new Kolejnatura();
	Swiat_zw swiat = new Swiat_zw();
	JTextArea field;
	int[][] plansza_spr = new int[45][45];
	JTextArea iloscs2 = new JTextArea();
	JTextArea iloscw2 = new JTextArea();
	JTextArea iloscn2 = new JTextArea();
	JTextField ilosct = new JTextField();
	JTextArea iloscsarenw = new JTextArea();
	JTextArea iloscwilkoww = new JTextArea();
	JTextArea iloscniedzwiedziw = new JTextArea();
	
	JTextArea glodsaren = new JTextArea();
	JTextArea glodwilkow = new JTextArea();
	JTextArea glodniedziwiedzi= new JTextArea();
	
	
	JPanel tlo2 = new JPanel();
	JButton start = new JButton();
	JTextField jt2 = new JTextField("Podaj ilosc Wilkow", 30);

	JTextField jt3 = new JTextField("Podaj ilosc Niedzwiedzi", 30);
	JTextField jt = new JTextField("Podaj ilosc saren", 30);
	public int ilosc_t2 = 0;
	Font pixel;

	public Main() {

		try {
			pixel = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(10f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		jt.setFont(pixel);
		jt2.setFont(pixel);
		jt3.setFont(pixel);
		ilosct.setFont(pixel);
		ilosct.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		this.setSize(350, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);

		this.setLocation(xPos, yPos);
		this.setResizable(false);
		this.setTitle("projekt");

		jt.setBounds(50, 50, 120, 20);
		jt.setEditable(false);
		jt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(jt);

		jt2.setBounds(50, 80, 120, 20);
		jt2.setEditable(false);
		jt2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(jt2);

		jt3.setBounds(50, 110, 150, 20);
		jt3.setEditable(false);
		jt3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(jt3);

		start.setBounds(80, 150, 100, 30);
		start.setText("start");
		start.addActionListener(this);
		add(start);
		iloscsarenw.setBounds(200, 50, 100, 20);
		iloscwilkoww.setBounds(200, 80, 100, 20);
		iloscniedzwiedziw.setBounds(200, 110, 100, 20);
		add(iloscsarenw);
		add(iloscwilkoww);
		add(iloscniedzwiedziw);

		add(tlo2);

	}

//interakcje z guzikami
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("kolejna"))

		{
            czysc();
			kolejna.kolejna_tura(swiat.wilk,swiat.sarna,swiat.niedzwiedz,swiat.trawa,swiat.zwierz);
			sprawdzinterakcje();
			umieszczanie();
			int iosc = 0;
			for (int i = 0; i < 45; i++) {
				for (int j = 0; j < 45; j++) {

					if (swiat.plansza[i][j] == 3) {

					}

				}

			}
			
			int iloscsint = swiat.sarna.size();
			int iloscwilk = swiat.wilk.size();
			int iloscnied = swiat.niedzwiedz.size();
			String iloscs = Integer.toString(iloscsint);
			String iloscw = Integer.toString(iloscwilk);
			String iloscn = Integer.toString(iloscnied);
			String ilosct2 = Integer.toString(ilosc_t2);
			iloscs2.setText(iloscs);
			iloscw2.setText(iloscw);
			iloscn2.setText(iloscn);
			ilosct.setText(ilosct2);

			ilosc_t2++;
		} else if (e.getActionCommand().equals("start")) {
			boolean sameliczby = true;
			boolean zaduzo = true;

			try {
				swiat.ilosc_s = Integer.parseInt(iloscsarenw.getText());

			} catch (Exception a) {
				System.out.println("Sproboj ponownie");
				sameliczby = false;
			}
			try {
				swiat.ilosc_w = Integer.parseInt(iloscwilkoww.getText());

			} catch (Exception a) {
				System.out.println("Sproboj ponownie");
				sameliczby = false;
			}
			try {
				swiat.ilosc_n = Integer.parseInt(iloscniedzwiedziw.getText());

			} catch (Exception a) {
				System.out.println("Sproboj ponownie");
				sameliczby = false;
			}
			if (sameliczby) {

				if (swiat.ilosc_n + swiat.ilosc_s + swiat.ilosc_w + swiat.ilosc_t > 45 * 45) {
					System.out.println("za duzo zwierzat");
					zaduzo = false;
				}
				if (zaduzo) {
					tlo2.setVisible(false);
					jt.setVisible(false);
					jt2.setVisible(false);
					jt3.setVisible(false);
					start.setVisible(false);
					iloscniedzwiedziw.setVisible(false);
					iloscsarenw.setVisible(false);
					iloscwilkoww.setVisible(false);
					start();
				}

			}

		}
		else if(e.getActionCommand().equals("Zapis")){
			
				try {
					// wywolywanie funkcji zapisujacej statystyki
					zapis.zapis(swiat.wilk,swiat.sarna,swiat.niedzwiedz,ilosc_t2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			
			
		}

	}

	public static void main(String[] args) {
		new Main().setVisible(true);

	}

// funkcja do graficznej wizualizacji pozycji obiektow 
	public void umieszczanie() {

		for (int i = 0; i < 45; i++) {
			for (int j = 0; j < 45; j++) {
				if (swiat.plansza[i][j] == 1) {
					table[i][j].setIcon(new ImageIcon("wilkglowa2.png"));
				} else if (swiat.plansza[i][j] == 2) {
					table[i][j].setIcon(new ImageIcon("sarnaglowa3.jpg"));

				} else if (swiat.plansza[i][j] == 3) {
					table[i][j].setIcon(new ImageIcon("niedzwiedz.png"));

				} else if (swiat.plansza[i][j] == 4) {
					table[i][j].setIcon(new ImageIcon("trawa.jpg"));

				} else if (swiat.plansza[i][j] == 0) {
					table[i][j].setIcon(null);
				}

			}
		}

	}

private  void czysc() {
	for (int i = 0; i < 45; i++) {
		for (int j = 0; j < 45; j++) {
			
	swiat.plansza[i][j]=0;		
		}
	}
		
}
private void sprawdzinterakcje() {
	swiat.spr_sarny();
	swiat.spr_wilki();
	swiat.spr_niedzw();
	swiat.spr_trawa();
}
	private void start() {

		this.setVisible(true);
		this.setSize(1050, 890);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);

		this.setLocation(xPos, yPos);
		this.setResizable(false);
		this.setTitle("projekt");

		JPanel tlo = new JPanel();

		table = new javax.swing.JButton[45][45];
//teorzenie tabeli złożonej z guzikow
		for (int i = 0; i < 45; i++) {
			for (int j = 0; j < 45; j++) {
				Border bored = BorderFactory.createLineBorder(new Color(185, 122, 87));
				Dimension wymiar = new Dimension(20, 20);
				table[i][j] = new JButton();
				table[i][j].setMargin(new Insets(0, 0, 0, 0));
				table[i][j].setPreferredSize(wymiar);
				table[i][j].setMaximumSize(wymiar);
				table[i][j].setMinimumSize(wymiar);
				table[i][j].setBackground(new Color(185, 122, 87));
				table[i][j].setForeground(new Color(185, 122, 87));
				table[i][j].setSize(wymiar);
				table[i][j].setLocation((i * 19), j * 19);
				table[i][j].setText(" ");

				table[i][j].setBorder(bored);
				this.add(table[i][j]);
			}
		}
		// guziok odpowiadajacy kolejnej turze
		JButton next = new JButton();
		next.setBounds(800, 0, 100, 30);
		next.setText("kolejna");
		next.setFont(pixel);
		next.addActionListener(this);
		add(next);
		int t = 2;
		JLabel iloscs = new JLabel();
		iloscs.setBounds(900, 30, 100, 30);

		iloscs2.setBounds(950, 40, 100, 20);
		iloscs2.setEditable(false);
		add(iloscs2);
		JButton sarna = new JButton();
		sarna.setBounds(900, 40, 20, 20);
		sarna.setBackground(new Color(185, 122, 87));
		sarna.setForeground(new Color(185, 122, 87));
		sarna.setIcon(new ImageIcon("sarnaglowa32.jpg"));
		add(sarna);
		JLabel iloscw = new JLabel();
		iloscs.setBounds(900, 30, 100, 30);

		iloscw2.setBounds(950, 70, 100, 20);
		iloscw2.setEditable(false);
		add(iloscw2);
		JButton wilk = new JButton();
		wilk.setBounds(900, 70, 20, 20);
		wilk.setBackground(new Color(185, 122, 87));
		wilk.setForeground(new Color(185, 122, 87));
		wilk.setIcon(new ImageIcon("wilkglowa2.png"));
		add(wilk);
		JLabel iloscn = new JLabel();
		iloscs.setBounds(900, 30, 100, 30);

		iloscn2.setBounds(950, 100, 100, 20);
		iloscn2.setEditable(false);
		add(iloscn2);
		JButton nied = new JButton();
		nied.setBounds(900, 100, 20, 20);
		nied.setBackground(new Color(185, 122, 87));
		nied.setForeground(new Color(185, 122, 87));
		nied.setIcon(new ImageIcon("niedzwiedz2.png"));
		add(nied);
		JLabel ilosc_t = new JLabel();
		iloscs.setBounds(900, 30, 100, 30);

		ilosct.setBounds(950, 130, 100, 20);
		ilosct.setEditable(true);
		add(ilosct);
		JTextField jt = new JTextField(" TURA", 30);
		jt.setBounds(890, 130, 50, 20);
		jt.setEditable(false);
		jt.setFont(pixel);
		jt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(jt);
		next.setBounds(900, 0, 100, 30);
		JButton zapis = new JButton();
		zapis.setBounds(900, 800, 100, 30);
		zapis.setText("Zapis");
		zapis.setFont(pixel);
		zapis.addActionListener(this);
		add(zapis);

		this.add(tlo);
		// generowanie zwierząt
		swiat.wilki();
		swiat.sarny();
		swiat.trawa();
		swiat.niedzwiedzie();
		// umieszczanie zwierząt
		umieszczanie();

	}
}
