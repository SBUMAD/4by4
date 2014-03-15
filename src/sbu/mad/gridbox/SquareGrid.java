package sbu.mad.gridbox;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class SquareGrid {
	public float width;
	public int rows;
	public float x, y; // position
	public Tile[][] tiles; // the tiles of the grid
	public float tileWidth;

	public SquareGrid(float x, float y, float width, int rows) {
		this.x = x;
		this.y = y;
		this.rows = rows;
		this.width = width;
		this.tiles = new Tile[rows][rows];
		tileWidth = width / rows;
	}

	public void render(Canvas canvas) {
		// draw grid lines
		for (int i = 0; i < rows; i++) {

			// now render the number value in the middle of the space
			for (int j = 0; j < rows; j++) {

				// Only render anything if the cell has a value over 0
				if (tiles[i][j].value > 0) {
					float tempX = tileWidth * i;
					float tempY = tileWidth * j;
					
					// draw the background color of cell
					canvas.drawRect(x + tempX, y + tempY,
									x + tempX + tileWidth, 
									y + tempY + tileWidth,
									tiles[i][j].paint);

					// Draw Text Value of the tile
					// Set up font
					Paint p = new Paint();
					p.setTextSize(40);
					Typeface bold = Typeface.DEFAULT_BOLD;
					p.setTypeface(bold);
					// and render value in center of cell
					canvas.drawText(tiles[i][j].value + "", 
									x + tempX + tileWidth / 2 - 10, // small adjustments to get text in center of cell
									y + tempY + tileWidth / 2 + 10,
									p);
				}
			}
		}
		
		// render grid outside (to avoid overlap from cells
		for (int i = 0; i <= rows; i++) {
			canvas.drawLine(x + i * tileWidth, y, x + i * tileWidth, y + width, new Paint());
			canvas.drawLine(x + 0, y + i * tileWidth, x + width, y + i * tileWidth, new Paint());
		}
	}
}
