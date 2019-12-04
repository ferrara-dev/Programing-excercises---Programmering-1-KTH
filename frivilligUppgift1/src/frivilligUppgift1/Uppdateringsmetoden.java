package frivilligUppgift1;

public class Uppdateringsmetoden 
{
	public static int min(int [] element)
	{
		int min = element [0];
		
		for(int v:element)
	 		if(v < min )
	 			min = v;	
		
		return min;
	}
}
