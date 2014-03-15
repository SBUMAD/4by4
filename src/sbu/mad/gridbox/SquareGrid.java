package sbu.mad.gridbox;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

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
				float tempX = tileWidth * i;
				float tempY = tileWidth * j;
				canvas.drawRect(x + tempX, y + tempY, x + tempX + tileWidth, y
						+ tempY + tileWidth, tiles[i][j].paint);
				Paint p = new Paint();
				p.setColor(Color.GREEN);
				// Draw value
				if (tiles[i][j].value < 2)
					canvas.drawText(tiles[i][j].value + "", x + i * tileWidth
							+ tileWidth / 2, y + j * tileWidth + tileWidth / 2, p);
			}
		}
		// render grid
		for (int i = 0; i < rows; i++) {
			canvas.drawLine(x + i * tileWidth, y, x + i * tileWidth, y + width,
					new Paint());
			canvas.drawLine(x + 0, y + i * tileWidth, x + width, y + i
					* tileWidth, new Paint());
		}
	}

	public void resetTiles() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.rows; j++) {
				this.tiles[i][j] = new Tile(0, i, j);
			}
		}
	}
}
