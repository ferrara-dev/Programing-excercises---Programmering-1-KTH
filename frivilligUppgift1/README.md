Algoritmer

Det minsta heltalet – hitta fel i lösningen
Ett problem att lösa: bestäm det minsta heltalet
Det finns en sekventiell samling med heltal. Bestäm det minsta heltalet i samlingen.
Lösningen
Följande lösning innehåller två fel, utplacerade i två olika rader. Det första felet gör att algoritmen blir oändlig. Det andra
felet leder till ett felaktigt svar för vissa talsekvenser.
Felen i lösningen ska hittas och korrigeras. När ett fel korrigeras, ska bara en del av den motsvarande raden ändras.
En lösning till problemet – innehåller två fel
// min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
public static int min (int[] element) throws IllegalArgumentException
{
if (element.length == 0)
throw new IllegalArgumentException ("tom samling");
// hör ihop med spårutskriften 2:
// int antalVarv = 1;
int[] sekvens = element;
int antaletPar = sekvens.length / 2;
int antaletOparadeElement = sekvens.length % 2;
int antaletTankbaraElement = antaletPar + antaletOparadeElement;
int[] delsekvens = new int[antaletTankbaraElement];
int i = 0;
int j = 0;
while (sekvens.length > 1)
{
// skilj ur en delsekvens med de tänkbara elementen
i = 0;
j = 0;
while (j < antaletPar)
{
delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
i += 2;
}
if (antaletOparadeElement == 1)
delsekvens[j] = sekvens[sekvens.length - 1];
// utgå nu ifrån delsekvensen
sekvens = delsekvens;
antaletPar = antaletTankbaraElement / 2;
antaletOparadeElement = antaletTankbaraElement % 2;
antaletTankbaraElement = antaletPar + antaletOparadeElement;
// spårutskrift 1 – för att följa sekvensen
// System.out.println (java.util.Arrays.toString (sekvens));
// spårutskrift 2 - för att avsluta loopen i förväg
// (för att kunna se vad som händer i början)
// if (antalVarv++ == 10)
// System.exit (0);
}
// sekvens[0] är det enda återstående tänkbara elementet
// - det är det minsta elementet
return sekvens[0];
