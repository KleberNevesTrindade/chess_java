package boardgame;

public class Board {

	private int rows;
	private int colunms;
	private Piece[][] pieces;
	
	public Board(int rows, int colunms) {
		if (rows < 1 || colunms <1) {
			throw new BoardException("Erro ao criar o tabuleiro");
		}
		this.rows = rows;
		this.colunms = colunms;
		pieces = new Piece[rows][colunms];
	}

	public int getRows() {
		return rows;
	}

	public int getColunms() {
		return colunms;
	}

	// Pega a peća pela linha e coluna
	public Piece piece(int row, int colunm) {
		if (!positionExists(row, colunm)) {
			throw new BoardException("Peća fora do tabuleiro");
		}
		return pieces[row][colunm];
	}
	
	// Pega a pela posićão
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Peća fora do tabuleiro");
		}
		return pieces[position.getRow()][position.getColunm()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peća nessa posićão? " + position);
		}
		pieces[position.getRow()][position.getColunm()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int colunm) {
		return row >= 0 && row < rows && colunm >= 0 && colunm < colunms;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColunm());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Peća fora do tabuleiro");
		}
		return (piece(position) != null);
	}
	
}
