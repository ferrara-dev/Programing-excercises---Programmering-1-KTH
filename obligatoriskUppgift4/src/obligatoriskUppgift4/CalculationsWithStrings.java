package obligatoriskUppgift4;

public class CalculationsWithStrings 
{
	public static String multiply(String first, String second) 
	{ 
	    int len1 = first.length(); 
	    int len2 = second.length(); 
	    if (len1 == 0 || len2 == 0) 
	        return "0"; 
	  
	    // will keep the result number in vector 
	    // in reverse order 
	    int result[] = new int[len1 + len2]; 
	    // Below two indexes are used to  
	    // find positions in result.  
	    int i_n1 = 0;  
	    int i_n2 = 0;  
	      
	    // Go from right to left in num1 
	    for (int i = len1 - 1; i >= 0; i--) 
	    { 
	        int carry = 0; 
	        int n1 = first.charAt(i) - '0'; 
	  
	        // To shift position to left after every 
	        // multipliccharAtion of a digit in num2 
	        i_n2 = 0;  
	          
	        // Go from right to left in num2              
	        for (int j = len2 - 1; j >= 0; j--) 
	        { 
	            // Take current digit of second number 
	            int n2 = second.charAt(j) - '0'; 
	  
	            // Multiply with current digit of first number 
	            // and add result to previously stored result 
	            // charAt current position.  
	            int sum = n1 * n2 + result[i_n1 + i_n2] + carry; 
	  
	            // Carry for next itercharAtion 
	            carry = sum / 10; 
	  
	            // Store result 
	            result[i_n1 + i_n2] = sum % 10; 
	  
	            i_n2++; 
	        } 
	  
	        // store carry in next cell 
	        if (carry > 0) 
	            result[i_n1 + i_n2] += carry; 
	  
	        // To shift position to left after every 
	        // multipliccharAtion of a digit in num1. 
	        i_n1++; 
	    } 
	  
	    // ignore '0's from the right 
	    int i = result.length - 1; 
	    while (i >= 0 && result[i] == 0) 
	    i--; 
	  
	    // If all were '0's - means either both  
	    // or one of num1 or num2 were '0' 
	    if (i == -1) 
	    return "0"; 
	  
	    // genercharAte the result String 
	    String s = ""; 
	      
	    while (i >= 0) 
	        s += (result[i--]); 
	  
	    return s; 
	} 

	public static String addNaturalStringNumbers(String numA, String numB)
	{
		int carry = 0;
		int lastIndexA = numA.length()-1;
		int lastIndexB = numB.length()-1;
		StringBuilder sum =  new StringBuilder(); 
		int digit = 0;
		
		while(lastIndexA >= 0 && lastIndexB >= 0)
		{
			int digitSum = (numA.charAt(lastIndexA) - 48) //Genom att ta karaktärens värde i ascii minus 48 får man "rätta" värdet
					+ (numB.charAt(lastIndexB) - 48) 
					+ carry; //Lägger till carry
			
			digit = digitSum % 10;
			carry = digitSum /10;
			sum.append(digit);
			lastIndexA --;
			lastIndexB --;
		}
		
		while(lastIndexA >= 0)
		{
			int digitSum = carry + (numA.charAt(lastIndexA) - 48);
			digit =digitSum %10;
			carry = digitSum /10;
			sum.append(digit);
			lastIndexA --;
		}
		
		while(lastIndexB >= 0)
		{
			int digitSum = carry + (numB.charAt(lastIndexB) - 48);
			digit =digitSum %10;
			carry = digitSum /10;
			sum.append(digit);
			
			lastIndexB --;
		}
		if (carry != 0)
			sum.append(carry);
		// Vänder och omvandlar Stringbuilder objektet till String innan det returneras				
		return sum.reverse().toString(); 
		
		
		
		
	}
	
	public static String subtractNaturalStringNumbers(String numA, String numB)
	{
		StringBuilder dif =  new StringBuilder(); 
		
		 if (isSmaller(numA, numB)) 
		    { 
		        String t = numA; 
		        numA = numB; 
		        numB = t; 
		    } 

		int carry = 0;
		int lastIndexA = numA.length()-1;
		int lastIndexB = numB.length()-1;
		
		
		while(lastIndexA >= 0 && lastIndexB >= 0)
		{
			int digitDif = (numA.charAt(lastIndexA) - 48) //Genom att ta karaktärens värde i ascii minus 48 får man "rätta" värdet
					- (numB.charAt(lastIndexB) - 48) 
					- carry; //Lägger till carry ;
			 if (digitDif < 0) 
		        { 
				 digitDif= digitDif+ 10; 
		            carry = 1; 
		        } 
		        else
		            carry = 0; 
			dif.append(digitDif);
			lastIndexA --;
			lastIndexB --;
		}
		
		while(lastIndexA >= 0)
		{
			int digitDif = (numA.charAt(lastIndexA) - 48)- carry;
			 if (digitDif < 0) 
		        { 
				 digitDif= digitDif+ 10; 
		            carry = 1; 
		        } 
		        else
		            carry = 0; 
			dif.append(digitDif);
			lastIndexA --;
		}
		
		while(lastIndexB >= 0)
		{
			int digitDif = carry + (numB.charAt(lastIndexB) - 48);
			if (digitDif < 0) 
	        { 
			 digitDif= digitDif+ 10; 
	            carry = 1; 
	        } 
	        else
	            carry = 0; 
			
			dif.append(digitDif);
			
			lastIndexB --;
			}
			if (carry != 0)
				dif.append(carry);
			
			if(dif.length() != 1) //Om längden är större än 1
			{
			if(dif.charAt(dif.length() - 1) == 48) //Kolla om sista karaktären är en 0a
			{
				dif.deleteCharAt(dif.length() - 1); //Tar bort denna
			}
		}
			
		// Ser till att det blir ett minustecken framför strängen om differensen är negativ
		if (isSmaller(numB, numA)) 
		{
			dif.append("-");
			return dif.reverse().toString(); //Vänder och returnerar strängen som byggdes
		}
		
		return dif.reverse().toString(); //Vänder och returnerar strängen som byggdes
	}
	
	/*************************************************************************
	     Metod som returnerar true om talet i numA är mindre än det i numB
	 *************************************************************************/
	static boolean isSmaller(String numA, String numB) 
	{ 
	    // Calculate lengths of both string 
	    int nA = numA.length();
	    int nB = numB.length(); 
	    if (nA < nB) 
	        return true; 
	    
	    if (nB < nA) 
	        return false; 
	      
	    for (int i = 0; i < nA; i++) 
	    if (numA.charAt(i) < numB.charAt(i)) 
	        return true; 
	    else if (numA.charAt(i) > numB.charAt(i)) 
	        return false; 
	  
	    return false; 
	} 
}
