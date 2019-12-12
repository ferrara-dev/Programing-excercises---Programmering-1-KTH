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
	        
	        Punkt p11 = new Punkt("A", 8, 3);
	        Punkt p22 = new Punkt("B", 9, 9);
	        Punkt p33 = new Punkt("C", 1, 19);

	        Punkt[] PunktLista1 = {p1, p2, p3};
	        Punkt[] PunktLista2 = {p11, p22, p33};
		Polylinje nLine = new NPolylinje(PunktLista1);
	        Polylinje vLine = new VPolylinje(PunktLista2);


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
	        out.println("\nITERATOR");
	        out.print("NPolyline : ");
	        for (Punkt horn : nLine)
	        {
	        	out.print(count);
	            out.print(horn);
	            count++;
	        }
	        
	        count = 1;
	        out.println();
	        out.print("VPolyline : ");
	        for (Punkt horn : vLine) 
	        {
	        	out.print(count);
	            out.print(horn);
	            count++;
	            
	        }
	        out.println("\n");
	        out.println("end.");
	        
			Polylinjer p = new Polylinjer();
			System.out.println();
			System.out.println("------------------------------------------");
			
			System.out.println("VEKTOR INNEHÅLLANDE N");
			{
			Polylinje [] poly = new Polylinje [p.getRadomAntalLinjer()];
			poly = p.getPolyVektorN();
			
			for(int i = 0; i < poly.length; i++)
			{
		
				System.out.println(poly[i].toString());
			}
			System.out.println("------------------------------------------");
			Polylinje kortastGul = Polylinjer.findShortestYellowPolyline(poly);
			double kortastLangd = 0;
			
			if(kortastGul != null)
			{
				kortastLangd = kortastGul.langd();
				System.out.println("\nKortaste gula linjen är: \n" + kortastGul +
						"\nOch har längden: " + kortastLangd + "\n");
			}
			
			}
			System.out.println("VEKTOR INNEHÅLLANDE V");
			{
			Polylinje [] poly = new Polylinje [p.getRadomAntalLinjer()];
			poly = p.getPolyVektorV();
			
			for(int i = 0; i < poly.length; i++)
			{
		
				System.out.println(poly[i].toString());
			}
			System.out.println("------------------------------------------");
			Polylinje kortastGul = Polylinjer.findShortestYellowPolyline(poly);
			double kortastLangd = 0;
			
			if(kortastGul != null)
			{
				kortastLangd = kortastGul.langd();
				System.out.println("\nKortaste gula linjen är: \n" + kortastGul +
						"\nOch har längden: " + kortastLangd + "\n");
			}
			
			}
	        System.out.println("VEKTOR INNEHÅLLANDE BÅDA SORTER");
	        {
	        
			
			System.out.println("------------------------------------------");
			
			Polylinje [] poly = new Polylinje [p.getRadomAntalLinjer()];
			poly = p.getPolyVektorVN();
			
			for(int i = 0; i < poly.length; i++)
			{
		
				System.out.println(poly[i].toString());
			}
			System.out.println("------------------------------------------");
			Polylinje kortastGul = Polylinjer.findShortestYellowPolyline(poly);
			double kortastLangd = 0;
			
			if(kortastGul != null)
			{
				kortastLangd = kortastGul.langd();
				System.out.println("\nKortaste gula linjen är: \n" + kortastGul +
						"\nOch har längden: " + kortastLangd + "\n");
			}
	        }
	    }
			
	}
