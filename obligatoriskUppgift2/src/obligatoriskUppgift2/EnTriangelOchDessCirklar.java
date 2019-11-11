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
    private static final String EXIT_PROGRAM = "Exit program";
	private static final String CALCULATE_ANGLE = "Calculate angle";
	private static final String CALCULATE_MEDIANS = "Calculate medians";
	private static final String CALCULATE_AREA = "Calculate area";
	private static final String CALCULATE_PERIMETER = "Calculate perimeter";
	
	// Triangelobjektet
	private static TriangleObject triangleObj;
	static Scanner in = new Scanner(System.in);
	// Vertex coordinates for triangle corners
	public static double x1;
	public static double y1;
	public static double x2;
	public static double y2;
	public static double x3;
	public static double y3;
	public static double xCoG;
	public static double yCoG;
	public static Point2D A;
	public static Point2D B;
	public static Point2D C; 
	public static Point2D CoG;
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
				 choice[0]);
		
		if(input1 == null)
			return;
		// Initial choice
		if(input1.contentEquals("Length of three sides"))
		{
			set3sides(); 
			while(run)
			{
				 String[] choices = 
				 { CALCULATE_PERIMETER, 
				   CALCULATE_AREA, 
				   "Calculate vertex coordinates", 
				   CALCULATE_MEDIANS, 
				   CALCULATE_ANGLE,
				   "Inner Radius",
				   "Circum Radius",
				   EXIT_PROGRAM 
				 };
				 String input = (String) JOptionPane.showInputDialog
				 (null, "Choose now...",
				  "The Choice of a Lifetime",
				  JOptionPane.QUESTION_MESSAGE,
				  null,
			       	  choices, // Array of choices
			       	  choices[0] // Initial choice
				 ); 
				
				if(input == null)
					return;
				
				if(input.contentEquals(EXIT_PROGRAM))
					run = false;
				
				if(input.contentEquals("Inner Radius"))
					innerRadius();
					
				if(input.contentEquals("Circum Radius"))
					circumRadius();
				
				if(input.contentEquals(CALCULATE_PERIMETER))
					perimeter();
				
				if(input.contentEquals(CALCULATE_AREA))
					area();
				
				if(input.contentEquals("Calculate vertex coordinates"))
					vertexCoordinates()
				
				if(input.contentEquals(CALCULATE_MEDIANS))
					medians();
				
				if(input.contentEquals("Calculate center of gravity"))
				{
					calcCoG();
					Point2D CoG = new Point2D.Double(xCoG, yCoG);
					System.out.println(CoG);
				}
			}
		}

	/*************************************************************
	 		* Set triangle parameters *
	 	- Set all of the triangle sides from user input
	 	- calculates the vertex coordinates 
	 *************************************************************/
	public static void set3sides()
	{
	    try
	    {
		System.out.println("Please choose length of side a");
		double a = in.nextDouble();
		System.out.println("Please choose length of side b");
		double b = in.nextDouble();
		System.out.println(b);
		System.out.println("Please choose length of side C");
		double c = in.nextDouble();
		System.out.println(c);
		// Triangel objektet som defineras av sidorna a,b,c instansieras
		triangleObj = new TriangleObject(a, b, c);

	
		if((triangleObj.getSideA()+triangleObj.getSideB())<=triangleObj.getSideC() || (triangleObj.getSideA()+triangleObj.getSideC())<=triangleObj.getSideB() || (triangleObj.getSideB()+triangleObj.getSideC())<=triangleObj.getSideA())
		{
			System.out.println("The triangle does not exist, remember that the parameters must "
		        + "meet the following requierments to form a triangle");
			System.out.println("(A+B)>C & (A+C)>B & (B+C)>A");
			set3sides();
	      }
	    }
	   catch (Exception e) 
	   {
			System.out.println("That is not a number, please try again:");
			in.nextLine();
			set3sides();
	    }
	}

	/*************************************************************
			*Print out vertex coordinates*
	  Calls static method "getCoordinates()" from class triangle
	 *************************************************************/
	static void vertexCoordinates()
	{	
		System.out.println("The triangle vertex coordinates are : ");
		System.out.println("Point A : "  + TriangleObject. getCoordinates(triangleObj,Point.AA));
		System.out.println("Point B : " + TriangleObject. getCoordinates(triangleObj,Point.BB));
		System.out.println("Point C : " + TriangleObject. getCoordinates(triangleObj,Point.CC));
	}
	/**********************************************************
		   * print out the triangle perimeter  *
	 Calls static method "getPerimeter()" from class Triangle 

	 **********************************************************/
	static void perimeter()
	{
		System.out.println("The triangle perimeter is " + TriangleObject.getPerimeter(triangleObj));
	}
	
	/************************************************************
	 		 * print out the triangle area *
		Calls static method "getArea()" from class Triangle
	 *************************************************************/
	static void area()
	{
		//Parameters.getArea();
		System.out.println("The triangle area " + TriangleObject.getArea(triangleObj));
		/*double s =  (a1+b1+c1) / 2;
		area = sqrt(s*(s-a1)*(s-b1)*(s-c1));
		return area;*/
	}
	/********************************************************************************************
				* print out triangle medians *
	  	calls static method "medians"  that calculate triangle medians  in class TriangleObj
			
	 ********************************************************************************************/
	static void medians()
	{
		System.out.println("Median A : " + TriangleObject.getMedian(triangleObj,Side.A));
		System.out.println("Median B : " + TriangleObject.getMedian(triangleObj,Side.B));
		System.out.println("Median C : " + TriangleObject.getMedian(triangleObj,Side.C));
	}
	
	static Point2D calcCoG()
	{
		xCoG = (x1+x2+x3)/2;
		yCoG = (y1+y2+y3)/2;
		return CoG;
	}
	
	public static void circumRadius()
	{
		System.out.println("Circum radius is : " + TriangleObject.getCircumRadius(triangleObj));
	}
		
	public static void innerRadius()
	{
		System.out.println("Inner radius is : " + TriangleObject.getInnerRadius(triangleObj));
	}

}

 
