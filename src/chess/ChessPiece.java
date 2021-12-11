package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{

	private Color color;
	private int moveCount;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	//Retorna posição no formato do xadrez
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	//Verifica se há uma peça adversária na posição
	protected boolean isThereOpponentPiece(Position position) {
		//Recebe a peça que estiver na posição
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		//Verifica se é uma peça adversária
		return p != null && p.getColor() != color;
	}
	
}
