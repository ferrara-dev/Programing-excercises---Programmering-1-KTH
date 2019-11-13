	// Uppgifter att göra i samband med obligatorisk uppgift 3

/**______________________________________________________________________________________________________________________________________

	[1] Bestäm en instans av det här problemet i fallet att m = 3 och n = 4 – välj väglängderna. Specificera den instansen med en
		 bild. Det ska framgå vilka stationer och vägar som finns, och hur långa vägarna är. 
	 m = 3
	 n = 4
_________________________________________________________________________________________________________________________________________

	[2] Specificera den valda instansen även med en tabell. Lös den aktuella instansen av problemet med papper och penna:
	    undersök alla möjliga vägar och bestäm mellanstationerna för den kortaste vägen 
	    (för in längderna i kolumnen ”Längd” och välj de mellanstationer som motsvarar den minsta längden).
		 m = 3
		 n = 4
		 
		  z1 | ai | z2 | bij | z3 | cj | z4 | Längd | Kortaste sträckan |
		 ----|----|----|-----|----|----|----|-------|-------------------|
		  x  |  5 | u1 |   3 | v1 | 34 |  Y |    42 |					
		  x  |    | u1 |   5 | v2 |    |  Y |    19 |	----X-- 
		  x  |    | u1 |  11 | v3 |    |  Y |    38 |					
		  x  |    | u1 |   2 | v4 | 11 |  Y |    18 |					
		  x  |  9 | u2 |   3 | v1 |    |  Y | 	 23 |					
		  x  |    | u2 |  33 | v2 |    |  Y | 	 64 |					
		  x  |    | u2 |   1 | v3 | 22 |  Y | 	 43 |					
		  x  |    | u2 |  20 | v4 |    |  Y | 	 30 |					
		  x  |  4 | u3 |  11 | v1 |    |  Y | 	 37 |					
		  x  |    | u3 |  13 | v2 | 22 |  Y | 	 21 |					
		  x  |    | u3 |  5  | v3 |    |  Y | 	 36 |					
		  x  |    | u3 |  21 | v4 |    |  Y | 	 27 |					
		  
_________________________________________________________________________________________________________________________________________		  
		  
	
	[3] Hitta en minneseffektiv algoritm som löser det här problemet i ett allmänt fall – använd uppdateringsstrategi. Beskriv den
		algoritmen på två olika sätt: med ord och med pseudokod.
		
	 													*** PROBLEM ***
	PROBLEMBESKRIVNING:
	--------------------
		Det ska bestämmas vilka mellanstationer man bör gå via för att 
		vägen mellan stationen X och stationen Y blir så kort som möjligt.
	    Det kan hända att det finns flera vägar som har den kortaste längden. 
	    I så fall ska mellanstationer på en av dessa vägar bestämmas.
		- Zonen Z1 omfattar endast stationen X, och zonen Z4 omfattar bara stationen Y. 
		- Zonen Z2 omfattar stationerna U1, U2, ..., Um,  (m är ett positivt heltal).
		- Zonen Z3 omfattar stationerna V1, V2, ..., n (n är ett positivt heltal).
		- Det finns direkta vägar mellan stationen X och alla stationer i zonen Z2.
		- Zonerna Z2 och Z3 är väl kopplade med varandra
														
														*** ALGORITM ***
	FÖRVILLKOR:
	-----------
		i z1 : x
		i z2 : u1, u2...Um   (m >= 1)
		i z3 : v1, v2,...,vn (m >= 1)
		i z4 : Y
		
		- För ett godtyckligt heltal i, 1 <= i <= m, gäller: längden av vägen mellan stationen X och stationen Ui är ai.
			d(X,u1) = a1
			d(X,u2) = a2
			d(X,u3)  = a3
			...
			d(a1,Um)  = am
		
		- För ett godtyckligt heltal i, 1 <= i <= m, och för ett godtyckligt heltal j, 1 <= j <= n, gäller: 
		längden av vägen mellan stationen Ui och stationen Vj är bij.
			d(U1,v1) = b11
			d(u1,v2) = b12
			d(u1,v3) = b13
			d(u2,v1) = b21
		...
		d(Um,Vn) = bmn
		- För ett godtyckligt heltal j, 1 <= j <= n, gäller: längden av vägen mellan stationen Vj och stationen Y är cj
			d(v1,Y) = c1
			d(v2,Y) = c2
			...
			d(Vn,y) = cn

		
	STEG I ALGORITMEN:
	------------------
		Steg 1 ----> Avståndet a1 + b11 + c1 antas vara det kortaste
		
		Steg 2 ----> avståndet jämförs med anståndet a1 + b12 + c1, om det senare är mindre
					 antas det som det nya minsta värdet.
					 Proceduren upprepas tills det att alla alternativa sträckor har
					 jämförts.
					 
		End   ---->  Den kortaste sträcka, den position i ordningen som den låg i 
					eller båda två kan nu tas fram.
		
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
		// Minneskomplexiteten för denna algoritm är m(n) = 2 => " Memorykomplexity for this algoritm is 2 "
		// Denna alogritm har en mycket mindre minneskomplexitet och är därav den bättre av de två
		
_________________________________________________________________________________________________________________________________________		
	
	[4]  Skapa  ett  Javaprogram  som  kan  lösa  olika  instanser  av  det  här  problemet.
	  	 Använd  programmet  i  samband  med  två instanser, och förklarade resultat som erhålls.	
		 Det ska finnas två klasser: DenKortasteVagenoch BestamDenKortasteVagen.  
		 Den första klassen ska se ut så här:
		 
		 class DenKortasteVagen
		 {
			 // mellanstationer returnerar en vektor med de mellanstationersom finns på den kortaste vägen.
			 // Ordningsnummerav den förstamellanstationen finns på index1, 
			 // och ordningsnummer av den andra mellanstationen på index2 i vektorn.
			
			 public static int[] mellanstationer (double[] a, double[][] b,double[] c)
			 {
			 	// koden här
			 }
			 
			 // langd returnerar längden av den kortaste vägen.
			 publicstatic double langd (double[] a, double[][] b, double[] c)
			 {
			 	// koden här
		 	 }
		 }
		Klassen BestamDenKortasteVagenska  innehålla  metoden main, där instansspecifika
 		uppgiftermatas  in,  och  metoder  i klassen DenKortasteVagenanropas. 
	*/
