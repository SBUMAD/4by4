package sbu.mad.gridbox;

public class GameGridManager {

	public SquareGrid grid;
	public int rows, cols;

	// public GameGridManager(int[][] grid) {
	// this.grid = grid;
	// }

	public GameGridManager(SquareGrid grid) {
		this.grid = grid;
		this.grid.resetTiles();
	}

	public void moveUp() {
		for (int i = 1; i < grid.tiles.length; i++) {
			for (int j = 0; j < grid.tiles[i].length; j++) {
				for (int k = i; k > 0; k--) {
					if (grid.tiles[k - 1][j].value == 0) {
						grid.tiles[k - 1][j].value = grid.tiles[k][j].value;
						grid.tiles[k][j].value = 0;
					} else if (grid.tiles[k - 1][j].value == grid.tiles[k][j].value) {
						grid.tiles[k - 1][j].value += grid.tiles[k][j].value;
						grid.tiles[k][j].value = 0;
						k = -2;
					} else {
						k = -2;
					}
				}
			}
		}
		if (!checkIfFull()) {
			addRandom4();
		} else {
			gameOver();
		}
	}

	public void moveDown() {

		for (int i = grid.tiles.length - 2; i > -1; i--) {
			for (int j = 0; j < grid.tiles[i].length; j++) {
				for (int k = i; k < grid.tiles.length - 1; k++) {
					if (grid.tiles[k + 1][j].value == 0) {
						grid.tiles[k + 1][j].value = grid.tiles[k][j].value;
						grid.tiles[k][j].value = 0;
					} else if (grid.tiles[k + 1][j].value == grid.tiles[k][j].value) {
						grid.tiles[k + 1][j].value += grid.tiles[k][j].value;
						grid.tiles[k][j].value = 0;
						k = grid.tiles.length;
					} else {
						k = grid.tiles.length;
					}
				}
			}
		}
		if (!checkIfFull()) {
			addRandom4();
		} else {
			gameOver();
		}
	}

	public void moveLeft() {

		for (int j = 0; j < grid.tiles[0].length; j++) {
			for (int i = 0; i < grid.tiles.length; i++) {
				for (int k = j; k > 0; k--) {
					if (grid.tiles[i][k - 1].value == 0) {
						grid.tiles[i][k - 1].value = grid.tiles[i][k].value;
						grid.tiles[i][k].value = 0;
					} else if (grid.tiles[i][k - 1].value == grid.tiles[i][k].value) {
						grid.tiles[i][k - 1].value += grid.tiles[i][k].value;
						grid.tiles[i][k].value = 0;
						k = -2;
					} else {
						k = -1;
					}
				}
			}
		}

		if (!checkIfFull()) {
			addRandom4();
		} else {
			gameOver();
		}
	}

	public void moveRight() {
		for (int j = grid.tiles[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < grid.tiles.length; i++) {
				for (int k = j; k < grid.tiles[0].length - 1; k++) {
					if (grid.tiles[i][k + 1].value == 0) {
						grid.tiles[i][k + 1].value = grid.tiles[i][k].value;
						grid.tiles[i][k].value = 0;
					} else if (grid.tiles[i][k + 1].value == grid.tiles[i][k].value) {
						grid.tiles[i][k + 1].value += grid.tiles[i][k].value;
						grid.tiles[i][k].value = 0;
						k = 6;
					} else {
						k = 6;
					}
				}
			}
		}

		if (!checkIfFull()) {
			addRandom4();
		} else {
			gameOver();
		}
	}

	public void gameOver() {
		// System.out.println("Game Over");
		grid.resetTiles();
		// grid.printGrid();
	}

	public boolean checkIfFull() {
		boolean flag = true;
		for (int i = 0; i < grid.tiles.length; i++) {
			for (int j = 0; j < grid.tiles[i].length; j++) {
				if (grid.tiles[i][j].value == 0) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}

	public void addRandom4() {
		boolean flag = true;
		while (flag) {
			int x = (int) (Math.random() * 4);
			int y = (int) (Math.random() * 4);
			if (grid.tiles[x][y].value == 0) {
				grid.tiles[x][y].value = 4;
				flag = false;
			}
		}
	}

	public String printGrid() {
		String result = "";
		for (int i = 0; i < grid.tiles.length; i++) {
			for (int j = 0; j < grid.tiles[0].length; j++) {
				result += grid.tiles[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
}
