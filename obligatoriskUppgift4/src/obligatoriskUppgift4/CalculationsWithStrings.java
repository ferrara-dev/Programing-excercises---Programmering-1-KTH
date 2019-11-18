package obligatoriskUppgift4;
import static java.lang.System.out;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CalculationsWithStrings 
{
	static boolean bol = true;
	public static String addera(String talA, String talB)
	{
		StringBuilder sBuilder =  new StringBuilder(); //En stringbuilder
		int length = talA.length();
		talB = matchLength(length, talB); //Skickar iväg andra strängen för att matcha längd
		int carry = 0;
		int i = 0;
		
		if(talB.length() > length) //Kollar om längden på second är längre än first.
		{
			length = talB.length();
			talA = matchLength(length, talA); //Matchar längderna
		}
		
		talA = new StringBuilder(talA).reverse().toString();  //Vänder på strängen för en enklare while-loop
		talB = new StringBuilder(talB).reverse().toString(); //-||-
		while(i < length || carry == 1) //Körs så länge i är mindre än längden och carry == 1
		{
			int temp; //Deklarerar en int för värdet som skall vara värdet av additionen
			if(i < length)
			{
				//Adderar alla värden
				temp = (talA.charAt(i) - 48) //Genom att ta karaktärens värde i ascii minus 48 får man "rätta" värdet
						+ (talB.charAt(i) - 48) 
						+ carry; //Lägger till carry 
			}else
			{
				temp = carry; 
			}

			carry = 0;

			if(temp > 9) //Om temp är större än tio behöver vi en carry
			{
				out.println(temp % 10);
				carry = 1;
				sBuilder.append(temp % 10);  //Modulus på temp med 10 och ger lägger till resten
			}else
			{
				sBuilder.append(temp);
			}
			i++;
		}
		return new StringBuilder(sBuilder.toString()).reverse().toString(); //Vänder och returnerar strängen som byggdes
	}
	
	
	
	
	public static String subraction(String first, String second)
	{
		StringBuilder sBuilder = new StringBuilder(); //Stringbuilder
		int length = first.length(); 
		second = matchLength(length, second); //Matchar längder
		int carry = 0;
		int i = 0;
		
		if(second.length() > length)  //Om second är längre än first
		{
			length = second.length(); //Lägger length till second
			first = matchLength(length, first); //Skicka iväg för matchas
		}

		for( int j = 0; j < length; j++)
		{
			if(first.charAt(i) < second.charAt(i))
			{
				bol = true;
				String storeSecond = second;
				second = first;
				first = storeSecond;
			}
		}
		
		first = new StringBuilder(first).reverse().toString();  //Vänder på strängen för en enklare while-loop
		second = new StringBuilder(second).reverse().toString(); //-||-
		
		
		
		while(i < length || carry == 1) //Körs så länge i är mindre än längden och carry == 1
		{
			
			int temp; //Deklarerar en int för värdet som skall vara summan av subtraktionen
			if(i < length)
			{
				//Subtraherar alla värden
				temp = (first.charAt(i) - 48) //Genom att ta karaktärens värde i ascii minus 48 får man "rätta" värdet
						- (second.charAt(i) - 48)
						- carry; //Subtraherar carry
			}
			else
			{
				temp = carry;
			}

			carry = 0;

			if(temp < 0) //Om temp är mindre än 0 behöver vi låna 10
			{
				carry = 1;
				sBuilder.append(10 + temp); //Lägger till 10 på temp, får därefter rätt värde
			}else
			{
				sBuilder.append(temp);
			}
			i++;
		}
		if(sBuilder.length() != 1) //Om längden är större än 1
		{
		if(sBuilder.charAt(sBuilder.length() - 1) == 48) //Kolla om sista karaktären är en 0a
		{
			sBuilder.deleteCharAt(sBuilder.length() - 1); //Tar bort denna
		}
		}
		return new StringBuilder(sBuilder.toString()).reverse().toString(); //Vänder och returnerar strängen som byggdes
	}
	
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
	
	public static String matchLength(int length, String tal)
	{
		StringBuilder sBuilder = new StringBuilder(); //Stringbuilder
		while(sBuilder.length() < (length - tal.length())) //Medan stringbuilders längd är mindre än längd - en av talens längder
		{
			sBuilder.append(0); //Lägg till 0or
		}
		sBuilder.append(tal); //Lägg till talet
		return sBuilder.toString(); //Returnera strängen
	}
	
	public static String add(String a, String b) {
		
		List<BigInteger> integers = Arrays.asList(new BigInteger(a), new BigInteger(b));
		Collections.sort(integers);
		Long sum = integers.stream()
				  .mapToLong(BigInteger::longValue)
				  .sum();
		return sum.toString();
	}
	
  
	public static String addition2(String numA, String numB)
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
					+ carry; //Lägger till carry ;
			out.println(digitSum);
			digit = digitSum % 10;
			carry = digitSum /10;
			sum.append(digit);
			out.println(sum.toString());
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
		return sum.reverse().toString(); //Vänder och returnerar strängen som byggdes
	}
	
	public static String minus(String numA, String numB)
	{
		int carry = 0;
		int lastIndexA = numA.length()-1;
		int lastIndexB = numB.length()-1;
		StringBuilder dif =  new StringBuilder(); 
		/*
		int handleNeg = 0;
		if((numA.length() - numB.length() ) < 0)
		{
			handleNeg = numB.length();
		}
		else if((numA.length() - numB.length() ) >= 0)
		{
			handleNeg = numA.length();
		}
		
		for( int j = 0; j < handleNeg; j++)
		{
			if(numA.charAt(j) < numB.charAt(j))
			{
				String storeB = numB;
				numB = numA;
				numA = storeB;
			}
			else
			bol = false; 
		}*/
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
		return dif.reverse().toString(); //Vänder och returnerar strängen som byggdes
	}
}
	
