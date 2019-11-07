/*
 * Author: Samuel Ferrara
 * Date
 */



/**********************************************UPPGIFTSBESKRIVNING ********************************************************
  
  En klass Triangel ska skapas: klassen ska inneh�lla flera statiska metoder som utf�r olika ber�kningar i samband med en
  triangel. En metod tar emot vissa uppgifter, och ber�knar och returnerar n�gon annan uppgift. Till exempel kan en metod 
  ta emot l�ngden av en triangels sida och l�ngden av motsvarande h�jd, och returnera triangelns area. En annan metod kan 
  ta emot l�ngderna av alla tre sidorna, och returnera antingen triangelns omkrets, dess area, en av triangelns medianer 
  eller bisektriser, eller n�got annat.
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
		System.out.print("Triangelns l�ngd :: ");
		double length = in.nextDouble();
		System.out.println("");
		System.out.print("Triangelns h�jd :: ");
		double heigth = in.nextDouble();
		System.out.println("");
		
		double area = (length*heigth)/2;
		
		
		
		return area;
	}
	public static void triangeln()
	{
		System.out.println("Ange triangelns l�ngd och h�jd");
		System.out.println("Triangelns area :: " + calcArea());
	}
}
