package temperatur;

import java.util.Locale;
import java.util.Scanner;

public class Values {
	static int antalMatningarPerVecka;
	private static Scanner in = new Scanner(System.in);

	/*public static void main(String[] args) {

		int nrWeek = in.nextInt();
		int nrTest = in.nextInt();
		double w[][] = new double[nrWeek][nrTest];
		for (int row = 0; row < nrWeek; pos++) {

			for (int col = 0; testPos < nrTest; testPos++) {

				w[pos][testPos] = in.nextDouble();

			}

		}

		for (int pos = 0; pos < nrWeek; pos++) {

			for (int testPos = 0; testPos < nrTest; testPos++) {

				System.out.print(w[pos][testPos] + " ");

			}
			System.out.println();
		}

	}*/

	public static void main(String[] args) {
		System.out.println("TEMPERATURER\n");
		// inmatningsverktyg
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		// mata in uppgifter om antalet veckor och antalet mätningar
		System.out.print("antalet veckor: ");
		int antalVeckor = in.nextInt();
		System.out.print("antalet mätningar per vecka: ");
		int antalMatningarPerVecka = in.nextInt();
		// plats att lagra temperaturer
		double[][] t = new double[antalVeckor ][antalMatningarPerVecka ];
		// mata in temperaturerna
		for (int vecka = 0; vecka < antalVeckor; vecka++) {
			System.out.println("temperaturer" + (vecka+1) + ":");
			
			for (int matning = 0; matning < antalMatningarPerVecka; matning++)
				t[vecka][matning] = in.nextDouble();
		}
		System.out.println();
	

		System.out.println();
		System.out.println();
		// den minsta, den största och medeltemperaturen – veckovis
		double[] minT = new double[antalVeckor];
		double[] maxT = new double[antalVeckor];
		double[] sumT = new double[antalVeckor];
		double[] medelT = new double[antalVeckor];
		// koden ska skrivas här
		for (int i = 0; i < t.length; i++) {
			maxT[i] = t[i][0];
			sumT[i] = t[i][0];
			minT[i] = t[i][0];
			for (int j = 1; j < t[i].length; j++) {
				if (t[i][j] < minT[i])
					minT[i] = t[i][j];

				if (t[i][j] > maxT[i]) {
					maxT[i] = t[i][j];

				}
				sumT[i] += t[i][j];
			}
			medelT[i] = (double) sumT[i] / (t[i].length);
		}
		// den minsta, den största och medeltemperaturen - hela mätperioden
		double minTemp = minT[0];
		double maxTemp = maxT[0];
		double sumTemp = sumT[0];
		double medelTemp = 0;
		double sumMedelTemp = 0;
		
		for (int i = 0; i < t.length; i++) {
			sumMedelTemp += medelT[i];
			medelTemp = sumMedelTemp / antalVeckor;
			if (minT[i] < minTemp) {
				minTemp = minT[i];
			}
			if (maxT[i] > maxTemp) {
				maxTemp = maxT[i];

			}
		}
		// koden ska skrivas här
		int count=0;
		System.out.println("temperaturerna:");
		
		System.out.println();
		System.out.print("Vecka |");
		
		
		while (count != antalMatningarPerVecka)
		{
			count ++;
			System.out.printf(" Mätning " + count + "  | ");
			
		}
		System.out.printf( "  maxT     |" + "   minT     |"  +  "    medelT  " );
		System.out.println();
		for (int vecka = 0; vecka < antalVeckor; vecka++) {
			//System.out.print( "  " + (vecka+1) + "    | ");
			System.out.print( (vecka+1)+ "     |  ");
			
			for (int matning = 0; matning < antalMatningarPerVecka; matning++)
				{
				
				System.out.printf("%7.2f   |   ",t[vecka][matning]);
				
				//System.out.printf("  " + " " + t[vecka][matning] + " " + " |  ");
				
				}
			System.out.printf( "%7.2f  |   %7.2f  |   %7.2f  \n", maxT[vecka], minT[vecka], medelT[vecka]);
			System.out.println();
			
			
		}
		System.out.printf( "      |   Maxtemp  |" + "   mintemp   |"  +  "  Medeltemp |" );
		System.out.println();
		System.out.printf("      | %7.2f    |" + "  %7.2f    | " + "%7.2f    |", maxTemp, minTemp,medelTemp);
	


		
	}
}

