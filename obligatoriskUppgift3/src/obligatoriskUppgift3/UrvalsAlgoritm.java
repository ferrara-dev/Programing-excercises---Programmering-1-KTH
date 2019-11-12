package obligatoriskUppgift3;

public class UrvalsAlgoritm 
{
	/******************************PROBLEM*************************************************
	 Det finns en eskvens med n element av n�gon typ, n >= 1
	 
	 l1,l2,l3...ln
	 
	 Tv� godtyckliga element i sekvensen kan j�mf�ras med operatorn <, f�r att best�mma det minsta av dem.
	 
	 Best�m det minsta elementet i sekvensen.
	 */
	
	/******************************F�RVILLKOR*************************************************
	F�rvillkor:
	n, n >= 1 element l1,l2,l3
	
	F�r varje element l1,l2,l3..ln i sekvensen, kan v�rdet p� n�got index i j�mf�ras med v�rdet
	p� n�got index j i sekvensen.
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
	
	// komplexiteten f�r denna algoritm �r m(n) = 1
	
	 */
	/***************************** AlGORITM URSKILJNINGSTRATEGI ************************************************
	element [5,8,3,17,2,24,25,1,7]
			
	Nyelement[5,3,2,1,7]
	
	Nyelement[3,1,7]
	
	Nyelemnet [1,7]
	
	Nyelement [1]
	// komplexiteten f�r denna algoritm �r m(n) = n/2
	
	 */
}
