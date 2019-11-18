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
		 out.println("Med metoder från klassen CalculationsWithStrings  " );
		 out.println ("Summan av talen är :" + CalculationsWithStrings.addNaturalStringNumbers(tal1,tal2));
		 out.println ("Differensen av talen är :" + CalculationsWithStrings.subtractNaturalStringNumbers(tal1, tal2));
		// out.println("Produkten av de naturliga talen är : " +  CalculationsWithStrings.multiply(tal1, tal2));
		 
		 // Testa klassen som skapar objekt av klassen bigInteger
		 out.println();
		 out.println(" Med metoder från klassen OperationerMedStrangarLatt  " );
		 out.println(" Produkten av de talen är :" + OperationerMedStrangarLatt.multiplyString(tal1,tal2));
		 out.println(" Kvoten av de två talen är :" + OperationerMedStrangarLatt.divideString(tal1,tal2));
		 out.println(" Summan av de två talen är :" + OperationerMedStrangarLatt.addString(tal1,tal2));
		 out.println(" Differensen av de två talen är :" + OperationerMedStrangarLatt.subtractString(tal1,tal2));
		 
		 in.close();
	 }
}

