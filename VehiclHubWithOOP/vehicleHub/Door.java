/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Door {
	private int width, height;
	private Color color;

	public Door(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;

	}
	
	public void SetColor(Color color) {
		this.color = color;
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(this.color);		
		Drawing.pen().fillRect(left, bottom - height, width, height);

	}

}
