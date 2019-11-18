package A;

import java.io.*; // PrintWriter
public class punktTest 
{
	{	
	static int x;
	static int y;
	static String name;
	static Scanner in = new Scanner(System.in);
	static PrintWriter out = new PrintWriter (System.out, true);
	public static void main (String[] args)
	 {
			
		 Scanner in = new Scanner(System.in);
		 PrintWriter out = new PrintWriter (System.out, true);
		 // testa en konstruktor och en transformator
		// Sätt namn och koordinater för den andra punkten
		 Punkt p1 = new Punkt ("", x, y);
		 out.println("Set coordinates and name for the first point");
		 out.println("Set X : ");
		 p1.setX (in.nextInt());
		 x = p1.getX();
		 out.println("Set Y : ");
		 p1.setY (in.nextInt());
		 in.nextLine();
		 out.println("Set Name : ");
		 p1.setNamn (in.nextLine());
		 name = p1.getNamn();
		 out.println(p1);
		 // Skapa en ny punkt och sätt namn och koordinater för den andra punkten
		 Punkt p2 = new Punkt ("", x, y);
		 out.println("Set coordinates and name for the second point");
		 out.println("Set X : ");
		 p2.setX (in.nextInt());
		 x = p2.getX();
		 out.println("Set Y : ");
		 p2.setY (in.nextInt());
		 in.nextLine();
		 out.println("Set Name : ");
		 p2.setNamn (in.nextLine());
		 name = p2.getNamn();
		 out.println(p2);
		 out.println("Existing points are : " + p1 + p2);
		 
		 // testa en konstruktor till
		 Punkt p = new Punkt (p1);
		 out.println (p);
		 
		 // Ta fram anvståndet mellan två punkter
		 double d = p1.distance (p2);
		 out.println ("The distance between"
		 		+ "" + p1 + " and "
		 		+ "" + p2 + " is : "
		 		+ d
		 		+ " length units"
		 		);
		 

		 /*
		 // testa inspektorer
		 p1.setNamn (in.nextLine());
		 p1.setX (in.nextInt());
		 p1.setY (in.nextInt());
		 name = p1.getNamn();
		 x = p1.getX();
		 y = p1.getY();
		 out.println (p1 + " " + p2);
		 //out.println (n + " " + x + " " + y);
		 // testa en kombinator och en komparator
		 double d = p1.distance (p2);
		 out.println (d);
		 boolean b = p1.equals (p2);
		 out.println (b);
		 // testa mutatorer
		 p2.setX (in.nextInt());
		 p2.setY (in.nextInt());
		 p2.setNamn(in.nextLine());
		 out.println (p2);
		 // testa en konstruktor till
		 Punkt p = new Punkt (p1);
		 out.println (p); */

}

