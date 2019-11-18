package obligatoriskUppgift5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polylinje {

	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje() {
		this.horn = new Punkt[0];
	}

	public Polylinje(Punkt[] horn) {
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt(horn[i]);
	}

	public Punkt[] getHorn() {
		return horn;
	}

	public void setHorn(Punkt[] horn) {
		this.horn = horn;
	}

	public String getFarg() {
		return farg;
	}

	public void setFarg(String farg) {
		this.farg = farg;
	}

	public int getBredd() {
		return bredd;
	}

	public void setBredd(int bredd) 
	{
		this.bredd = bredd;
	}

	public double langd() 
	{
		double l = 0;
		for(int i =0; i<horn.length; i++) {
			
			for(int j = 1; j<horn.length; j++) {
				l += horn[i].distance(horn[j]);
			}
		}
		return l;
	}

	@Override
	public String toString() {
		return "Polylinje " + Arrays.toString(horn) + ", farg=" + farg + ", bredd=" + bredd + "]";
	}

	public void laggTill(Punkt horn) {

		Punkt[] h = new Punkt[this.horn.length + 1];

		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);

		this.horn = h;
	}

	public void laggTillFramfor(Punkt punkt, String hornNamn) {
		
		/*
		 *   A  B C 
		 *   
		 *   X -> B 
		 *   
		 *   
		 */
		//. I metoden getHorn ska en vektor som innehåller kopior av polylinjens hörn skapas, och en referens till denna vektor ska returneras
		List <Punkt> list = new ArrayList<Punkt>(Arrays.asList(horn));
		
		for(Punkt p: list) 
		{
			if(p.getNamn().equals(hornNamn)) 
			{
				int pos = list.lastIndexOf(p);
				list.add(pos+1, punkt);
				break;
			}
		}
		this.horn = list.toArray(new Punkt[list.size()]);
	}

	public void taBort(String hornNamn) {
	}
}
