package eu4;

import java.io.PrintWriter;
import java.util.Iterator;

public class PolyLineTest 
{
	public static void main(String[] args) 
	{
		PrintWriter out = new PrintWriter(System.out, true);

	        // init
	        Punkt p1 = new Punkt("A", 3, 4);
	        Punkt p2 = new Punkt("B", 5, 6);
	        Punkt p3 = new Punkt("C", 1, 7);

	        Punkt[] PunktLista = {p1, p2, p3};
	        NPolylinje nLine = new NPolylinje(PunktLista);
	        VPolylinje vLine = new VPolylinje(PunktLista);

	        Punkt p4 = new Punkt("X", 4, 1);
	        Punkt p5 = new Punkt("Y", 3, 2);
	        Punkt p6 = new Punkt("Z", 1, 3);

	        out.println("Init");
	        out.println(nLine);
	        out.println(vLine);

	        // add point
	        nLine.laggTill(p4);
	        vLine.laggTill(p4);

	        out.println("\nPoint 'X' added");
	        out.println(nLine);
	        out.println(vLine);

	        // insert before
	        nLine.laggTillFramfor(p5, "C");
	        vLine.laggTillFramfor(p5, "C");

	        out.println("\nPoint 'Y' inserted before 'C'");
	        out.println(nLine);
	        out.println(vLine);

	        // remove
	        nLine.taBort("C");
	        vLine.taBort("C");

	        out.println("\nRemove 'C'");
	        out.println(nLine);
	        out.println(vLine);

	        // iterator
	        int count = 1;
	        out.println("\nIterator");
	        for (Punkt horn : nLine)
	        {
	        	out.print(count);
	            out.print(horn);
	            count++;
	        }
	        count = 1;
	        out.println();

	        for (Punkt horn : vLine) 
	        {
	        	out.print(count);
	            out.print(horn);
	            count++;
	            
	        }
	        out.println("\n");
	        out.println("end.");

	    }
	}


