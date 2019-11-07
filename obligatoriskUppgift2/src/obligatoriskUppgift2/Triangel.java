/*
 * Author: Samuel Ferrara
 * Date
 */



/**********************************************UPPGIFTSBESKRIVNING ********************************************************
  
  En klass Triangel ska skapas: klassen ska innehålla flera statiska metoder som utför olika beräkningar i samband med en
  triangel. En metod tar emot vissa uppgifter, och beräknar och returnerar någon annan uppgift. Till exempel kan en metod 
  ta emot längden av en triangels sida och längden av motsvarande höjd, och returnera triangelns area. En annan metod kan 
  ta emot längderna av alla tre sidorna, och returnera antingen triangelns omkrets, dess area, en av triangelns medianer 
  eller bisektriser, eller något annat.
 **************************************************************************************************************************/



package obligatoriskUppgift2;
import java.util.*;



public class Triangel
{

	private static Scanner in = new Scanner(System.in);
	
	// triangelns sidor

	public static void main(String[] args) 
	{
		System.out.println("Triangel - Omkrets och area");
		triangeln();
	}
	
	public static double  calcArea()
	{
		System.out.print("Triangelns längd :: ");
		double length = in.nextDouble();
		System.out.println("");
		System.out.print("Triangelns höjd :: ");
		double heigth = in.nextDouble();
		System.out.println("");
		
		double area = (length*heigth)/2;
		
		
		
		return area;
	}
	public static void triangeln()
	{
		System.out.println("Ange triangelns längd och höjd");
		System.out.println("Triangelns area :: " + calcArea());
	}
}
