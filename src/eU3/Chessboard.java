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
     class NotValidFieldException extends Exception 
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
			 Chesspiece temp = this.piece;
	         this.piece = null;
	         return temp;
		
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
	 public static final int FIRST_COLUMN = 0;
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
          sb.append("    1  2  3  4  5  6  7  8\n");
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
		 int c = column ;
		 Chessboard.this.fields[r][c].put (this);
	 }
	 public void moveOut () 
	 {
		 if(isOnBoard())
         {
                 Chessboard.this.fields[row - FIRST_ROW][this.column].take();
         }
	 }
	 
	 public int getRowIndex(char row) 
	 {
         return row - FIRST_ROW;
     }

     public int getColIndex(byte column) 
     {
         return column - FIRST_COLUMN;
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
			 
			 for(int i = 0; i <= 8; i++)
             {
                     if (Chessboard.this.isValidField((char) (FIRST_ROW + i),this.column))
                     {
   
                             Chessboard.this.fields[(char) i][this.column].mark();
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

                 for(int i = 0; i <= 8; i++)
                 {
                         if (Chessboard.this.isValidField((char) (FIRST_ROW + i),this.column))
                         {
                                 Chessboard.this.fields[i][this.column].unmark();
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
			 byte col1 = (byte) (column + 2);
			 char Row1 = (char) (row + 1);
			 if (Chessboard.this.isValidField((Row1), col1))
             {
                     Chessboard.this.fields[Row1 - FIRST_ROW][col1].mark();
             }
			 
			 byte col2 = (byte) (column + 2);
			 char Row2 = (char) (row - 1);
			 if (Chessboard.this.isValidField((Row2), col2))
             {
                     Chessboard.this.fields[Row2 - FIRST_ROW][col2].mark();
             }
			 
			 byte col3 = (byte) (column + 1);
			 char Row3 = (char) (row -2);
			 if (Chessboard.this.isValidField((Row3), col3))
             {
                     Chessboard.this.fields[Row3 - FIRST_ROW][col3].mark();
             }
			 
			 byte col4 = (byte) (column - 1);
			 char Row4 = (char) (row - 2);
			 if (Chessboard.this.isValidField((Row4), col4))
             {
                     Chessboard.this.fields[Row4 - FIRST_ROW][col4].mark();
             }
			 
			 byte col5 = (byte) (column + 1);
			 char Row5 = (char) (row + 2);
			 if (Chessboard.this.isValidField((Row5), col5))
             {
                     Chessboard.this.fields[Row5 - FIRST_ROW][col5].mark();
             }
			 
			 byte col6 = (byte) (column -1);
			 char Row6 = (char) (row + 2);
			 if (Chessboard.this.isValidField((Row6), col6))
             {
                     Chessboard.this.fields[Row6 - FIRST_ROW][col6].mark();
             }
			 
			 byte col7 = (byte) (column -2);
			 char Row7= (char) (row + 1);
			 if (Chessboard.this.isValidField((Row7), col7))
             {
                     Chessboard.this.fields[Row7 - FIRST_ROW][col7].mark();
             }
			 
			 byte col8 = (byte) (column -2);
			 char Row8 = (char) (row - 1);
			 if (Chessboard.this.isValidField((Row8), col8))
             {
                     Chessboard.this.fields[Row8 - FIRST_ROW][col8].mark();
             }

		 }
		 
		 public void unmarkReachableFields()
         {
			 byte col1 = (byte) (column + 2);
			 char Row1 = (char) (row + 1);
			 if (Chessboard.this.isValidField((Row1), col1))
             {
                     Chessboard.this.fields[Row1 - FIRST_ROW][col1].unmark();
             }
			 
			 byte col2 = (byte) (column + 2);
			 char Row2 = (char) (row - 1);
			 if (Chessboard.this.isValidField((Row2), col2))
             {
                     Chessboard.this.fields[Row2 - FIRST_ROW][col2].unmark();
             }
			 
			 byte col3 = (byte) (column + 1);
			 char Row3 = (char) (row -2);
			 if (Chessboard.this.isValidField((Row3), col3))
             {
                     Chessboard.this.fields[Row3 - FIRST_ROW][col3].unmark();
             }
			 
			 byte col4 = (byte) (column - 1);
			 char Row4 = (char) (row - 2);
			 if (Chessboard.this.isValidField((Row4), col4))
             {
                     Chessboard.this.fields[Row4 - FIRST_ROW][col4].unmark();
             }
			 
			 byte col5 = (byte) (column + 1);
			 char Row5 = (char) (row + 2);
			 if (Chessboard.this.isValidField((Row5), col5))
             {
                     Chessboard.this.fields[Row5 - FIRST_ROW][col5].unmark();
             }
			 
			 byte col6 = (byte) (column -1);
			 char Row6 = (char) (row + 2);
			 if (Chessboard.this.isValidField((Row6), col6))
             {
                     Chessboard.this.fields[Row6 - FIRST_ROW][col6].unmark();
             }
			 
			 byte col7 = (byte) (column -2);
			 char Row7= (char) (row + 1);
			 if (Chessboard.this.isValidField((Row7), col7))
             {
                     Chessboard.this.fields[Row7 - FIRST_ROW][col7].unmark();
             }
			 
			 byte col8 = (byte) (column -2);
			 char Row8 = (char) (row - 1);
			 if (Chessboard.this.isValidField((Row8), col8))
             {
                     Chessboard.this.fields[Row8 - FIRST_ROW][col8].unmark();
             }
         }
		 
	 }
	 
	 public class Bishop extends Chesspiece 
	 {
		public Bishop(char color, char name)
		{
			 super (color, name);
		}

		public void markReachableFields() 
		{
			  int i = 1;
              byte col = (column);
              char markedRow = (row);

              while(Chessboard.this.isValidField((char) (markedRow + i),(byte) (col + i)))
              {
                      byte col1 = (byte) (column + i);
                      char markedRow1 = (char) (row + i);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].mark();
                      i++;
              }
             
              int j = 1;
              byte colA = (column);
              char markedRowA = (row);

              while(Chessboard.this.isValidField((char) (markedRowA - j),(byte) (colA - j)))
              {
                      byte col1 = (byte) (column - j);
                      char markedRow1 = (char) (row - j);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].mark();
                      j++;
              }
              
              int k = 1;
              byte colB = (column);
              char markedRowB = (row);

              while(Chessboard.this.isValidField((char) (markedRowB - k),(byte) (colB + k)))
              {
                      byte col1 = (byte) (column + k);
                      char markedRow1 = (char) (row - k);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].mark();
                      k++;
              }
              
              int l = 1;
              byte colC = (column);
              char markedRowC = (row);

              while(Chessboard.this.isValidField((char) (markedRowC + l),(byte) (colC - l)))
              {
                      byte col1 = (byte) (column - l);
                      char markedRow1 = (char) (row + l);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].mark();
                      l++;
              }
		}

		public void unmarkReachableFields() 
		{
			  int i = 1;
              byte col = (column);
              char markedRow = (row);

              while(Chessboard.this.isValidField((char) (markedRow + i),(byte) (col + i)))
              {
                      byte col1 = (byte) (column + i);
                      char markedRow1 = (char) (row + i);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].unmark();
                      i++;
              }
             
              int j = 1;
              byte colA = (column);
              char markedRowA = (row);

              while(Chessboard.this.isValidField((char) (markedRowA - j),(byte) (colA - j)))
              {
                      byte col1 = (byte) (column - j);
                      char markedRow1 = (char) (row - j);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].unmark();
                      j++;
              }
              
              int k = 1;
              byte colB = (column);
              char markedRowB = (row);

              while(Chessboard.this.isValidField((char) (markedRowB - k),(byte) (colB + k)))
              {
                      byte col1 = (byte) (column + k);
                      char markedRow1 = (char) (row - k);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].unmark();
                      k++;
              }
              
              int l = 1;
              byte colC = (column);
              char markedRowC = (row);

              while(Chessboard.this.isValidField((char) (markedRowC + l),(byte) (colC - l)))
              {
                      byte col1 = (byte) (column - l);
                      char markedRow1 = (char) (row + l);
                      Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].unmark();
                      l++;
              }
			
		}
	 }
	 public class Queen extends Chesspiece 
	 {
		public Queen(char color, char name)
			{
				 super (color, name);
			}

		 
		public void markReachableFields() 
		{ 
			for(int i = 0; i <= ('h' - FIRST_ROW); i++)
			{
	            if (Chessboard.this.isValidField(row, (byte) i))
	            {
	                    Chessboard.this.fields[row - FIRST_ROW][(byte) i].mark();
	            }
			}

		    for(int i2 = 0; i2 < 8; i2++)
		    {
		            if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
		            {
		                    Chessboard.this.fields[i2][this.column].mark();
		            }
		    }
	
	
	
		    int i = 1;
		    byte col = (column);
		    char markedRow = (row);
	
		    while(Chessboard.this.isValidField((char) (markedRow + i),(byte) (col + i)))
		    {
		            byte col1 = (byte) (column + i);
		            char markedRow1 = (char) (row + i);
		            Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].mark();
		            i++;
		    }
	
	
	
		    int i1 = 1;
		    byte col1 = (column);
		    char markedRow1 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow1 - i1),(byte) (col1 - i1)))
		    {
		            byte col11 = (byte) (column - i1);
		            char markedRow11 = (char) (row - i1);
		            Chessboard.this.fields[markedRow11 - FIRST_ROW][col11].mark();
		            i1++;
		    }
	
	
		    int i11 = 1;
		    byte col11 = (column);
		    char markedRow11 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow11 - i11),(byte) (col11 + i11)))
		    {
		            byte col111 = (byte) (column + i11);
		            char markedRow111 = (char) (row - i11);
		            Chessboard.this.fields[markedRow111 - FIRST_ROW][col111].mark();
		            i11++;
		    }
		
		
		    int i111 = 1;
		    byte col111 = (column);
		    char markedRow111 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow111 + i111),(byte) (col111 - i111)))
		    {
		            byte col1111 = (byte) (column - i111);
		            char markedRow1111 = (char) (row + i111);
		            Chessboard.this.fields[markedRow1111 - FIRST_ROW][col1111].mark();
		            i111++;
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
	
	
	
		    int i = 1;
		    byte col = (column);
		    char markedRow = (row);
	
		    while(Chessboard.this.isValidField((char) (markedRow + i),(byte) (col + i)))
		    {
		            byte col1 = (byte) (column + i);
		            char markedRow1 = (char) (row + i);
		            Chessboard.this.fields[markedRow1 - FIRST_ROW][col1].unmark();
		            i++;
		    }
	
	
	
		    int i1 = 1;
		    byte col1 = (column);
		    char markedRow1 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow1 - i1),(byte) (col1 - i1)))
		    {
		            byte col11 = (byte) (column - i1);
		            char markedRow11 = (char) (row - i1);
		            Chessboard.this.fields[markedRow11 - FIRST_ROW][col11].unmark();
		            i1++;
		    }
	
	
		    int i11 = 1;
		    byte col11 = (column);
		    char markedRow11 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow11 - i11),(byte) (col11 + i11)))
		    {
		            byte col111 = (byte) (column + i11);
		            char markedRow111 = (char) (row - i11);
		            Chessboard.this.fields[markedRow111 - FIRST_ROW][col111].unmark();
		            i11++;
		    }
		
		
		    int i111 = 1;
		    byte col111 = (column);
		    char markedRow111 = (row);
		
		    while(Chessboard.this.isValidField((char) (markedRow111 + i111),(byte) (col111 - i111)))
		    {
		            byte col1111 = (byte) (column - i111);
		            char markedRow1111 = (char) (row + i111);
		            Chessboard.this.fields[markedRow1111 - FIRST_ROW][col1111].unmark();
		            i111++;
		    }
		 
	 }

	}
	 
	 
	 public class King extends Chesspiece 
	 {
		public King(char color, char name)
		{
			super (color, name);
		}
		
		public void markReachableFields()
		{
			 byte col = (byte) (this.column + 1);
			 if (Chessboard.this.isValidField (this.row, col))
			 {
				 int r = this.row - FIRST_ROW;
				 int c = col - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].mark ();
			 }
			 
			 byte col1 = (byte) (this.column - 1);
			 if (Chessboard.this.isValidField (this.row, col1))
			 {
				 int r = this.row - FIRST_ROW;
				 int c = col1 - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].mark ();
			 }
			 
			 char row1 = (char) (this.row +1);
			 if (Chessboard.this.isValidField (row1, this.column))
			 {
				 int r = row1 - FIRST_ROW;
				 int c = this.column - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].mark ();
			 }
			
			 char row2 = (char) (this.row -1);
			 if (Chessboard.this.isValidField (row2, this.column))
			 {
				 int r = row2 - FIRST_ROW;
				 int c = this.column - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].mark ();
			 }

             int[] z = {1, 1, -1, -1, 1};
			 for (int i = 1; i <= 1; i++) {
	                for (int j = 0; j < 4; j++) 
	                {
	                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1])))
	                    {
	                        int r = (char) (row + i*z[j]) - FIRST_ROW;
	                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
	                        Chessboard.this.fields[r][c].mark();
	                    }
	                }
	            }
             
           
		}
		 
		public void unmarkReachableFields()
		{
			 byte col = (byte) (this.column + 1);
			 if (Chessboard.this.isValidField (this.row, col))
			 {
				 int r = this.row - FIRST_ROW;
				 int c = col - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].unmark ();
			 }
			 
			 byte col1 = (byte) (this.column - 1);
			 if (Chessboard.this.isValidField (this.row, col1))
			 {
				 int r = this.row - FIRST_ROW;
				 int c = col1 - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].unmark ();
			 }
			 
			 char row1 = (char) (this.row - 1);
			 if (Chessboard.this.isValidField (row1, this.column))
			 {
				 int r = row1 - FIRST_ROW;
				 int c = this.column - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].unmark ();
			 }
			
			 char row2 = (char) (this.row +1);
			 if (Chessboard.this.isValidField (row2, this.column))
			 {
				 int r = row2 - FIRST_ROW;
				 int c = this.column - FIRST_COLUMN;
				 Chessboard.this.fields[r][c].unmark ();
			 }
		     int[] z = {1, 1, -1, -1, 1};
					 for (int i = 1; i <= 1; i++) {
			                for (int j = 0; j < 4; j++) 
			                {
			                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1])))
			                    {
			                        int r = (char) (row + i*z[j]) - FIRST_ROW;
			                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
			                        Chessboard.this.fields[r][c].unmark();
			                    }
			                }
			            }
		             
		}
		 
	 }
}
