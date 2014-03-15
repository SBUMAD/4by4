package sbu.mad.gridbox;

public class GameGridManager {

	public SquareGrid grid; // A reference to the grid

	public GameGridManager(SquareGrid grid) {
		// Init the gridmgr
		this.grid = grid;
		this.resetTiles();

		// Start with a random tile
		for (int i = 0; i < grid.rows / 2; i++) {
			addRandomTiles();
		}
	}

	// Slides all the tiles up
	public boolean moveLeft() {
		boolean flag = false;
		for (int i = 1; i < grid.tiles.length; i++) {
			for (int j = 0; j < grid.tiles[i].length; j++) {
				for (int k = i; k > 0; k--) {
					// if matches
					if (grid.tiles[k - 1][j].value == 0) {
						grid.tiles[k - 1][j].setVal(grid.tiles[k][j].value);
						grid.tiles[k][j].setVal(0);
						flag = true;
					} else if (grid.tiles[k - 1][j].value == grid.tiles[k][j].value) {
						grid.tiles[k - 1][j].value += grid.tiles[k][j].value;
						grid.tiles[k][j].setVal(0);
						k = -2;
						flag = true;
					} else {
						k = -2;
					}
				}
			}
		}
		if (!checkIfFull()) {
			addRandomTiles();
		} else {
			gameOver();
		}
		return flag;
	}

	// TODO: Change move methods to return bools so we can increment the # of moves properly in GameView
	
	// Slides all the tiles down
	public void moveRight() {

		for (int i = grid.tiles.length - 2; i > -1; i--) {
			for (int j = 0; j < grid.tiles[i].length; j++) {
				for (int k = i; k < grid.tiles.length - 1; k++) {
					if (grid.tiles[k + 1][j].value == 0) {
						grid.tiles[k + 1][j].setVal(grid.tiles[k][j].value);
						grid.tiles[k][j].setVal(0);
					} else if (grid.tiles[k + 1][j].value == grid.tiles[k][j].value) {
						grid.tiles[k + 1][j].value += grid.tiles[k][j].value;
						grid.tiles[k][j].setVal(0);
						k = grid.tiles.length;
					} else {
						k = grid.tiles.length;
					}
				}
			}
		}
		if (!checkIfFull()) {
			addRandomTiles();
		} else {
			gameOver();
		}
	}

	// Slides all the tiles left
	public void moveUp() {

		for (int j = 0; j < grid.tiles[0].length; j++) {
			for (int i = 0; i < grid.tiles.length; i++) {
				for (int k = j; k > 0; k--) {
					if (grid.tiles[i][k - 1].value == 0) {
						grid.tiles[i][k - 1].setVal(grid.tiles[i][k].value);
						grid.tiles[i][k].setVal(0);
					} else if (grid.tiles[i][k - 1].value == grid.tiles[i][k].value) {
						grid.tiles[i][k - 1].value += grid.tiles[i][k].value;
						grid.tiles[i][k].setVal(0);
						k = -2;
					} else {
						k = -1;
					}
				}
			}
		}

		if (!checkIfFull()) {
			addRandomTiles();
		} else {
			gameOver();
		}
	}

	// Slides all the tiles right
	public void moveDown() {
		for (int j = grid.tiles[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < grid.tiles.length; i++) {
				for (int k = j; k < grid.tiles[0].length - 1; k++) {
					if (grid.tiles[i][k + 1].value == 0) {
						grid.tiles[i][k + 1].setVal(grid.tiles[i][k].value);
						grid.tiles[i][k].setVal(0);
					} else if (grid.tiles[i][k + 1].value == grid.tiles[i][k].value) {
						grid.tiles[i][k + 1].value += grid.tiles[i][k].value;
						grid.tiles[i][k].setVal(0);
						k = 6;
					} else {
						k = 6;
					}
				}
			}
		}

		if (!checkIfFull()) {
			addRandomTiles();
		} else {
			gameOver();
		}
	}

	// Handles what to do when there are no more moves
	public void gameOver() {
		// System.out.println("Game Over");
		resetTiles();
		// grid.printGrid();
	}

	// Returns true if the game grid is full
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

	// Resets all tiles to 0
	public void resetTiles() {
		for (int i = 0; i < grid.rows; i++) {
			for (int j = 0; j < grid.rows; j++) {
				grid.tiles[i][j] = new Tile(0, i, j);
			}
		}
	}

	// Adds a base-value tile to an empty cell in the grid
	public void addRandomTiles() {
		boolean flag = true;
		while (flag) {
			int x = (int) (Math.random() * grid.rows);
			int y = (int) (Math.random() * grid.rows);
			if (grid.tiles[x][y].value == 0) {
				grid.tiles[x][y].setVal(4); // TODO: Maybe set this to different
											// value, dependent on grid area?
				flag = false;
			}
		}
	}

	// Returns a string with the layout of the grid's values
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
