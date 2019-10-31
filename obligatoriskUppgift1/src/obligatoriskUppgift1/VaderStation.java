/***************************************************************************************************
 		   *** ATT GÖRA I SAMBAND MED UPPGIFT "VaderStation" ***
1. Skapa en tabell som innehåller möjliga temperaturer, 
   både de som erhålls genom mätningarna och de som beräknas.
   
2. Komplettera programmet VaderStation: 
   lägg till den kod som bestämmer och visar de minsta, största och medeltemperaturerna. 
   Kör programmet flera gånger med olika data, och kontrollera om de erhållna resultaten är riktiga.

3. Rita den vektor där de temperaturer som erhålls genom mätningarna lagras. 
   Hur kommer man åt en viss uppgift i denna vektor? 
   Rita även de vektorer och variabler där de erhållna resultaten lagras.
   När en vektor ritas ska både dess referenser, minnesceller och de lagrade uppgifterna finnas med. 
   Det ska framgå vad de enskilda referenserna heter. 
   När en variabel ritas ska den data som lagras och variabelns namn finnas med.

4. Vilken strategi använder man för att bestämma den minsta temperaturen? Illustrera denna strategi: 
   rita en serie bilder som visar hur man kommer fram till den minsta temperaturen.
 ***************************************************************************************************/

package obligatoriskUppgift1;

/***************************************
 	  *** "import java.util.*;" ***
 	  
Vägvisare till bilioteket som innehåller 
standard objektet "java.util.Scanner"
****************************************/
import java.util.*;
public class VaderStation {
	
	static int antalVeckor;
	static int antalMätningar;
	static int vecka;
	static int mätning;
	static double [] [] t ;
	static double minT;
	static double maxT;
	static double sumT;
	static double medelT;
	
	//(1)
	/**************************************************************************************************
	    							*** Verktyg för inmatning ***
	(a) "new" reserverar minne för objektet som skapats av klassen "java.util.Scanner".
	 
	(b) "(System.in)" ger information till objektet ".Scanner",  
	 
	(c) "in" är en referens bestående i en variabel som innehåller adressen till objektet. 
	 
	 ***************************************************************************************************/
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
	
		System.out.println("Väderstation : Temperaturer");
		
		// Användaren matar in antalet veckor och antalet mätningar per vecka 
		//setAntal();
		
		//(2)
		/******************************************************************************		 
		"in.nextInt();" anger adressen där värdet sparas till objektet "Scanner
		 ******************************************************************************/
		System.out.println("Var god och ange antalet veckor:");
		antalVeckor = in.nextInt();
				
		System.out.println("Var god och ange antalet mätningar per vecka:");
		antalMätningar = in.nextInt();
				
		System.out.println("Antalet veckor:  " + antalVeckor);
		System.out.println("Antalet mätningar per vecka: " + antalMätningar);
		System.out.flush();
		//setTemp();
		
		// (3)Plats att lagra temperaturer
		/***********************************************************************************
		 				         *** Plats att lagra temperaturer ***
		(a) "new" reserverar minne för den vektor som temperaturena ska lagras i .

		(b) Vektorns djup sätts till värdet av antalVeckor respektive antalMätningar vars
			värden hämtas från 

		(c) "in" är en referens bestående i en variabel som innehåller adressen till objektet. 

		 *************************************************************************************/
		double [] [] t = new double [antalVeckor + 1] [antalMätningar +1];
		
		// mata in temperatrurer
	
		int r = 0;			
		while(r==0) /* <-- Här låg felet, genom att lägga till while-loopen växer elemntet veckor 
								 	varje gång antaletmätningar per vecka är uppfyllt. */
		{
			if(vecka>=mätning)
				r=1;
				
			else
				vecka ++;
		
		for(int vecka=1; vecka <= antalVeckor; vecka++)
		{
			System.out.println("temperaturer - vecka " + vecka + ":");
			for(int mätning=1; mätning <= antalMätningar; mätning++)
			{
				
				System.out.println("Mätning " + mätning);
				
					t[vecka][mätning] = in.nextDouble();
					}
			
				
		}
		System.out.println ("temperaturerna:");
		for (vecka = 1; vecka <= antalVeckor; vecka++)
			{
			for ( mätning = 1; mätning <= antalMätningar; mätning++)
					System.out.print (t[vecka][mätning] + " ");
					System.out.println ();
			}
			
			System.out.println ();
		
		}
		
		
		
		
		// den minsta, den största och medeltemperaturen – veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];
		
		// koden ska skrivas här
		for (int i = 1; i < t.length; i++)
	        {
	            maxT[i] = t[i][1];
	            sumT[i] = t[i][1];
	            minT[i] = t[i][1];
	            for (int j = 2; j < t[i].length; j++)
	            {
	            	if (t[i][j] < minT[i])
	                	minT[i]=t[i][j];
	            	
	                if (t[i][j] > maxT[i])
	                {
	                    maxT[i] = t[i][j];
	               
	                }
	                sumT [i] += t[i][j];
				}
	            medelT[i] = (double) sumT[i] / (t[i].length - 1);
			}
		/* System.out.println ("Högsta, lägsta och medeltemperatur - Veckovis");
	        for (int i = 1; i < t.length; i++)
	        {
	            System.out.printf("Vecka " + i + " :"
	            +"  %4f  |  %4f  |  %7.2f   \n", maxT[i], minT[i], medelT[i]);
	        }
	        System.out.println ();
	        */
	     
	       // Minsta största och medeltemperaturen för hela perioden
	        
	        double minTemp = minT[1];
	        double maxTemp = maxT[1];
	        double sumMedelTemp =0;
	        int kvot = antalVeckor*antalMätningar;
	        double medelTemp=0;
	        int counter=0;
	        for (int i=1; i < t.length; i++)
	        {
	        	sumMedelTemp+=medelT[i];
	        	medelTemp=sumMedelTemp/antalVeckor; 
	        	if(minT[i]< minTemp)
	        	{
	        		minTemp=minT[i];
	        	}
	        	if(maxT[i] > maxTemp)
	        	{
	        		maxTemp=maxT[i];
	        		
	        	}
	        	
	        // visa temperaturerna
			
	        		        	//medelTemp = (double) sumTemp /kvot;
	        }
	        System.out.println ("Högsta, lägsta och medeltemperatur - Veckovis \n");
	        System.out.println("           Maxtemp     mintemp     Medeltemp      ");
        	System.out.println("_____________________________________________");
	        for (int i = 1; i < t.length; i++)
	        {	
	            System.out.printf("Vecka " + i + " |"
	            +"  %7.2f  |  %7.2f  |  %7.2f  \n", maxT[i], minT[i], medelT[i]);
	            System.out.println("_____________________________________________");
	        }
	       
	        System.out.println("Högsta,lägsta och medeltemperatur - Hela perioden");
	   
	        System.out.println("_____________________________________________");
	        System.out.printf("Max "+ "    |"
		            +"  %7.2f  |\n", maxTemp);
	        System.out.println("_____________________________________________");
	        System.out.printf("Min "+ "    |"
		            +"  %7.2f  | \n", minTemp);
	        System.out.println("_____________________________________________");
	        System.out.printf("Medel "+ "  |"
		            +"  %7.2f  | \n", medelTemp);
	        System.out.println("_____________________________________________");
	      
	      
	       
	       System.out.println("sumMedelTemp --> " + sumMedelTemp); // Test för att algoritmen fungerar
	     
	}
	
/*	private static void setAntal()
	{
	
				
		//(2)
		/******************************************************************************		 
		"in.nextInt();" anger adressen där värdet sparas till objektet "Scanner
		 ******************************************************************************/
	/*	System.out.println("Var god och ange antalet veckor:");
		antalVeckor = in.nextInt();
				
		System.out.println("Var god och ange antalet mätningar per vecka:");
		antalMätningar = in.nextInt();
				
		System.out.println("Antalet veckor:  " + antalVeckor);
		System.out.println("Antalet mätningar per vecka: " + antalMätningar);
		System.out.flush();
	} */
	
	/*private static void setTemp()
	{
		// (3)Plats att lagra temperaturer
				/***********************************************************************************
				 				         *** Plats att lagra temperaturer ***
				(a) "new" reserverar minne för den vektor som temperaturena ska lagras i .

				(b) Vektorns djup sätts till värdet av antalVeckor respektive antalMätningar vars
					värden hämtas från 

				(c) "in" är en referens bestående i en variabel som innehåller adressen till objektet. 

				 *************************************************************************************/
			/*	double [] [] t = new double [antalVeckor + 1] [antalMätningar +1];
				
				// mata in temperatrurer
			
				int r = 0;			
				while(r==0) /* <-- Här låg felet, genom att lägga till while-loopen växer elemntet veckor 
										 	varje gång antaletmätningar per vecka är uppfyllt. */
			/*	{
					if(vecka>=mätning)
						r=1;
						
					else
						vecka ++;
				
				for(int vecka=1; vecka <= antalVeckor; vecka++)
				{
					System.out.println("temperaturer - vecka " + vecka + ":");
					for(int mätning=1; mätning <= antalMätningar; mätning++)
					{
						
						System.out.println("Mätning " + mätning);
						
							t[vecka][mätning] = in.nextDouble();
							}
					
						
				}
				System.out.println ("temperaturerna:");
				for (vecka = 1; vecka <= antalVeckor; vecka++)
					{
					for ( mätning = 1; mätning <= antalMätningar; mätning++)
							System.out.print (t[vecka][mätning] + " ");
							System.out.println ();
					}
					
					System.out.println ();
				
				}
				
				}
	*/
}