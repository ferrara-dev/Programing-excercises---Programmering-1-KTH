package obligatoriskUppgift3;

import java.util.Scanner;

public class TheShortestDistance 
{
		static Scanner in = new Scanner(System.in);
		static double minDist;
		static int bestRoute[][];
		 // mellanstationer returnerar en vektor med de mellanstationersom finns på den kortaste vägen.
		 // Ordningsnummerav den förstamellanstationen finns på index1, 
		 // och ordningsnummer av den andra mellanstationen på index2 i vektorn.
		
	/*	 public static int[] mellanstationer (double[] a, double[][] b,double[] c)
		 {

		 }
	*/	
		 // langd returnerar längden av den kortaste vägen.
		 public static double langd (double[] a, double[][] b, double[] c)
		 {
			
			minDist = b[0][0] + a[0] + c[0];
			for(int i = 0; i < a.length; i++)
			{
				for(int j = 0; j < c.length; j++)
			 	{

			 		double newMinDist = a[i] + b[i][j] + c[j];
			 		
			 		if(newMinDist < minDist)
			 			minDist = newMinDist;	
			 	}
		 	
			 // koden här
	 	 }
			 return minDist;
		 }
}
