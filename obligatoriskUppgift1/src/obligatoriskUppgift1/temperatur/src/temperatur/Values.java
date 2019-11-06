/********************************************************
                *** ATT GÖRA ***
[x] Skriv ut resultatet i tabellform 
[x] Kompletera koden så att maximum, minimum och medel
    temperatur beräknas för enskild vecka samt perioden
[x]  Rita den vektor där de temperaturer som erhålls genom 
    mätningarna lagras. Hur kommer man åt en viss uppgift
    i denna vektor? Rita även de vektorer och variabler
    där de erhållna resultaten lagras.
[x] Vilken strategi använder man för att bestämma den 
   minsta temperaturen? Illustrera denna strategi: 
   rita en serie bilder som visar hur man kommer fram 
   till den minsta temperaturen.
*********************************************************/
package temperatur;

import java.util.*;
//import java.util.Scanner;

public class Values {
	static int antalMatningarPerVecka;
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("TEMPERATURER\n");
		// inmatningsverktyg
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
	/****************************************************************************
	    ** Uppgifter om antalet veckor och mätningar per vecka matas in **  
	*****************************************************************************/
		System.out.print("antalet veckor: ");
		int antalVeckor = in.nextInt();
		System.out.print("antalet mätningar per vecka: ");
		int antalMatningarPerVecka = in.nextInt();
	/****************************************************************************
	   	 ** Plats reserveras i minnet för lagring av temperaturer **  
	*****************************************************************************/
		double[][] t = new double[antalVeckor ][antalMatningarPerVecka ];
	
	/******************************************************************************************
	 ** Användren matar in temperaturer som kopieras från objekt .Scanner till vektorn t[][]**  
	*******************************************************************************************/
		for (int vecka = 0; vecka < antalVeckor; vecka++) {
			System.out.println("Vecka " + (vecka+1) + ":");
			
			for (int matning = 0; matning < antalMatningarPerVecka; matning++) {
				System.out.print("Mätning " + (matning+1) + ": ");
				t[vecka][matning] = in.nextDouble();
			}
			}
		System.out.println();
		System.out.println();
		System.out.println();
	/****************************************************************************
	    ** Största, minsta och medeltemperaturen för varje vecka beräknas **  
	*****************************************************************************/
		double[] minT = new double[antalVeckor];
		double[] maxT = new double[antalVeckor];
		double[] sumT = new double[antalVeckor];
		double[] medelT = new double[antalVeckor];
	
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
		
	/****************************************************************************
	    ** Största, minsta och medeltemperaturen för hela perioden beräknas **  
	*****************************************************************************/
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
		
		/********************************
		    ** Resultaten skrivs ut **
		********************************/
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
