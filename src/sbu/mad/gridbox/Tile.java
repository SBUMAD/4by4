package sbu.mad.gridbox;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Tile {
	//public ArrayList<Tile> neighbors;
	public Paint paint;
	
	// grid info
	public int row, col;	// their current grid row and col
	public int value;		// the value of the tile (powers of 2)
	public SquareGrid grid;	// the grid it belongs to
	public int x, y;

	public Tile(int value, int row, int col) {
		paint = new Paint();
		//paint.setColor(Color.rgb((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255));
		
		paint.setColor(Color.RED);
		this.row = row;
		this.col = col;
	}

	public void draw(Canvas canvas) {
		
	}
	
	
}