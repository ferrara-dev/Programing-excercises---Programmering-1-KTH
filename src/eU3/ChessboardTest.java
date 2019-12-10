package eU3;

import eU3.Chessboard.*;

import java.util.*;

public class ChessboardTest {

    public static void main(String args[])throws NotValidFieldException
    {
            ChessboardTest test = new ChessboardTest();
    }

    public ChessboardTest()throws NotValidFieldException
    {
            Chessboard chessBoard = new Chessboard ();
            Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6]; 
            Scanner in = new Scanner(System.in);
            
            String val = in.nextLine();
            
            // Testa drottningen
            System.out.println("TESTA DROTTNINGEN");
        	System.out.println(chessBoard);
        	val = in.nextLine();
            pieces[0] = chessBoard.new Queen ('w', 'Q');
            pieces[0].moveTo('f',(byte) (3));
            pieces[0].markReachableFields();
            System.out.println(chessBoard);
        	val = in.nextLine();
       
        	pieces[0].unmarkReachableFields();
        	pieces[0].moveOut();
        	val = in.nextLine();
        	System.out.println(chessBoard);
        	val = in.nextLine();
            // Testa bonden
        	System.out.println("TESTA BONDEN");
            System.out.println(chessBoard);
            val = in.nextLine();
            pieces[1] = chessBoard.new Pawn ('w', 'P');
            pieces[1].moveTo('d',(byte) (3));
        	pieces[1].markReachableFields();
        	val = in.nextLine();
        	System.out.println(chessBoard);
        	pieces[1].unmarkReachableFields();
        	pieces[1].moveOut();
        	val = in.nextLine();
        	
        	// Testa tornet
        	System.out.println("TESTA TORNET");
        	System.out.println(chessBoard);
            pieces[2] = chessBoard.new Rook ('b', 'R');
            pieces[2].moveTo('d',(byte) (3));
        	pieces[2].markReachableFields();
        	val = in.nextLine();
        	System.out.println(chessBoard);
        	pieces[2].unmarkReachableFields();
        	pieces[2].moveOut();
        	val = in.nextLine();
        	
        	// hästen
        	System.out.println("TESTA HÄSTEN");
        	System.out.println(chessBoard);
            pieces[3] = chessBoard.new Knight ('w', 'N');
            pieces[3].moveTo('d',(byte) (3));
        	pieces[3].markReachableFields();
        	System.out.println(chessBoard);
        	pieces[3].unmarkReachableFields();
        	pieces[3].moveOut();
        	
        	// Testa löparen
        	System.out.println("TESTA LÖPAREN");
        	System.out.println(chessBoard);
            pieces[4] = chessBoard.new Bishop ('w', 'B'); 
            pieces[4].moveTo('d',(byte) (3));
        	pieces[4].markReachableFields();
        	System.out.println(chessBoard);
        	pieces[4].unmarkReachableFields();
        	pieces[4].moveOut();
        	System.out.println(chessBoard);
        	
        	// Testa kungen
            pieces[5] = chessBoard.new King ('b', 'K'); 
            pieces[5].moveTo('d',(byte) (3));
        	pieces[5].markReachableFields();
        	System.out.println(chessBoard);
        	pieces[5].unmarkReachableFields();
        	pieces[5].moveOut();
        	
        	System.out.println(chessBoard);
            System.out.println("\n Pawn: " + pieces[0] 
                            + "\n Rook: " + pieces[1] 
                            +" \n Queen: "+ pieces[2]
                            + "\n Bishop: " + pieces[3]
                            + "\n King: " + pieces[4]
                            + "\n Knight: " + pieces[5] + "\n");
            
           /* pieces[0].moveTo('d',(byte) (3));
            pieces[0].markReachableFields();
            System.out.println(pieces[0].toString());
            System.out.println(chessBoard);
            */
           
            /*
            for(Chesspiece piece : pieces)
            {
            	
            	System.out.println(piece.toString());
            	piece.moveTo('d',(byte) (3));
            	piece.markReachableFields();
            	System.out.println(chessBoard);
            	piece.unmarkReachableFields();
            	piece.moveOut();
            }
            */
   }
}