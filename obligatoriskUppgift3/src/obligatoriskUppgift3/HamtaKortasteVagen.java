package obligatoriskUppgift3;
import java.util.*;

public class HamtaKortasteVagen
{
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		System.out.println("Skriv in 1 för att testa den första instansen eller 2 för att testa den andra");
		Scanner in = new Scanner(System.in);
		int val = in.nextInt();

		/*******FÖRSTA INSTANSEN********
		* +--------------------------+ *
		* |    3 stationer i zon 2   | *
		* |    4 stationer i zon 3   | *
		* +--------------------------+ *
		********************************/
		if(val == 1)
		{
		double a []   = new double [] {0,10,10,5 };
		double b [][] = new double [][] {{0,0,0,0,0} ,{0,10,7,7,5},{0,2,12,15,7},{0,10,3,5,15} };
		double c []   = new double [] {0,2,3,10,5 };
		double minimum = TheShortestDistance.langd(a,b,c);
		int bWay [] = TheShortestDistance.mellanstationer (a,b,c);
		System.out.println("Den kortaste sträckan går mellan station : " + "u" + (bWay[0]) +" och v" + (bWay[1]));
		System.out.println("Den kortaste sträckan mellan station X och Y är : " + minimum);
		}
		
		/********ANDRA INSTANSEN********
		* +--------------------------+ *
		* |    2 stationer i zon 2   | *
		* |    5 stationer i zon 3   | *
		* +--------------------------+ *
		********************************/
		if(val == 2)
		{
		double a []   = new double [] {0,2,3};
		double b [][] = new double [][] { {0,0,0,0,0},{0,2,12,15,7,1},{0,10,3,5,15,8} };
		double c []   = new double [] {0,7,10,5,3,5 };
		double minimum = TheShortestDistance.langd(a,b,c);
		int bWay [] = TheShortestDistance.mellanstationer (a,b,c);
		System.out.println("Den kortaste sträckan går mellan station : " + "u" + (bWay[0]) +" och v" + (bWay[1]));
		System.out.println("Den kortaste sträckan mellan station X och Y är : " + minimum);

		}

		in.close();
	  }
}
			
