package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		//Mostra a inicial da peça no tabuleiro
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {  //Movimentos possiveis da torre
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//Posição inicial
		Position p = new Position(0, 0);
		
		//Verifica as posições acima
		p.setValues(position.getRow() - 1,	position.getColumn());
		//Enquanto não tiver um peça na posicao acima
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
		}
		//Verifica se na próxima posição tem peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Verifica as posições a esquerda
		p.setValues(position.getRow(),	position.getColumn()-1);
		//Enquanto não tiver um peça na posicao a esquerda
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()-1);
		}
		//Verifica se na próxima posição tem peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Verifica as posições a direita
		p.setValues(position.getRow(),	position.getColumn()+1);
		//Enquanto não tiver um peça na posicao a direita
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()+1);
		}
		//Verifica se na próxima posição tem peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Verifica as posições abaixo
		p.setValues(position.getRow() + 1,	position.getColumn());
		//Enquanto não tiver um peça na posicao abaixo
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
		}
		//Verifica se na próxima posição tem peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}

}
