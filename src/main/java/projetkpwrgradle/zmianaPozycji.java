package projetkpwrgradle;

import java.util.Random;

public class zmianaPozycji {
	
	
	
	
	
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

}
