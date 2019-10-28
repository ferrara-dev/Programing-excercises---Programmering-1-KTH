package övning1C;

public class PersonligaUppgifter {

	public static void main(String[] args)  throws Exception{

		System.out.println ("Personal information");
		System.out.println ();
		
		// inmatningsverktyg
		java.util.Scanner  in = new java.util.Scanner (System.in);
		
		// Put in personal information
		System.out.print ("Birthyear: ");
		int year = in.nextInt ();
		in.nextLine ();
		//in.nextLine ();    // (2)
		System.out.print ("Your name and sirname: ");
		String name = in.nextLine ();
		System.out.println ();
		// Save input in a file
			java.io.PrintWriter  fout = new java.io.PrintWriter ("persUpp.txt");
				fout.println (name + ": " + year);
			fout.flush ();
				// ett meddelande
				System.out.println ("Oppna filen persUpp.txt!");
	}
}
