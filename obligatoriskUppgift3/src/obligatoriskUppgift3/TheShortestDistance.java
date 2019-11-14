package obligatoriskUppgift3;

import java.util.Scanner;

public class TheShortestDistance 
{
		static Scanner in = new Scanner(System.in);
		static int bestRoute[][];
		 // mellanstationer returnerar en vektor med de mellanstationersom finns på den kortaste vägen.
		 // Ordningsnummerav den förstamellanstationen finns på index1, 
		 // och ordningsnummer av den andra mellanstationen på index2 i vektorn.
		
		 public static int[] mellanstationer (double[] a, double[][] b,double[] c)
		 {
			int index [] = new int [2];
			int k = 1;
			int l = 1;
			double bestStation = b[1][1] + a[1] + c[1];
			
			for(int i = 1; i < a.length; i++)
			{	
				for(int j = 1; j < c.length; j++)
			 	{
					bestStation = a[i] + c[j] + b[i][j];
					double newBestStation =a[l] + c[k] + b[l][k];
					if(bestStation < newBestStation)
			 		{
			 			k = j;
			 			l = i;
			 			index [0] = l;
			 			index [1] = k;
			 		}	
			 	}
			}
		   	return index;
		 }
		 
		 // langd returnerar längden av den kortaste vägen.
		 public static double langd (double[] a, double[][] b, double[] c)
		 {
			double minDist = b[1][1] + a[1] + c[1];
			for(int i = 1; i < a.length; i++)
			{
				for(int j = 1; j < c.length; j++)
			 	{

			 		double newMinDist = a[i] + b[i][j] + c[j];
			 		
			 		if(newMinDist < minDist)
			 			minDist = newMinDist;	
			 	}
			}
			 return minDist;
		 }
}
