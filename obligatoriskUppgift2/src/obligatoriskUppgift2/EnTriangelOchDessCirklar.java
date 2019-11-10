/***********************************************************************************************************************
                                          *** UPPGIFTS BESKRIVNING ***
Ett program EnTriangelOchDessCirklar ska skapas: programmet ska mata in längderna av en triangels sidor, och bestämma 
radien av den cirkel som är omskriven kring triangeln, samt radien av den cirkel som är inskriven i triangeln. För dessa 
beräkningar ska passande metoder i klassen Triangel användas: man ska anropa den metod som bestämmer radien för den 
omskrivna cirkeln och den metod som bestämmer radien för den inskrivna cirkeln.
************************************************************************************************************************/



package obligatorisk2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import static java.lang.Math.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.*;

public class EnTriangelOchDessCirklar
{
  // triangle sides  
	public static double a1;
	public static double b1;
	public static double c1;
	static Scanner in = new Scanner(System.in);

	public static Triangle a = new Triangle();
	public static Triangle b = new Triangle();
	public static Triangle c = new Triangle();

  // Vertex coordinates for triangle corners
	static double x1;
	static double y1;
	static double x2;
  static double y2;
	static double x3;
	static double y3;
	static double xCoG;
	static double yCoG;
	static Point2D A;
	static Point2D B;
	static Point2D C; 
	static Point2D CoG;
  
	public static boolean run;

	public static void main(String[] args) 
	{
	  run = true;
		triangle();	
	}
	
	
	static void triangle()
	{	
		String[] choice = 
				{ "Length of three sides",
				  "Length of two sides",

				  "coordinates","Exit Program" };
		String input1 = 
				(String) JOptionPane.showInputDialog(null, 
				 "Choose now...",
				 "Wich parameters are know?", 
				 JOptionPane.QUESTION_MESSAGE, null,
				 choice, // Array of choices
				 choice[0]); // Initial choice
		if(input1.contentEquals("Length of three sides"))
		{
			set3sides(); 
			while(run)
			{
				 String[] choices = 
				 { "Calculate circumcission", 
				   "Calculate area", 
				   "Calculate vertex coordinates", 
				   "Calculate medians", 
				   "Calculate angels",
           "Calculate Circles",
				   "Exit program" };
				 String input = 
					(String) JOptionPane.showInputDialog
					(null, "Choose now...",
				    "The Choice of a Lifetime",
				    JOptionPane.QUESTION_MESSAGE,
				    null,
			        choices, // Array of choices
			        choices[1]); // Initial choice
				

				if(input.contentEquals("Exit program"))
					run = false;
				if(input.contentEquals("Calculate perimeter"))
				{
					perimeter();
				}
				
				if(input.contentEquals("Calculate area"))
				{
					area();
				}
				if(input.contentEquals("Calculate Circles"))
				{
				calculateCircumAndInnerRadius();
				}
        
				if(input.contentEquals("Calculate vertex coordinates"))
				{
				//	calcVert(area);
					//System.out.println(calcVert(co));
				}
				
				if(input.contentEquals("Calculate medians"))
				{
					medians();
				}
				
				if(input.contentEquals("Calculate center of gravity"))
				{
					calcCoG();
					Point2D CoG = new Point2D.Double(xCoG, yCoG);
					System.out.println(CoG);
				}
				
				
			}
		}
			   
		
		//if(input1.contentEquals("Length of two sides"))
			//	set2sides();
		
		//if(input1.contentEquals("coordinates"))
			//	setCoordinates();

	}
	
	/*************************************************************
				/*** Set triangle parameters ***\
		- Sets the coordinates of the triangle from userinput
		- calculates the sides
	 *************************************************************/
	/* static double setCoordinates()
	  {
	  
	  }
	  
	 */
	
	/*************************************************************
	  			/*** Set triangle parameters ***\
		- Sets two of the triangle sides from user input
		- calculates the third side
	 *************************************************************/
	/*static double set2sides()
	{
		
	}*/
	
	/*************************************************************
	 			    * Set triangle parameters *
	 		- Sets all of the triangle sides from user input
	 		- calculates the vertex coordinates 
	 *************************************************************/
	public static double set3sides()
	{
		double r = 0;
	    try
	    {
	    System.out.println("Please choose length of side a");
		a.setSideA(in.nextDouble());
		a1 = a.getSideA();
		System.out.println("Please choose length of side b");
		b.setSideB(in.nextDouble());
		b1 = b.getSideB();
		System.out.println(b1);
		
		System.out.println("Please choose length of side C");
		c.setSideC(in.nextDouble());
		c1 = c.getSideC();
		System.out.println(c1);
		
		
		calcCoordinates();
		Point2D A = new Point2D.Double(x1, y1);
		Point2D B = new Point2D.Double(x2, y2);
		Point2D C = new Point2D.Double(x3, y3);
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println ("Point A" +  "("+0+"; "+0+")");
		System.out.println ("Point B" +  "("+b1+"; "+0+")");
		System.out.printf("(%.2f ; %.4f)\n", x3,y3);

		if((a1+b1)<=c1 || (a1+c1)<=b1 || (b1+c1)<=a1)
		{
			System.out.println("The triangle does not exist, remember that the parameters must "
	        + "meet the following requierments to form a triangle");
			System.out.println("(A+B)>C & (A+C)>B & (B+C)>A");
			r = set3sides();
		}
	    }
		catch (Exception e) 
	    {
			System.out.println("That is not a number, please try again:");
			in.nextLine();
			r = set3sides();
		}
	    return r;
	}

	/********************************************
			* Calculate vertex coordinates*
		Corner A is set to the vertex point (0,0) 
		Corner B is set to be located at the x-axis

	 ********************************************/
	static void calcCoordinates()
	{	
		x1 = 0;
		y1 = 0;
		x2 = b1;
		y2 = 0;
		double a1Square = Math.pow(a1, 2);
		double b2 = 2 * b1;
		x3 = (a1Square)/(b2);
		double xSquare = Math.pow(x3, 2);
		y3 = sqrt(a1Square - xSquare);
	}
	/**********************************************************
				* print out the triangle perimeter  *
	 Calls static method "getPerimeter()" from class Parameters 

	 **********************************************************/
	static void perimeter()
	{
		System.out.println("The triangle perimeter is " + Triangle.getPerimeter());
	}
	
	/**********************************************************
	 			 * print out the triangle area *
		Calls static method "getArea()" from class Parameters
	 **********************************************************/
	static void area()
	{
		//Parameters.getArea();
		System.out.println("The triangle area " + Triangle.getArea());
		/*double s =  (a1+b1+c1) / 2;
		area = sqrt(s*(s-a1)*(s-b1)*(s-c1));
		return area;*/
	}
	/*************************************************************************
	  				     * print out triangle medians *
	  	calls methods in class Parameters that calculate triangle medians 
			
	 *************************************************************************/
	static void medians()
	{
		System.out.println("Median A : " + Triangle.getMedianA());
		System.out.println("Median B : " + Triangle.getMedianB());
		System.out.println("Median C : " + Triangle.getMedianC());
		//calcMedianA();
		//calcMedianB();
		//calcMedianC();
		//calcCoG();
	}
	
	static Point2D calcCoG()
	{
		xCoG = (x1+x2+x3)/2;
		yCoG = (y1+y2+y3)/2;
		return CoG;
	
	}
	
	public static void calculateCircumAndInnerRadius()
	{
		double semi = Triangle.getSemiperimeter();
		double ar = Triangle.getArea();
		double r = ar/semi;
		System.out.println(r);
		a1 = a.getSideA();
		b1 = b.getSideB();
		c1 = c.getSideC();
		double j = (a1*b1*c1);
		double R = j /(4*r*semi);
		System.out.println("The Circumradius is : " + R);
    //System.out.println("The cirumcirkel circumsision is : " + 
    System.out.println("The inneradius is : " + r);
		
		System.out.println(R);
	}
	
	/*
	static double calcMedianA()
	{
		double aSquare = Math.pow(a1, 2);
		double bSquare = Math.pow(b1, 2);
		double cSquare = Math.pow(c1, 2);
		double medA = sqrt(2 * cSquare + 2 * bSquare - aSquare)/2;
		mediA = medA;
		return medianA;
	}
	
	static double calcMedianB()
	{
		double aSquare = Math.pow(a1, 2);
		double bSquare = Math.pow(b1, 2);
		double cSquare = Math.pow(c1, 2);
		double medB = sqrt(2 * aSquare + 2 * cSquare - bSquare)/2;
		medianB = medB;
		return medianB;
		
	}
	
	static double calcMedianC()
	{
		double aSquare = Math.pow(a1, 2);
		double bSquare = Math.pow(b1, 2);
		double cSquare = Math.pow(c1, 2);
		double medC = sqrt(2 * aSquare + 2 * bSquare - cSquare)/2;
		medianC = medC;
		return medianC;
		
	}
	
	static Point2D calcCoG()
	{
		xCoG = (x1+x2+x3)/2;
		yCoG = (y1+y2+y3)/2;
		return CoG;
	}*/
}

 
