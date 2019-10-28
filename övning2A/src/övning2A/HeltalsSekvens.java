/*******************************************************
 A program that handles a sequence of integers. Generates 
 a sequence of random integers between one to ten and 
 stores the values in an array. The program then goes on
 to calculate and print out the following:
 1. maximum value integer
 2. minimum value integer
 3. sum of the integers
 4. mean value of the integers

 Author: Samuel Ferrra
 
 Date: 2019-10-28
 
 *******************************************************/

package �vning2A;

import java.util.*;

public class HeltalsSekvens 
{

	public static void main(String[] args) 
	
	{
		
		// Print out
		System.out.println("A random sequence of integers\n\n");
		
		// Inmatningsverktyg
		java.util.Scanner    in = new java.util.Scanner (System.in);
		
		// Anv�ndaren matar listans l�ngd
	     
		System.out.println ("Ange hur m�nga heltal som ska ing� i sekvensen:"); 
		int d = in.nextInt();
		System.out.println ();
	
		int[]    u = new int[d];        
		//System.out.println ("ange 10 heltal i en rad:");  
		System.out.println("De ig�ende heltalen �r: ");
		for (int i = 0; i < u.length; i++)  
		{
			int a = (int)(10*Math.random()+1);
			u[i] = a;  //in.nextInt ();   
			System.out.println(a +"\r");
			System.out.println ();
		}
		 
		
		
		  // algorithm to get maximum and minimum value
		int    min = u[0];        
		int    sum = u[0];        
		int    max = u[0];

		for (int i = 1; i < u.length; i++)        
		{     
			sum += u[i];
			
			//Compare to get minimum value
			if (u[i] < min) {
				min = u[i];            
			
			}   
			//Compare to get maximum value
			if(u[i] > max) {
				max=u[i];
	
			}
		}
			
		// algorithm to calculate mean value
		double    mean = (double) sum / (u.length);
		
		// Print out result       
		System.out.println ("St�rsta och minsta "
							+ "heltalet samt heltalens"
							+ " summa och medelv�rde");     
 
		System.out.printf    ("H�gsta v�rdet: %4d  |"
						   + "L�gsta v�rdet:  %4d  |"
						   + "Summan:  %4d  |"
						   + "Medelv�rdet: %7.2f\n\n\n"
						   ,max, min,sum, mean);
	
	
	}

}
