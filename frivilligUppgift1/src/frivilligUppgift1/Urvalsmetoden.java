package frivilligUppgift1;

public class Urvalsmetoden 
{
	// min returnerar det minsta elementet i en sekventiell samling.
	// Om samlingen �r tom, kastas ett undantag av typen IllegalArgumentException.
	public static int min (int[] element) throws IllegalArgumentException
	{
	if (element.length == 0)
	throw new IllegalArgumentException ("tom samling");
	// h�r ihop med sp�rutskriften 2:
	// int antalVarv = 1;
	int[] sekvens = element;
	int antaletPar = sekvens.length / 2;
	int antaletOparadeElement = sekvens.length % 2;
	int antaletTankbaraElement = antaletPar + antaletOparadeElement;
	int[] delsekvens = new int[antaletTankbaraElement];
	int i = 0;
	int j = 0;
	
	/*****************************************
	(1)elementen i vektorn "sekvens" s�ks 
	   igenom varp� de minsta kopieras till
	   vektorn "delsekvens".
	   
	(2)Vid starten av loopen reserveras ny plats 
	   i minnet f�r vektorn "delsekvens, 
	   vilket �r n�dv�ndigt sekvens efter varje
	   varv beh�ver krympa om loopen inter ska
	   forts�tta i o�ndlighet.
	 *****************************************/
	while (antaletPar > 0)
	{
		i = 0;
		j = 0;
			while (j < antaletPar)
				{
					delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i]: sekvens[i + 1];
					System.out.println(sekvens[i]);
					
					i += 2;
				}
		if (antaletOparadeElement == 1)
		delsekvens[j] = sekvens[antaletPar*2];
		
		sekvens = delsekvens;
		antaletPar = antaletTankbaraElement / 2;
		antaletOparadeElement = antaletTankbaraElement % 2;
		antaletTankbaraElement = antaletPar + antaletOparadeElement;
	}
	
	return sekvens[0];
	
	}

}
