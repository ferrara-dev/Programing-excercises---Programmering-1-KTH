package obligatoriskUppgift3;

public class UrvalsAlgoritm 
{
	/******************************PROBLEM*************************************************
	 Det finns en eskvens med n element av någon typ, n >= 1
	 
	 l1,l2,l3...ln
	 
	 Två godtyckliga element i sekvensen kan jämföras med operatorn <, för att bestämma det minsta av dem.
	 
	 Bestäm det minsta elementet i sekvensen.
	 */
	
	/******************************FÖRVILLKOR*************************************************
	Förvillkor:
	n, n >= 1 element l1,l2,l3
	
	För varje element l1,l2,l3..ln i sekvensen, kan värdet på något index i jämföras med värdet
	på något index j i sekvensen.
	ai < ai --> True | false
	
	 */
	
	/***************************** AlGORITM UPPDATERINGSSTRATEGI ************************************************
	min(n,l1,l2...ln)
	{
	k = 1
	for i = 2,3,...,n
		if ei < ek
		k = i
	
	retuern ek
	
	// komplexiteten för denna algoritm är m(n) = 1
	
	 */
	/***************************** AlGORITM URSKILJNINGSTRATEGI ************************************************
	element [5,8,3,17,2,24,25,1,7]
			
	Nyelement[5,3,2,1,7]
	
	Nyelement[3,1,7]
	
	Nyelemnet [1,7]
	
	Nyelement [1]
	// komplexiteten för denna algoritm är m(n) = n/2
	
	 */
}
