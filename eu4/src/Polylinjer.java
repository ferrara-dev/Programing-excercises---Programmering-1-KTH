package eu4;

import java.util.Random;



public class Polylinjer 
{
public int antalPolys = 0;
	
	/*****************************************************
	 * Metod som skapar ett slumpmässigt antal polylinjer*
	 
	 * @return antalet polylinjer
	 *****************************************************/
	public int genPoly()
	{
		antalPolys = (new Random().nextInt(5)+1);
		return antalPolys;
	}
	
	/*************************************************************
	 * Metod som skapar en vektor med referenser till polylinjerna
	 * @return
	 ************************************************************/
	public Polylinje[] polyVektor()
	{
        NPolylinje[] nLinjer = new NPolylinje[genPoly()];
        VPolylinje[] vLinjer = new VPolylinje[genPoly()];
		Polylinje[] vektor = new Polylinje[nLinjer.length  + vLinjer.length];
		for(int i = 0; i < nLinjer.length; i++)
		{
			vektor[i] = vLinjer[i];
		}
		
		return vektor;
	}

	/*******************************************************************************
	 * Metod som genererar polylinjer med slupmässig färg antal punkter samt bredd *
	 * @return
	 ********************************************************************************/

	
	/*********************************************************************
	 *  Metod som genererar en slumpmässig bredd för de nya polylinjerna *
	 * @return
	 *********************************************************************/
	public int generateRandomBredd()
	{
		return (new Random().nextInt(9)+1);
	}

	/***************************************************
	 *  Metod som genererar en slumpmässig X-koordinat *
	 * @return
	 ***************************************************/
	public int randomXPos(){
		int x = (new Random().nextInt(9)+1);
		return x;
	}
	
	/***************************************************
	 *  Metod som genererar en slumpmässig Y-koordinat *
	 * @return
	 ***************************************************/
	public int randomYPos()
	{
		int y = (new Random().nextInt(9)+1);
		return y;
	}

	//Generar random namn
	//Genom att slumpa ett tal mellan 0 och 25 får man stora bokstäver
	//Slumpar även längden av texten
	public String generateRandomName()
	{
		StringBuilder sBuilder = new StringBuilder();
		int antalBokstaver = (new Random().nextInt(3)+1);
		for (int i = 0; i < antalBokstaver+1; i++){
			int charBok = (new Random().nextInt(26))+65;
			sBuilder.append((char)charBok);
		}
		String name = sBuilder.toString();
		return name;
	}
	
	/*******************************************************************************
	 *  Metod som slumpmässigt väljer om polylinjen skall  vara gul, blå eller röd *
	 * @return
	 *******************************************************************************/
	public String generateRandomFarg()
	{
		String[] farger = {"gul", "röd", "blå"};
		int i = (new Random().nextInt(3));
		String farg = farger[i];
		return farg;
	}
	
	//Slumpar antal punkter
	public Punkt[] generateRandomAntalPunkter()
	{
		int antal = (new Random().nextInt(3)+2);
		Punkt []vektor = new Punkt[antal];
		for(int i = 0; i < antal; i++){
			vektor[i] = new Punkt(generateRandomName(), randomXPos(), randomYPos());
		}
		return vektor;
	}
	
	
	//Kollar efter den kortaste gula linjen
	//Den gör enbart en jämförelse om färgen == "gul"
	public Polylinje kortastGulSamling(Polylinje[] polylinjer){
		Polylinje valdPolylinje = null;
		int j = 0;
		double kortast = 0;
		for(int i = 0; i < polylinjer.length; i++)
		{
			if(polylinjer[i].getFarg().equals("gul"))
			{
				if(j == 0)
				{
					kortast = polylinjer[i].langd();
					valdPolylinje = polylinjer[i];
					j++;
				}
				if(polylinjer[i].langd() < kortast)
				{
					kortast = polylinjer[i].langd();
					valdPolylinje = polylinjer[i];
				}
			}
		}
		return valdPolylinje;
	}
}
