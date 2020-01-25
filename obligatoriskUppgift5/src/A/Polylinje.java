package A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Polylinje 
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
		//Iterator
	public class PolylinjeIterator
	{
		private int aktuell = -1;
		public PolylinjeIterator ()
		{
			if (this.horn.length > 0) aktuell = 0; 
		}
			
		public boolean finnsHorn ()
		{
				return aktuell != -1; 
		}
			
		public Punkt horn () throws java.util.NoSuchElementException
		{
			if (!this.finnsHorn ()) {
				throw new java.util.NoSuchElementException ( "slut av iterationen");
			}		
			Punkt horn = Polylinje.this.horn[aktuell];
					
			return horn; 
		}
			
		public void gaFram ()
		{
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1) 
				aktuell++;
				
			else aktuell = -1; 
		}
	}
	


	public Polylinje() 
	{
		this.horn = new Punkt[0];
	}
	
	
	
	/**********************************************************
	 * Metod för att skapa en ny polylinje med färg och bredd *
	 * @param horn
	 * @param farg
	 * @param bredd
	 **********************************************************/
	public Polylinje(Punkt[] horn,String farg, int bredd) 
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt(horn[i]);
		this.farg = farg;
		this.bredd = bredd;
	}
	
	
	
	/****************************************************************************
	 * Metod för att returnera en vektor med punkter vilka ingår i en polylinje *
	 * @return vektor med punkter
	 ****************************************************************************/
	public Punkt[] getHorn() 
	{
		return horn;
	}
   
	
	
	/*********************************
     * Skapar en ny vektor med punkter
     * @param horn
     ********************************/
	public void setHorn(Punkt[] horn) 
	{
		this.horn = horn;
	}
	
	
	
	/********************************************
	 * Metod för att returnera polylinjens färg *
	 * @return polylinjens färg
	 *********************************************/
	public String getFarg() 
	{
		return farg;
	}

	
	
	/*****************************************************
	 * Metod för att ändra polylinjens färg från default *
	 * @param farg
	 *****************************************************/
	public void setFarg(String farg) 
	{
		this.farg = farg;
	}
	
	
	
	/******************************************
	 * Metod som returnerar polylinjens bredd *
	 * @return polylinjens bredd
	 ******************************************/
	public int getBredd() 
	{
		return bredd;
	}
	
	
	
	/*************************************************************
	 * Metod för att ändra polylinjens bredd från default värdet *
	 * @param bredd
	 *************************************************************/
	public void setBredd(int bredd) 
	{
		this.bredd = bredd;
	}

	
	
	/***********************************************************
	 * Metod som beräknar och returnerar polylinjens längd 
	   genom att addera avståndet mellan samtliga punkter.
					    +---------------------+
					    |   [A]----[B]	  |
					    |             \       |
					    | 	           \	  |
					    |		    [C]   |
					    |			  |
					    | dist = AB + BC      |
					    |			  |
					    +---------------------+
	**************************************************************/
	public double langd() 
	{
		double l = 0;
        for (int i = 0; i < this.horn.length -1 ; i++)
            l += this.horn[i].distance(this.horn[i + 1]);
        return l;
	}
	
	
	
	@Override
	public String toString() 
	{
		return "Polylinje " + Arrays.toString(horn) + ", farg=" + farg + ", bredd=" + bredd + "]";
	}
	
	
	
	/************************************************************************
	 * Metod för att lägga till ett nytt hörn på sista platsen i polylinjen *
					    +---------------------------+
					    |(1)   [A]---[B]            |
					    |               \		|
					    |	             \	        |
					    |		      [C]       |
					    |	   			|
					    |(2)	C -> X          |
					    |      			|
					    | 	   [A]---[B]            |
					    |               \		|
					    |		     \		|
					    |		      \         |
					    |			[C]--[X]|
					    +---------------------------+
	**************************************************************************/
	public void laggTill(Punkt horn) 
	{
		Punkt[] h = new Punkt[this.horn.length + 1];

		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);

		this.horn = h;
	}
	
	
	
	/*************************************************************************************
	 * Metod för att lägga till ett nytt hörn framför något befintligt hörn i polylinjen *
					    +------------------------------+
					    |(1)   [A]-------[B]           |
					    |                   \          |
					    |			 \	   |
					    |			  [C]      |
					    |	   			   |
					    |(2)	A -> X   	   |
					    |         			   |
					    |		        	   | 
					    |(3) [A]       [B]             |
					    |       \     /   \            |
					    |	     \   /     \	   |
					    |	      [X]       [C]        |	
					    +------------------------------+
	* @param horn (Det nya hörnet)
	* @param namn (Namnet på det hörn som den nya punkten ska placeras framför)
	**************************************************************************************/
	public void laggTillFramfor(Punkt horn, String namn) 
	{	
		System.out.println(horn);
		Punkt[] h = new Punkt[this.horn.length + 1];
		int keyPos = 0;
		for (int i = 0; i < this.horn.length; i++)
		{
			h[i] = this.horn[i];
				if(this.horn[i].name.equals(namn))
				{
					keyPos = i+1;
					h[keyPos] = horn;
					break;
				}
		}
		for(int i = keyPos + 1; i < this.horn.length + 1; i++){
			 h[i] = this.horn[i-1];
		 }

		this.horn = h;
		System.out.println(this.horn[keyPos-1] + " <-- " + this.horn[keyPos]);
	}
	
	
	
	/*****************************************************
	 * Metod för att ta bort någon punkt från polylinjen *
	 * 		+------------------------------+
			|(1)   [A]-------[B]           |
			|                   \          |
			|		     \	       |
			|		      [C]      |
			|	   		       |
			|(2)   Remove [C]   	       |
			|         		       |
			|		               | 
			|(3)    [A]-------[B]          |
			+------------------------------+
	 * Metoden är recursiv, om användaren anger ett ett
	   namn som inte finns med i polylinjen anropas en 
	   hjälpfunktionen "recurse(String names[])
	 * @param namn (Namnet på det hörn som ska tas bort)
	 ******************************************************/
	public void taBort(String namn) 
	{
		String [] names = new String [horn.length];

		for(int j = 0; j < this.horn.length; j ++)
			names [j] = this.horn[j].getNamn();

		if (!(Arrays.asList(names).contains(namn)))
		{
			// anropar hjälp metod om det inte finns något hörn med angivet namn på polylinjen
			recurse(names);
		}
			
		for(int i = 0; i < this.horn.length; i++)			   
		{
			if (this.horn[i].getNamn().equals(namn))
			{
				// anropar hjälp metod om det finns något hörn med angivet namn på polylinjen
				execute(namn);
			}
		}
	}
	
	
	
	/*******************************************
	 	* Hjälp metod till "taBort()" *    
	 - utför bortagningen av det angivna hörnet
	   om det finns på polylinjen
	 * @param namn
	 *******************************************/
	public void execute(String namn)
	{
		Punkt [] h = new Punkt[horn.length-1];
		int indexHorn = 0;
		int indexH = 0;

		while(indexHorn < this.horn.length && indexH < this.horn.length-1)
		{
			if(this.horn[indexHorn].getNamn().equals(namn)) 
			{
				indexHorn++;
			}
			else
			{
				h[indexH] = horn[indexHorn];
				indexHorn ++;
				indexH ++;
			}
		}
		this.horn = h;
	}
	
	
	
	/*****************************************************
	 	    *  Hjälp metod till "taBort()" *
	 -  Låter användaren skriva in ett nytt namn i fallet 
	    att polylinjen inte innehåller det namn som angavs 
	    först
	 * @param temp
	 *****************************************************/
	public void recurse(String names[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println(
				"Det existerar inget hörn med ett sådant namn"
				+ ", var god skriv in någon av följande : \n"
				+ Arrays.toString(names) 
				);
		String name = in.nextLine();
		taBort(name);
	}
	
	
	
	public double polyArea()
	{
		return getBredd()*langd();
	}
}
 
