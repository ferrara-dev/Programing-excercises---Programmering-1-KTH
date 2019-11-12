module obligatoriskUppgift3
{
}
// Uppgifter att g�ra i samband med obligatorisk uppgift 3

/****************************************************************************************************************************
[1] Best�m en instans av det h�r problemet i fallet att m = 3 och n = 4 � v�lj v�gl�ngderna. Specificera den instansen med en
	 bild. Det ska framg� vilka stationer och v�gar som finns, och hur l�nga v�garna �r. 
 m = 3
 n = 4
 */

/***********************************************************************************************************************
[2] Specificera den valda instansen �ven med en tabell. L�s den aktuella instansen av problemet med papper och penna:
    unders�k alla m�jliga v�gar och best�m mellanstationerna f�r den kortaste v�gen 
    (f�r in l�ngderna i kolumnen �L�ngd� och v�lj de mellanstationer som motsvarar den minsta l�ngden).
	 m = 3
	 n = 4
	 
	  z1 | ai | z2 | bij | z3 | cj | z4 | L�ngd | Kortaste str�ckan |
	 ----|----|----|-----|----|----|----|-------|-------------------|
	  x  |  5 | u1 |   3 | v1 | 34 |  Y |    42 |					|
	  x  |    | u1 |   5 | v2 |  9 |  Y |    19 |	  ----X----	    |
	  x  |    | u1 |  11 | v3 | 22 |  Y |    38 |					|
	  x  |    | u1 |   2 | v4 | 31 |  Y |    38 |					|
	  x  |  9 | u2 |   3 | v1 | 11 |  Y | 	 23 |					|
	  x  |    | u2 |  33 | v2 | 22 |  Y | 	 64 |					|
	  x  |    | u2 |   1 | v3 | 33 |  Y | 	 43 |					|
	  x  |    | u2 |  20 | v4 |  1 |  Y | 	 30 |					|
	  x  |  4 | u3 |  11 | v1 | 22 |  Y | 	 37 |					|
	  x  |    | u3 |  13 | v2 |  4 |  Y | 	 21 |					|
	  x  |    | u3 |  5  | v3 | 27 |  Y | 	 36 |					|
	  x  |    | u3 |  21 | v4 |  2 |  Y | 	 27 |					|
	  
	  
*/
	
/******************************************************************************************************************************
[3] Hitta en minneseffektiv algoritm som l�ser det h�r problemet i ett allm�nt fall � anv�nd uppdateringsstrategi. Beskriv den
	algoritmen p� tv� olika s�tt: med ord och med pseudokod.
	
 													*** PROBLEM ***
	PROBLEMBESKRIVNING:
	--------------------
	Det ska best�mmas vilka mellanstationer man b�r g� via f�r att 
	v�gen mellan stationen X och stationen Y blir s� kort som m�jligt.
    Det kan h�nda att det finns flera v�gar som har den kortaste l�ngden. 
    I s� fall ska mellanstationer p� en av dessa v�gar best�mmas.
	- Zonen Z1 omfattar endast stationen X, och zonen Z4 omfattar bara stationen Y. 
	- Zonen Z2 omfattar stationerna U1, U2, ..., Um,  (m �r ett positivt heltal).
	- Zonen Z3 omfattar stationerna V1, V2, ..., n (n �r ett positivt heltal).
	- Det finns direkta v�gar mellan stationen X och alla stationer i zonen Z2.
	- Zonerna Z2 och Z3 �r v�l kopplade med varandra
													*** ALGORITM ***
	F�RVILLKOR:
	----------_
	i z1 : x
	i z2 : u1, u2...Um   (m >= 1)
	i z3 : v1, v2,...,vn (m >= 1)
	i z4 : Y
	
	- F�r ett godtyckligt heltal i, 1 <= i <= m, g�ller: l�ngden av v�gen mellan stationen X och stationen Ui �r ai.
		d(X,u1) = a1
		d(X,u2) = a2
		d(X,u3)  = a3
		...
		d(a1,Um)  = am
	
	- F�r ett godtyckligt heltal i, 1 <= i <= m, och f�r ett godtyckligt heltal j, 1 <= j <= n, g�ller: 
	l�ngden av v�gen mellan stationen Ui och stationen Vj �r bij.
		d(U1,v1) = b11
		d(u1,v2) = b12
		d(u1,v3) = b13
		d(u2,v1) = b21
	...
	d(Um,Vn) = bmn
	- F�r ett godtyckligt heltal j, 1 <= j <= n, g�ller: l�ngden av v�gen mellan stationen Vj och stationen Y �r cj
		d(v1,Y) = c1
		d(v2,Y) = c2
		...
		d(Vn,y) = cn
		
	STEG I ALGORITMEN:
	------------------
	Steg 1 ----> Avst�ndet a1 + b11 + c1 antas vara det kortaste och ben�mns d
	
	Steg 2 ----> d j�mf�rs med anst�ndet a1 + b12 + c1, om det senare �r mindre
				 antas det som det nya minsta v�rdet.
				 Proceduren upprepas tills det att alla alternativa str�ckor har
				 j�mf�rts.
				 
	End   ---->  Den kortaste str�cka, den position i ordningen som den l�g i 
				eller b�da tv� kan nu tas fram.
	
	STEG I ALGORITMEN - PSUEDOKOD:
	-------------------------------
	Start ---> 	 shortestDist(m,a1,a2 ...,am,c1,c2,...cm,b11,b12..,b21,....bmn)
		 		{
	Step 1 ---> 	k = 1
					d = a1 + b11 + c1
					
	Step 2 --->	 	for i = 2,3,...m
						for  j = 2,3...n
		 				if ai + bi < d
		 				k = i, d = ai + bi
	
	End  --->		return k
	// Minneskomplexiteten f�r denna algoritm �r m(n) = 2 => " Memorykomplexity for this algoritm is 2 "
	// Denna alogritm har en mycket mindre minneskomplexitet och �r d�rav den b�ttre av de tv�
	
	
*/