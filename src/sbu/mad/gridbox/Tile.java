package sbu.mad.gridbox;

import android.graphics.Color;
import android.graphics.Paint;

public class Tile {
	public Paint paint;	// knows what to color itself
	
	// grid info
	public int row, col;	// their current grid row and col
	public int value;		// the value of the tile (powers of 2)
	
	// Screen info
	public int x, y;

	public Tile(int value, int row, int col) {
		paint = new Paint();
		this.row = row;
		this.col = col;
		
		this.updateColor();
	}
	
	public void setVal(int newVal)
	{
		this.value = newVal;
		updateColor();
	}
	
	// Increases redness of the tile as it increases in value
	public void updateColor()
	{
		paint.setColor(Color.rgb(255, (int)(200 - 20*Math.log(value) / Math.log(2)), (int)(200 - 20*Math.log(value) / Math.log(2))));
	}
}