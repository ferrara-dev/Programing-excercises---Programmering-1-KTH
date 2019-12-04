package frivilligUppgift1;

public class HittaFelet_MinstaHeltal {
		static int minVal;
	static int element[];
	static int elementA [] = {17,22,11,21,31,2,-5,3,66,10,35,9,1,99,-10,100};
	static int elementB[]  = {17,-32,11,21,31,2,-5,3,66,10,35,9,1,99,-10,-32,-33,88,55};
		
	public static void main(String[] args) 
	{
			      	printMin();
	      	System.out.println("Goodbye!");
	}
		
	
	public static void printMin()
	{
		
	  Scanner sc = new Scanner(System.in);
      System.out.println("VÄLJ SEKVENS");
     
      System.out.println(" Type \"a\" if u want an array that contains the "
      						+ "following 16 elements "
      						+ "{17,22,11,21,31,2,-5,3,66,10,35,9,1,99,-10,100 }");
      System.out.println(" Type \"b\" if u want an array that contains the "
				+ "following 19 elements "
				+ "{17,-32,11,21,31,2,-5,3,66,10,35,9,1,99,-10,-32,-33,88,55};");
      
      String choice = sc.nextLine();
      switch(choice)
      {
      	case "a":
      	{
      		element = elementA;
      		break;
      	}
      	case "b":
      	{
      		element = elementB;
      		break;
      	}
      }
	     
	    System.out.println("TEST AV URVALSSTRATEGIN");
		
		System.out.println("The minimum element is :: " + Urvalsmetoden.min(element));
		System.out.println("---------------------------------------------------------");
		System.out.println("TEST AV UPPDATERINGSSTRATEGIN");
		System.out.println("The minimum element is :: " + Uppdateringsmetoden.min(element));
		System.out.println("---------------------------------------------------------");
		System.out.println("KONTROLL ATT DE ÄR LIKA STORA");
		if(Uppdateringsmetoden.min(element)==Urvalsmetoden.min(element))
			System.out.println("Resultaten är lika !");
		
		else
			System.out.println("Något är fel, resultaten är inte lika !");
	
	}
		
	}
}
