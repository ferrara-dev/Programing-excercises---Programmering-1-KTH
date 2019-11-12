package obligatoriskUppgift3;
/****** FÖRVILLKOR *************\
i z1 : a
i z2 : s1, s2...sn   (n >= 1)
i z3 : b
*******************************/
/*** AVSTÅND ***\
d(a1,s1) = a1
d(a1,s2) = a2
d(a1,3)  = a3
...
d(a1,n)  = an

d(b1,s1) = b1
d(b1,s2) = b2
d(b1,3)  = b3
...
d(b1,n)  = bn
*/

/*** EFTERVILLKOR***\
Variabeln k innehåller
ordningsnummer av en
station i z2 sådan att
avstånden mellan a och b
genom Sk är så kort som 
möjligt.
*********************/
public class UppdateringsAlgoritm 
{
	/*********************************PseudoKod********************************************\
	[1]
	Start ---> 	 shortestPath(n,a1,a2 ...an,b1,b2...bn)
		 		{
	Step 1 ---> 	for = i 1,2,..n
		 				di = ai+bi
		 			k = 1
	Step 2 --->	 	for i = 2,3,...n
		 				if di < dk
		 				k = i
	
	End  --->		return k
		 		}
	// Minneskomplexiteten för denna algoritm är m(n) = n + 1 => " Memorykomplexity for this algoritm is n +1 "
	[2]
	Start ---> 	 shortestPath(n,a1,a2 ...an,b1,b2...bn)
		 		{
	Step 1 ---> 	k = 1
					d = a1 + b1
					
	Step 2 --->	 	for i = 2,3,...n
		 				if ai + bi < d
		 				k = i, d = ai + bi
	
	End  --->		return k
	// Minneskomplexiteten för denna algoritm är m(n) = 2 => " Memorykomplexity for this algoritm is 2 "
	// Denna alogritm har en mycket mindre minneskomplexitet och är därav den bättre av de två
	\*****************************************************************************************/
}
