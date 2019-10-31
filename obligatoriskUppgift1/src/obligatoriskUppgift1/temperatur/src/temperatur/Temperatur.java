package temperatur;

import java.util.*;

public class Temperatur {
	static int antalVeckor;
	static int antalMätningar;
	static int vecka;
	static int mätning;
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
		// Input från användaren angående vilket nummer man vill satsa på
		antalVeckor = 0;

		System.out.print("antalet veckor: ");

		// "try-statement" fångar upp undantag för att programmet inte ska krascha
		// Om användaren skriver in ett nummer större än 6 eller mindre än 1
		//

		try {
			antalVeckor = in.nextInt();
			/*
			 * Om användaren skriver in ett nummer större än 6 eller mindre än 1 returneras
			 * funktionen "chooseDiceFace()" och funktionen börjar om
			 */
			if (antalVeckor <= 0) {
				System.out.println("You can not have a negative number of weeks, please try again:");
				antalVeckor = setV();
			}
			/*
			 * Om användaren skriver in någonting som inte är ett nummer, returneras
			 * funktionen "chooseDiceFace()" och funktionen börjar om
			 */
		} catch (Exception e) {
			System.out.println("That is not a number, please try again:");
			in.nextLine();
			antalVeckor = setV();
		}
		return antalVeckor;
	}

	private static int setM() {
		antalMätningar = 0;
		System.out.print("antalet mätningar per vecka: ");

		try {
			antalMätningar = in.nextInt();
			if (antalMätningar <= 0) {

				System.out.println("Antalet mätningar kan inte vara mindre än 1, var god försök igen: ");
				antalMätningar = setM();
			}
		} catch (Exception e) {
			in.nextLine();
			System.out.println("Endast heltal större än 0 godtas, var god försök igen: ");
			;
			antalMätningar = setM();
		}
		return antalMätningar;
	}

	private static void temperatur() {

		antalVeckor = setV();
		antalMätningar = setM();
		r = 0;
		double[][] t = new double[antalVeckor + 1][antalMätningar + 1];

		// reservera plats i minnet för en vektor att lagra uppmätta temperaturer i

		// mata in temperaturerna

		while (r == 0) /*
						 * <-- Här låg felet, genom att lägga till while-loopen växer elemntet veckor
						 * varje gång antaletmätningar per vecka är uppfyllt.
						 */
		{
			if (vecka >= mätning)
				r = 1;
			else
				vecka++;

			for (int vecka = 1; vecka <= antalVeckor; vecka++) {
				System.out.println("temperaturer - vecka " + vecka + ":");
				for (int mätning = 1; mätning <= antalMätningar; mätning++) {

					System.out.println("Mätning " + mätning);

					t[vecka][mätning] = in.nextDouble();
				}

			}
			System.out.println("temperaturerna:");
			for (vecka = 1; vecka <= antalVeckor; vecka++) {

				System.out.print("vecka " + vecka + " | ");
				for (mätning = 1; mätning <= antalMätningar; mätning++)
					System.out.print(t[vecka][mätning] + "  |  ");
				System.out.println();
			}

			System.out.println();

		}

		// den minsta, den största och medeltemperaturen – veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];

		// koden ska skrivas här
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

		// Minsta största och medeltemperaturen för hela perioden

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
		System.out.println("Högsta, lägsta och medeltemperatur - Veckovis \n");
		System.out.println("           Maxtemp     mintemp     Medeltemp      ");
		System.out.println("_____________________________________________");
		for (int i = 1; i < t.length; i++) {
			System.out.printf("Vecka " + i + " |" + "  %7.2f  |  %7.2f  |  %7.2f  \n", maxT[i], minT[i], medelT[i]);
			System.out.println("_____________________________________________");
		}

		System.out.println("Högsta,lägsta och medeltemperatur - Hela perioden");

		System.out.println("_____________________________________________");
		System.out.printf("Max " + "    |" + "  %7.2f  |\n", maxTemp);
		System.out.println("_____________________________________________");
		System.out.printf("Min " + "    |" + "  %7.2f  | \n", minTemp);
		System.out.println("_____________________________________________");
		System.out.printf("Medel " + "  |" + "  %7.2f  | \n", medelTemp);
		System.out.println("_____________________________________________");

		System.out.println("sumMedelTemp --> " + sumMedelTemp); // Test för att algoritmen fungerar

	}

}
