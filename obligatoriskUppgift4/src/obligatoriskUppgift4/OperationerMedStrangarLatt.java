/**Klass som används för beräkningar av tal representerade som strängar**
 
 	Author: Samuel Ferara

 	Beskrivning: 
 	Skapar objekt av klassen BigDecimal och kopierar tal som finns i strängar till dessa. 
 	Utför diverse beräkningar genom metoder som finns i klassen BigDecimal för att sedan 
 	omvandla det mottade resultatet till sträng-format och returnera det.
 	
 ************************************************************************************/


package obligatoriskUppgift4;

import java.math.BigDecimal;

public class OperationerMedStrangarLatt 
{
	public static String addString(String a, String b) 
	{
		BigDecimal numA = new BigDecimal(a);
		BigDecimal numB = new BigDecimal(b);
		
		return numA.add(numB).toString();
	}
	
	public static String multiplyString(String a, String b)
	{
		BigDecimal numA = new BigDecimal(a);
		BigDecimal numB = new BigDecimal(b);
		
		return numA.multiply(numB).toString(); 
	}
	
	public static String divideString(String a, String b)
	{
		BigDecimal numA = new BigDecimal(a);
		BigDecimal numB = new BigDecimal(b);
		
		return numA.divide(numB).toString(); 
	}
	
	public static String subtractString(String a, String b)
	{
		BigDecimal numA = new BigDecimal(a);
		BigDecimal numB = new BigDecimal(b);
		
		return numA.subtract(numB).toString(); 
	}
}
