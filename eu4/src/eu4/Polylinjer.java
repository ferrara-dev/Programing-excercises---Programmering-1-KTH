package eu4;

import java.util.Arrays;
import java.util.Random;


public class Polylinjer 
{

	
	@Override
	public String toString() {
		return "Slumpmässig polylinje = [" + getPolyVektorVN() + "]";
	}
	public int antalLinjer = 0;

	/************************************************************************
	 * Metod som generar en slumpmässig storlek på en vektor med polylinjer *
	 * 
	 * @return
	 *************************************************************************/
	public int getRadomAntalLinjer() 
	{
		antalLinjer = (new Random().nextInt(9) + 1);
		return antalLinjer;
	}

	public Polylinje[] getPolyVektorV() 
	{
		Polylinje[] vektor = new Polylinje[antalLinjer];

		for (int i = 0; i < antalLinjer; i++) 
		{
			vektor[i] = getRandomVPoly();
		}
		return vektor;
	}
	
	public Polylinje[] getPolyVektorN() 
	{
		Polylinje[] vektor = new Polylinje[antalLinjer];

		for (int i = 0; i < antalLinjer; i++) 
		{
			vektor[i] = getRandomNPoly();
		}
		return vektor;
	}
	
	/*********************************************
	 * Metod som skapar en vektor med polylinjer *
	 * 
	 * @return
	 **********************************************/
	public Polylinje[] getPolyVektorVN() 
	{
		Polylinje[] vektor = new Polylinje[antalLinjer];
		for (int i = 0; i < antalLinjer/2; i++) 
		{
			vektor[i] = getRandomNPoly();
		}
		
		for (int i = antalLinjer/2; i < antalLinjer; i++) 
		{
			vektor[i] = getRandomVPoly();
		}
		return vektor;
	}

	/***************************************************************
	 * Metod som returnerar ett slumpmässigt antal polylinjer * +
	 * ---------------------------------------------------------+ | De polylinjer
	 * som returneras har även slumpmässig: | | - Bredd | | - Färg | | - Antal hörn
	 * samt position och namn för dessa |
	 * +----------------------------------------------------------+
	 * 
	 * @return
	 ***************************************************************/
	public Polylinje getRandomNPoly() 
	{
		NPolylinje linje = new NPolylinje();
		linje = new NPolylinje(getRandomPunkter());
		linje.setFarg(getRandomFarg());
		return linje;
	}
	
	public Polylinje getRandomVPoly() 
	{
		VPolylinje linje = new VPolylinje();
		linje = new VPolylinje(getRandomPunkter());
		linje.setFarg(getRandomFarg());
		return linje;
	}

	/***************************************************
	 * Metod som returnerar en slumpmässig X-koordinat *
	 * 
	 * @return
	 ***************************************************/
	public int getRandomX() 
	{
		int x = (new Random().nextInt(9) + 1);
		return x;
	}

	/***************************************************
	 * Metod som returnerar en slumpmässig Y-koordinat *
	 * 
	 * @return
	 ***************************************************/
	public int getRandomY() 
	{
		int y = (new Random().nextInt(9) + 1);
		return y;
	}

	/****************************************************************
	 * Metod som returnerar ett slumpmässigt valt namn för en punkt * - Slumpar
	 * längden av texten - slumpa ett tal mellan 0 och 25 för att få stora bokstäver
	 * 
	 * @return
	 *****************************************************************/
	public String getRandomNamn() 
	{
		StringBuilder sBuilder = new StringBuilder();
		int antalBokstaver = (new Random().nextInt(3) + 1);
		for (int i = 0; i < antalBokstaver + 1; i++) {
			int charBok = (new Random().nextInt(26)) + 65;
			sBuilder.append((char) charBok);
		}
		String name = sBuilder.toString();
		return name;
	}

	/*********************************************************************
	 * Metod som slumpmässigt returnerar någon av färgerna blå,röd och gul
	 * 
	 * @return
	 **********************************************************************/
	public String getRandomFarg() 
	{
		String[] farger = { "blå", "röd", "gul" };
		int i = (new Random().nextInt(3));
		String farg = farger[i];
		return farg;
	}

	/*****************************************************
	 * Metod som returnerar ett slumpmässigt antal punkter
	 * 
	 * @return
	 *****************************************************/
	public Punkt[] getRandomPunkter() {
		int antalPunkter = (new Random().nextInt(4) + 2);
		Punkt[] vektor = new Punkt[antalPunkter];
		for (int i = 0; i < antalPunkter; i++) {
			vektor[i] = new Punkt(getRandomNamn(), getRandomX(), getRandomY());
			if (i > 1 && vektor[i].getNamn().equals(vektor[i - 1].getNamn()))
				vektor[i].setNamn(getRandomNamn());
		}
		return vektor;
	}

	public Polylinje kortastGul(Polylinje[] polylinjer)

	{
		Polylinje aktuell = null;
		int j = 0;
		double kortast = 0;

		if (check(polylinjer) == true) 
		{
			for (int i = 1; i < polylinjer.length; i++) 
			{
				if (polylinjer[i].getFarg().equals("gul")) 
				{
					if (j == 0) 
					{
						kortast = polylinjer[i].langd();
						aktuell = polylinjer[i];
						j++;
					}

					if (polylinjer[i].langd() < kortast) 
					{
						kortast = polylinjer[i].langd();
						aktuell = polylinjer[i];
					}
				}
			}
		}
		
		return aktuell;
	}

	private static boolean check(Polylinje[] polylinjer) 
	{
		String[] temp = new String[polylinjer.length];
		for (int k = 0; k < polylinjer.length; k++)
			temp[k] = polylinjer[k].getFarg();

		if (!(Arrays.asList(temp).contains("gul"))) {
			System.out.println("Error : det finns ingen gul polylinje i samlingen");
			return false;
		}

		return true;
	}
	
	public static Polylinje findShortestYellowPolyline(Polylinje [] linjer)
	{
		Polylinje aktuell = null;
		int j = 0;
		double kortast = 0;

		if (check(linjer) == true) 
		{
			for (int i = 1; i < linjer.length; i++) 
			{
				if (linjer[i].getFarg().equals("gul")) 
				{
					if (j == 0) 
					{
						kortast = linjer[i].langd();
						aktuell = linjer[i];
						j++;
					}

					if (linjer[i].langd() < kortast) 
					{
						kortast = linjer[i].langd();
						aktuell = linjer[i];
					}
				}
			}
		}
		return aktuell;
	}
}

