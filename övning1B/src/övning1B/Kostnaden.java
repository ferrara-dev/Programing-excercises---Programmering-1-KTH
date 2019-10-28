package övning1B;
import java.util.*;

public class Kostnaden {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("kostnad");
		System.out.println();
		
		// Verktyg för inmatning
		java.util.Scanner   in = new java.util.Scanner (System.in);
		
		// Inmatning av antalböcker och pris
		System.out.print ("Antalet bocker: ");
		int  antal = in.nextInt ();
		System.out.print ("Pris pa bockerna: ");
		double    pris = in.nextDouble ();
		
		// beräkning av kostnaden
		double    kostnad = antal * pris;
		
		double moms = 0.125*kostnad; // Moms på böckerna
		double totalt = moms + kostnad;
		
		// Kostnad skrivs ut
		System.out.println ("Kostnad: " + kostnad + " " + "kr" + "\r");
		System.out.println ("Moms:" + moms + " " +"kr" + "\r" );
		System.out.println ("Kostnad inklusive moms: " + totalt + " " +"kr");
	}

}
