package obligatoriskUppgift4;

import java.util.*; // Scanner
import static java.lang.System.out;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar 
{
	public static void main (String[] args)
	 {
		 out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
		 // mata in två naturliga heltal
		 Scanner in = new Scanner (System.in);
		 out.println ("två naturliga heltal:");
		 String tal1 = in.next ();
		 String tal2 = in.next ();
		 out.println ("(Metod addition 2) Summan av de naturilga talen är :" + CalculationsWithStrings.addition2(tal1,tal2));
		 out.println ("Summan av de naturilga talen är :" + CalculationsWithStrings.addera(tal1, tal2));
		 out.println ("Differensen av de naturilga talen är :" + CalculationsWithStrings.minus(tal1, tal2));
		out.println("Differensen av de naturliga talen är : " + CalculationsWithStrings.subraction(tal1,tal2));
		// out.println("Produkten av de naturliga talen är : " +  CalculationsWithStrings.multiply(tal1, tal2));
	 }
}
