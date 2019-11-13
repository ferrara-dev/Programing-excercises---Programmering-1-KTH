package obligatoriskUppgift3;
import java.util.*;

public class HamtaKortasteVagen
{
	static Scanner in = new Scanner(System.in);
	static TheShortestDistance längd = new TheShortestDistance ();
	static double a[];
	static double b[][];
	static double c[];
	static double min;
	static int m;
	static int n;
	
	public static void main(String[] args) 
	{
		
		int n = 4;
		int m = 3;
		double [] a = new double[m];
		double [][] b = new double[m][n];	
		double [] c = new double[n];
				 
		c [0] = 34;
		c [1] = 11;
		c [2] = 22;
		c [3] = 22;
				
		for(int i = 0; i < m; i++)
		{
			System.out.println("Ange sträcka mellan x och u" + (i+1));
			a[i] = in.nextDouble();
						
			for(int j = 0; j < n; j++)
			{	
				System.out.println("Ange sträckan mellan U"+(i+1) +" och V" + (j+1) + " : " );
				b[i][j] = in.nextDouble();
			}
		}	
				
		for(int j = 0; j < n; j++)
		{
		System.out.println("Ange sträckan mellan V"+(j+1) +" och Y" + (j+1) + " : ");
		c[j] = in.nextDouble();
		}
		// Utför beräkning 
		double minimum = TheShortestDistance.langd(a,b,c);
		int bWay [] = TheShortestDistance.mellanstationer (a,b,c);
		System.out.println("Den kortaste sträckan mellan station X och Y är : " + Arrays.toString(bWay));
		System.out.println("Den kortaste sträckan mellan station X och Y är : " + minimum);
		System.out.println("Den kortaste sträckan mellan station X och Y är : " + minimum);
	}
}
			
