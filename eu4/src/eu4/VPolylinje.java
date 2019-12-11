package eu4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class VPolylinje implements Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	
	public VPolylinje() 
	{
		this.horn = new Punkt[0];
	}

	    /**
	     * Initialise the polyline with vertices.
	     * @param vertices
	     */
	public VPolylinje(Punkt[] horn) 
	{
		this.horn = new Punkt[horn.length];
	    for (int i = 0; i < horn.length; i++) 
	    {
	    	this.horn[i] = new Punkt(horn[i]);
	    }
	}
	
	
	@Override
	public Punkt[] getHorn() 
	{
		return horn;
	}

	@Override
	public String getFarg() 
	{
		return farg;
	}

	@Override
	public int getBredd() 
	{
		// TODO Auto-generated method stub
		return bredd;
	}

	@Override
	public double langd() 
	{
		double l = 0;
        for (int i = 0; i < this.horn.length -1 ; i++)
        l += this.horn[i].distance(this.horn[i + 1]);
        
        return l;
	}

	@Override
	public void setFarg(String farg) 
	{
		this.farg = farg;
		
	}

	@Override
	public void setBredd(int bredd) 
	{
		this.bredd = bredd;
	}

	@Override
	public void laggTill(Punkt horn) 
	{
		Punkt[] h = new Punkt[this.horn.length + 1];

		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);

		this.horn = h;
		
	}
	
	@Override
	public void laggTillFramfor(Punkt horn, String namn) 
	{
		System.out.println(horn);
		Punkt[] h = new Punkt[this.horn.length + 1];
		int keyPos = 0;
		for (int i = 0; i < this.horn.length; i++)
		{
			h[i] = this.horn[i];
			if (this.horn[i].name.equals(namn)) {
				keyPos = i + 1;
				h[keyPos] = new Punkt(horn);
				break;
			}
		}
		for(int i = keyPos + 1; i < this.horn.length + 1; i++)
			 h[i] = this.horn[i-1];

		this.horn = h;
		System.out.println(this.horn[keyPos-1] + " <-- " + this.horn[keyPos]);
		
	}

	@Override
	public void taBort(String namn) 
	{
		String [] temp = new String [horn.length];

		for(int j = 0; j < this.horn.length; j ++)
			temp [j] = this.horn[j].getNamn();

		if (!(Arrays.asList(temp).contains(namn)))
		{
			recurse(temp);
		}
			
		for(int i = 0; i < this.horn.length; i++)			   
		{
			if (this.horn[i].getNamn().equals(namn))
			{
	
				execute(namn);
			}
		}
		
	}
	
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
	
	public void recurse(String temp[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println(
				"Det existerar inget hör med ett sådant namn"
				+ ", var god skriv in någon av följande : \n"
				+ Arrays.toString(temp) 
				);
		String name = in.nextLine();
		taBort(name);
	}

	@Override
	public Iterator<Punkt> iterator() 
	{
        return new Iterator<Punkt>() 
        {
            private int pos = 0;

            public boolean hasNext() 
            {
                return horn.length > pos;
            }

            public Punkt next() 
            {
                return horn[pos++];
            }

            public void remove() 
            {
            	
            }
        };
	}

	@Override
	public String toString()
	{
		return "VPolylinje [horn=" + Arrays.toString(horn) + ", farg=" + farg + ", bredd=" + bredd + "]";
	}

	
	
}
