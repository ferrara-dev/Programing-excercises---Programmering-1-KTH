package temperatur;

import java.util.*;

public class Temperatur {
	static int antalVeckor;
	static int antalM�tningar;
	static int vecka;
	static int m�tning;
	static int r;
	static double[][] t;
	static double minT;
	static double maxT;
	static double sumT;
	static double medelT;
	// setTemp();

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("TEMPERATURER\n");
		// inmatningsverktyg
		temperatur();

	}

	private static int setV() {
		// Input fr�n anv�ndaren ang�ende vilket nummer man vill satsa p�
		antalVeckor = 0;

		System.out.print("antalet veckor: ");

		// "try-statement" f�ngar upp undantag f�r att programmet inte ska krascha
		// Om anv�ndaren skriver in ett nummer st�rre �n 6 eller mindre �n 1
		//

		try {
			antalVeckor = in.nextInt();
			/*
			 * Om anv�ndaren skriver in ett nummer st�rre �n 6 eller mindre �n 1 returneras
			 * funktionen "chooseDiceFace()" och funktionen b�rjar om
			 */
			if (antalVeckor <= 0) {
				System.out.println("You can not have a negative number of weeks, please try again:");
				antalVeckor = setV();
			}
			/*
			 * Om anv�ndaren skriver in n�gonting som inte �r ett nummer, returneras
			 * funktionen "chooseDiceFace()" och funktionen b�rjar om
			 */
		} catch (Exception e) {
			System.out.println("That is not a number, please try again:");
			in.nextLine();
			antalVeckor = setV();
		}
		return antalVeckor;
	}

	private static int setM() {
		antalM�tningar = 0;
		System.out.print("antalet m�tningar per vecka: ");

		try {
			antalM�tningar = in.nextInt();
			if (antalM�tningar <= 0) {

				System.out.println("Antalet m�tningar kan inte vara mindre �n 1, var god f�rs�k igen: ");
				antalM�tningar = setM();
			}
		} catch (Exception e) {
			in.nextLine();
			System.out.println("Endast heltal st�rre �n 0 godtas, var god f�rs�k igen: ");
			;
			antalM�tningar = setM();
		}
		return antalM�tningar;
	}

	private static void temperatur() {

		antalVeckor = setV();
		antalM�tningar = setM();
		r = 0;
		double[][] t = new double[antalVeckor + 1][antalM�tningar + 1];

		// reservera plats i minnet f�r en vektor att lagra uppm�tta temperaturer i

		// mata in temperaturerna

		while (r == 0) /*
						 * <-- H�r l�g felet, genom att l�gga till while-loopen v�xer elemntet veckor
						 * varje g�ng antaletm�tningar per vecka �r uppfyllt.
						 */
		{
			if (vecka >= m�tning)
				r = 1;
			else
				vecka++;

			for (int vecka = 1; vecka <= antalVeckor; vecka++) {
				System.out.println("temperaturer - vecka " + vecka + ":");
				for (int m�tning = 1; m�tning <= antalM�tningar; m�tning++) {

					System.out.println("M�tning " + m�tning);

					t[vecka][m�tning] = in.nextDouble();
				}

			}
			System.out.println("temperaturerna:");
			for (vecka = 1; vecka <= antalVeckor; vecka++) {

				System.out.print("vecka " + vecka + " | ");
				for (m�tning = 1; m�tning <= antalM�tningar; m�tning++)
					System.out.print(t[vecka][m�tning] + "  |  ");
				System.out.println();
			}

			System.out.println();

		}

		// den minsta, den st�rsta och medeltemperaturen � veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];

		// koden ska skrivas h�r
		for (int i = 1; i < t.length; i++) {
			maxT[i] = t[i][1];
			sumT[i] = t[i][1];
			minT[i] = t[i][1];
			for (int j = 2; j < t[i].length; j++) {
				if (t[i][j] < minT[i])
					minT[i] = t[i][j];

				if (t[i][j] > maxT[i]) {
					maxT[i] = t[i][j];

				}
				sumT[i] += t[i][j];
			}
			medelT[i] = (double) sumT[i] / (t[i].length - 1);
		}

		// Minsta st�rsta och medeltemperaturen f�r hela perioden

		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumMedelTemp = 0;
		double medelTemp = 0;

		for (int i = 1; i < t.length; i++) {
			sumMedelTemp += medelT[i];
			medelTemp = sumMedelTemp / antalVeckor;
			if (minT[i] < minTemp) {
				minTemp = minT[i];
			}
			if (maxT[i] > maxTemp) {
				maxTemp = maxT[i];

			}

			// visa temperaturerna

			// medelTemp = (double) sumTemp /kvot;
		}
		System.out.println("H�gsta, l�gsta och medeltemperatur - Veckovis \n");
		System.out.println("           Maxtemp     mintemp     Medeltemp      ");
		System.out.println("_____________________________________________");
		for (int i = 1; i < t.length; i++) {
			System.out.printf("Vecka " + i + " |" + "  %7.2f  |  %7.2f  |  %7.2f  \n", maxT[i], minT[i], medelT[i]);
			System.out.println("_____________________________________________");
		}

		System.out.println("H�gsta,l�gsta och medeltemperatur - Hela perioden");

		System.out.println("_____________________________________________");
		System.out.printf("Max " + "    |" + "  %7.2f  |\n", maxTemp);
		System.out.println("_____________________________________________");
		System.out.printf("Min " + "    |" + "  %7.2f  | \n", minTemp);
		System.out.println("_____________________________________________");
		System.out.printf("Medel " + "  |" + "  %7.2f  | \n", medelTemp);
		System.out.println("_____________________________________________");

		System.out.println("sumMedelTemp --> " + sumMedelTemp); // Test f�r att algoritmen fungerar

	}

}
