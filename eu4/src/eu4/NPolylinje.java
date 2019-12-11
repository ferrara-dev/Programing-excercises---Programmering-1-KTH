package eu4;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NPolylinje implements Polylinje
{
	private static class Nod
	{
		public Punkt horn;
		public Nod nastaNod;
		
		public Nod (Punkt horn)
		{
			this.horn = horn;
			nastaNod = null;
		}
	}
	
	private Nod horn;
	private String farg = "svart";
	private int bredd = 1;
	
	public NPolylinje()
	{
		this.horn = null;
	}
	
	public NPolylinje (Punkt[] horn)
	{
		if (horn.length > 0)
		{
			Nod nod = new Nod (new Punkt (horn[0]));
			this.horn = nod;
			int pos = 1;
			
			while (pos < horn.length)
			{
				nod.nastaNod = new Nod (new Punkt (horn[pos++]));
				nod = nod.nastaNod;
			}
		}
	}

	@Override
	public Punkt[] getHorn() 
	{
		return new Punkt[0];
	}

	@Override
	public String getFarg() 
	{
		return this.farg;
	}

	@Override
	public int getBredd() 
	{
		return this.bredd;
	}

	@Override
	public double langd() 
	{
		double l = 0;
		Nod aktuell = horn;
		while(aktuell.nastaNod!=null)
		{
			l += aktuell.horn.distance(aktuell.nastaNod.horn);
			aktuell = aktuell.nastaNod;
		}
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

        Nod aktuell = this.horn;
		while(aktuell.nastaNod != null)
		{
			aktuell = aktuell.nastaNod;
		}
		
		Nod n = new Nod (new Punkt(horn));
		aktuell.nastaNod = n;
	}
	
	
	

	@Override
	public void laggTillFramfor(Punkt horn, String namn) 
	{
		Nod aktuell = this.horn;
		while (aktuell.nastaNod != null && aktuell.nastaNod.horn.getNamn() != namn) 
		{
			aktuell = aktuell.nastaNod;
		}
		
	    Nod temp = aktuell.nastaNod;
	    aktuell.nastaNod = new Nod(horn);
	    aktuell.nastaNod.nastaNod = temp;
		
	}

	@Override
	public void taBort(String namn) 
	{
	      Iterator<Punkt> iterator = iterator();
	      Punkt aktuell = iterator.next();
	      while (aktuell.getNamn() != namn) 
	      {
	            aktuell = iterator.next();
	      }

	        iterator.remove();
		
	}

	@Override
	public String toString() 
	{
	    String output = "[";
        Nod aktuell = horn;
        while (aktuell.nastaNod != null) 
        {
            output += aktuell.horn + ", ";
            aktuell = aktuell.nastaNod;
        }

        return "NPolylinje " + output + aktuell.horn + "], " + "farg=" + this.farg + ", " + "bredd=" + this.bredd + "]";
	}


	@Override
	public Iterator<Punkt> iterator() 
	{
		return new Iterator<Punkt>() {
        private Nod prePrevious = null;
        private Nod previous = null;
        private Nod aktuell = horn;

        public boolean hasNext() {
            return aktuell != null;
        }

        public Punkt next() 
        {
            if (!hasNext()) 
            {
                throw new NoSuchElementException("Reached the end.");
            }

            prePrevious = previous;
            previous = aktuell;
            aktuell = aktuell.nastaNod != null ? aktuell.nastaNod : null;
            return previous.horn;
        }

        public void remove() 
        {
            prePrevious.nastaNod = aktuell;
        }
    };
	}
	
}
