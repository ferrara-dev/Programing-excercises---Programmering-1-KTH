package eU3;
/***
 * 	1. Komplettera definitionsklassen Chessboard och alla klasser inuti den. Skapa undantagsklassen
	NotValidFieldException. Beskriv klasserna och deras medlemmar.
		
	2. Varför skapas klassen Field som en nästlad klass? Kan den skapas utanför klassen Chessboard?
	Varför skapas de klasser som representerar pjäserna som inre klasser? Kan de skapas utanför klassen Chessboard?
	
	3. Skapa ett enkelt testprogram, där ett objekt av klassen Chessboard och flera objekt av de klasser som representerar
	pjäserna skapas och används.

 * @author spof
 *
 */
public class Chessboard 
{
	/**
	 * @param Kastar ett Exception för en otillåten plats på spelplanen
	 */
    private class NotValidFieldException extends Exception 
    {
        public NotValidFieldException()
        {
        	
        }
        public NotValidFieldException(String s) 
        {
            super(s);
        }
    }
    
	public static class Field
	{
		 private char row;
		 private byte column;
		 private Chesspiece piece = null;
		 private boolean marked = false;
		 
		 // punkterna på spelplanen
		 public Field (char row, byte column) 
		 {
			 this.row = row;
             this.column = column;
		 }
		 
		 // Placera någon pjäs
		 public void put (Chesspiece piece) 
		 {
			 this.piece = piece;
		 }
		// Ta någon pjäs
		 public Chesspiece take () 
		 {
			 this.piece = null;
			 return this.piece;
		 }
		// Markera någon position
		 public void mark () 
		 {
			this.marked = true;
		 }
		 
		 // Avmarkera någon position
		 public void unmark () 
		 {
			 this.marked = false;
		 }
		 // Skriv ut den markerade poitionen och den pjäs som finns där
		 public String toString ()
		 {
			 String s = (marked)? "xx" : "--";
			 return (piece == null)? s : piece.toString ();
		 }

	 }
	
	 public static final int NUMBER_OF_ROWS = 8;
	 public static final int NUMBER_OF_COLUMNS = 8;
	 public static final int FIRST_ROW = 'a';
	 public static final int FIRST_COLUMN = 1;
	 private Field[][] fields;
	 
	 //konstruktor som skapar spelplanen
	 public Chessboard ()
	 {
		 fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		 char row = 0;
		 byte column = 0;
		 for (int r = 0; r < NUMBER_OF_ROWS; r++)
		 {
			 row = (char) (FIRST_ROW + r);
			 column = FIRST_COLUMN;
			 
			 for (int c = 0; c < NUMBER_OF_COLUMNS; c++)
			 {
				 fields[r][c] = new Field (row, column);
				 column++;
			 }
		 }
	 }
	 
	 public String toString () 
	 {
		 StringBuilder sb = new StringBuilder();
         sb.append(" 1  2  3  4  5  6  7  8\n");
         for(int i = 0; i < 8; i++)
         {
                 sb.append((char) (i + FIRST_ROW) + " ");
                 for(int i2 = 0; i2 < 8; i2++)
                 {
                         sb.append(" " + fields[i][i2]);
                         if(i2 == 7)
                         {
                                 sb.append("\n");
                         }
                 }
         }
         return sb.toString();
	 }
	 
	 public boolean isValidField (char row, byte column) 
	 {
		  if(row >= 97 && row <= 104 && column <= 7 && column >= 0)
          {
                  return true;
          }
          return false;
	 }
	
	 public abstract class Chesspiece
	 {
	 private char color;
	 // w - white, b - black
	 private char name;
	 // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
	 // P – Pawn
	 protected char row = 0;
	 protected byte column = -1;
	 protected Chesspiece (char color, char name) 
	 {
		  this.color = color;
          this.name = name;
	 }
	
	 public String toString ()
	 {
		 return "" + color + name;
	 }
	
	 public boolean isOnBoard ()
	 {
		 return Chessboard.this.isValidField (row, column);
	 }
	 
	 public void moveTo (char row, byte column) throws NotValidFieldException
	 {
		 if (!Chessboard.this.isValidField (row, column))
		 throw new NotValidFieldException ("bad field: " + row + column );
		 this.row = row;
		 this.column = column;
		 int r = row - FIRST_ROW;
		 int c = column - FIRST_COLUMN;
		 Chessboard.this.fields[r][c].put (this);
	 }
	 public void moveOut () 
	 {
		 if(isOnBoard())
         {
                 Chessboard.this.fields[row - FIRST_ROW][column].take();
         }
	 }
	 public abstract void markReachableFields ();
	 public abstract void unmarkReachableFields ();
	 }
	 
	 public class Pawn extends Chesspiece
	 {
	 public Pawn (char color, char name)
	 {
		 super (color, name);
	 }
	 
	 public void markReachableFields ()
	 {
		 byte col = (byte) (column + 1);
		 if (Chessboard.this.isValidField (row, col))
		 {
			 int r = row - FIRST_ROW;
			 int c = col - FIRST_COLUMN;
			 Chessboard.this.fields[r][c].mark ();
		 }
	 }
	 
	 public void unmarkReachableFields ()
	 {
	 byte col = (byte) (column + 1);
	 if (Chessboard.this.isValidField (row, col))
	 {
	 int r = row - FIRST_ROW;
	 int c = col - FIRST_COLUMN;
	 Chessboard.this.fields[r][c].unmark ();
	 }
	 }
	 }
	 
	 public class Rook extends Chesspiece 
	 {
		 public Rook (char color, char name)
		 {
			 super (color, name);
		 }
		 
		 public void markReachableFields ()
		 {
			 for(int i = 0; i <= ('h' - FIRST_ROW); i++)
             {
                     if (Chessboard.this.isValidField(row, (byte) i))
                     {
                             Chessboard.this.fields[row - FIRST_ROW][(byte) i].mark();
                     }
             }
		 }
		 
		 public void unmarkReachableFields()
         {
                 for(int i = 0; i <= ('h' - FIRST_ROW); i++)
                 {
                         if (Chessboard.this.isValidField(row, (byte) i))
                         {
                                 Chessboard.this.fields[row - FIRST_ROW][(byte) i].unmark();
                         }
                 }

                 for(int i2 = 0; i2 < 8; i2++)
                 {
                         if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
                         {
                                 Chessboard.this.fields[i2][this.column].unmark();
                         }
                 }                
         }
	 }
	 
	 public class Knight extends Chesspiece 
	 {
		 public Knight(char color, char name) 
		 {
             super(color, name);
		 }
		 
		 public void markReachableFields ()
		 {
			 byte col = (byte) (column + 1);
			 if (Chessboard.this.isValidField (row, col))
			 {
				 int r = row - FIRST_ROW;
				 int c = col - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].mark ();
			 }
		 }
		 
	 }
	 public class Bishop extends Chesspiece 
	 {
		 
	 }
	 public class Queen extends Chesspiece 
	 {
		 
	 }
	 public class King extends Chesspiece 
	 {
		 
	 }
	 
	}
