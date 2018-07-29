package vik.demo.backtracking;


public class FourQueensInChess {

	public static void main(String[] args) {
		FourQueensInChess fqic = new FourQueensInChess();
		
		int[][] chessboard = {   {0, 0, 0, 0 },
								{0, 0, 0, 0 },
								{0, 0, 0, 0 },
								{0, 0, 0, 0 }
						    };
		fqic.placeQueens(chessboard, 0);
		for (int i = 0 ; i < chessboard.length ; i++) {
			for (int j = 0 ; j < chessboard.length ; j++) {
				System.out.print(chessboard[i][j]);
			}
			System.out.println();
		}
	}

	private boolean placeQueens( int[][] chessboard, int column ) {
		
		if (column >= 4) {
			return true;
		}
		/**
		 * LOGIC TRACE:
		 * 1, Start with row 0 col 0
		 * 2. If queen position valid set [row][col] = 1
		 *    If queen position invalid, remove this queen and go to previous queen and move it
		 * 3. Keep on doing this until all are placed   
		 */
		for(int row = 0 ; row < chessboard.length; row++) {
			
			if (isQueenPositionValid(chessboard, row, column)) {
				chessboard[row][column] = 1;
				if (placeQueens(chessboard, column+1)) {
					return true;
				}
				chessboard[row][column] = 0;
			}
		}
		return false;
	}
	
	private boolean isQueenPositionValid(int[][] chessboard, int row, int col) {

		//check row on left
		for (int i = 0; i < col ; i++){
			if (chessboard[row][i] == 1) {
				return false;
			}
		}

		//check upper left diagonal
		for (int i = row, j = col ; j >=0 && i >= 0; i--, j--) {
			if (chessboard[i][j] == 1) {
				return false;
			}
		}
		
		//check lower left diagnoal
		for (int i = row, j = col ; i < chessboard.length  && j >= 0 ; i++, j--) {
			if (chessboard[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}