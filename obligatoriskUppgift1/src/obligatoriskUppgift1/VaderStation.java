/***************************************************************************************************
 		   *** ATT G�RA I SAMBAND MED UPPGIFT "VaderStation" ***
1. Skapa en tabell som inneh�ller m�jliga temperaturer, 
   b�de de som erh�lls genom m�tningarna och de som ber�knas.
   
2. Komplettera programmet VaderStation: 
   l�gg till den kod som best�mmer och visar de minsta, st�rsta och medeltemperaturerna. 
   K�r programmet flera g�nger med olika data, och kontrollera om de erh�llna resultaten �r riktiga.

3. Rita den vektor d�r de temperaturer som erh�lls genom m�tningarna lagras. 
   Hur kommer man �t en viss uppgift i denna vektor? 
   Rita �ven de vektorer och variabler d�r de erh�llna resultaten lagras.
   N�r en vektor ritas ska b�de dess referenser, minnesceller och de lagrade uppgifterna finnas med. 
   Det ska framg� vad de enskilda referenserna heter. 
   N�r en variabel ritas ska den data som lagras och variabelns namn finnas med.

4. Vilken strategi anv�nder man f�r att best�mma den minsta temperaturen? Illustrera denna strategi: 
   rita en serie bilder som visar hur man kommer fram till den minsta temperaturen.
 ***************************************************************************************************/

package obligatoriskUppgift1;

/***************************************
 	  *** "import java.util.*;" ***
 	  
V�gvisare till bilioteket som inneh�ller 
standard objektet "java.util.Scanner"
****************************************/
import java.util.*;
public class VaderStation {
	
	static int antalVeckor;
	static int antalM�tningar;
	static int vecka;
	static int m�tning;
	static double [] [] t ;
	static double minT;
	static double maxT;
	static double sumT;
	static double medelT;
	
	//(1)
	/**************************************************************************************************
	    							*** Verktyg f�r inmatning ***
	(a) "new" reserverar minne f�r objektet som skapats av klassen "java.util.Scanner".
	 
	(b) "(System.in)" ger information till objektet ".Scanner",  
	 
	(c) "in" �r en referens best�ende i en variabel som inneh�ller adressen till objektet. 
	 
	 ***************************************************************************************************/
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
	
		System.out.println("V�derstation : Temperaturer");
		
		// Anv�ndaren matar in antalet veckor och antalet m�tningar per vecka 
		//setAntal();
		
		//(2)
		/******************************************************************************		 
		"in.nextInt();" anger adressen d�r v�rdet sparas till objektet "Scanner
		 ******************************************************************************/
		System.out.println("Var god och ange antalet veckor:");
		antalVeckor = in.nextInt();
				
		System.out.println("Var god och ange antalet m�tningar per vecka:");
		antalM�tningar = in.nextInt();
				
		System.out.println("Antalet veckor:  " + antalVeckor);
		System.out.println("Antalet m�tningar per vecka: " + antalM�tningar);
		System.out.flush();
		//setTemp();
		
		// (3)Plats att lagra temperaturer
		/***********************************************************************************
		 				         *** Plats att lagra temperaturer ***
		(a) "new" reserverar minne f�r den vektor som temperaturena ska lagras i .

		(b) Vektorns djup s�tts till v�rdet av antalVeckor respektive antalM�tningar vars
			v�rden h�mtas fr�n 

		(c) "in" �r en referens best�ende i en variabel som inneh�ller adressen till objektet. 

		 *************************************************************************************/
		double [] [] t = new double [antalVeckor + 1] [antalM�tningar +1];
		
		// mata in temperatrurer
	
		int r = 0;			
		while(r==0) /* <-- H�r l�g felet, genom att l�gga till while-loopen v�xer elemntet veckor 
								 	varje g�ng antaletm�tningar per vecka �r uppfyllt. */
		{
			if(vecka>=m�tning)
				r=1;
				
			else
				vecka ++;
		
		for(int vecka=1; vecka <= antalVeckor; vecka++)
		{
			System.out.println("temperaturer - vecka " + vecka + ":");
			for(int m�tning=1; m�tning <= antalM�tningar; m�tning++)
			{
				
				System.out.println("M�tning " + m�tning);
				
					t[vecka][m�tning] = in.nextDouble();
					}
			
				
		}
		System.out.println ("temperaturerna:");
		for (vecka = 1; vecka <= antalVeckor; vecka++)
			{
			for ( m�tning = 1; m�tning <= antalM�tningar; m�tning++)
					System.out.print (t[vecka][m�tning] + " ");
					System.out.println ();
			}
			
			System.out.println ();
		
		}
		
		
		
		
		// den minsta, den st�rsta och medeltemperaturen � veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];
		
		// koden ska skrivas h�r
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
		/* System.out.println ("H�gsta, l�gsta och medeltemperatur - Veckovis");
	        for (int i = 1; i < t.length; i++)
	        {
	            System.out.printf("Vecka " + i + " :"
	            +"  %4f  |  %4f  |  %7.2f   \n", maxT[i], minT[i], medelT[i]);
	        }
	        System.out.println ();
	        */
	     
	       // Minsta st�rsta och medeltemperaturen f�r hela perioden
	        
	        double minTemp = minT[1];
	        double maxTemp = maxT[1];
	        double sumMedelTemp =0;
	        int kvot = antalVeckor*antalM�tningar;
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
	        System.out.println ("H�gsta, l�gsta och medeltemperatur - Veckovis \n");
	        System.out.println("           Maxtemp     mintemp     Medeltemp      ");
        	System.out.println("_____________________________________________");
	        for (int i = 1; i < t.length; i++)
	        {	
	            System.out.printf("Vecka " + i + " |"
	            +"  %7.2f  |  %7.2f  |  %7.2f  \n", maxT[i], minT[i], medelT[i]);
	            System.out.println("_____________________________________________");
	        }
	       
	        System.out.println("H�gsta,l�gsta och medeltemperatur - Hela perioden");
	   
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
	      
	      
	       
	       System.out.println("sumMedelTemp --> " + sumMedelTemp); // Test f�r att algoritmen fungerar
	     
	}
	
/*	private static void setAntal()
	{
	
				
		//(2)
		/******************************************************************************		 
		"in.nextInt();" anger adressen d�r v�rdet sparas till objektet "Scanner
		 ******************************************************************************/
	/*	System.out.println("Var god och ange antalet veckor:");
		antalVeckor = in.nextInt();
				
		System.out.println("Var god och ange antalet m�tningar per vecka:");
		antalM�tningar = in.nextInt();
				
		System.out.println("Antalet veckor:  " + antalVeckor);
		System.out.println("Antalet m�tningar per vecka: " + antalM�tningar);
		System.out.flush();
	} */
	
	/*private static void setTemp()
	{
		// (3)Plats att lagra temperaturer
				/***********************************************************************************
				 				         *** Plats att lagra temperaturer ***
				(a) "new" reserverar minne f�r den vektor som temperaturena ska lagras i .

				(b) Vektorns djup s�tts till v�rdet av antalVeckor respektive antalM�tningar vars
					v�rden h�mtas fr�n 

				(c) "in" �r en referens best�ende i en variabel som inneh�ller adressen till objektet. 

				 *************************************************************************************/
			/*	double [] [] t = new double [antalVeckor + 1] [antalM�tningar +1];
				
				// mata in temperatrurer
			
				int r = 0;			
				while(r==0) /* <-- H�r l�g felet, genom att l�gga till while-loopen v�xer elemntet veckor 
										 	varje g�ng antaletm�tningar per vecka �r uppfyllt. */
			/*	{
					if(vecka>=m�tning)
						r=1;
						
					else
						vecka ++;
				
				for(int vecka=1; vecka <= antalVeckor; vecka++)
				{
					System.out.println("temperaturer - vecka " + vecka + ":");
					for(int m�tning=1; m�tning <= antalM�tningar; m�tning++)
					{
						
						System.out.println("M�tning " + m�tning);
						
							t[vecka][m�tning] = in.nextDouble();
							}
					
						
				}
				System.out.println ("temperaturerna:");
				for (vecka = 1; vecka <= antalVeckor; vecka++)
					{
					for ( m�tning = 1; m�tning <= antalM�tningar; m�tning++)
							System.out.print (t[vecka][m�tning] + " ");
							System.out.println ();
					}
					
					System.out.println ();
				
				}
				
				}
	*/
}