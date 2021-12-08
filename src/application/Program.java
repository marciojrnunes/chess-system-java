package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();  //Lista de peças capturadas
		
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				//Imprime posicoes possiveis
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getpieces(), possibleMoves);  //Imprime peças e movimentos possiveis
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				//Adiciona peça capturada
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();  //aguarda usuário apertar ENTER
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();  //aguarda usuário apertar ENTER
			}
		}
		//Após o checkMate, limpa a tela e mostra partida finalizada
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
